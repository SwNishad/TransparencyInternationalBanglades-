/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.*;


public class Complain implements Serializable {
    private String description;

    public Complain(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Complain{" + "description=" + description + '}';
    }


    public static void WriteComplainToFile(Complain newComplain) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Complain.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newComplain);

        } catch (IOException ex) {
            ex.printStackTrace();  
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

