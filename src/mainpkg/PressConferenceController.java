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



public class PressConferenceController implements Initializable {

    @FXML
    private TableView<PressConference> pressConferenceTABLEVIEW;
    @FXML
    private TableColumn<PressConference, LocalDate> pressDateColumn;
    @FXML
    private TableColumn<PressConference, LocalDate> pressTimeColumn;
    @FXML
    private TableColumn<PressConference, String> pressVenueColumn;
    @FXML
    private TableColumn<PressConference, String> pressAgendaColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pressDateColumn.setCellValueFactory(new PropertyValueFactory<PressConference,LocalDate>("pressDate"));
        pressTimeColumn.setCellValueFactory(new PropertyValueFactory<PressConference,LocalDate>("pressTime"));
        pressVenueColumn.setCellValueFactory(new PropertyValueFactory<PressConference,String>("pressVenue"));        
        pressAgendaColumn.setCellValueFactory(new PropertyValueFactory<PressConference,String>("pressAgenda")); 
      
    }    

    @FXML
    private void editPCONCLICK(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PressConfUpdate.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void showPressSchedule(MouseEvent event) {
        PressConference.viewPressConference(pressConferenceTABLEVIEW);
    }
    
}
