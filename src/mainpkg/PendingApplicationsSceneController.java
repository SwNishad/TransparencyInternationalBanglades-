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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class PendingApplicationsSceneController implements Initializable {

    @FXML
    private TextField requestIDToApproveTextField;
    @FXML
    private TableView<AdminRequest> pendingRequestsTableView;
    @FXML
    private TableColumn<AdminRequest, Integer> requestIDTableColumn;
    @FXML
    private TableColumn<AdminRequest, String> requestContentTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        requestIDTableColumn.setCellValueFactory(new PropertyValueFactory<AdminRequest,Integer>("adminRequestID"));
        requestContentTableColumn.setCellValueFactory(new PropertyValueFactory<AdminRequest,String>("adminRequestContent"));
    }    

    @FXML
    private void approveRequestButtonOnClick(ActionEvent event) {
        int adminRequestToApproveID = Integer.parseInt(requestIDToApproveTextField.getText());
        
        AdminRequest adminRequestToApprove = Admin.getAdminRequest(adminRequestToApproveID);
        Admin.approveRequestToFile(adminRequestToApprove);
    }

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        pendingRequestsTableView.getItems().clear();
        Admin.LoadAdminRequestTable(pendingRequestsTableView);
    }
    
}
