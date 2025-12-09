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
import javafx.scene.control.TextArea;

//RESEARCHER

public class ResourceCenterSceneController implements Initializable {

    @FXML
    private TextArea sendResourcesTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int resourceID = (int) (timestamp & 0xFFFFFFFF);
        String resourceContent = sendResourcesTextArea.getText();
        
        ResearcherDocument newDoc = new ResearcherDocument(resourceID, resourceContent);
            
        
        Researcher.WriteResource(newDoc);
        
    }
    
}
