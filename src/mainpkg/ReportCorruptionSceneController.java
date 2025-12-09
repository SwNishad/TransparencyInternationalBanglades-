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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;


public class ReportCorruptionSceneController implements Initializable {

    @FXML
    private TableView<CorruptionReport> corruptionReportsTableView;
    @FXML
    private TableColumn<CorruptionReport, Integer> reportIDColumn;
    @FXML
    private TableColumn<CorruptionReport, String> reportContentColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reportIDColumn.setCellValueFactory(new PropertyValueFactory<CorruptionReport, Integer>("reportID"));
        reportContentColumn.setCellValueFactory(new PropertyValueFactory<CorruptionReport, String>("reportContent"));
    }    

    @FXML
    private void viewReport(MouseEvent event) {
        CorruptionReport.LoadCorruptionReports(corruptionReportsTableView);
    }

    @FXML
    private void pdfONCLICK(ActionEvent event) {
        try{

           FileChooser fc = new FileChooser();
           fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", ".pdf"));
           fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files",".txt"));
            
           File f = fc.showSaveDialog(null);

            if(f!=null){
               PdfWriter pw = new PdfWriter(new FileOutputStream(f));
               PdfDocument pdf =  new PdfDocument(pw);
               pdf.addNewPage();
               Document doc = new Document(pdf);
               doc.setLeftMargin(70);
               
               doc.add(new Paragraph("\n"));

            // Iterate through TableView items
            for (CorruptionReport report : corruptionReportsTableView.getItems()) {
                String reportContent = report.getReportContent();
                // Create a paragraph for each report
                Paragraph para = new Paragraph("Report Content: " + reportContent);
                para.setTextAlignment(TextAlignment.LEFT);
                para.setFontSize(16f);
                doc.add(para);
            }
               Text titleText = new Text("Transparency International Bangladesh: Corruption Report");
               titleText.setFontSize(23f);
               Paragraph pageTitle = new Paragraph(titleText);
               pageTitle.setBold();
               pageTitle.setFontColor(Color.BLUE);
               pageTitle.setTextAlignment(TextAlignment.CENTER);

               PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
               PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

               doc.add(pageTitle);
                
               Alert a = new Alert(Alert.AlertType.INFORMATION);
               a.setContentText("Corruption Report PDF created successfully!");
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
