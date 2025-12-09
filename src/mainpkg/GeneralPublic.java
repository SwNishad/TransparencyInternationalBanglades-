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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 *
 * @author Acer
 */
public class GeneralPublic extends User implements Serializable{

    protected int gpID;
    protected String gpName;
    protected String gpPassword;
    protected LocalDate gpDOB;
    protected LocalDate gpDOJ;
    protected String gpPhone;
    protected String gpEmail;

    public GeneralPublic(int gpID, String gpName, String gpPassword, LocalDate gpDOB, LocalDate gpDOJ, String gpPhone, String gpEmail) {
        this.gpID = gpID;
        this.gpName = gpName;
        this.gpPassword = gpPassword;
        this.gpDOB = gpDOB;
        this.gpDOJ = gpDOJ;
        this.gpPhone = gpPhone;
        this.gpEmail = gpEmail;
    }
    
    public static void WriteGeneralPublicToGPFile(GeneralPublic newGP) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("GPObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newGP);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("Membership Approved");
            employeeAdded.setContentText("Welcome to the Active Citizens' Community. Your ID is: " + Integer.toString(newGP.getGpID()));
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(GPSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(GPSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void LoadCitizensTable(TableView gpActiveCitizensTableView) {
        
        ObjectInputStream ois=null;
         try {
            GeneralPublic gp;
            ois = new ObjectInputStream(new FileInputStream("GPObjects.bin"));
            
            while (true) {
                gp = (GeneralPublic) ois.readObject();
                gpActiveCitizensTableView.getItems().add(gp);                 
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
    
    public static PublicWorkshop getWorkshopDetails(int workshopID) {
        ObjectInputStream ois=null;
         try {
            PublicWorkshop pw;
            ois = new ObjectInputStream(new FileInputStream("PublicWorkshop.bin"));
            
            while (true) {
                pw = (PublicWorkshop) ois.readObject();
                
                if (pw.getWorkshopNo() == workshopID) {
                    return pw;
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
         PublicWorkshop pw = new PublicWorkshop(1, "Error", "Error", LocalDate.now()); 
         return pw;   
    }
    

    public int getGpID() {
        return gpID;
    }

    public String getGpName() {
        return gpName;
    }

    public String getGpPassword() {
        return gpPassword;
    }

    public LocalDate getGpDOB() {
        return gpDOB;
    }

    public LocalDate getGpDOJ() {
        return gpDOJ;
    }

    public String getGpPhone() {
        return gpPhone;
    }

    public String getGpEmail() {
        return gpEmail;
    }

    public void setGpID(int gpID) {
        this.gpID = gpID;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public void setGpPassword(String gpPassword) {
        this.gpPassword = gpPassword;
    }

    public void setGpDOB(LocalDate gpDOB) {
        this.gpDOB = gpDOB;
    }

    public void setGpDOJ(LocalDate gpDOJ) {
        this.gpDOJ = gpDOJ;
    }

    public void setGpPhone(String gpPhone) {
        this.gpPhone = gpPhone;
    }

    public void setGpEmail(String gpEmail) {
        this.gpEmail = gpEmail;
    }

    @Override
    public String toString() {
        return "Membership ID: " + gpID + "\nName: " + gpName +
                "\nDate of Birth: " + gpDOB + "\nDate of Joining: " + gpDOJ + "\nPhone (+880): " + gpPhone + "\nEmail: " + gpEmail + "\n";
    }
    
    public static void showUserProfile(int enteredGpID, String enteredGpPassword, Label gpIDLabel, Label gpNameLabel, Label gpDOBLabel, Label gpDOJLabel, Label gpEmailLabel, Label gpPhoneLabel) {
        
        ObjectInputStream ois=null;
        boolean gpExists = false;
        
         try {
            GeneralPublic gp;
            ois = new ObjectInputStream(new FileInputStream("GPObjects.bin"));
            
            while (true) {
                gp = (GeneralPublic) ois.readObject();
                
                if (gp.getGpID() == enteredGpID && (gp.getGpPassword() == null ? enteredGpPassword == null : gp.getGpPassword().equals(enteredGpPassword))) {
                    gpExists = true;
                    gpIDLabel.setText(Integer.toString(gp.getGpID()));
                    gpNameLabel.setText(gp.getGpName());
                    gpDOBLabel.setText(gp.getGpDOB().toString());
                    gpDOJLabel.setText(gp.getGpDOJ().toString());
                    gpEmailLabel.setText(gp.getGpEmail());
                    gpPhoneLabel.setText(gp.getGpPhone());
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
        if (gpExists == false) {
                Alert doesntExist = new Alert(Alert.AlertType.ERROR);
                doesntExist.setTitle("Verification Error");
                doesntExist.setHeaderText("Member Not Found");
                doesntExist.setContentText("Please check your credentials");
                doesntExist.showAndWait(); 
            }
    }

    
    
}
