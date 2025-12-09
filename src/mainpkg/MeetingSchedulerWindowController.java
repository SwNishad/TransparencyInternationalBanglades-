/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Acer
 */



public class MeetingSchedulerWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField meetingIDTextField;
    @FXML
    private TextField meetingTitleTextField;
    @FXML
    private DatePicker meetingTimeDatePicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    ArrayList<MeetingInternal> internalMeetingsList = new ArrayList();
    
    
    @FXML
    private void confirmScheduleMeetingOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int meetingID = (int) (timestamp & 0xFFFFFFFF); // Code to generate unique ID always
        String meetingName = meetingTitleTextField.getText();
        LocalDate meetingTime = meetingTimeDatePicker.getValue();
        
        MeetingInternal newMeeting = new MeetingInternal(meetingID, meetingName, meetingTime);
        internalMeetingsList.add(newMeeting);
        
        Admin.ScheduleInternalMeeting(newMeeting);
    }


}
