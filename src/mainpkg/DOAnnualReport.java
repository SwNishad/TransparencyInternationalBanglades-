/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import com.itextpdf.io.font.FontConstants;
import java.io.Serializable;
import java.time.LocalDate;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;


/**
 *
 * @author MSI Prestige
 */
public class DOAnnualReport extends Report implements Serializable {
    protected int reportYear;
    protected int noOfincidents;
    protected int noOfEvents;
    protected int noOfCountries;
    protected int noOfinfractions;

    public DOAnnualReport(int reportYear,int noOfincidents, int noOfEvents, int noOfCountries, int noOfinfractions, String reportContent, String reportType, int reportID) {
        super(reportContent, reportType, reportID);
        this.reportYear = reportYear;
        this.noOfincidents = noOfincidents;
        this.noOfEvents = noOfEvents;
        this.noOfCountries = noOfCountries;
        this.noOfinfractions = noOfinfractions;
    }

    public int getReportYear() {
        return reportYear;
    }

    public void setReportYear(int reportYear) {
        this.reportYear = reportYear;
    }

    public int getNoOfincidents() {
        return noOfincidents;
    }

    public void setNoOfincidents(int noOfincidents) {
        this.noOfincidents = noOfincidents;
    }

    public int getNoOfEvents() {
        return noOfEvents;
    }

    public void setNoOfEvents(int noOfEvents) {
        this.noOfEvents = noOfEvents;
    }

    public int getNoOfCountries() {
        return noOfCountries;
    }

    public void setNoOfCountries(int noOfCountries) {
        this.noOfCountries = noOfCountries;
    }

    public int getNoOfinfractions() {
        return noOfinfractions;
    }

    public void setNoOfinfractions(int noOfinfractions) {
        this.noOfinfractions = noOfinfractions;
    }

    @Override
    public String getReportContent() {
        return reportContent;
    }

    @Override
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public String getReportType() {
        return reportType;
    }

    @Override
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Override
    public int getReportID() {
        return reportID;
    }

    @Override
    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    @Override
    public String toString() {
        return "DOAnnualReport{" + "reportYear=" + reportYear + ", noOfincidents=" + noOfincidents + ", noOfEvents=" + noOfEvents + ", noOfCountries=" + noOfCountries + ", noOfinfractions=" + noOfinfractions + '}';
    }

    

    
    
    public static void generateAnnualReport(DOAnnualReport newAnnualReport) {
        
               
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
                        = "Year: " + newAnnualReport.getReportYear() + "\n"
                        + "Number of Incidents: " + newAnnualReport.getNoOfincidents() + "\n"
                        + "Number of Events: " + newAnnualReport.getNoOfEvents()+ "\n"
                        + "Number of Countries hosted events: " + newAnnualReport.getNoOfCountries()+ "\n"
                        + "Number of Infractions: " + newAnnualReport.getNoOfinfractions();
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Transparency International Bangladesh: ANNUAL REPORT\n" + "For the Year " + newAnnualReport.getReportYear());
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
    
    public static void WriteAnnualReportToFile(DOAnnualReport newAnnualReport) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("AnnualReportobjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newAnnualReport);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("Report Added");
            employeeAdded.setContentText("Report has been added successfully");
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(DOAnnualReportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(DOAnnualReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    @Override
    public void generateReport(Report newReport) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}