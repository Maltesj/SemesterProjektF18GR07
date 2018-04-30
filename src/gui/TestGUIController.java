/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.Constants;
import acquaintance.ConstantsEnum;
import business.BusinessFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
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
          
    }

    @FXML
    private void afslutEvent(ActionEvent event) { 
        BusinessFacade.getInstance().write(textAreaAcademicallyAssessment.getText(), ConstantsEnum.PROFFESSIONALASSESSMENT1.toString());
        
        
        checkText.setText(BusinessFacade.getInstance().done().toString());
          
    }

    @FXML
    private void SaveAction(ActionEvent event) {
        BusinessFacade.getInstance().save();
        
    }

    @FXML
    private void tableOfContentMenuItemAction(ActionEvent event) {
        if(tableOfContentMenuItem.isSelected()){
            
        }
    }
    
    
}
