/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;



public class ExploreBenefitsController implements Initializable {

    @FXML
    private AnchorPane employeeBenefitsAnchoPane;
    @FXML
    private TextArea emloyeeBenefitsDetailsTextArea;
    @FXML
    private ComboBox<String> workDurationComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workDurationComboBox.getItems().addAll(
                "Less than 1 Year", "1 Year", "2 Years", "3 Years", "4 Years", "5+ Years"
        );
        // TODO
    }    

    @FXML
    private void viewBenifitsButtonOnClick(ActionEvent event) {
        String selectedDuration = workDurationComboBox.getValue().toString(); // Get selected duration
    
    // Update employee benefits details based on selected duration
        switch (selectedDuration) {
            case "Less than 1 Year":
                emloyeeBenefitsDetailsTextArea.setText(
                "Onboarding Support\nSkill Enhancement Workshops\nFlexible Work Arrangements"
                );
                break;
            case "1 Year":
                emloyeeBenefitsDetailsTextArea.setText(
                "Health & Wellness Benefits\nPerformance Bonuses\nProfessional Memberships"
                );
                break;
            case "2 Years":
                emloyeeBenefitsDetailsTextArea.setText(
                "Professional Development Funding\nIncreased Paid Time Off\nProject Leadership Opportunities"
                );
                break;
            case "3 Years":
                emloyeeBenefitsDetailsTextArea.setText(
                "Career Path Planning\nAdditional Retirement Contributions\nTraining and Conferences Abroad"
                );
                break;
            case "4 Years":
                emloyeeBenefitsDetailsTextArea.setText(
                "Leadership Training Opportunities\nSabbatical Leave Options\nStock Options or Equity Grants"
                );
                break;
            case "5+ Years":
                emloyeeBenefitsDetailsTextArea.setText(
                "Generous Annual Leave\nSpecial Recognition & Awards\nExecutive Coaching and Mentorship"
                );
                break;
        default:
            emloyeeBenefitsDetailsTextArea.setText("No benefits available for the selected duration.");
        }
    }
}

