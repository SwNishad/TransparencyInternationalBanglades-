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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class RequestRaiseController implements Initializable {

    @FXML
    private AnchorPane RaiseAnchor;
    @FXML
    private TextField remarksTextArea;
    @FXML
    private ComboBox<String> raisePercentComboBox;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private TextField requestIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        raisePercentComboBox.getItems().addAll("5%","10%","15%","20%");
        
        // TODO
    }    

    @FXML
    private void submitRequestButtonOnClick(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int raiseRequestID = (int) (timestamp & 0xFFFFFFFF);
        String messageContent = "I would like to request a raise of " + raisePercentComboBox.getValue()+"of my current salary.\nRemarks: "+ remarksTextArea.getText();
        AdminRequest raiseRequest = new AdminRequest(raiseRequestID, messageContent);
        
        AdminRequest.addRequestToFile(raiseRequest);
        
        
        detailsTextArea.setText(messageContent);
        
        
    }

    @FXML
    private void checkRequestStatusButtonOnClick(ActionEvent event) {
        
        AdminRequest.checkAdminRequestStatus(Integer.parseInt(requestIDTextField.getText()));
    }
    
}
