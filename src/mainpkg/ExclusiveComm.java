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
import javafx.scene.control.TextArea;


public class ExclusiveComm implements Serializable {
    protected String title;
    protected LocalDate date;
    protected String content;

    @Override
    public String toString() {
        return "ExclusiveComm{" + "title=" + title + ", date=" + date + ", content=" + content + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ExclusiveComm(String title, LocalDate date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
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
    
    
    public static void viewExclusiveComm(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ExclusiveCommunication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ExclusiveComm exclusivecomm;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    exclusivecomm = (ExclusiveComm)ois.readObject();
                    System.out.println(exclusivecomm.toString());
                    outputTextArea.appendText(exclusivecomm.toString()+"\n");
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll Announcements have been loaded.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
}
