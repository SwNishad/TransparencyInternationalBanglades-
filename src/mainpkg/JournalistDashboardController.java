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


public class JournalistDashboardController implements Initializable {

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
    private void FileAReportMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPReportCorruptionScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void FileAComplaintMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ComplaintScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void PublishArticleMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublishArticleScene.fxml"));
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
    private void ExclusiveCommunicationsSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CommunicationScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void PressConferenceSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PressConferenceScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void ApplyForWorkshopSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("WorkshopApplyScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void CollaborateSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CollaborateScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void PublicationsSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublicationsScene.fxml"));
        borderPane.setCenter(parent);  
    }
    
}
