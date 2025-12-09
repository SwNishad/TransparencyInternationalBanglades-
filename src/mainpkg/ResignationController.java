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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


public class ResignationController implements Initializable {

    @FXML
    private AnchorPane ResignationAnchorPane;
    @FXML
    private TextField requestIDTextField;
    @FXML
    private DatePicker resignationDatePicker;
    @FXML
    private TextArea messageContentTextArea;
    @FXML
    private RadioButton medicalRadioButton;
    @FXML
    private RadioButton dissatisfactionRadioButton;
    @FXML
    private RadioButton careerAdvcRadioButton;
    @FXML
    private RadioButton retirementRadioButton;
    @FXML
    private RadioButton OtherRadioButton;
    @FXML
    private TextArea remarksTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        
        medicalRadioButton.setToggleGroup(tg);
        dissatisfactionRadioButton.setToggleGroup(tg);
        careerAdvcRadioButton.setToggleGroup(tg);
        retirementRadioButton.setToggleGroup(tg);
        OtherRadioButton.setToggleGroup(tg);
        
        
        // TODO
    }    

    @FXML
    private void submitResignButtonOnClick(ActionEvent event) {
        
        String resignationReason = "";
        
        if (medicalRadioButton.isSelected()) {
            resignationReason = medicalRadioButton.getText();
        }
        if (dissatisfactionRadioButton.isSelected()) {
            resignationReason = dissatisfactionRadioButton.getText();
        }
        if (careerAdvcRadioButton.isSelected()) {
            resignationReason = careerAdvcRadioButton.getText();
        }
        if (retirementRadioButton.isSelected()) {
            resignationReason = retirementRadioButton.getText();
        }
        if (OtherRadioButton.isSelected()) {
            resignationReason = OtherRadioButton.getText();
        }
        
      
        
        
        
        
        
        
        long timestamp = System.currentTimeMillis();
        int resignationRequestID = (int) (timestamp & 0xFFFFFFFF);
        String messageContent = "I would like to resign effective from " + resignationDatePicker.getValue().toString() + 
                "; for " + resignationReason + ".\nAdditional Remarks: "+remarksTextArea.getText();
        AdminRequest resignationRequest = new AdminRequest(resignationRequestID, messageContent);
        
        AdminRequest.addRequestToFile(resignationRequest);
        
        
        messageContentTextArea.setText(messageContent);
    }

    @FXML
    private void checkstatusButtonOnClick(ActionEvent event) {
        AdminRequest.checkAdminRequestStatus(Integer.parseInt(requestIDTextField.getText()));
    }

    
}
