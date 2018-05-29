/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.Checklistable;
import acquaintance.EnumCaseInformation;
import acquaintance.IController;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class CaseInformationGUIController implements Initializable, IController {

    @FXML
    private Text fysiskFunktion;
    @FXML
    private Text FysiskeksFXID;
    @FXML
    private Text pysiskeksFXID;
    @FXML
    private Text psykiskFunktionFXID;
    @FXML
    private ScrollPane ScrollpaneIndholdfortegnelse;
    @FXML
    private AnchorPane testAnchor;
    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle test;
    @FXML
    private Text psyksikfunktionsFXID;
    @FXML
    private Text SocialProblemFXID1;
    @FXML
    private Text psykiskindholdsfortegnelse;
    @FXML
    private Text fysiskfunktionFXID;
    @FXML
    private TextArea Fysisk_borger_oplysning;
    @FXML
    private Rectangle psykisk_funktions_tal;
    @FXML
    private TextArea Fysisk_oplysning_andre;
    @FXML
    private TextArea fysisk_sagsbehandlers_bemaerk;
    @FXML
    private TextArea psyisk_borger_oplysning;
    @FXML
    private TextArea pyskisk_oplysning_borger;
    @FXML
    private TextArea psykisk_sagsbehandling_bemaerk;
    @FXML
    private TextArea Socialt_behandlers_bemaerk;
    @FXML
    private TextArea Socialt_oplysning_andre;
    @FXML
    private TextArea Socialt_oplysning_borger;
    @FXML
    private TextArea socialt_funktions_tal;
    @FXML
    private TextArea Fysisk_funktions_tal;
    @FXML
    private TextArea Fysisk_funktions_tekst;
    @FXML
    private TextArea psykisk_funtkions_tekst;
    @FXML
    private TextArea socialt_funktions_tekst;
    @FXML
    private Text fysiskfunktionFXID11;
    
    private Map<Checklistable, TextArea> informationFields;
    @FXML
    private Text SocialtproblemFXID;
    private TextArea testText;
    @FXML
    private Text socialFunktionFXID1;
    @FXML
    private Text SocialtFXID1;
    
    private boolean online;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        informationFields = new HashMap<>();
        informationFields.put(EnumCaseInformation.PHYSICPROBLEM1, Fysisk_borger_oplysning);
        informationFields.put(EnumCaseInformation.PHYSICPROBLEM2, Fysisk_oplysning_andre);
        informationFields.put(EnumCaseInformation.PHYSICPROBLEM3, fysisk_sagsbehandlers_bemaerk);
        informationFields.put(EnumCaseInformation.PHYSICPROBLEM4, Fysisk_funktions_tal);
        informationFields.put(EnumCaseInformation.PSYCICPROBLEM1, psyisk_borger_oplysning);
        informationFields.put(EnumCaseInformation.PSYCICPROBLEM2, pyskisk_oplysning_borger);
        informationFields.put(EnumCaseInformation.PSYCICPROBLEM3, psykisk_sagsbehandling_bemaerk);
        informationFields.put(EnumCaseInformation.PSYCICPROBLEM4, psykisk_funtkions_tekst);
        informationFields.put(EnumCaseInformation.SOCIALPROBLEM1, Socialt_oplysning_borger);
        informationFields.put(EnumCaseInformation.SOCIALPROBLEM2, Socialt_oplysning_andre);
        informationFields.put(EnumCaseInformation.SOCIALPROBLEM3, Socialt_behandlers_bemaerk);
        informationFields.put(EnumCaseInformation.SOCIALPROBLEM4, socialt_funktions_tekst);
    
        this.online = true;
    }

    void loadInformation(String caseID){
        
        Map<Checklistable, String> info = GUIFacade.getInstance().getCaseInformation(caseID);

        for (Checklistable sourceID : info.keySet()) {
            TextArea area = informationFields.get(sourceID);
            area.setText(info.get(sourceID));
        }
    }

    @FXML
    private void showExample(MouseEvent event) {
        fysiskFunktion.setVisible(true);
        
    }

    @FXML
    private void HideExample(MouseEvent event) {
        fysiskFunktion.setVisible(false);
        
    }

    @FXML
    private void HideExamplePsy(MouseEvent event) {
        psykiskFunktionFXID.setVisible(false);
    }

    @FXML
    private void showExamplePsy(MouseEvent event) {
        psykiskFunktionFXID.setVisible(true);
    }

    @FXML
    private void ShowPsykisk(MouseEvent event) {
        // ScrollpaneIndholdfortegnelse.setVvalue(0.092);
       //psykiskFunktionFXID.getLayoutY();
//       double scrollTo = psykiskFunktionFXID.getLayoutY() / (ScrollpaneIndholdfortegnelse.getHeight());
       double scrollTo1 = psyksikfunktionsFXID.getLayoutY() / (testAnchor.getHeight()-990);
//       ScrollpaneIndholdfortegnelse.getChildrenUnmodifiable().get(0);
//        System.out.println(psykiskFunktionFXID.getLayoutY());
//        System.out.println(ScrollpaneIndholdfortegnelse.getHeight());
        Platform.runLater(()-> {
            ScrollpaneIndholdfortegnelse.setVvalue(scrollTo1);
        });
//        ScrollpaneIndholdfortegnelse.setVvalue(scrollTo1);
//        ScrollpaneIndholdfortegnelse.setv
//        System.out.println(test.getLayoutY());
//        System.out.println(test.getLayoutBounds().getMinY());
    }

    @FXML
    private void ShowFunktions(MouseEvent event) {
        ScrollpaneIndholdfortegnelse.setVvalue(0);
    }

    @FXML
    private void HideExampleSocial(MouseEvent event) {
        socialFunktionFXID1.setVisible(false);
    }
    

    @FXML
    private void showExampleSocial(MouseEvent event) {
           socialFunktionFXID1.setVisible(true);
    }

    @FXML
    private void ShowSocialt(MouseEvent event) {
        ScrollpaneIndholdfortegnelse.setVvalue(1);
    }
  
}
