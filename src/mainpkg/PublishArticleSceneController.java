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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

//JOURNALIST

public class PublishArticleSceneController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private ComboBox<String> colorComboBox;
    @FXML
    private ComboBox<Integer> fontSizeComboBox;
    @FXML
    private ComboBox<String> fontStyleComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorComboBox.getItems().addAll("Red", "Green", "Blue");

        fontSizeComboBox.getItems().addAll(12, 16, 20, 24, 28, 32, 36);

        fontStyleComboBox.getItems().addAll("Plain", "Bold", "Italic");

        textArea.setWrapText(true);
       
    }    

    @FXML
    private void onChangeColorClicked() {
        String selectedColor = colorComboBox.getSelectionModel().getSelectedItem();
        if (selectedColor != null) {
            switch (selectedColor) {
                case "Red":
                    textArea.setStyle("-fx-text-fill: red;");
                    break;
                case "Green":
                    textArea.setStyle("-fx-text-fill: green;");
                    break;
                case "Blue":
                    textArea.setStyle("-fx-text-fill: blue;");
                    break;
            }
        }
    }

    @FXML
    private void onChangeFontSizeClicked() {
        Integer selectedFontSize = fontSizeComboBox.getSelectionModel().getSelectedItem();
        if (selectedFontSize != null) {
            Font newFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, selectedFontSize);
            textArea.setFont(newFont);
        }
    }

    @FXML
    private void onFontStyleChanged() {
        String selectedStyle = fontStyleComboBox.getSelectionModel().getSelectedItem();
        Font currentFont = textArea.getFont();
        
        if (selectedStyle != null) {
            Font newFont = applyFontStyle(currentFont, selectedStyle);
            textArea.setFont(newFont);
        }
    }

    private Font applyFontStyle(Font currentFont, String fontStyle) {
    FontWeight fontWeight = currentFont.getStyle().contains("Bold") ? FontWeight.BOLD : FontWeight.NORMAL;
    FontPosture fontPosture = currentFont.getStyle().contains("Italic") ? FontPosture.ITALIC : FontPosture.REGULAR;

    if (fontStyle.equals("Bold")) {
        fontWeight = FontWeight.BOLD;
        fontPosture = currentFont.getStyle().contains("Italic") ? FontPosture.ITALIC : FontPosture.REGULAR;
    } else if (fontStyle.equals("Italic")) {
        fontPosture = FontPosture.ITALIC;
        fontWeight = currentFont.getStyle().contains("Bold") ? FontWeight.BOLD : FontWeight.NORMAL;
    } else if (fontStyle.equals("Plain")) {
        fontWeight = FontWeight.NORMAL;
        fontPosture = FontPosture.REGULAR;
    }

    return Font.font(currentFont.getFamily(), fontWeight, fontPosture, currentFont.getSize());
}

    @FXML
    private void publishButtonOnClick(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int articleID = (int) (timestamp & 0xFFFFFFFF);
        String articleContent = textArea.getText();
                
        Article newArticle = new Article(articleID, articleContent);
                 
        
        Journalist.publishArticle(newArticle);
        
        
    }
    
}
