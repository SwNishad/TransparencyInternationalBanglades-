/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class User implements Serializable{
    
    
    public static int userLogin(int enteredID, String enteredPassword){
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        int idMatch=0;
        int passwordMatch=0;
        int userType=0;
        
        try {
            
            f = new File("LoginObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee tempEmployee;
            
            try{
                System.out.println("Printing login objects");
                
                while(true){
                    
                    if (idMatch==1){break;}
                    tempEmployee = (Employee) ois.readObject();
                    System.out.println(tempEmployee.toString());
                    
                    if (enteredID==tempEmployee.getEmployeeID()){
                        idMatch=1;
                        
                        if (enteredPassword.equals(tempEmployee.getEmployeePassword())){
                            passwordMatch=1;
                            if (tempEmployee.getEmployeeType().equals("Admin")){userType=1;}
                            else if (tempEmployee.getEmployeeType().equals("General Public")){userType=2;}
                            else if (tempEmployee.getEmployeeType().equals("Secretary")){userType=3;}
                            else if (tempEmployee.getEmployeeType().equals("Data Officer")){userType=4;}
                            else if (tempEmployee.getEmployeeType().equals("Journalist")){userType=5;}
                            else if (tempEmployee.getEmployeeType().equals("Researcher")){userType=6;}
                            else if (tempEmployee.getEmployeeType().equals("Recordkeeper")){userType=7;}
                            else if (tempEmployee.getEmployeeType().equals("MediaOfficer")){userType=8;}
                            break;
                        }
                    }
                }
            }
            catch(IOException | ClassNotFoundException e){
                System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
            
            if (idMatch==1){
                if(passwordMatch==1){
                    //errorLabel.setText("Login Successful");
                    return userType;
                }
                else{return 10;}
                //("Error, wrong password");
            }
            else{return 11;}
                //("Error, user not found");
        
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
            return 0;
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        //code 0 - unhandled exception
    }
    
    
}
