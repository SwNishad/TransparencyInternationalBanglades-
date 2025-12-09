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

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Acer
 */
public class GPDonateSceneController implements Initializable {


    @FXML
    private BarChart<String, Number> donationInActionBarChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private TextField donatedAmountTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void donateButtonOnClick(ActionEvent event) {
        int donatedAmount = Integer.parseInt(donatedAmountTextField.getText());
        
        int reportsProcessed = donatedAmount / 150;
        int districtsSupported = donatedAmount / 100000;
        int researchProjectsFunded = donatedAmount / 15000;
        int eventsFunded = donatedAmount / 1000;
        int movementsSupported = donatedAmount / 5000;
        
                
        //generate bar chart
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        
        
        series.getData().add(new XYChart.Data<String,Number>("Reports Processed",reportsProcessed));
        series.getData().add(new XYChart.Data<String,Number>("Districts Supported",districtsSupported));
        series.getData().add(new XYChart.Data<String,Number>("Research Projects Funded",researchProjectsFunded));
        series.getData().add(new XYChart.Data<String,Number>("Events Funded",eventsFunded));
        series.getData().add(new XYChart.Data<String,Number>("Movements Supported",movementsSupported));
        series.setName("Donation Overview");
        donationInActionBarChart.getData().add(series);
    }

}
