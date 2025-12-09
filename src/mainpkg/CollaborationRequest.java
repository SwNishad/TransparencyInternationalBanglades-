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
public class CollaborationRequest implements Serializable{
    
    protected int collborationReqID;
    protected String collaborationReqContent;

    public CollaborationRequest(int collborationReqID, String collaborationReqContent) {
        this.collborationReqID = collborationReqID;
        this.collaborationReqContent = collaborationReqContent;
    }

    public int getCollborationReqID() {
        return collborationReqID;
    }

    public String getCollaborationReqContent() {
        return collaborationReqContent;
    }

    public void setCollborationReqID(int collborationReqID) {
        this.collborationReqID = collborationReqID;
    }

    public void setCollaborationReqContent(String collaborationReqContent) {
        this.collaborationReqContent = collaborationReqContent;
    }

    @Override
    public String toString() {
        return "CollaborationRequest{" + "collborationReqID=" + collborationReqID + ", collaborationReqContent=" + collaborationReqContent + '}';
    }
    
    
    
    public static void addRequestToFile(CollaborationRequest newRequest) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("CollaborationRequestObjects.bin");
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
            requestAdded.setHeaderText("Request Sent to Researcher");
            requestAdded.setContentText("Your request ID is " + newRequest.getCollborationReqID());
            requestAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(CollaborateSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CollaborateSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void checkCollaborationRequestStatus(int collaborationReqID) {
        
        ObjectInputStream ois=null;
        boolean approved = false;
        
         try {
            CollaborationRequest cr;
            ois = new ObjectInputStream(new FileInputStream("ApprovedCollaborationRequestObjects.bin"));
            
            while (true) {
                cr = (CollaborationRequest) ois.readObject();
                
                if (cr.getCollborationReqID() == collaborationReqID) {
                    approved = true;
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Succcess");
                    a.setTitle("Approved!");
                    a.setHeaderText("Your Request Has Been Approved");
                    a.setContentText("Request has been approved");
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
                    a.setContentText("Request is still waiting for response");
                    a.showAndWait();
         }
    }
    
}
