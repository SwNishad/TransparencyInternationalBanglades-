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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

//JOURNALIST

public class ComplaintSceneController implements Initializable {

    @FXML
    private TextArea complaintTextArea;
    @FXML
    private Button homeButtonOnClick;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        String description = complaintTextArea.getText();
        
        Complain newComplain = new Complain(description);

        Complain.WriteComplainToFile(newComplain);
        
        
    }
    
}
