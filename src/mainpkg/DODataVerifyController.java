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
import javafx.scene.layout.AnchorPane;


public class DODataVerifyController implements Initializable {

    @FXML
    private AnchorPane DataVerifyAnchorPane;
    @FXML
    private TextField enterEmpIDTextField;
    @FXML
    private TextArea verifiiedEmpInfoTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void verifyEmpButtonOnClick(ActionEvent event) {
        
        Employee emp = Secretary.getEmployee(Integer.parseInt(enterEmpIDTextField.getText()));
        
        if ("Error".equals(emp.getEmployeeName())) {
            Alert wrongUser = new Alert(Alert.AlertType.ERROR);
            wrongUser.setTitle("Error");
            wrongUser.setHeaderText("Employee Does Not Exist");
            wrongUser.setContentText("Please check your credentials");
            wrongUser.showAndWait();
            
        }
        else {
            String empString ="----Verified Employee---"+ "\n\nEmployee ID: " + Integer.toString(emp.getEmployeeID()) + "\nEmployee Name: " + emp.getEmployeeName() 
                + "\nDesignation: " + emp.getEmployeeType() + "\nDate of Joining: " + emp.getEmployeeDOJ().toString() + 
                "\nSalary: " + Double.toString(emp.getEmployeeSalary());
        
        
            verifiiedEmpInfoTextArea.setText(empString);            
        }
        
        
        
    }

    
}
