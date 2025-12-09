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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Shohel
 */
public class DORequestMeetingSceneController implements Initializable {

    @FXML
    private AnchorPane requestMeetingWithAdminAnchorPane;
    @FXML
    private TextField timeOfMeetingTextField;
    @FXML
    private DatePicker dateOfMeetingDatePicker;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private TextField meetingRequestIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitMeetingRequestButtonOnClick(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int meetingRequestID = (int) (timestamp & 0xFFFFFFFF);
        String messageContent = "I would like to Schedule a meeting on " + dateOfMeetingDatePicker.getValue().toString() + 
                ", at " + timeOfMeetingTextField.getText() + ".\nAdditional Remarks: "+remarksTextArea.getText();
        AdminRequest meetingRequest = new AdminRequest(meetingRequestID, messageContent);
        
        AdminRequest.addRequestToFile(meetingRequest);
        
       
    }

    @FXML
    private void viewMeetingRequestStatusButtonOnClick(ActionEvent event) {
        AdminRequest.checkAdminRequestStatus(Integer.parseInt(meetingRequestIDTextField.getText()));
        
    }

    
}
