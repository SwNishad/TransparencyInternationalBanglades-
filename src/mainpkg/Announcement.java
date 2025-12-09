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


public class Announcement implements Serializable {
    protected int announcementNo;
    protected LocalDate announcementDate;
    protected String announcementContent;

    @Override
    public String toString() {
        return "Announcement No.: " + announcementNo + "\n\nAnnouncement: " + announcementContent + "\n\n";
    }

    public int getAnnouncementNo() {
        return announcementNo;
    }

    public void setAnnouncementNo(int announcementNo) {
        this.announcementNo = announcementNo;
    }

    public LocalDate getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(LocalDate announcementDate) {
        this.announcementDate = announcementDate;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Announcement(int announcementNo, LocalDate announcementDate, String announcementContent) {
        this.announcementNo = announcementNo;
        this.announcementDate = announcementDate;
        this.announcementContent = announcementContent;
    }
    
    public static void createAnnouncement(Announcement newAnnouncement) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("InternalAnnouncement.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newAnnouncement);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Announcement has been made successfully!");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(AnnounceMakeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AnnounceMakeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void viewAnnouncement(TextArea announcementViewTXTAREA) {
        announcementViewTXTAREA.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("InternalAnnouncement.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Announcement an;
            
            try{
                announcementViewTXTAREA.setText("");
                while(true){
                    an = (Announcement)ois.readObject();
                    announcementViewTXTAREA.appendText(an.toString());
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
