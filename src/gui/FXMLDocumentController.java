/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.IBusinessFacade;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * FXML Controller class
 *
 * @author malte
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> chooseCase;
    private ObservableList<String> listen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     listen = FXCollections.observableArrayList();  
        listen.add("123242415");
        listen.add("123132123");
        chooseCase.setItems(listen);
        
        
        // TODO
  
        
        
        
        
 
    }

 

    @FXML
    private void onaction(ActionEvent event) {
//        chooseCase.get
//       GUIFacade.getInstance().startAssessment(CaseID, caseWorkerID);
//        
    }
}