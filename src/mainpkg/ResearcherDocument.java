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
public class ResearcherDocument implements Serializable {
    
    protected int resourceID;
    protected String resourceContent;
      
    public ResearcherDocument(int resourceID, String resourceContent) {
        this.resourceID = resourceID;
        this.resourceContent = resourceContent;

    }

    public int getResourceID() {
        return resourceID;
    }

    public String getResourceContent() {
        return resourceContent;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setResourceContent(String resourceContent) {
        this.resourceContent = resourceContent;
    }

    @Override
    public String toString() {
        return "ResearcherDocument{" + "resourceID=" + resourceID + ", resourceContent=" + resourceContent + '}';
    }

    
    
}
