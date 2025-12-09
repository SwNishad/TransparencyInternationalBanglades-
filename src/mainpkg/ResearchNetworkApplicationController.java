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
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//RESEARCHER

public class ResearchNetworkApplicationController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea reasonTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void applyButtonOnClick(ActionEvent event) {
        
         Alert b = new Alert(Alert.AlertType.INFORMATION);
         b.setTitle("TIB Research Network");
         b.setHeaderText("Application Status");
         b.setContentText("You have successfully applied to this workshop.");
         b.showAndWait();}   
    
        
        
        
    }
    

