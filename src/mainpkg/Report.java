/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author MSI Prestige
 
 */
public abstract class Report implements Serializable {
    protected String reportContent;
    protected String reportType;
    protected int reportID;

    @Override
    public String toString() {
        return "Report{" + "reportContent=" + reportContent + ", reportType=" + reportType + ", reportID=" + reportID + '}';
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public Report(String reportContent, String reportType, int reportID) {
        this.reportContent = reportContent;
        this.reportType = reportType;
        this.reportID = reportID;
    }
    
    public abstract void generateReport(Report newReport);
}