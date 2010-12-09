package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class ErrorHandlingMedicine
{
    private int errorHandlingMedicineID;
    private int medicineID;
    private int clientID;
    private int employeeID;
    private String date;
    private String episode;
    private int quantity;
    

    public ErrorHandlingMedicine() 
    {

    }

    public ErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int clientID, int employeeID, String episode, int quantity)
    {
        this.errorHandlingMedicineID = errorHandlingMedicineID;
        this.medicineID = medicineID;
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.date = "";
        this.episode = episode;
        this.quantity = quantity;
        setThisDate();
        
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
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

     public void setThisDate()
     {
        ToDaysDate toDaysDate = new ToDaysDate();
        date = toDaysDate.toString();
    }
}




