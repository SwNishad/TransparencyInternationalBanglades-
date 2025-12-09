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

/**
 *
 * @author Acer
 */
public class AdminRequest implements Serializable {
    
    protected int adminRequestID;
    protected String adminRequestContent;

    public AdminRequest(int adminRequestID, String adminRequestContent) {
        this.adminRequestID = adminRequestID;
        this.adminRequestContent = adminRequestContent;
    }
    
    public static void addRequestToFile(AdminRequest newRequest) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("AdminRequestObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newRequest);
            
            Alert requestAdded = new Alert(Alert.AlertType.INFORMATION);
            requestAdded.setTitle("Success");
            requestAdded.setHeaderText("Request Sent to Admin");
            requestAdded.setContentText("Your request ID is " + newRequest.getAdminRequestID());
            requestAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ResearchFundingSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ResearchFundingSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void checkAdminRequestStatus(int adminRequestID) {
        
        ObjectInputStream ois=null;
        boolean approved = false;
        
         try {
            AdminRequest ar;
            ois = new ObjectInputStream(new FileInputStream("ApprovedAdminRequestObjects.bin"));
            
            while (true) {
                ar = (AdminRequest) ois.readObject();
                
                if (ar.getAdminRequestID() == adminRequestID) {
                    approved = true;
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Succcess");
                    a.setTitle("Approved!");
                    a.setHeaderText("Your Request Has Been Approved");
                    a.setContentText("Request has been approved by the administrator");
                    a.showAndWait();
                    return;
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
         if (!approved) {
             Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Pending");
                    a.setTitle("Not Approved");
                    a.setHeaderText("Your Request is Not Approved Yet");
                    a.setContentText("Request is still waiting for response from Admin");
                    a.showAndWait();
         }
    }
    
    
    

    public int getAdminRequestID() {
        return adminRequestID;
    }

    public String getAdminRequestContent() {
        return adminRequestContent;
    }

    public void setAdminRequestID(int adminRequestID) {
        this.adminRequestID = adminRequestID;
    }

    public void setAdminRequestContent(String adminRequestContent) {
        this.adminRequestContent = adminRequestContent;
    }

    @Override
    public String toString() {
        return "AdminRequest{" + "adminRequestID=" + adminRequestID + ", adminRequestContent=" + adminRequestContent + '}';
    }
    
}
