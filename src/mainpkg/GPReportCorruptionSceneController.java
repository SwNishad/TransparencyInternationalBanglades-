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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class GPReportCorruptionSceneController implements Initializable {

    @FXML
    private TextArea reportContentTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitReportButtonOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int reportID = (int) (timestamp & 0xFFFFFFFF); // Lower 32 bits
        CorruptionReport corruptionReport = new CorruptionReport(reportID, reportContentTextArea.getText(), "Corruption Report");
        
        CorruptionReport.generateReportToFile(corruptionReport);
    }

    
}
