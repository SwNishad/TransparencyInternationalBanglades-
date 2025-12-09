/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class RKViewCompanyMeetingController implements Initializable {


    @FXML
    private TextArea companymeetingoutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        // TODO
    }    

    @FXML
    private void showcompanymeeting(MouseEvent event) {
        Admin tempAdmin = new Admin(700000, "John Doe", "1234p", "Recordkeeper", 475000.00, true, LocalDate.of(2018, Month.SEPTEMBER, 9));
        tempAdmin.ViewInternalMeetings(companymeetingoutput);  
    }
    
}
