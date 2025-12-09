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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MediaOfficerLOAController implements Initializable {

    @FXML
    private TextArea loaTXTAREA;
    @FXML
    private TextField enterCheckRequestIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void submitLOAONCLICK(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int adminRequestID = (int) (timestamp & 0xFFFFFFFF); // Lower 32 bits
        String adminRequestContent = loaTXTAREA.getText();

        AdminRequest newRequest = new AdminRequest(adminRequestID, adminRequestContent);
        
        AdminRequest.addRequestToFile(newRequest);
    }

    @FXML
    private void checkStatusButtonOnClick(ActionEvent event) {
        AdminRequest.checkAdminRequestStatus(Integer.parseInt(enterCheckRequestIDTextField.getText()));
    }
    
}
