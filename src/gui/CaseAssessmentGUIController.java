/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.Checklistable;
import acquaintance.EnumAssessment;
import acquaintance.IController;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class CaseAssessmentGUIController implements Initializable, IController {
    
    @FXML
    private ScrollPane dokumentScroller;
    @FXML
    private Text checkText;
    @FXML
    private TextArea textAreaAcademicallyAssessment;
    @FXML
    private CheckMenuItem tableOfContentMenuItem;
    @FXML
    private GridPane BackgroundGrid;
    
    private HashMap<EnumAssessment, TextArea> informationFields;
    private boolean online;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dokumentScroller.setVvalue(0);
        checkText.setText("");
        
        this.informationFields = new HashMap<>();
        
        this.informationFields.put(EnumAssessment.PROFFESSIONALASSESSMENT1, textAreaAcademicallyAssessment);
        
        this.online = true;
        
    }
    
    @FXML
    private void checkEvent(ActionEvent event) {
        Set<Checklistable> obligatoryFields = GUIFacade.getInstance().checkAssessment();
        checkText.setText(obligatoryFields.toString());
        
        this.updateIfFieldsIsFilled(obligatoryFields);
    }
    
    @FXML
    private void afslutEvent(ActionEvent event) {
        Set<Checklistable> obligatoryFields = GUIFacade.getInstance().done(online);
        checkText.setText(obligatoryFields.toString());
        
        this.updateIfFieldsIsFilled(obligatoryFields);
    }
    
    @FXML
    private void SaveAction(ActionEvent event) {
        GUIFacade.getInstance().save(online);
    }

    @FXML
    private void writeEventHandler(KeyEvent event) {
        TextArea area = (TextArea)(event.getSource());
        
        String textArea = area.getId();
        EnumAssessment sourceID = null;
        
        // get the enum value corresponding to the FXID 
        for (Map.Entry<EnumAssessment, TextArea> entry : this.informationFields.entrySet()) {
            if (entry.getValue().equals(area)) {
                sourceID = entry.getKey();
            }
        }
        
        GUIFacade.getInstance().write(area.getText(), sourceID);
    }

    @FXML
    private void tableOfContentMenuItemAction(ActionEvent event) {
        if(tableOfContentMenuItem.isSelected()){
            
        }
    }
    
    private void updateIfFieldsIsFilled(Set<Checklistable> obligatoryFields){
        Collection<TextArea> filledFields = this.informationFields.values();
        
        for (TextArea filledField : filledFields) {
            filledField.setStyle("-fx-control-inner-background:  #e4f0d4 ;"); 
        }
        
        for (Checklistable obligatoryField : obligatoryFields) {
            this.informationFields.get(obligatoryField).setStyle("-fx-control-inner-background:  #e4f0d4 ;-fx-border-color: red;-fx-border-width: 3");
        }
        
        
    }
    
}
