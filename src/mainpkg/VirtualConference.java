/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class VirtualConference implements Serializable {
    
    protected int conferenceID;
    protected String conferenceTopic;
    protected LocalDate conferenceDate;
    protected String conferenceDuration;
    protected String conferenceLink;   

    public VirtualConference(int conferenceID, String conferenceTopic, LocalDate conferenceDate, String conferenceDuration, String conferenceLink) {
        this.conferenceID = conferenceID;
        this.conferenceTopic = conferenceTopic;
        this.conferenceDate = conferenceDate;
        this.conferenceDuration = conferenceDuration;
        this.conferenceLink = conferenceLink;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public String getConferenceTopic() {
        return conferenceTopic;
    }

    public LocalDate getConferenceDate() {
        return conferenceDate;
    }

    public String getConferenceDuration() {
        return conferenceDuration;
    }

    public String getConferenceLink() {
        return conferenceLink;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    public void setConferenceTopic(String conferenceTopic) {
        this.conferenceTopic = conferenceTopic;
    }

    public void setConferenceDate(LocalDate conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public void setConferenceDuration(String conferenceDuration) {
        this.conferenceDuration = conferenceDuration;
    }

    public void setConferenceLink(String conferenceLink) {
        this.conferenceLink = conferenceLink;
    }

    @Override
    public String toString() {
        return "VirtualConference{" + "conferenceID=" + conferenceID + ", conferenceTopic=" + conferenceTopic + ", conferenceDate=" + conferenceDate + ", conferenceDuration=" + conferenceDuration + ", conferenceLink=" + conferenceLink + '}';
    }
    
}
