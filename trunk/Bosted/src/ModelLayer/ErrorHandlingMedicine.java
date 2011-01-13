package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class ErrorHandlingMedicine
{
    private int errorHandlingMedicineID;
    private Medicine medicine;
    private Client client;
    private Employee employee;
    private String date;
    private String episode;
    private int quantity;
    

    public ErrorHandlingMedicine() 
    {

    }

    public ErrorHandlingMedicine(int errorHandlingMedicineID, Medicine medicine, Client client, Employee employee, String episode, int quantity)
    {
        this.errorHandlingMedicineID = errorHandlingMedicineID;
        this.medicine = medicine;
        this.client = client;
        this.employee = employee;
        this.date = "";
        this.episode = episode;
        this.quantity = quantity;
        setThisDate();
        
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
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

    public Medicine getMedicine()
    {
        return medicine;
    }

    public void setMedicine(Medicine medicine)
    {
        this.medicine = medicine;
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




