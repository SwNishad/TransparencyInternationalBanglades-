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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class PressConfUpdateController implements Initializable {

    @FXML
    private DatePicker pressDateDP;
    @FXML
    private ComboBox<String> pressTimeCombobox;
    @FXML
    private TextField venueTXTFIELD;
    @FXML
    private TextField agendaTXTFIELD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pressTimeCombobox.getItems().addAll("11:00 a.m", "12:00 p.m", "4:00 p.m.", "5:00 p.m", "6:00 p.m", "7:00 p.m.", "8:00 p.m");
        
    }    

    @FXML
    private void addPCONCLICK(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int pressID = (int) (timestamp & 0xFFFFFFFF); // Lower 32 bits
        
        LocalDate pressDate = pressDateDP.getValue();
        String pressTime = pressTimeCombobox.getValue();
        String pressVenue = venueTXTFIELD.getText();
        String pressAgenda = agendaTXTFIELD.getText();
        
        PressConference newPC = new PressConference(pressID, pressDate, pressTime, pressVenue, pressAgenda);
        
        MediaOfficer.makePressConference(newPC);
    }
    
}
