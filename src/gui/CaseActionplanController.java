/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.IController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HCHB
 */
public class CaseActionplanController implements Initializable, IController {

    @FXML
    private GridPane BackgroundGrid;
    @FXML
    private ScrollPane dokumentScroller;
    @FXML
    private CheckBox guardianshipCheckBox;
    @FXML
    private CheckBox guardianship2CheckBox;
    @FXML
    private CheckBox curatorshipCheckBox;
    @FXML
    private CheckBox guardianship3CheckBox;
    @FXML
    private TextArea nameArea;
    @FXML
    private TextArea cprArea;
    @FXML
    private TextArea adressArea;
    @FXML
    private TextArea telephonenumber_area;
    @FXML
    private TextArea mail_area;
    @FXML
    private TextArea closetsNextOfKinArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void startActionplanEventHandler(ActionEvent event) {
        GUIFacade.getInstance().startActionPlan("caseWorkerID", "caseID");
        
    }

    @FXML
    private void continueActionplanEventHandler(ActionEvent event) {
        
        GUIFacade.getInstance().continueActionPlan();
    }

    @FXML
    private void discardPhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().discardPhase();
    }

    @FXML
    private void savePhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().savePhase();
    }


    

   



    
    
}
