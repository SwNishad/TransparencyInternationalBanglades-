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


public class DashboardSecretaryController implements Initializable {

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
    private void SingOutButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene admindashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(admindashboard);
            stg2.show();
    }

    @FXML
    private void AnnouncementButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Announcement.fxml"));
        borderPane.setCenter(parent);    

    }



    @FXML
    private void OperationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("OperationsSecretary.fxml"));
        borderPane.setCenter(parent);    

    }

    @FXML
    private void RaiseSalaryButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RequestRaise.fxml"));
        borderPane.setCenter(parent);    

    }

    @FXML
    private void IncidentButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ReportIncident.fxml"));
        borderPane.setCenter(parent);    

    }

    @FXML
    private void resignationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Resignation.fxml"));
        borderPane.setCenter(parent);    

    }

    @FXML
    private void employeeInfoMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewAndPrintEmployeeIDScene.fxml"));
        borderPane.setCenter(parent);  
    }

    @FXML
    private void viewResourcesMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewResources.fxml"));
        borderPane.setCenter(parent);    

    }

    @FXML
    private void employeeBenifitsMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ExploreBenefits.fxml"));
        borderPane.setCenter(parent);   
    }

    
}
