/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class CaseInformationGUIController implements Initializable {

    @FXML
    private Text fysiskFunktion;
    @FXML
    private Text FysiskeksFXID;
    @FXML
    private Text pysiskeksFXID;
    @FXML
    private Text psykiskFunktionFXID;

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
    
}
