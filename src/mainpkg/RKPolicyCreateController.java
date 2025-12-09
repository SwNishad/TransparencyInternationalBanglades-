/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class RKPolicyCreateController implements Initializable {

    @FXML
    private TextArea createpolicytxtarea;

    /**
     * Initializes the controller class.
     */
    private String readBinFile() {
    try {
        // Read the binary file and convert its content to a String
        File binaryFile = new File("\"C:\\Users\\Shohel\\Desktop\\TransparencyInternationalBangladesh\\ScheduledInternalMeetings.bin\""); // Provide the actual path to your binary file
        byte[] contentBytes = Files.readAllBytes(binaryFile.toPath());
        return new String(contentBytes, StandardCharsets.UTF_8);
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
        return "Error reading binary file"; // Return an error message or handle the exception
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    ArrayList<RecordKeeperPolicy> rkpolicyList = new ArrayList();


    @FXML
    private void gobackonclick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("RKPolicyScene.fxml"));
        Scene recordkeeperdash = new Scene(mainSceneParent);
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(recordkeeperdash);
        stg2.show();
    }

    @FXML
    private void saveonclick(ActionEvent event) {
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            
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
                        = "In our organization, effective record keeping is essential to ensure accurate and transparent documentation of all activities. This Record Keeper Policy establishes the standards and practices that all employees must adhere to when creating, storing, and accessing records. Records play a crucial role in supporting decision-making processes, tracking progress, and maintaining accountability. By following this policy, we aim to ensure the integrity, security, and accessibility of our records, contributing to the overall efficiency and success of our operations.\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Record Keeper Policy");
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

    @FXML
    private void createonclick(ActionEvent event) {
        RecordKeeper tempRK = new RecordKeeper(700000, "Jane Doe", "password", "RecordKeeper", 20000.00, true, LocalDate.of(2001, Month.JANUARY, 26));
            
        String policycontent = createpolicytxtarea.getText();
        String policytype = createpolicytxtarea.getText();
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Success");
        a.setHeaderText("Record Keeper Policy");
        a.setContentText("Successful!");
        a.showAndWait();
        
        RecordKeeperPolicy newPolicy = new RecordKeeperPolicy(policytype, policycontent);
        rkpolicyList.add(newPolicy);
        
        RecordKeeper.createRKPolicy(newPolicy);
        
    }
        
         
}