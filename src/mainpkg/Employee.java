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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author Acer
 */



public class Employee extends User implements Serializable{    
    
    protected int employeeID;
    protected String employeeName;
    protected String employeePassword;
    protected String employeeType;
    //protected String employeePhone;
    //protected LocalDate employeeDOB;
    protected LocalDate employeeDOJ; 
    
    protected double employeeSalary;
    protected boolean employeeFullTime;
    
    
    public Employee(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
    this.employeeID = employeeID;
    this.employeeName = employeeName;
    this.employeePassword = employeePassword;
    this.employeeType = employeeType;
    //this.employeePhone = employeePhone;
    //this.employeeDOB = employeeDOB;
    this.employeeDOJ = employeeDOJ;
    
    this.employeeSalary = employeeSalary;
    this.employeeFullTime = employeeFullTime;
    }
    
    public static void WriteEmployeeToEmployeeFile(Employee newEmployee) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("EmployeeObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newEmployee);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("Employee Added");
            employeeAdded.setContentText("Employee has been added successfully");
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(EmployeeAddWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeAddWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void WriteEmployeeToLoginFile(Employee newEmployee) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("LoginObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newEmployee);

        } catch (IOException ex) {
            Logger.getLogger(EmployeeAddWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeAddWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void LoadEmployeesTable(TableView employeesTableView) {
        
        ObjectInputStream ois=null;
         try {
            Employee emp;
            ois = new ObjectInputStream(new FileInputStream("EmployeeObjects.bin"));
            
            while (true) {
                emp = (Employee) ois.readObject();
                employeesTableView.getItems().add(emp);
                emp = (Employee) ois.readObject(); employeesTableView.getItems().add(emp);                
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
    

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeePassword=" + employeePassword + ", employeeType=" + employeeType + ", employeeDOJ=" + employeeDOJ + ", employeeSalary=" + employeeSalary + ", employeeFullTime=" + employeeFullTime + '}';
    }
    
    
    
    
    

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public boolean isEmployeeFullTime() {
        return employeeFullTime;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setEmployeeFullTime(boolean employeeFullTime) {
        this.employeeFullTime = employeeFullTime;
    }
   
    

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    
    
    public void setEmployeeDOJ(LocalDate employeeDOJ) {
        this.employeeDOJ = employeeDOJ;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public String getEmployeeType() {
        return employeeType;
    }

   

    public LocalDate getEmployeeDOJ() {
        return employeeDOJ;
    }

    
    public static Employee getEmployee(int employeeID) {
        
        ObjectInputStream ois=null;
         try {
            Employee emp;
            ois = new ObjectInputStream(new FileInputStream("EmployeeObjects.bin"));
            
            while (true) {
                emp = (Employee) ois.readObject();
                
                if (emp.getEmployeeID() == employeeID) {
                    return emp;
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
        Employee emp = new Employee(1, "employee", "1234", "notype", 1000, false, LocalDate.now());
        return emp;
    }
    
}
