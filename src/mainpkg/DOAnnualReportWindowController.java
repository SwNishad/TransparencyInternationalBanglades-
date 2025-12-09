/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author MSI Prestige
 */
public class DOAnnualReportWindowController implements Initializable {

    @FXML
    private PieChart incidentCountPieChart;
    @FXML
    private BarChart<String, Number> eventsCountBarChart;
    @FXML
    private LineChart<String, Number> countryCountLineChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private ObservableList <PieChart.Data> listX = FXCollections.observableArrayList();

    @FXML
    private void generateChartsOnClick(ActionEvent event) {
        //pie chart
        int incidentCount2020 = 0; int incidentCount2021 = 0;  int incidentCount2022 = 0; 
        int incidentCount2023 = 0;
        
        DODataOfficer.GenerateIncidentCountSummary(listX, incidentCountPieChart, incidentCount2020, incidentCount2021, incidentCount2022, incidentCount2023);
        
        //bar chart
        int eventCount2020 = 0; int eventCount2021 = 0;  int eventCount2022 = 0; 
        int eventCount2023 = 0;
        
        DODataOfficer.generateEventsCountSummary(eventsCountBarChart, eventCount2020, eventCount2021, eventCount2022, eventCount2023);
        
        //line chart
        int countryCount2020 = 0; int countryCount2021 = 0;  int countryCount2022 = 0; 
        int countryCount2023 = 0;
        
        DODataOfficer.generateCountryCountSummary(countryCountLineChart, countryCount2020, countryCount2021, countryCount2022, countryCount2023);
    }

    
}
