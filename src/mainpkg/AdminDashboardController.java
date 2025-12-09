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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class AdminDashboardController implements Initializable {

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
    private void RecordkeepingSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RecordsScene.fxml"));
        borderPane.setCenter(parent);        
    }

    @FXML
    private void EmployeesSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("EmployeesScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void PendingApplicationsSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PendingApplicationsScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void OperationsSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("MeetingsScheduledScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void FinancesSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FinancesScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void memberVerificationMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VerificationScene.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void companyInformationMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CompanyInfoScene.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void AnalysisMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AnalysisScene.fxml"));
        borderPane.setCenter(parent);
    }
    
    
    
    
}
