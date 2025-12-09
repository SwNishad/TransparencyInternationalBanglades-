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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class PublicWorkshopUpdateController implements Initializable {

    @FXML
    private DatePicker workshopDateDP;
    @FXML
    private TextField workshopNoTXTFIELD;
    @FXML
    private TextField agendaTXTFIELD;
    @FXML
    private TextField speakerTXTFIELD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPWONCLICK(ActionEvent event) {
        int workshopNo = Integer.parseInt(workshopNoTXTFIELD.getText());
        String workshopAgenda = agendaTXTFIELD.getText();
        String speaker = speakerTXTFIELD.getText();
        LocalDate workshopDate = workshopDateDP.getValue();
        
        PublicWorkshop newPW = new PublicWorkshop(workshopNo, workshopAgenda,speaker,workshopDate);
        
        PublicWorkshop.addPublicWorkshop(newPW);
    }
    
}
