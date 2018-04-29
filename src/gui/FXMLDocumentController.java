/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.IController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author malte
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ComboBox<String> chooseCase;
    
    private ObservableList<String> listen;
    private String caseWorkerID;
    private List<IController> controllers;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controllers = new ArrayList<>();
        
        this.caseWorkerID = "worker 1";
        
        listen = FXCollections.observableArrayList();
        Set<String> caseIDs = GUIFacade.getInstance().getCaseIDS();
        listen.addAll(caseIDs);
        
        
        
        
        
        
        chooseCase.setItems(listen);
        
        
        
        
        
    }
    
    @FXML
    private void onaction(ActionEvent event) {
        String caseID =  chooseCase.getValue();
        
        GUIFacade.getInstance().startAssessment(caseID, caseWorkerID);
    }
    
    @FXML
    private void showCaseInformationtEventHandler(ActionEvent event) {
        
        String caseID = this.chooseCase.getValue();
        ObservableList<String> caseIDs = this.chooseCase.getItems();
        
        if (caseIDs.contains(caseID)) {
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("CaseInformationGUI.fxml"));
            
            IController controller = loader.getController();
            controllers.add(controller);
            
            Stage stage = new Stage();
            
            try {
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("No such case exists");
            
        }
    }
}