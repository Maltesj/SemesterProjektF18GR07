/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.EnumPhases;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author malte
 */
public class StartScreenController implements Initializable {
    
    @FXML
    private ComboBox<String> chooseCase;
    
    private ObservableList<String> listen;
    private String caseWorkerID;
    private List<IController> controllers;
    @FXML
    private TabPane topTab;
    @FXML
    private Rectangle rectstart;
    @FXML
    private Button StartAss;
    @FXML
    private Button ShowInfoButton;
    @FXML
    private Button helpfxid;
    @FXML
    private Button indstillingerfxid;
    @FXML
    private Button startActionPlanButton;
    
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

//            Stage stage = new Stage();
            
            try {
                Parent root = loader.load();
                IController controller = loader.getController();
                controllers.add(controller);
                Scene scene = new Scene(root);

                Tab tab = new Tab();
                tab.setContent(root);
                tab.setText("Sagsoplysning");
                tab.setStyle("-fx-border-color: darkgrey; -fx-background-color: #e4f0d4;-fx-background-radius: 7; -fx-border-radius: 5;");
                tab.setOnSelectionChanged(e -> {
                    
                });
                
                this.topTab.getTabs().add(tab);
                
                CaseInformationGUIController control = (CaseInformationGUIController)controller;
                control.loadInformation(caseID);
                
//                stage.setScene(scene);
//                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("No such case exists");
            
        }
    }

    @FXML
    private void startAssesment(ActionEvent event) {
        
        String caseID = this.chooseCase.getValue();
        ObservableList<String> caseIDs = this.chooseCase.getItems();
        
        if (caseIDs.contains(caseID)) {
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("CaseAssessmentGUI.fxml"));
            
            try {
                Parent root = loader.load();
                IController controller = loader.getController();
                controllers.add(controller);
                Scene scene = new Scene(root);
                
                Tab tab = new Tab();
                tab.setContent(root);
                tab.setText("Sagsvurdering");
                tab.setStyle("-fx-border-color: darkgrey; -fx-background-color: #e4f0d4;-fx-background-radius: 7; -fx-border-radius: 5;");
                tab.setOnSelectionChanged(e -> {
                    GUIFacade.getInstance().setState(EnumPhases.ASSESSMENT);
                });
                
                this.topTab.getTabs().add(tab);        
                GUIFacade.getInstance().startAssessment(caseID, this.caseWorkerID);

            } catch (IOException ex) {
                Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("No such case exists");
            
        }
    }

    @FXML
    private void mouseoverblah(MouseEvent event) {
        if (this.chooseCase.getValue() == null) {
            
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: red; -fx-border-color: black; -fx-background-radius: 7; -fx-border-radius: 5;-fx-border-width: 3;");
        
        }
        else {
            Button b = (Button)event.getSource();
            b.setStyle("-fx-background-color: #4688f4; -fx-border-color: black; -fx-background-radius: 7; -fx-border-radius: 5;");
    
        }
        
    }

    @FXML
    private void mouseoutblah(MouseEvent event) {
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: #89dd52; -fx-border-color: black; -fx-background-radius: 7; -fx-border-radius: 5;");
    }
    
    @FXML
    private void startActionplanEventHandler(ActionEvent event){
        
        
        String caseID = this.chooseCase.getValue();
        ObservableList<String> caseIDs = this.chooseCase.getItems();
        
        if (caseIDs.contains(caseID)) {
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("CaseActionplan.fxml"));
            
            try {
                Parent root = loader.load();
                IController controller = loader.getController();
                controllers.add(controller);
                Scene scene = new Scene(root);
                
                Tab tab = new Tab();
                tab.setContent(root);
                tab.setText("Handleplan");
                tab.setStyle("-fx-border-color: darkgrey; -fx-background-color: #e4f0d4;-fx-background-radius: 7; -fx-border-radius: 5;");
                tab.setOnSelectionChanged(e -> {
                    GUIFacade.getInstance().setState(EnumPhases.ACTIONPLAN);
                });
                
                this.topTab.getTabs().add(tab);        
                GUIFacade.getInstance().startAssessment(caseID, this.caseWorkerID);

            } catch (IOException ex) {
                Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("No such case exists");
            
        }
    }
}