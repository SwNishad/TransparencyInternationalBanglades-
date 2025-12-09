/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;


public class CorruptionReport extends Report implements Serializable {

    

    public CorruptionReport(int reportID, String reportContent, String reportType) {
        super(reportContent, reportType, reportID);
        this.reportID = reportID;
        this.reportContent = reportContent;
        this.reportType = reportType;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }
    
    public static void generateReportToFile(CorruptionReport newReport) {
        
        //adds corruption report to corruption file
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("CorruptionReportObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newReport);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("Corruption Report Sent");
            employeeAdded.setContentText("Corruption report submitted successfully");
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(GPReportCorruptionSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(GPReportCorruptionSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void LoadCorruptionReports(TableView corruptionReportsTableView) {
        
        ObjectInputStream ois=null;
         try {
            CorruptionReport rep;
            ois = new ObjectInputStream(new FileInputStream("CorruptionReportObjects.bin"));
            
            while (true) {
                rep = (CorruptionReport) ois.readObject();
                corruptionReportsTableView.getItems().add(rep);               
            }
                        
            
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
        
    }

    @Override
    public void generateReport(Report newReport) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
        
    
    
    
}
