/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import business.BusinessFacade;
import java.net.URL;
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
public class TestGUIController implements Initializable {
    
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dokumentScroller.setVvalue(0);
        checkText.setText("");
        BusinessFacade.getInstance().startAssessment("DummyCase1", "blah");
    }
    
    @FXML
    private void checkEvent(ActionEvent event) {
        Set<String> obligatoryFields = BusinessFacade.getInstance().checkAssessmentFields();
        checkText.setText(obligatoryFields.toString());
    }
    
    @FXML
    private void afslutEvent(ActionEvent event) {
        Set<String> obligatoryFields = BusinessFacade.getInstance().done();
        
        checkText.setText(obligatoryFields.toString());
    }
    
    @FXML
    private void SaveAction(ActionEvent event) {
        BusinessFacade.getInstance().save();
    }

    @FXML
    private void writeEventHandler(KeyEvent event) {
        TextArea area = (TextArea)(event.getSource());
        
        String textArea = area.getId();
        
        BusinessFacade.getInstance().write(textAreaAcademicallyAssessment.getText(), textArea);
    }

    @FXML
    private void tableOfContentMenuItemAction(ActionEvent event) {
        if(tableOfContentMenuItem.isSelected()){
            
        }
    }
    
}
