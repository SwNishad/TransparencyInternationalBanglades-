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
import javafx.scene.layout.AnchorPane;


public class DOCalculateTaxSceneController implements Initializable {

    @FXML
    private AnchorPane calculateTaxAnchorPane;
    @FXML
    private TextArea showPayableTaxTextArea;
    @FXML
    private TextField assetValueTextField;
    @FXML
    private TextField deductionTextField;
    @FXML
    private ComboBox<String> selectTaxType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectTaxType.getItems().addAll("Asset Tax", "Inventory Tax");
        // TODO
    }    

    @FXML
    private void calculateTaxButtonOnClick(ActionEvent event) {
        double assetValue = Double.parseDouble(assetValueTextField.getText());
        double deduction = Double.parseDouble(deductionTextField.getText());
        String selectedTaxType = selectTaxType.getValue();
        double taxRate = 0.0;

        if (selectedTaxType.equals("Asset Tax")) {
            taxRate = 1.8;
        } else if (selectedTaxType.equals("Inventory Tax")) {
            taxRate = 3.4;
        }

        double taxableAmount = assetValue - deduction;
        double payableTax = (taxableAmount * taxRate) / 100;

        String formattedTaxRate = String.format("%.1f%%", taxRate);
        String formattedPayableTax = String.format("%.2f", payableTax);

        String result = "Tax Type: " + selectedTaxType + "\n"
            + "Tax Rate: " + formattedTaxRate + "\n"
            + "Payable Tax Amount: " + formattedPayableTax + " tk";

        showPayableTaxTextArea.setText(result);
    }
    

}    
