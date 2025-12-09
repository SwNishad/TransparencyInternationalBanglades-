/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI Prestige
 */
public class DOAnnualReportController implements Initializable {

    @FXML
    private AnchorPane annualReportAnchorPane;
    @FXML
    private ComboBox<Integer> SelectYearComboBox;
    @FXML
    private TextField noOfincidentsTextField;
    @FXML
    private TextField noOffCTextField;
    @FXML
    private TextField noOfCountriesTextField;
    @FXML
    private TextField noOfEventsTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         IntStream.rangeClosed(2015, 2025).forEach(year -> SelectYearComboBox.getItems().add(year));
        // TODO
    }    

    @FXML
    private void generatePDFReportButtonOnClick(ActionEvent event) {
        try {
            int selectedYear = SelectYearComboBox.getValue();
        
            int noOfIncidents = Integer.parseInt(noOfincidentsTextField.getText());
            int noOfEvents = Integer.parseInt(noOfEventsTextField.getText());
            int noOfCountries = Integer.parseInt(noOfCountriesTextField.getText());
            int noOfInfractions = Integer.parseInt(noOffCTextField.getText());
        
            String reportContent = "Year: " + selectedYear +  "\nNumber of Incidents: "+ noOfIncidents + "Number of Events: " + noOfEvents + "\nNumber of countries: " + noOfCountries + "\nNumber of Infractions: "+ noOfInfractions;
        
        // Create DOAnnualReport object
            DOAnnualReport annualReport = new DOAnnualReport(selectedYear, noOfIncidents, noOfEvents, noOfCountries, noOfInfractions, "", "Annual Report", 1);
            
            DOAnnualReport.WriteAnnualReportToFile(annualReport);            
            DOAnnualReport.generateAnnualReport(annualReport);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
    
        
        // TODO: Generate and save PDF report based on annualReport
    }


    @FXML
    private void analyseReportButtononClick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DOAnnualReportWindow.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        
    }
    
}
