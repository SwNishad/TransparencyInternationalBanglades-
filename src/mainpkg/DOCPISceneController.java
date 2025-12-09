/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class DOCPISceneController implements Initializable {

    @FXML
    private AnchorPane updateCPIAnchorPane;
    @FXML
    private Label confirmationLabel;
    @FXML
    private TextField enterCountryTextField;
    @FXML
    private TextField enterCPIIndexTextField;
    @FXML
    private TextField enterYearTextField;
    @FXML
    private TableView<CPI> cpiIndexTableView;
    @FXML
    private TableColumn<CPI, String> countryTableColoumn;
    @FXML
    private TableColumn<CPI, Integer> yearTableColoumn;
    @FXML
    private TableColumn<CPI, Integer> cpiTableColoumn;
    
    private List<CPI> cpiData = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryTableColoumn.setCellValueFactory(new PropertyValueFactory<CPI,String>("cpiCountry"));
        yearTableColoumn.setCellValueFactory(new PropertyValueFactory<CPI,Integer>("cpiyear"));
        cpiTableColoumn.setCellValueFactory(new PropertyValueFactory<CPI,Integer>("cpiIndexValue"));
        
        
        CPI.LoadCPITable(cpiIndexTableView);
        
     
    }    

    @FXML
    private void updateCPIButtonOnClick(ActionEvent event) {
        CPI newCPI = new CPI(enterCountryTextField.getText(),Integer.parseInt(enterYearTextField.getText()),Integer.parseInt(enterCPIIndexTextField.getText()));
        CPI.WriteCPItoFile(newCPI);
    }
          
    
}

