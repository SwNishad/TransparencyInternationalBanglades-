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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 *
 * @author sazin
 */
public class Journalist extends Employee implements Serializable {
    
    public Journalist(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
    
    public static void publishArticle(Article newArticle) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Article.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newArticle);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("New Article Added Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(PublishArticleSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PublishArticleSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void viewResearchPublication(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ResearcherPublicationObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ResearchPaper rp;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    rp = (ResearchPaper)ois.readObject();
                    System.out.println(rp.toString());
                    outputTextArea.appendText(rp.toString()+"\n");
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll publications have been loaded.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    public static ResearchPaper getResearchPaper(int publicationID) {
        ObjectInputStream ois=null;
         try {
            ResearchPaper rp;
            ois = new ObjectInputStream(new FileInputStream("ResearcherPublicationObjects.bin"));
            
            while (true) {
                rp = (ResearchPaper) ois.readObject();
                
                if (rp.getPublicationID()== publicationID) {
                    return rp;
                }
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
         ResearchPaper rp = new ResearchPaper(0, "Error", "Error"); 
         return rp;   
    }
    
    
    
    
    
    public static void viewPressConference(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("PressConference.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            PressConference pc;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    pc = (PressConference)ois.readObject();
                    System.out.println(pc.toString());
                    outputTextArea.appendText(pc.toString()+"\n");
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll press conferences have been loaded.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    public static PressConference getPressConference(int pressID) {
        ObjectInputStream ois=null;
         try {
            PressConference pc;
            ois = new ObjectInputStream(new FileInputStream("PressConference.bin"));
            
            while (true) {
                pc = (PressConference) ois.readObject();
                
                if (pc.getPressID()== pressID) {
                    return pc;
                }
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
         PressConference pc = new PressConference(0, LocalDate.now(), "Error", "Error", "Error"); 
         return pc;   
    }
    
    
}
