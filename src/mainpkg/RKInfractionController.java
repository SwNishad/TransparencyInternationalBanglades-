/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class RKInfractionController implements Initializable {

    @FXML
    private TextField infractionOffenderTXTFIELD;
    @FXML
    private TextField infractionIDTXTFIELD;
    @FXML
    private DatePicker infractionDateDP;
    @FXML
    private TextField infractionAmountChargedTXT;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitInfractionONCLICK(ActionEvent event) {
        int infractionID = Integer.parseInt(infractionIDTXTFIELD.getText());
        String infractionOffender = infractionOffenderTXTFIELD.getText();
        int infractionAmountCharged = Integer.parseInt(infractionAmountChargedTXT.getText());
        LocalDate infractionDate = infractionDateDP.getValue();
        
        Infraction newInfraction = new Infraction(infractionID, infractionOffender, infractionAmountCharged,infractionDate);
        
        Infraction.createInfractionLogs(newInfraction);

    
    }

    @FXML
    private void saveOnClick(ActionEvent event) {

        try{

            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", ".pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files",".txt"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Doc files",".docx"));
            
            File f = fc.showSaveDialog(null);

            if(f!=null){
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);

                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(4);

                String paraText1 
                        = "Infraction ID: " + infractionIDTXTFIELD.getText()
                        + "\2nOffender: " + infractionOffenderTXTFIELD.getText()
                        + "\nCharged Amount: " + infractionAmountChargedTXT.getText()
                        + "\nDate of Offense: " + infractionDateDP.getValue();
                Paragraph para1 = new Paragraph(paraText1);
                para1.setTextAlignment(TextAlignment.LEFT);
                para1.setFontSize(16f);
                Text titleText = new Text("Transparency International Bangladesh: Infraction Logs");
                titleText.setFontSize(23f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                pageTitle.setFontColor(Color.BLUE);
                pageTitle.setTextAlignment(TextAlignment.CENTER);

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(lineSpace);
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Infraction PDF created successfully!");
                a.showAndWait();

                doc.close();
            }
            else{
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                b.setContentText("Could not generate PDF");
                b.showAndWait();}

            }catch(Exception e){
               Alert a = new Alert(Alert.AlertType.INFORMATION);
               a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
               a.showAndWait(); 

        }

    }

}