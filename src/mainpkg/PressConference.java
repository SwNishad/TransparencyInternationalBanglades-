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


public class PressConference implements Serializable {
    protected int pressID;
    protected LocalDate pressDate;
    protected String pressTime;
    protected String pressVenue;
    protected String pressAgenda;

    @Override
    public String toString() {
        return "PressConference{" + "pressID=" + pressID + ", pressDate=" + pressDate + ", pressTime=" + pressTime + ", pressVenue=" + pressVenue + ", pressAgenda=" + pressAgenda + '}';
    }

    public int getPressID() {
        return pressID;
    }

    public void setPressID(int pressID) {
        this.pressID = pressID;
    }

    public LocalDate getPressDate() {
        return pressDate;
    }

    public void setPressDate(LocalDate pressDate) {
        this.pressDate = pressDate;
    }

    public String getPressTime() {
        return pressTime;
    }

    public void setPressTime(String pressTime) {
        this.pressTime = pressTime;
    }

    public String getPressVenue() {
        return pressVenue;
    }

    public void setPressVenue(String pressVenue) {
        this.pressVenue = pressVenue;
    }

    public String getPressAgenda() {
        return pressAgenda;
    }

    public void setPressAgenda(String pressAgenda) {
        this.pressAgenda = pressAgenda;
    }

    public PressConference(int pressID, LocalDate pressDate, String pressTime, String pressVenue, String pressAgenda) {
        this.pressID = pressID;
        this.pressDate = pressDate;
        this.pressTime = pressTime;
        this.pressVenue = pressVenue;
        this.pressAgenda = pressAgenda;
    }
    
    public static void viewPressConference(TableView pressConferenceTABLEVIEW) {
        
        ObjectInputStream ois=null;
        
         try {
            PressConference pc;
            ois = new ObjectInputStream(new FileInputStream("PressConference.bin"));
            
            while (true) {
                pc = (PressConference) ois.readObject();
                pressConferenceTABLEVIEW.getItems().add(pc);
                pc = (PressConference) ois.readObject(); pressConferenceTABLEVIEW.getItems().add(pc);                
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
