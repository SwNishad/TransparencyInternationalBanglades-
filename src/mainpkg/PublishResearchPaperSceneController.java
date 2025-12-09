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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class PublishResearchPaperSceneController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField researchTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void publishButtonOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int publicationID = (int) (timestamp & 0xFFFFFFFF);
        String publicationTitle = researchTitle.getText();
        String publicationContent = textArea.getText();
        
                
        ResearchPaper newPaper = new ResearchPaper(publicationID, publicationTitle, publicationContent);
                 
        
        Researcher.publishResearchPaper(newPaper);
        
        
        
        
        
    }
    
}
