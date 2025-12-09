/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class RecordsSceneController implements Initializable {

    
    @FXML
    private TableColumn<Infraction, Integer> infractionIDCOLUMN;
    @FXML
    private TableColumn<Infraction, String> infractionOffenderCOLUMN;
    @FXML
    private TableColumn<Infraction, Integer> infractionAmountChargedCOLUMN;
    @FXML
    private TableColumn<Infraction, LocalDate> infractionDateCOLUMN;
    @FXML
    private TableView<Infraction> infractionsTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        infractionIDCOLUMN.setCellValueFactory(new PropertyValueFactory<Infraction,Integer>("infractionID"));
        infractionOffenderCOLUMN.setCellValueFactory(new PropertyValueFactory<Infraction,String>("infractionOffender"));
        infractionAmountChargedCOLUMN.setCellValueFactory(new PropertyValueFactory<Infraction,Integer>("infractionAmountCharged"));        
        infractionDateCOLUMN.setCellValueFactory(new PropertyValueFactory<Infraction,LocalDate>("infractionDate"));       
        
       
    }    

    private void editInfractionsONCLICK(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordsEditWindow.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void viewInfractionMOUSECLICK(MouseEvent event) {
        Infraction.viewInfractionLogs(infractionsTableView);
    }

    @FXML
    private void viewOnClick(ActionEvent event) {
        Infraction.viewInfractionLogs(infractionsTableView);
    }

    
}
