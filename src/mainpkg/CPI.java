package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author MSI Prestige
 */
//public class Infraction implements Serializable
public class CPI implements Serializable {

    static void add(CPI newCPI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    protected String cpiCountry;
    protected int cpiyear;
    protected int cpiIndexValue;

    public CPI(String cpiCountry, int cpiyear, int cpiIndexValue) {
        this.cpiCountry = cpiCountry;
        this.cpiyear = cpiyear;
        this.cpiIndexValue = cpiIndexValue;
    }

    public String getCpiCountry() {
        return cpiCountry;
    }

    public void setCpiCountry(String cpiCountry) {
        this.cpiCountry = cpiCountry;
    }

    public int getCpiyear() {
        return cpiyear;
    }

    public void setCpiyear(int cpiyear) {
        this.cpiyear = cpiyear;
    }

    public int getCpiIndexValue() {
        return cpiIndexValue;
    }

    public void setCpiIndexValue(int cpiIndexValue) {
        this.cpiIndexValue = cpiIndexValue;
    }

    @Override
    public String toString() {
        return "CPI{" + "cpiCountry=" + cpiCountry + ", cpiyear=" + cpiyear + ", cpiIndexValue=" + cpiIndexValue + '}';
    }
    
    
    public static List<CPI> loadCpiDataFromFile(String fileName) throws FileNotFoundException, IOException {
        List<CPI> cpiData = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                CPI cpi = (CPI) ois.readObject();
                cpiData.add(cpi);
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return cpiData;
    }
    
    // Write CPI data to a file
    public static void LoadCPITable(TableView cpiIndexTableView) {
        
        ObjectInputStream ois=null;
         try {
            CPI cpi;
            ois = new ObjectInputStream(new FileInputStream("CPIRecords.bin"));
            
            while (true) {
                cpi = (CPI) ois.readObject();
                cpiIndexTableView.getItems().add(cpi);
              
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

    public static void WriteCPItoFile(CPI newCPI) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("CPIRecords.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newCPI);
            
            Alert employeeAdded = new Alert(Alert.AlertType.INFORMATION);
            employeeAdded.setTitle("Success");
            employeeAdded.setHeaderText("CPI Added");
            employeeAdded.setContentText("CPI has been added successfully");
            employeeAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(DOCPISceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(DOCPISceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
   
