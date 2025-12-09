/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class GPSignUpSceneController implements Initializable {

    @FXML
    private TextField gpNameTextField;
    @FXML
    private TextField gpPhoneTextField;
    @FXML
    private TextField gpEmailTextField;
    @FXML
    private TextField gpPasswordTextField;
    @FXML
    private DatePicker gpDOBDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    @FXML
    private void gpRegisterButtonOnClick(ActionEvent event) {
        
        Random random = new Random();
        int gpID = random.nextInt(299999 - 200000) + 200000;
        String gpName = gpNameTextField.getText();
        String gpPhone = gpPhoneTextField.getText();
        String gpEmail = gpEmailTextField.getText();
        String gpPassword = gpPasswordTextField.getText();
        LocalDate gpDOB = gpDOBDatePicker.getValue();
        
        Employee tempGP = new Employee(gpID, gpName, gpPassword, "General Public", 0, false, gpDOB);
        Employee.WriteEmployeeToLoginFile(tempGP);
        
        GeneralPublic newGP = new GeneralPublic(gpID, gpName, gpPassword, gpDOB, LocalDate.now(), gpPhone, gpEmail);
        GeneralPublic.WriteGeneralPublicToGPFile(newGP);
    }

    @FXML
    private void returnToLoginPageButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene loginscene = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(loginscene);
            stg2.show();
    }
    
}
