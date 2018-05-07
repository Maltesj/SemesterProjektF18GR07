/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.AssessmentEnum;
import acquaintance.IController;
import java.net.URL;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class TestGUIController implements Initializable, IController {
    
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
    
    private HashMap<String, TextArea> informationFields;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dokumentScroller.setVvalue(0);
        checkText.setText("");
        
        this.informationFields = new HashMap<>();
        
        this.informationFields.put(AssessmentEnum.PROFFESSIONALASSESSMENT1.toString(), textAreaAcademicallyAssessment);
        
    }
    
    @FXML
    private void checkEvent(ActionEvent event) {
        Set<String> obligatoryFields = GUIFacade.getInstance().checkAssessment();
        checkText.setText(obligatoryFields.toString());
    }
    
    @FXML
    private void afslutEvent(ActionEvent event) {
        Set<String> obligatoryFields = GUIFacade.getInstance().done();
        checkText.setText(obligatoryFields.toString());
        
    }
    
    @FXML
    private void SaveAction(ActionEvent event) {
        GUIFacade.getInstance().save();
    }

    @FXML
    private void writeEventHandler(KeyEvent event) {
        TextArea area = (TextArea)(event.getSource());
        
        String textArea = area.getId();
        String sourceID = null;
        
        // get the enum value corresponding to the FXID 
        for (Map.Entry<String, TextArea> entry : this.informationFields.entrySet()) {
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
    
}
