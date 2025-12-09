/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.scene.control.TextArea;


public class RecordKeeper extends Employee implements Serializable {

    public RecordKeeper(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
    
    
    public static boolean createRKPolicy(RecordKeeperPolicy newPolicy){
          
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("RecordKeeperPolicy.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos); 
                oos.writeObject(newPolicy);
                return true;
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);     
                oos.writeObject(newPolicy);
                return true;
            }          
        
                        
        } catch (IOException ex) {
                return false;

        }      

    }
    
    public static boolean viewRKPolicy(TextArea outputtxtarea) {
        outputtxtarea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("RecordKeeperPolicy.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RecordKeeperPolicy rkpolicy;
            
            try{
                outputtxtarea.setText("");
                while(true){
                    rkpolicy = (RecordKeeperPolicy)ois.readObject();
                    rkpolicy.getPolicycontent();
                    outputtxtarea.appendText(rkpolicy.toString());
                }
            }
            catch(Exception e){
                
            }    
            outputtxtarea.appendText("");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return false;
    
    }
}

