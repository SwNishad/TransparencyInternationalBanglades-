/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//JOURNALIST

public class WorkshopApplySceneController implements Initializable {

    @FXML
    private TableColumn<PublicWorkshop, Integer> workshopNoColumn;
    @FXML
    private TableColumn<PublicWorkshop, String> workshopAgendaColumn;
    @FXML
    private TableColumn<PublicWorkshop, String> speakerColumn;
    @FXML
    private TableColumn<PublicWorkshop, LocalDate> workshopDateColumn;
    @FXML
    private TableView<PublicWorkshop> publicworkshopTABLEVIEW;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workshopNoColumn.setCellValueFactory(new PropertyValueFactory<PublicWorkshop, Integer>("workshopNo"));
        workshopAgendaColumn.setCellValueFactory(new PropertyValueFactory<PublicWorkshop, String>("workshopAgenda"));
        speakerColumn.setCellValueFactory(new PropertyValueFactory<PublicWorkshop, String>("speaker"));        
        workshopDateColumn.setCellValueFactory(new PropertyValueFactory<PublicWorkshop, LocalDate>("workshopDate")); 
    }    

    @FXML
    private void applyButtonOnClick(ActionEvent event) {
        Alert b = new Alert(Alert.AlertType.INFORMATION);
         b.setTitle("TIB Workshop");
         b.setHeaderText("Application Status");
         b.setContentText("You have successfully applied to this workshop.");
         b.showAndWait();
    }
    
    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        PublicWorkshop.viewPublicWorkshop(publicworkshopTABLEVIEW);
    }
    
    
}
    
  
