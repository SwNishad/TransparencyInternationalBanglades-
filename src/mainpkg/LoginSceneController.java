/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mainpkg;

import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class LoginSceneController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField userIdTextField;
    @FXML
    private PasswordField passwordPasswordField;
    private Button loginButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
                  
                
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        
        //Super user login code (dummy)
        
        Employee admin = new Employee(1000, "John Doe", "password", "Admin", 1000.00, true, LocalDate.of(2000, Month.JANUARY, 1));
        
        int givenUserID = Integer.parseInt(userIdTextField.getText());
        String givenPassword = passwordPasswordField.getText();
        
        if ((givenUserID == admin.getEmployeeID()) && (givenPassword == null ? admin.getEmployeePassword() == null : givenPassword.equals(admin.getEmployeePassword()))) {
            
            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
            Scene admindashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(admindashboard);
            stg2.show();
        
        }else {
                    
                    }
        
        
        
        // Actual Login Code
        
        int login = User.userLogin(Integer.parseInt(userIdTextField.getText()), passwordPasswordField.getText());
        
        switch(login){
            
            case 1: 
                System.out.println("Login Successful - Admin");                         //Admin authenticated
                Parent adminParent = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
                Scene admindashboard = new Scene(adminParent);
                Stage stg1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg1.setScene(admindashboard);
                stg1.show();
                break;
            case 2: 
                System.out.println("Login Successful - General Public");                         //Admin authenticated
                Parent gpParent = FXMLLoader.load(getClass().getResource("GPDashboard.fxml"));
                Scene gpdashboard = new Scene(gpParent);
                Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg2.setScene(gpdashboard);
                stg2.show();
                break;             
            case 3:
                System.out.println("Login Successful - Secretary");
                Parent secretaryParent = FXMLLoader.load(getClass().getResource("DashboardSecretary.fxml"));
                Scene secretarydashboard = new Scene(secretaryParent);
                Stage stg3 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg3.setScene(secretarydashboard);
                stg3.show();
                break;
            case 4:
                System.out.println("Login Successful - Data Officer");
                Parent dataofficerParent = FXMLLoader.load(getClass().getResource("DashboardDataOfficer.fxml"));
                Scene dataofficerdashboard = new Scene(dataofficerParent);
                Stage stg4 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg4.setScene(dataofficerdashboard);
                stg4.show();                
                break;
            case 5: 
                System.out.println("Login Successful - Journalist");
                Parent journalistParent = FXMLLoader.load(getClass().getResource("JournalistDashboard.fxml"));
                Scene journalistdashboard = new Scene(journalistParent);
                Stage stg5 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg5.setScene(journalistdashboard);
                stg5.show();
                break;
            case 6: 
                System.out.println("Login Successful - Researcher");
                Parent researcherParent = FXMLLoader.load(getClass().getResource("ResearcherDashboard.fxml"));
                Scene researcherdashboard = new Scene(researcherParent);
                Stage stg6 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg6.setScene(researcherdashboard);
                stg6.show();
                break;    
            case 7:
                System.out.println("Login Successful - Recordkeeper");
                Parent recordkeeperParent = FXMLLoader.load(getClass().getResource("RecordKeeperDash.fxml"));
                Scene recordkeeperdashboard = new Scene(recordkeeperParent);
                Stage stg7 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg7.setScene(recordkeeperdashboard);
                stg7.show();
                break;
            case 8: 
                System.out.println("Login Successful - Media Officer");
                Parent mediaofficerParent = FXMLLoader.load(getClass().getResource("MediaOfficerDash.fxml"));
                Scene mediaofficerdashboard = new Scene(mediaofficerParent);
                Stage stg8 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg8.setScene(mediaofficerdashboard);
                stg8.show();
                break;
            case 10:    //Wrong Password                
                Alert wrongPass = new Alert(Alert.AlertType.INFORMATION);
                wrongPass.setTitle("Login Error");
                wrongPass.setHeaderText("Incorrect Information");
                wrongPass.setContentText("Please check your credentials");
                wrongPass.showAndWait();                 
                break;
            case 11:    //User does not exist
                Alert wrongUser = new Alert(Alert.AlertType.INFORMATION);
                wrongUser.setTitle("Login Error");
                wrongUser.setHeaderText("Incorrect Password");
                wrongUser.setContentText("Please check your credentials");
                wrongUser.showAndWait();
                break; 
        }   
        
    }

    @FXML
    private void enterkeytopassword(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (event.getSource() == userIdTextField) {
                passwordPasswordField.requestFocus();
            } else if (event.getSource() == passwordPasswordField) {
            }
        }
    }

    @FXML
    private void applyForMembershipButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("GPSignUpScene.fxml"));
            Scene GPSignUpScene = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(GPSignUpScene);
            stg2.show();
    }


    
}
