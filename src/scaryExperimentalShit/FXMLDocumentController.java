/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package scaryExperimentalShit;

import acquaintance.IBusinessFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author malte
 */
public class FXMLDocumentController implements Initializable, Controller{
    
    @FXML
    private ComboBox<String> chooseCase;
    private ObservableList<String> listen;
    private String caseWorkerID;
    @FXML
    private GridPane gridPane;
    @FXML
    private Pane importantPane;
    
    private String currentWindowType;
    
    private ArrayList<Controller> controllers;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listen = FXCollections.observableArrayList();
//        Set<String> caseIDs = GUIFacade.getInstance().getCaseIDS();
//        listen.addAll(caseIDs);
        
        controllers = new ArrayList<>();
        
        
        
        
        chooseCase.setItems(listen);
        
        
        
        
        
    }
    
    
    
    @FXML
    private void onaction(ActionEvent event) {
        
        String caseID =  chooseCase.getValue();
        
//        GUIFacade.getInstance().startAssessment(caseID, caseWorkerID);
    }
    
    private void changeScene(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            
            Controller controller = loader.getController();
            controllers.add(controller);
            
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
            
            Pane pane = new Pane(root1);
            
            this.importantPane.getChildren().add(pane);
            
//            stage.setScene(scene);
//            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @FXML
    private void importantButtonEvent(ActionEvent event) {
        this.changeScene(event);
        
    }
}