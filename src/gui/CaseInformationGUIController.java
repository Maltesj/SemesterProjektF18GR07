/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.ConstantsEnum;
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
    
    private Map<String, TextArea> informationFields;
    @FXML
    private Text SocialtproblemFXID;
    private TextArea testText;
    @FXML
    private Text socialFunktionFXID1;
    @FXML
    private Text SocialtFXID1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        informationFields = new HashMap<>();
        informationFields.put(ConstantsEnum.PHYSICPROBLEM1.toString(), Fysisk_borger_oplysning);
        informationFields.put(ConstantsEnum.PHYSICPROBLEM2.toString(), Socialt_oplysning_andre);
        informationFields.put(ConstantsEnum.PHYSICPROBLEM3.toString(), fysisk_sagsbehandlers_bemaerk);
        informationFields.put(ConstantsEnum.PHYSICPROBLEM4.toString(), Fysisk_funktions_tal);
        informationFields.put(ConstantsEnum.PSYCICPROBLEM1.toString(), psyisk_borger_oplysning);
        informationFields.put(ConstantsEnum.PSYCICPROBLEM2.toString(), pyskisk_oplysning_borger);
        informationFields.put(ConstantsEnum.PSYCICPROBLEM3.toString(), psykisk_sagsbehandling_bemaerk);
        informationFields.put(ConstantsEnum.PSYCICPROBLEM4.toString(), psykisk_funtkions_tekst);
        informationFields.put(ConstantsEnum.SOCIALPROBLEM1.toString(), Socialt_oplysning_borger);
        informationFields.put(ConstantsEnum.SOCIALPROBLEM2.toString(), Socialt_oplysning_andre);
        informationFields.put(ConstantsEnum.SOCIALPROBLEM3.toString(), Socialt_behandlers_bemaerk);
        informationFields.put(ConstantsEnum.SOCIALPROBLEM4.toString(), socialt_funktions_tekst);
        this.Fysisk_funktions_tal.setText("Initialise");
        this.Fysisk_funktions_tal.appendText("Initialise");
        this.Fysisk_funktions_tal.textProperty().setValue("Initfrereialise");
        //this.testTexr.setText("test2");
        
    }

    void loadInformation(String caseID){
        
        Map<String, String> info = GUIFacade.getInstance().getCaseInformation(caseID);
        
//        this.Fysisk_borger_oplysning.setText("gege");
//        this.Fysisk_borger_oplysning.appendText("gege");
//        this.Fysisk_oplysning_andre.textProperty().setValue("dede");
        //this.testTexr.setText("test1");
        
        for (String sourceID : info.keySet()) {
            TextArea area = informationFields.get(sourceID);
            area.setText(info.get(sourceID));
            System.out.println(area.getText());


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
        ScrollpaneIndholdfortegnelse.setVvalue(1);
    }

    @FXML
    private void HideExampleSocial(MouseEvent event) {
        socialFunktionFXID1.setVisible(false);
    }
    

    @FXML
    private void showExampleSocial(MouseEvent event) {
           socialFunktionFXID1.setVisible(true);
    }
  
}
