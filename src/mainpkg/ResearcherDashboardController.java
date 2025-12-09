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


public class ResearcherDashboardController implements Initializable {

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
    private void VirtualConferenceMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VirtualConferenceScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void ContactsMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewContactsScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void ApplyForResearchNetworkMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ResearchNetworkApplication.fxml"));
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
    private void ApplyForFundingSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ResearchFundingScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void ProposeResearchTopicSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ResearchTopicProposalScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void ResourceCenterSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ResourceCenterScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void CollaborateSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ResearcherCollaborateScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void PublishSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublishResearchPaperScene.fxml"));
        borderPane.setCenter(parent);  
    }
    
}
