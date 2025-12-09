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
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;


/**
 *
 * @author MSI Prestige
 */
public class DODataOfficer extends Employee implements Serializable {
    
    public DODataOfficer(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DODataOfficer{");
        sb.append('}');
        return sb.toString();
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
    
    
    
    public static void GenerateIncidentCountSummary(ObservableList <PieChart.Data> listX, PieChart pieChartX, int incidentCount2020, int incidentCount2021, int incidentCount2022, int incidentCount2023) {
        
        ObjectInputStream ois=null;
         try {
            DOAnnualReport rep;
            ois = new ObjectInputStream(new FileInputStream("AnnualReportobjects.bin"));
            
            while (true) {
                rep = (DOAnnualReport) ois.readObject();
                
                if (rep.getReportYear() == 2020) {
                    incidentCount2020 += rep.getNoOfincidents();
                }
                if (rep.getReportYear() == 2021) {
                    incidentCount2021 += rep.getNoOfincidents();
                }
                if (rep.getReportYear() == 2022) {
                    incidentCount2022 += rep.getNoOfincidents();
                }
                if (rep.getReportYear() == 2023) {
                    incidentCount2023 += rep.getNoOfincidents();
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
        
        listX.add( new PieChart.Data("2020",incidentCount2020) );
        listX.add( new PieChart.Data("2021",incidentCount2021) );
        listX.add( new PieChart.Data("2022",incidentCount2022) );
        listX.add( new PieChart.Data("2023",incidentCount2023) );
        
        pieChartX.setData(listX);
        
    }
    
    public static void generateEventsCountSummary(BarChart barChart, int eventCount2020, int eventCount2021, int eventCount2022, int eventCount2023){
        
        ObjectInputStream ois=null;
         try {
            DOAnnualReport rep;
            ois = new ObjectInputStream(new FileInputStream("AnnualReportobjects.bin"));
            
            while (true) {
                rep = (DOAnnualReport) ois.readObject();
                
                if (rep.getReportYear() == 2020) {
                    eventCount2020 += rep.getNoOfEvents();
                }
                if (rep.getReportYear() == 2021) {
                    eventCount2021 += rep.getNoOfEvents();
                }
                if (rep.getReportYear() == 2022) {
                    eventCount2022 += rep.getNoOfEvents();
                }
                if (rep.getReportYear() == 2023) {
                    eventCount2023 += rep.getNoOfEvents();
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
        
        //generate bar chart
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("2020",eventCount2020));
        series.getData().add(new XYChart.Data<String,Number>("2021",eventCount2021));
        series.getData().add(new XYChart.Data<String,Number>("2022",eventCount2022));
        series.getData().add(new XYChart.Data<String,Number>("2023",eventCount2023));
        series.setName("Events Overview");
        barChart.getData().add(series);
    }
    

    public static void generateCountryCountSummary(LineChart<String, Number> lineChart, int countryCount2020,int countryCount2021, int countryCount2022, int countryCount2023) {
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        
        ObjectInputStream ois=null;
         try {
            DOAnnualReport rep;
            ois = new ObjectInputStream(new FileInputStream("AnnualReportobjects.bin"));
            
            while (true) {
                rep = (DOAnnualReport) ois.readObject();
                
                if (rep.getReportYear() == 2020) {
                    countryCount2020 += rep.getNoOfCountries();
                }
                if (rep.getReportYear() == 2021) {
                    countryCount2021 += rep.getNoOfCountries();
                }
                if (rep.getReportYear() == 2022) {
                    countryCount2022 += rep.getNoOfCountries();
                }
                if (rep.getReportYear() == 2023) {
                    countryCount2023 += rep.getNoOfCountries();
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
        
        
        
        
        // Assuming you have data for country counts in 2022 and 2023
        series.getData().add(new XYChart.Data<String, Number>("2020", countryCount2020));
        series.getData().add(new XYChart.Data<String, Number>("2021", countryCount2021));
        series.getData().add(new XYChart.Data<String, Number>("2022", countryCount2022));
        series.getData().add(new XYChart.Data<String, Number>("2023", countryCount2023));
        
        series.setName("Countries Worked With");
        lineChart.getData().add(series);
    }
}
    
