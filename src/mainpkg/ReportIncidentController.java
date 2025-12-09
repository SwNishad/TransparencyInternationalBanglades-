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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


/**
 * FXML Controller class
 *
 * @author Shohel
 */
public class ReportIncidentController implements Initializable {

    @FXML
    private AnchorPane ReportIncidentAnchorPane;
    @FXML
    private DatePicker DOIdatePicker;
    @FXML
    private TextField TimeOfIncidentTExtFied;
    @FXML
    private TextField involvedPartiesTextField;
    @FXML
    private TextArea descriptionTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savePrintReportButtonOnClick(ActionEvent event) {
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

            
                Text titleText = new Text("Workplace Incident Report");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                doc.add(pageTitle);

            // Adding user inputs
                String date = "Date of Incident: " + DOIdatePicker.getValue();
                Paragraph dateParagraph = new Paragraph(date);
                doc.add(dateParagraph);

                String time = "Time of Incident: " + TimeOfIncidentTExtFied.getText();
                Paragraph timeParagraph = new Paragraph(time);
                doc.add(timeParagraph);

                String parties = "Involved Parties: " + involvedPartiesTextField.getText();
                Paragraph partiesParagraph = new Paragraph(parties);
                doc.add(partiesParagraph);

                String description = "Description:\n" + descriptionTextArea.getText();
                Paragraph descriptionParagraph = new Paragraph(description);
                doc.add(descriptionParagraph);

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
    
