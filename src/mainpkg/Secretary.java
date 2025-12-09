/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author MSI Prestige
 */
public class Secretary extends Employee implements Serializable {
    
    public Secretary(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public LocalDate getEmployeeDOJ() {
        return employeeDOJ;
    }

    public void setEmployeeDOJ(LocalDate employeeDOJ) {
        this.employeeDOJ = employeeDOJ;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public boolean isEmployeeFullTime() {
        return employeeFullTime;
    }

    public void setEmployeeFullTime(boolean employeeFullTime) {
        this.employeeFullTime = employeeFullTime;
    }
    
    
    
    public static Employee getEmployee(int employeeID) {
        ObjectInputStream ois=null;
         try {
            Employee emp;
            ois = new ObjectInputStream(new FileInputStream("EmployeeObjects.bin"));
            
            while (true) {
                emp = (Employee) ois.readObject();
                
                if (emp.getEmployeeID()== employeeID) {
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
         Employee emp = new Employee(0,"Error", "Error", "Error", 0, false, LocalDate.now()); 
         return emp;   
    }
}
