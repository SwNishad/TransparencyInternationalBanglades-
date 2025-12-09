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

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FinancesSceneController implements Initializable {

    @FXML
    private TextField currentAssetsTextField;
    @FXML
    private TextField currentLiabilitiesTextField;
    @FXML
    private TextField marketableSecuritiesTextField;
    @FXML
    private TextField cashInHandTextField;
    @FXML
    private ComboBox<String> selectLiquidityRatioComboBox;
    @FXML
    private TextArea displayLiquidityRatioResultTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectLiquidityRatioComboBox.getItems().addAll("Current Ratio", "Cash Ratio");
        // TODO
    }    

    @FXML
    private void calculateButtonOnClick(ActionEvent event) {
        
        float currentAssets = Float.parseFloat(currentAssetsTextField.getText());
        float currentLiabilities = Float.parseFloat(currentLiabilitiesTextField.getText());
        float marketableSecurities = Float.parseFloat(marketableSecuritiesTextField.getText());
        float cashInHand = Float.parseFloat(cashInHandTextField.getText());
        
        FinanceRecord financeRecord = new FinanceRecord(currentAssets, currentLiabilities, cashInHand, marketableSecurities);
        
        if (selectLiquidityRatioComboBox.getValue() == "Cash Ratio") {
            float ratioResult = financeRecord.calculateCashRatio(cashInHand, marketableSecurities, currentLiabilities);
            displayLiquidityRatioResultTextArea.setText(financeRecord.cashToString(ratioResult));            
        }
        if (selectLiquidityRatioComboBox.getValue() == "Current Ratio") {
            float ratioResult = financeRecord.calculateCurrentRatio(currentAssets, currentLiabilities);
            displayLiquidityRatioResultTextArea.setText(financeRecord.currentToString(ratioResult));
        }        
        
        
        
        
        
        
    }
    
}
