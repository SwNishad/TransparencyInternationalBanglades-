/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EmployeesSceneController implements Initializable {

    @FXML
    private TableView<Employee> employeesTableView;
    @FXML
    private TableColumn<Employee, Integer> employeeIdColumn;
    @FXML
    private TableColumn<Employee, String> employeeNameColumn;
    @FXML
    private TableColumn<Employee, String> employeePasswordColumn;
    @FXML
    private TableColumn<Employee, String> employeeTypeColumn;
    @FXML
    private TableColumn<Employee, Double> employeeSalaryColumn;
    @FXML
    private TableColumn<Employee, Boolean> employeeFullTimeColumn;
    @FXML
    private TableColumn<Employee, LocalDate> employeeDOJColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("employeeID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeName"));
        employeePasswordColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeePassword"));        
        employeeTypeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeType"));        
        employeeSalaryColumn.setCellValueFactory(new PropertyValueFactory<Employee,Double>("employeeSalary"));        
        employeeFullTimeColumn.setCellValueFactory(new PropertyValueFactory<Employee,Boolean>("employeeFullTime"));        
        employeeDOJColumn.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("employeeDOJ"));
        
    }    

    @FXML
    private void toAddEmployeeButtonOnClick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeAddWindow.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void clearTableButtonOnClick(ActionEvent event) {
        employeesTableView.getItems().clear();
    }

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        
        Employee.LoadEmployeesTable(employeesTableView);
         
    }
    
}
