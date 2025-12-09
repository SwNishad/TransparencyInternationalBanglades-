/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;

//ADMINISTRATOR

public class AnalysisSceneController implements Initializable {

    @FXML
    private PieChart pieChartA;
    @FXML
    private PieChart pieChartB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private ObservableList <PieChart.Data> listA = FXCollections.observableArrayList();
    private ObservableList <PieChart.Data> listB = FXCollections.observableArrayList();

    @FXML
    private void generateSummaryButtonOnClick(ActionEvent event) {
        
        int adminCount = 0; int secretaryCount = 0;  int dataofficerCount = 0; 
        int journalistCount = 0; int researcherCount = 0; int recordkeeperCount = 0; int mediaofficerCount = 0;
        
        int fulltimeCount = 0; int parttimeCount = 0;
        
        Admin.GenerateEmployeeDesignationSummary(listA, pieChartA, adminCount, secretaryCount, dataofficerCount, journalistCount, researcherCount, recordkeeperCount, mediaofficerCount);
        Admin.GenerateEmployeeFullTimeSummary(listB, pieChartB, fulltimeCount, parttimeCount);
        
    }

    



    
    
}
