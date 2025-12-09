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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Acer
 */
public class MeetingInternal implements Serializable {
    
    protected int meetingID;
    protected String meetingName;
    protected LocalDate meetingTime;
    
    public MeetingInternal(int meetingID, String meetingName, LocalDate meetingTime) {
        this.meetingID = meetingID;
        this.meetingName = meetingName;
        this.meetingTime = meetingTime;
    }
    
    public String toString() {
        return "Meeting ID: " + meetingID + ", Meeting Agenda: " + meetingName + ", Meeting Date: " + meetingTime + "}\n";
    }    
}