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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 *
 * @author Acer
 */
public class Researcher extends Employee implements Serializable {
    
    public Researcher(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
    
    public static void ScheduleVirtualConference(VirtualConference newConference) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ScheduledVirtualConferences.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newConference);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("New Conference Scheduled Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(VirtualConferenceSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VirtualConferenceSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void ViewVirtualConferences(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ScheduledVirtualConferences.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VirtualConference virtualConference;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    virtualConference = (VirtualConference)ois.readObject();
                    System.out.println(virtualConference.toString());
                    outputTextArea.appendText(virtualConference.toString()+"\n");
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll meetings have been loaded.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    public static void publishResearchPaper(ResearchPaper newPaper) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ResearcherPublicationObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newPaper);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("New Research Paper Published Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(PublishResearchPaperSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PublishResearchPaperSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
     public static void WriteResource(ResearcherDocument newResource) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ResourceObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newResource);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("Resource has been sent Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ResourceCenterSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ResourceCenterSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    public static void LoadCollaborationRequestTable(TableView collaborationRequestTableView) {
        
        collaborationRequestTableView.getItems().clear();
        
        ObjectInputStream ois=null;
         try {
            CollaborationRequest cr;
            ois = new ObjectInputStream(new FileInputStream("CollaborationRequestObjects.bin"));
            
            while (true) {
                cr = (CollaborationRequest) ois.readObject();
                collaborationRequestTableView.getItems().add(cr);              
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
    
    public static CollaborationRequest getCollaborationRequest(int collaborationReqID) {
        ObjectInputStream ois=null;
         try {
            CollaborationRequest cr;
            ois = new ObjectInputStream(new FileInputStream("CollaborationRequestObjects.bin"));
            
            while (true) {
                cr = (CollaborationRequest) ois.readObject();
                
                if (cr.getCollborationReqID() == collaborationReqID) {
                    return cr;
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
         CollaborationRequest cr = new CollaborationRequest(0, "Error"); 
         return cr;   
    }
    
    public static void approveRequestToFile(CollaborationRequest collaborationRequestToApprove) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ApprovedCollaborationRequestObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(collaborationRequestToApprove);
            
            Alert requestAdded = new Alert(Alert.AlertType.INFORMATION);
            requestAdded.setTitle("Success");
            requestAdded.setHeaderText("Request Approved");
            requestAdded.setContentText("The request has been approved successfully");
            requestAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ResearcherCollaborateSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ResearcherCollaborateSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
