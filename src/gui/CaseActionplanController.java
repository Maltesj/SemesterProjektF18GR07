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

/**
 * FXML Controller class
 *
 * @author HCHB
 */
public class CaseActionplanController implements Initializable, IController {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void startActionplanEventHandler(ActionEvent event) {
        GUIFacade.getInstance().getBusinessFacade().startActionPlan("caseWorkerID", "caseID");
        
    }

    @FXML
    private void continueActionplanEventHandler(ActionEvent event) {
        
        GUIFacade.getInstance().getBusinessFacade().continueActionPlan();
    }

    @FXML
    private void discardPhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().getBusinessFacade().discardPhase();
    }

    @FXML
    private void savePhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().getBusinessFacade().savePhase();
    }



    
    
}
