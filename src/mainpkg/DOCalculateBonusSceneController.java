/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class DOCalculateBonusSceneController implements Initializable {

    @FXML
    private AnchorPane calculateBonusEligibilityAnchorPane;
    @FXML
    private Label eligibilityResultLabel;
    @FXML
    private TextField employeeIDforBonusTextField;
    @FXML
    private TextArea bonusEligibilityStatusTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnToDashboard(ActionEvent event) {
    }

    @FXML
    private void checkjEligibilityButton(ActionEvent event) {
    }

    @FXML
    private void submitRequestForBonusButton(ActionEvent event) {
    }
    
}
