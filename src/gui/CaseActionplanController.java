/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.Checklistable;
import acquaintance.EnumActionplan;
import acquaintance.EnumAssessment;
import acquaintance.IController;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
import javafx.scene.input.KeyEvent;
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

    
    private Map<EnumActionplan, TextArea> informationFields;
    @FXML
    private TextArea effortPurposeArea;
    
    private boolean online;
    @FXML
    private TextArea otherField1;
    @FXML
    private TextArea otherField2;
    @FXML
    private TextArea coordinationField1;
    @FXML
    private TextArea coordinatingField2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        informationFields = new HashMap<>();
        
        informationFields.put(EnumActionplan.NAME, nameArea);
        informationFields.put(EnumActionplan.CPR, cprArea);
        informationFields.put(EnumActionplan.ADDRESS, adressArea);
        informationFields.put(EnumActionplan.MAIL, mail_area);
        informationFields.put(EnumActionplan.TELEPHONENUMBER, telephonenumber_area);
        
        informationFields.put(EnumActionplan.WORKPURPOSE, effortPurposeArea);
        informationFields.put(EnumActionplan.WORKOFFER1, goal1Area);
        informationFields.put(EnumActionplan.WORKOFFER2, goal2Area);
        informationFields.put(EnumActionplan.WORKSERVICE1, serviceArea);
        informationFields.put(EnumActionplan.ACTIONPLANOTHER1, otherField1);
        informationFields.put(EnumActionplan.ACTIONPLANOTHER2, otherField2);
        informationFields.put(EnumActionplan.ACTIONPLANCOORDINATING1, coordinationField1);
        informationFields.put(EnumActionplan.ACTIONPLANCOORDINATING2, coordinatingField2);

        this.online = true;
  
//dateArea;
//closetsNextOfKinArea
//offerArea;
//
//FollowupDate1;
//FollowupDate2;
//goal3Area;FollowupDate3;
    }

    
    

    @FXML
    private void discardPhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().discardPhase();
    }

    @FXML
    private void savePhaseEventHandler(ActionEvent event) {
        GUIFacade.getInstance().savePhase(online);
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
    
    void loadInformation(String caseID, Map<Checklistable, String> information){
        
        for (Map.Entry<Checklistable, String> entry : information.entrySet()) {
            Checklistable sourceID = entry.getKey();
            TextArea area = informationFields.get(sourceID);
            if (area != null) {
                area.setText(entry.getValue());
            }
        }
        
//        System.out.println(this.effortPurposeArea.getText());
    }
    @FXML
    private void writeEventHandler(KeyEvent event) {
        TextArea area = (TextArea)(event.getSource());
        
        String textArea = area.getId();
        EnumActionplan sourceID = null;
        
        // get the enum value corresponding to the FXID 
        for (Map.Entry<EnumActionplan, TextArea> entry : this.informationFields.entrySet()) {
            if (entry.getValue().equals(area)) {
                sourceID = entry.getKey();
            }
        }
        
        GUIFacade.getInstance().write(area.getText(), sourceID);
    }
   
}
