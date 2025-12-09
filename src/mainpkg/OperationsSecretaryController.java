/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class OperationsSecretaryController implements Initializable {

    @FXML
    private AnchorPane OperationsSecretaryAnchoPae;
    @FXML
    private CheckBox fileAndFoldersCheckBox;
    @FXML
    private CheckBox envelopesCheckBox;
    @FXML
    private CheckBox stickyNotesCheckBox;
    @FXML
    private CheckBox satpleCheckBox;
    @FXML
    private CheckBox printerInkCheckbox;
    @FXML
    private TextArea itemsSummarytextArea;
    
    private double totalPrice = 0;
    private StringBuilder selectedItems = new StringBuilder();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void placeOderButtonOnClick(ActionEvent event) {
        selectedItems.setLength(0); // Clear the selected items
        totalPrice = 0; // Reset total price
    
        if (fileAndFoldersCheckBox.isSelected()) {
            selectedItems.append("-Files and folders:   TK 500\n");
            totalPrice += 500;
        }
    
        if (envelopesCheckBox.isSelected()) {
            selectedItems.append("-Envelopes:   TK 500\n");
            totalPrice += 500;
            }
    
        if (stickyNotesCheckBox.isSelected()) {
            selectedItems.append("-Sticky notes:   TK 200\n");
            totalPrice += 200;
        
    
        if (satpleCheckBox.isSelected()) {
            selectedItems.append("-Staples and paper clips:   TK 500\n");
            totalPrice += 500;
        }
    
        if (printerInkCheckbox.isSelected()) {
           selectedItems.append("-Printer ink and toner:   TK 1000\n");
           totalPrice += 1000;
        }
    

        itemsSummarytextArea.setText(selectedItems.toString() + "\nTotal Price: TK " + totalPrice);
    }
    
    }  
    
    @FXML
    private void cancelOrderButtonOnClick(ActionEvent event) {
        selectedItems.setLength(0); // 
        totalPrice = 0; // 
        itemsSummarytextArea.clear();
        
        envelopesCheckBox.setSelected(false);
        
    }
     
    @FXML
    private void ConfirmorderButtonOnClick() {
    try {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));

        File f = fc.showSaveDialog(null);

        if (f != null) {
            PdfWriter pw = new PdfWriter(new FileOutputStream(f));
            PdfDocument pdf = new PdfDocument(pw);
            pdf.addNewPage();
            Document doc = new Document(pdf);
            doc.setLeftMargin(70);

            // Adding title and space
            Text titleText = new Text("Order Summary");
            titleText.setFontSize(18f);
            Paragraph pageTitle = new Paragraph(titleText);
            pageTitle.setBold();
            doc.add(pageTitle);

            // Adding selected items and total price
            String selectedItemsText = "Selected Items:\n" + selectedItems.toString();
            Paragraph selectedItemsParagraph = new Paragraph(selectedItemsText);
            doc.add(selectedItemsParagraph);

            String totalPriceText = "Total Price: TK " + totalPrice;
            Paragraph totalPriceParagraph = new Paragraph(totalPriceText);
            doc.add(totalPriceParagraph);

            // Close the document
            doc.close();
        } else {
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("Could not generate PDF");
            b.showAndWait();
        }
    } catch (Exception e) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Oops! Exception: " + e.toString() + " occurred.");
        a.showAndWait();
    }
}

}