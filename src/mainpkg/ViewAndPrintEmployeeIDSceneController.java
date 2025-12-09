/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author MSI Prestige
 */
public class ViewAndPrintEmployeeIDSceneController implements Initializable {

    @FXML
    private AnchorPane employeeUpdateAnchorPane;
    @FXML
    private TableView<Employee> EmployeeListTableView;
    @FXML
    private TableColumn<Employee, Integer> IDTableColumn;
    @FXML
    private TableColumn<Employee, String> nameTableColumn;
    @FXML
    private TableColumn<Employee, String> designationTableColumn;
    @FXML
    private TableColumn<Employee, LocalDate> DOJTableColumn;
    @FXML
    private TextField enterIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        IDTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("employeeID"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeName"));        
        designationTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeType"));        
        DOJTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("employeeDOJ"));
        
        Employee.LoadEmployeesTable(EmployeeListTableView);
       
    }    


    @FXML
    private void printIDButtonOnClick(ActionEvent event) {
        
        
        Employee emp=Employee.getEmployee(Integer.parseInt(enterIdTextField.getText())); 
        
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));            
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            
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
                        = "Membership ID: " + Integer.toString(emp.getEmployeeID())
                        + "\nName: " + emp.getEmployeeName()
                        + "\nDate of Joining: " + emp.getEmployeeDOJ().toString()
                        + "\nDesignation: " + emp.getEmployeeType();
                Paragraph para1 = new Paragraph(paraText1);
                para1.setTextAlignment(TextAlignment.CENTER);
                para1.setFontSize(15f);
                
                Text titleText = new Text("Transparency International Bangladesh: Employee");
                titleText.setFontSize(17f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                pageTitle.setTextAlignment(TextAlignment.CENTER);

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                
                // adding ID card image
                
                Alert addImage = new Alert(Alert.AlertType.INFORMATION);
                addImage.setContentText("Select an image for your card");
                addImage.showAndWait();
                
                File imageFile = fc.showOpenDialog(null);
                String imagePath = imageFile.getAbsolutePath();
                ImageData data = ImageDataFactory.create(imagePath);
                Image image = new Image(data);
                image.setWidthPercent(50);
                image.setFixedPosition(200, 400);
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Card has been generated successfully.");
                a.showAndWait();
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(image);
                for (int i = 1; i <= 15; i++) {
                    doc.add(lineSpace);
                }                
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
