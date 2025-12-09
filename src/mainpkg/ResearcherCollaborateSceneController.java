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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ResearcherCollaborateSceneController implements Initializable {

    @FXML
    private TableView<CollaborationRequest> requestTableView;
    @FXML
    private TableColumn<CollaborationRequest, Integer> idTableCol;
    @FXML
    private TableColumn<CollaborationRequest, String> messageTableCol;
    @FXML
    private TextField requestIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idTableCol.setCellValueFactory(new PropertyValueFactory<CollaborationRequest,Integer>("collborationReqID"));
        messageTableCol.setCellValueFactory(new PropertyValueFactory<CollaborationRequest,String>("collaborationReqContent"));
        
        Researcher.LoadCollaborationRequestTable(requestTableView);
    }    

    @FXML
    private void acceptRequestButtonOnClick(ActionEvent event) {
        int collaborationRequestToApproveID = Integer.parseInt(requestIDTextField.getText());
        
        CollaborationRequest collaborationRequestToApprove = Researcher.getCollaborationRequest(collaborationRequestToApproveID);
        Researcher.approveRequestToFile(collaborationRequestToApprove);
    }
    
}
