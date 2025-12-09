/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MediaOfficerDashController implements Initializable {

    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CompProfileMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CompanyInfoScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void CompMeetingMenuItemonclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RKViewCompanyMeeting.fxml"));
        borderPane.setCenter(parent); 
    }


    @FXML
    private void SignOutButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene admindashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(admindashboard);
            stg2.show();
    }

    @FXML
    private void announcementONclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Announcement.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void pressConfONclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PressConference.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void pendingArticlesONclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublishArticlePostWindow.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void exclusiveCommsONclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ExclusiveComm.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void LeaveOfAbsenceONclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("MediaOfficerLOA.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void publicWorkshopOnclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublicWorkshop.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void makeAnnouncementOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AnnounceMake.fxml"));
        borderPane.setCenter(parent);
    }

    
    
}
