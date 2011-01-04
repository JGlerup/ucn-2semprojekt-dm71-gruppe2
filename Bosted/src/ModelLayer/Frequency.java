package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Frequency
{
    private int frequencyID;
    private int timesPerDay;
    private int quantityEachTime;
    private String descriptionUsage;
    private String date;

    public Frequency(int frequencyID, int timesPerDay, int quantityEachTime, String descriptionUsage, String date)
    {
        this.frequencyID = frequencyID;
        this.timesPerDay = timesPerDay;
        this.quantityEachTime = quantityEachTime;
        this.descriptionUsage = descriptionUsage;
        this.date = date;
    }

    public Frequency()
    {

    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDescriptionUsage()
    {
        return descriptionUsage;
    }

    public void setDescriptionUsage(String descriptionUsage)
    {
        this.descriptionUsage = descriptionUsage;
    }

    public int getFrequencyID() {
        return frequencyID;
    }

    public void setFrequencyID(int frequencyID)
    {
        this.frequencyID = frequencyID;
    }

    public int getQuantityEachTime()
    {
        return quantityEachTime;
    }

    public void setQuantityEachTime(int quantityEachTime)
    {
        this.quantityEachTime = quantityEachTime;
    }

    public int getTimesPerDay()
    {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay)
    {
        this.timesPerDay = timesPerDay;
    }

    public void setThisDate()
    {
        ToDaysDate toDaysDate = new ToDaysDate();
        date = toDaysDate.toString();
    }

    public String toString()
    {
        return Integer.toString(frequencyID);
    }
}
