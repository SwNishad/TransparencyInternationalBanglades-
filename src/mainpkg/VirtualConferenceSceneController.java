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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class VirtualConferenceSceneController implements Initializable {

    @FXML
    private TextField meetingTopic;
    @FXML
    private ComboBox<String> timeComboBox;
    @FXML
    private DatePicker meetingDate;
    @FXML
    private Label meetingLinkLabel;
    @FXML
    private TextArea meetingInfoTextArea;
    @FXML
    private TextField linkTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        timeComboBox.getItems().addAll("30 Minutes", "1 Hour", "2 Hours", "2 Hours +");
        // TODO
    }    

    @FXML
    private void scheduleMeetingButtonClicked(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int conferenceID = (int) (timestamp & 0xFFFFFFFF); // Lower 32 bits
        String conferenceTopic = meetingTopic.getText();
        LocalDate conferenceDate = meetingDate.getValue();
        String conferenceDuration = timeComboBox.getValue();
        String conferenceLink = meetingLinkLabel.getText();
                
        VirtualConference newConference = new VirtualConference(conferenceID, conferenceTopic, conferenceDate, conferenceDuration, conferenceLink);
        
        Researcher.ScheduleVirtualConference(newConference);
        
        
    }

    @FXML
    private void loadMeetingButtonClicked(ActionEvent event) {
        Researcher.ViewVirtualConferences(meetingInfoTextArea);
    }
    
}
