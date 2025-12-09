/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class RKPolicySceneController implements Initializable {

    @FXML
    private TextArea outputtxtarea;
    @FXML
    private Button gotoupdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    ArrayList<RecordKeeperPolicy> rkpolicyList = new ArrayList();

    @FXML
    private void gobacktoRKdash(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("RecordKeeperDash.fxml"));
        Scene recordkeeperdash = new Scene(mainSceneParent);
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(recordkeeperdash);
        stg2.show();
    }

    @FXML
    private void updatepolicyonclick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RKPolicyUpdate.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void createonclick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RKPolicyCreate.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();

    }

    @FXML
    private void viewpolicy(MouseEvent event) {
        RecordKeeper.viewRKPolicy(outputtxtarea);   
    }
}
