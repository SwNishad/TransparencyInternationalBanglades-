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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

//JOURNALIST

public class CollaborateSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField topicTextField;
    @FXML
    private DatePicker DOPDatePicker;
    @FXML
    private TextField enterIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendRequestButtonOnClick(ActionEvent event) {
        long timestamp =System.currentTimeMillis();
        int collabID = (int) (timestamp & 0xFFFFFFFF);
        
        String messageContent = "Journalist Name: " +  nameTextField.getText() + "; Collaboration Topic: " + topicTextField.getText() 
                + "; Proposed Collaboration Start Date: " + DOPDatePicker.getValue().toString();
        
        CollaborationRequest newRequest = new CollaborationRequest(collabID, messageContent);
        CollaborationRequest.addRequestToFile(newRequest);
    }

    @FXML
    private void checkReqButtonOnClick(ActionEvent event) {
        CollaborationRequest.checkCollaborationRequestStatus(Integer.parseInt(enterIDTextField.getText()));
    }
    
}
