/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.Constants;
import business.BusinessFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dokumentScroller.setVvalue(0);
        checkText.setText("");
        BusinessFacade.getInstance().startAssessment("1", "1");
        
    }    

    @FXML
    private void checkEvent(ActionEvent event) {
          
    }

    @FXML
    private void afslutEvent(ActionEvent event) { 
        BusinessFacade.getInstance().write(textAreaAcademicallyAssessment.getText(), Constants.fieldAcademicallyAssessment);
        
        
        checkText.setText(BusinessFacade.getInstance().done().toString());
          
    }

    @FXML
    private void AcademicallyAssessmentUpdate(InputMethodEvent event) {
        
        
    }
    
    
}
