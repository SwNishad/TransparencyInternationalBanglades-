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

/**
 *
 * @author Acer
 */
public class Infraction implements Serializable{
    
    protected int infractionID;
    protected String infractionOffender;
    protected int infractionAmountCharged;
    //protected String infractionType;
    protected LocalDate infractionDate;

    public int getInfractionID() {
        return infractionID;
    }

    public void setInfractionID(int infractionID) {
        this.infractionID = infractionID;
    }

    public String getInfractionOffender() {
        return infractionOffender;
    }

    public void setInfractionOffender(String infractionOffender) {
        this.infractionOffender = infractionOffender;
    }

    public int getInfractionAmountCharged() {
        return infractionAmountCharged;
    }

    public void setInfractionAmountCharged(int infractionAmountCharged) {
        this.infractionAmountCharged = infractionAmountCharged;
    }

    public LocalDate getInfractionDate() {
        return infractionDate;
    }

    public void setInfractionDate(LocalDate infractionDate) {
        this.infractionDate = infractionDate;
    }

    @Override
    public String toString() {
        return "Infraction{" + "infractionID=" + infractionID + ", infractionOffender=" + infractionOffender + ", infractionAmountCharged=" + infractionAmountCharged + ", infractionDate=" + infractionDate + '}';
    }
    
    public Infraction(int infractionID, String infractionOffender, int infractionAmountCharged, LocalDate infractionDate) {
        this.infractionID = infractionID;
        this.infractionOffender = infractionOffender;
        this.infractionAmountCharged = infractionAmountCharged;
        //this.infractionType = infractionType;
        this.infractionDate = infractionDate;
    }
    
     public static void createInfractionLogs(Infraction newInfraction){
          
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Infractions.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos); 
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);     
                
            }
            oos.writeObject(newInfraction);
            
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setTitle("Success");
            b.setContentText("Infraction has been created successfully");
            b.showAndWait();
        
                        
        }catch (IOException ex) {
            Logger.getLogger(RKInfractionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RKInfractionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void viewInfractionLogs(TableView infractionsTableView) {
        
        ObjectInputStream ois=null;
        
         try {
            Infraction in;
            ois = new ObjectInputStream(new FileInputStream("Infractions.bin"));
            
            while (true) {
                in = (Infraction) ois.readObject();
                infractionsTableView.getItems().add(in);
                in = (Infraction) ois.readObject(); infractionsTableView.getItems().add(in);                
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