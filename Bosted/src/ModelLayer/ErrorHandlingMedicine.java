/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class ErrorHandlingMedicine {
    private int errorHandlingMedicineID;
    private int medicineID;
    private int clientID;
    private int employeeID;
    private ToDaysDate date;
    private String episode;
    private int quantity;
    

    public ErrorHandlingMedicine() 
    {

    }

    public ErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int employeeID, String episode, int quantity)
    {
        this.errorHandlingMedicineID = errorHandlingMedicineID;
        this.medicineID = medicineID;
        this.employeeID = employeeID;
        this.date = new ToDaysDate();
        this.episode = episode;
        this.quantity = quantity;
        
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public ToDaysDate getDate()
    {
        return date;
    }

    public void setDate(ToDaysDate date)
    {
        this.date = date;
    }

    public void setThisDate()
    {
        this.date = new ToDaysDate();
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getEpisode()
    {
        return episode;
    }

    public void setEpisode(String episode)
    {
        this.episode = episode;
    }

    public int getErrorHandlingMedicineID()
    {
        return errorHandlingMedicineID;
    }

    public void setErrorHandlingMedicineID(int errorHandlingMedicineID)
    {
        this.errorHandlingMedicineID = errorHandlingMedicineID;
    }

    public int getMedicineID()
    {
        return medicineID;
    }

    public void setMedicineID(int medicineID)
    {
        this.medicineID = medicineID;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}



