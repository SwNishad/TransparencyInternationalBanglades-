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


public class PublicWorkshop implements Serializable {
    protected int workshopNo;
    protected String workshopAgenda;
    protected String speaker;
    protected LocalDate workshopDate;

    @Override
    public String toString() {
        return "PublicWorkshop{" + "workshopNo=" + workshopNo + ", workshopAgenda=" + workshopAgenda + ", speaker=" + speaker + ", workshopDate=" + workshopDate + '}';
    }

    public int getWorkshopNo() {
        return workshopNo;
    }

    public void setWorkshopNo(int workshopNo) {
        this.workshopNo = workshopNo;
    }

    public String getWorkshopAgenda() {
        return workshopAgenda;
    }

    public void setWorkshopAgenda(String workshopAgenda) {
        this.workshopAgenda = workshopAgenda;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public LocalDate getWorkshopDate() {
        return workshopDate;
    }

    public void setWorkshopDate(LocalDate workshopDate) {
        this.workshopDate = workshopDate;
    }

    public PublicWorkshop(int workshopNo, String workshopAgenda, String speaker, LocalDate workshopDate) {
        this.workshopNo = workshopNo;
        this.workshopAgenda = workshopAgenda;
        this.speaker = speaker;
        this.workshopDate = workshopDate;
    }
    
    public static void addPublicWorkshop(PublicWorkshop newPW) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("PublicWorkshop.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newPW);
            
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("New Public Workshop added");
            b.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(PublicWorkshopUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PublicWorkshopUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void viewPublicWorkshop(TableView publicworkshopTABLEVIEW) {
        
        ObjectInputStream ois=null;
        
         try {
            PublicWorkshop pw;
            ois = new ObjectInputStream(new FileInputStream("PublicWorkshop.bin"));
            
            while (true) {
                pw = (PublicWorkshop) ois.readObject();
                publicworkshopTABLEVIEW.getItems().add(pw);
                pw = (PublicWorkshop) ois.readObject(); publicworkshopTABLEVIEW.getItems().add(pw);                
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
    
}
