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
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 *
 * @author Acer
 */
public class Admin extends Employee implements Serializable {
    
    public Admin(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
    
    public static void ScheduleInternalMeeting(MeetingInternal newMeeting) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ScheduledInternalMeetings.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newMeeting);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("New Meeting Scheduled Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MeetingSchedulerWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(MeetingSchedulerWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void ViewInternalMeetings(TextArea outputTextArea) {
        outputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ScheduledInternalMeetings.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MeetingInternal meetingInternal;
            
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    meetingInternal = (MeetingInternal)ois.readObject();
                    System.out.println(meetingInternal.toString());
                    outputTextArea.appendText(meetingInternal.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            outputTextArea.appendText("\nAll internal meetings are to take place at 12PM unless stated otherwise.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
    
    public static void GenerateEmployeeDesignationSummary(ObservableList <PieChart.Data> listA, PieChart pieChartA, int adminCount, int secretaryCount,  int dataofficerCount, 
        int journalistCount, int researcherCount, int recordkeeperCount, int mediaofficerCount) {
        
        ObjectInputStream ois=null;
         try {
            Employee emp;
            ois = new ObjectInputStream(new FileInputStream("EmployeeObjects.bin"));
            
            while (true) {
                emp = (Employee) ois.readObject();
                
                if ("Admin".equals(emp.getEmployeeType())) {
                    adminCount += 1;
                }
                if ("Secretary".equals(emp.getEmployeeType())) {
                    secretaryCount += 1;
                }
                if ("Data Officer".equals(emp.getEmployeeType())) {
                    dataofficerCount += 1;
                }
                if ("Journalist".equals(emp.getEmployeeType())) {
                    journalistCount += 1;
                }
                if ("Researcher".equals(emp.getEmployeeType())) {
                    researcherCount += 1;
                }
                if ("Recordkeeper".equals(emp.getEmployeeType())) {
                    recordkeeperCount += 1;
                }
                if ("Media Officer".equals(emp.getEmployeeType())) {
                    mediaofficerCount += 1;
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
        
        // Generate Chart
        
        listA.add( new PieChart.Data("Administrator",adminCount) );
        listA.add( new PieChart.Data("Secretary",secretaryCount) );
        listA.add( new PieChart.Data("Data Officer",dataofficerCount) );
        listA.add( new PieChart.Data("Journalist",journalistCount) );
        listA.add( new PieChart.Data("Researcher",researcherCount) );
        listA.add( new PieChart.Data("Recordkeeper",recordkeeperCount) );
        listA.add( new PieChart.Data("Media Officer",mediaofficerCount) );
        
        pieChartA.setData(listA);
        
    }
    
    
    public static void GenerateEmployeeFullTimeSummary(ObservableList <PieChart.Data> listB, PieChart pieChartB, int fulltimeCount, int parttimeCount) {
        
        ObjectInputStream ois=null;
         try {
            Employee emp;
            ois = new ObjectInputStream(new FileInputStream("EmployeeObjects.bin"));
            
            while (true) {
                emp = (Employee) ois.readObject();
                
                if (emp.isEmployeeFullTime() == true) {
                    fulltimeCount += 1;
                }
                else {
                    parttimeCount += 1;
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
        
        // Generate Chart
        
        listB.add( new PieChart.Data("Full-Time Employees",fulltimeCount) );
        listB.add( new PieChart.Data("Part-Time Employees",parttimeCount) );
        
        pieChartB.setData(listB);
        
    }
    
    
    public static void VerifyGPMembership(int gpID, TextArea memberDetailsTextArea) {
        
        ObjectInputStream ois=null;
        boolean gpExists = false;
         try {
            GeneralPublic gp;
            ois = new ObjectInputStream(new FileInputStream("GPObjects.bin"));
            
            while (true) {
                gp = (GeneralPublic) ois.readObject();
                
                if (gp.getGpID() == gpID) {
                    gpExists = true;
                    memberDetailsTextArea.setText(gp.toString());
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
                doesntExist.setHeaderText("Match Not Found");
                doesntExist.setContentText("No member with the given ID exists");
                doesntExist.showAndWait(); 
            }
        
    }
    
    public static void LoadAdminRequestTable(TableView adminRequestTableView) {
        
        ObjectInputStream ois=null;
         try {
            AdminRequest ar;
            ois = new ObjectInputStream(new FileInputStream("AdminRequestObjects.bin"));
            
            while (true) {
                ar = (AdminRequest) ois.readObject();
                adminRequestTableView.getItems().add(ar);              
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
    
    public static AdminRequest getAdminRequest(int adminRequestID) {
        ObjectInputStream ois=null;
         try {
            AdminRequest ar;
            ois = new ObjectInputStream(new FileInputStream("AdminRequestObjects.bin"));
            
            while (true) {
                ar = (AdminRequest) ois.readObject();
                
                if (ar.getAdminRequestID() == adminRequestID) {
                    return ar;
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
         AdminRequest ar = new AdminRequest(0, "Error"); 
         return ar;   
    }
    
    // code to approve request here
    
    public static void approveRequestToFile(AdminRequest adminRequestToApprove) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ApprovedAdminRequestObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(adminRequestToApprove);
            
            Alert requestAdded = new Alert(Alert.AlertType.INFORMATION);
            requestAdded.setTitle("Success");
            requestAdded.setHeaderText("Request Approved");
            requestAdded.setContentText("The request has been approved successfully");
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
    

}
