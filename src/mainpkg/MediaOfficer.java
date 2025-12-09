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


public class MediaOfficer extends Employee implements Serializable {

    public MediaOfficer(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
    
    public static void createExclusiveComm(ExclusiveComm newEC) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ExclusiveCommunication.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newEC);
            
            if(true){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Exclusive Communication has been sent!");
                a.showAndWait();
            }
            else{
                Alert b = new Alert(Alert.AlertType.WARNING);
                b.setContentText("ERROR! Unable to send.");
                b.showAndWait();
            }

        } catch (IOException ex) {
            Logger.getLogger(ExclusiveCommController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ExclusiveCommController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void makePressConference(PressConference newPC) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("PressConference.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newPC);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Press Conference has been scheduled!");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(PressConfUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PressConfUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
     public static void ViewMeetings(TextArea scheduledMeetingsDisplayTextArea) {
        scheduledMeetingsDisplayTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ScheduledInternalMeetings.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MeetingInternal meetingInternal;
            
            try{
                scheduledMeetingsDisplayTextArea.setText("");
                while(true){
                    meetingInternal = (MeetingInternal)ois.readObject();
                    scheduledMeetingsDisplayTextArea.appendText(meetingInternal.toString());
                }
            }
            catch(Exception e){
            }     
            scheduledMeetingsDisplayTextArea.appendText("\nAll internal meetings are to take place at 12PM unless stated otherwise.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
     
    public static void viewArticle(TextArea textArea) {
        textArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Article.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Article ar;
            
            try{
                textArea.setText("");
                while(true){
                    ar = (Article)ois.readObject();
                    textArea.appendText(ar.toString());
                }
            }
            catch(Exception e){
            }               
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    public static void viewResearcherDocument(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ResourceObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ResearcherDocument rd;
            
            try{
                outputTextArea.setText("");
                while(true){
                    rd = (ResearcherDocument)ois.readObject();
                    outputTextArea.appendText(rd.toString());
                }
            }
            catch(Exception e){
            }                 
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    
}
