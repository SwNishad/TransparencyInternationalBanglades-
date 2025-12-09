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

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class GPDashboardController implements Initializable {

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
    private void activeCitizensMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPActiveCitizensScene.fxml"));
        borderPane.setCenter(parent); 
    }


    @FXML
    private void AnnualReportsMenuItemOnClick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DOAnnualReportWindow.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void SignOutButtonOnClick(ActionEvent event) throws IOException {        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene gpdashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(gpdashboard);
            stg2.show();        
    }

    @FXML
    private void UserProfileSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPUserProfileScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void ReportCorruptionSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPReportCorruptionScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void EventsSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPViewPublicWorkshopScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void DonateSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPDonateScene.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void communityResourcesMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GPViewEducationalResourcesScene.fxml"));
        borderPane.setCenter(parent); 
    }
    
}
