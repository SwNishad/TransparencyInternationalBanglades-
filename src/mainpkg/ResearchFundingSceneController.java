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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//RESEARCHER

public class ResearchFundingSceneController implements Initializable {

    @FXML
    private TextField dayTextField;
    @FXML
    private TextField contentTextField;
    @FXML
    private ComboBox<Integer> dayComboBox;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private Label statusTextLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dayComboBox.getItems().addAll(7,30,90,365);
    }    
    
    
    
    @FXML
    private void calculateButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int requestID = (int) (timestamp & 0xFFFFFFFF); // Lower 32 bits
        System.out.println(requestID);
        int amountRequested = Integer.parseInt(dayTextField.getText()) * dayComboBox.getValue();
        
        String requestContent = "Funding Request of BDT: " + Integer.toString(amountRequested) + " for " + contentTextField.getText();
        detailsTextArea.setText(requestContent);
        AdminRequest newRequest = new AdminRequest(requestID, requestContent);
        AdminRequest.addRequestToFile(newRequest);  
    }
    
}
