/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.IController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }

    @FXML
    private void ShowFunktions(MouseEvent event) {
    }
    
}
