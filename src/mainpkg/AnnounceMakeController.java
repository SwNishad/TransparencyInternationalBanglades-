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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//MEDIAOFFICER

public class AnnounceMakeController implements Initializable {

    @FXML
    private TextArea announceTXTAREA;
    @FXML
    private TextField announcementNoTXTFIELD;
    @FXML
    private DatePicker announcementDateTXTFIELD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void announceONCLICK(ActionEvent event) {
        int announcementNo = Integer.parseInt(announcementNoTXTFIELD.getText());
        LocalDate announcementDate = announcementDateTXTFIELD.getValue();
        String announcementContent = announceTXTAREA.getText();
        
        Announcement newAnnouncement = new Announcement(announcementNo,  announcementDate, announcementContent);
        
        Announcement.createAnnouncement(newAnnouncement);

    }
    
}
