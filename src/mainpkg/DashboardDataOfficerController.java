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


public class DashboardDataOfficerController implements Initializable {

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
    private void SignOutButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene admindashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(admindashboard);
            stg2.show();
    }

    @FXML
    private void AnnualReportButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DOAnnualReport.fxml"));
        borderPane.setCenter(parent);    
    }


    @FXML
    private void eventsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PublicWorkshop.fxml"));
        borderPane.setCenter(parent);    

    }


    @FXML
    private void OperationsButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DORequestMeetingScene.fxml"));
        borderPane.setCenter(parent);    
    }


    @FXML
    private void benefitsAndPerksButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ExploreBenefits.fxml"));
        borderPane.setCenter(parent);    
    }

    @FXML
    private void updateCPIMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DOCPIScene.fxml"));
        borderPane.setCenter(parent);    
    }

    @FXML
    private void calculateTaxMentuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DOCalculateTaxScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void verifyEmployeeMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DODataVerify.fxml"));
        borderPane.setCenter(parent); 
    }
    
}
