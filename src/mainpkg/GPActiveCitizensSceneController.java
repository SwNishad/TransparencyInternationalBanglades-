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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class GPActiveCitizensSceneController implements Initializable {

    @FXML
    private TableView<GeneralPublic> gpActiveCitizensTable;
    @FXML
    private TableColumn<GeneralPublic, Integer> gpIDColumn;
    @FXML
    private TableColumn<GeneralPublic, String> gpNameColumn;
    @FXML
    private TableColumn<GeneralPublic, LocalDate> gpDOJcolumn;
    @FXML
    private TableColumn<GeneralPublic, String> gpPhoneColumn;
    @FXML
    private TableColumn<GeneralPublic, String> gpEmailColumn;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpIDColumn.setCellValueFactory(new PropertyValueFactory<GeneralPublic,Integer>("gpID"));
        gpNameColumn.setCellValueFactory(new PropertyValueFactory<GeneralPublic,String>("gpName"));
        gpDOJcolumn.setCellValueFactory(new PropertyValueFactory<GeneralPublic,LocalDate>("gpDOJ"));        
        gpPhoneColumn.setCellValueFactory(new PropertyValueFactory<GeneralPublic,String>("gpPhone"));        
        gpEmailColumn.setCellValueFactory(new PropertyValueFactory<GeneralPublic,String>("gpEmail"));
    }    

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        GeneralPublic.LoadCitizensTable(gpActiveCitizensTable);
    }
    
}
