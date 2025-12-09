/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ExclusiveCommController implements Initializable {

    @FXML
    private TextArea contentTXTAREA;
    @FXML
    private TextField titleTXTFIELD;
    @FXML
    private DatePicker dateDP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendOnClick(ActionEvent event) {
        String title = titleTXTFIELD.getText();
        LocalDate date = dateDP.getValue();
        String content = contentTXTAREA.getText();
        
        ExclusiveComm newEC = new ExclusiveComm(title, date , content);
        
        MediaOfficer.createExclusiveComm(newEC);
    }
    
}
