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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private RadioButton guardianshipCheckBox;
    @FXML
    private RadioButton guardianship2CheckBox;
    @FXML
    private RadioButton curatorshipCheckBox;
    @FXML
    private RadioButton guardianship3CheckBox;
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
    @FXML
    private CheckBox assessorCheckBox;
    @FXML
    private CheckBox representativeCheckBox;
    @FXML
    private CheckBox powerOfAttorneyCheckBox;
    @FXML
    private TextField RepresentationTextField;
    @FXML
    private TextArea dateArea;
    @FXML
    private TextArea effortgoalArea;
    @FXML
    private TextArea goal1Area;
    @FXML
    private TextArea goal2Area;
    @FXML
    private TextArea goal3Area;
    @FXML
    private TextArea FollowupDate1;
    @FXML
    private TextArea FollowupDate2;
    @FXML
    private TextArea FollowupDate3;
    @FXML
    private TextArea serviceArea;
    @FXML
    private TextArea offerArea;
    @FXML
    private TextField GuardianshipTextField;
    @FXML
    private ToggleGroup guardianshipToggle;

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

    @FXML
    private void guardianshipContactInfoClicked(ActionEvent event) {
       
        
        if( guardianship3CheckBox.isArmed()){
            GuardianshipTextField.setDisable(false);
            
        }
        else GuardianshipTextField.setDisable(true);
        GuardianshipTextField.clear();
    }

    @FXML
    private void checkBoxUsed(ActionEvent event) {
        if(powerOfAttorneyCheckBox.isArmed()){
            RepresentationTextField.setDisable(false);
        }
        else representativeCheckBox.setDisable(true);
        
    }
    


    

   



    
    
}
