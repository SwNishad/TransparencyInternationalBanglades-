/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author sazin
 */
public class Article implements Serializable {
    protected int articleID;
    protected String articleContent;
    
    public Article(int articleID, String articleContent) {
        this.articleID = articleID;
        this.articleContent = articleContent;
        
    }
    
    
}
