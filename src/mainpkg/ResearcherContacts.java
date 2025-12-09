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
import javafx.scene.control.TextArea;

/**
 *
 * @author Acer
 */
public class ResearcherContacts implements Serializable {
    
    protected String contactName;
    protected Integer contactNumber;

    public ResearcherContacts(String contactName, int contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Name: " + contactName + " | Number: " + contactNumber + "\n"; 
    }
    
       
    
    public static void WriteContactToContactFile(ResearcherContacts newContact) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Contacts.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newContact);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("Contact Added");
            employeeAdded.setContentText("Contact has been added successfully");
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ViewContactsSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ViewContactsSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void ViewContacts(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Contacts.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ResearcherContacts researcherContact;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    researcherContact = (ResearcherContacts)ois.readObject();
                    System.out.println(researcherContact.toString());
                    outputTextArea.appendText(researcherContact.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll contacts loaded successfully.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    
    
    
    
}
