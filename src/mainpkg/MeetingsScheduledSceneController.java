/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class MeetingsScheduledSceneController implements Initializable {

    @FXML
    private TextArea scheduledMeetingsDisplayTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void scheduleMeetingButtonOnClick(ActionEvent event) throws IOException {
        
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MeetingSchedulerWindow.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void loadMeetingsButtonOnClick(ActionEvent event) {
        
        Admin.ViewInternalMeetings(scheduledMeetingsDisplayTextArea);        
    }
    
}
