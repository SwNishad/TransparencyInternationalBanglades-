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
import javafx.scene.control.Label;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CompanyInfoSceneController implements Initializable {

    @FXML
    private Label registeredNameLabel;
    @FXML
    private Label establishedYearLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label aboutLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void printPDFButtonOnClick(ActionEvent event) throws MalformedURLException, FileNotFoundException {
        
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));
            
            File f = fc.showSaveDialog(null);
            
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Registered Name: Transparency International Bangladesh\n"
                        + "Established: 1997\n"
                        + "Address: House-5, Road-16, Dhanmondi, Dhaka-1209\n"
                        + "Phone: (+880-2) 41021267-70\n"
                        + "Email: info@ti-bangladesh.org\n"
                        + "About: Transparency International Bangladesh (TIB) is the Bangladeshi branch of the Berlin-based Transparency International, a civil society organisation dedicated to fighting against corruption.\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Transparency International: Bangladesh Chapter");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();   

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                //doc.add(bookInfo);
                doc.add(lineSpace);
                
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
