/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class ResearchPaper implements Serializable {
    protected int publicationID;
    protected String publicationTitle;
    protected String publicationContent;
    
    public ResearchPaper(int publicationID, String publicationTitle, String publicationContent) {
        this.publicationID = publicationID;
        this.publicationTitle = publicationTitle;
        this.publicationContent = publicationContent; 
        
    }

    public int getPublicationID() {
        return publicationID;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public String getPublicationContent() {
        return publicationContent;
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public void setPublicationContent(String publicationContent) {
        this.publicationContent = publicationContent;
    }

    @Override
    public String toString() {
        return "ResearchPaper{" + "publicationID=" + publicationID + ", publicationTitle=" + publicationTitle + '}';
    }
    
    
    
}
