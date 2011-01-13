package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Medicine
{
    private int medicineID;
    private Frequency frequency;
    private ExternalContact externalContact;
    private Client client;
    private String name;
    private String description;
    private String date;
    private int quantity;


    public Medicine()
    {

    }

    public Medicine(String name, String description, int quantity)
    {
        this.name = name;
        this.description = description;
        this.date = "";
        this.quantity = quantity;
        setThisDate();
    }

    public int getMedicineID()
    {
        return medicineID;
    }

    public void setMedicineID(int medicineID)
    {
        this.medicineID = medicineID;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public ExternalContact getExternalContact()
    {
        return externalContact;
    }

    public void setExternalContact(ExternalContact externalContact)
    {
        this.externalContact = externalContact;
    }

    public Frequency getFrequency()
    {
        return frequency;
    }

    public void setFrequency(Frequency frequency)
    {
        this.frequency = frequency;
    }

    public String getDate()
    {
        return date;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String toString()
    {
        return name;
    }
}



