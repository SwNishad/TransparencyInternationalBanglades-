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


public class PublicWorkshopController implements Initializable {

    @FXML
    private TableView<PublicWorkshop> publicworkshopTABLEVIEW;
    @FXML
    private TableColumn<PublicWorkshop, Integer> workshopNoColumn;
    @FXML
    private TableColumn<PublicWorkshop, String> workshopAgendaColumn;
    @FXML
    private TableColumn<PublicWorkshop, String> speakerColumn;
    @FXML
    private TableColumn<PublicWorkshop, LocalDate> workshopDateColumn;

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
    private void updateonClick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PublicWorkshopUpdate.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }
    
    @FXML
    private void showPublicWorkshop(MouseEvent event) {
        PublicWorkshop.viewPublicWorkshop(publicworkshopTABLEVIEW);
    }
    
}
