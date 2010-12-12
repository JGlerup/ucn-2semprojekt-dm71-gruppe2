package DBLayer;

import ModelLayer.Frequency;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBFrequency implements IFDBFreq
{
     private Connection con;

    /** Creates a new instance of DBFrequency */
    public DBFrequency()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Frequency findFrequencyByTimesPerDayAndQuantityEachTime(int timesPerDay, int quantityEachTime, boolean retrieveAssociation)
    {
        Frequency freqObj = new Frequency();
        freqObj = singleWhere("times_per_day = " + timesPerDay + " AND quantity_each_time = " + quantityEachTime, false);
        return freqObj;
    }

    public Frequency findFrequencyByID(int frequencyID, boolean retrieveAssociation)
    {
        Frequency freqObj = new Frequency();
        freqObj = singleWhere("frequency_id = " + frequencyID, false);
        return freqObj;
    }
    public ArrayList<Frequency> getAllFrequency(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public int insertFrequency(Frequency freq)
    {
        int rc = -1;
        String query = "INSERT INTO frequency(times_per_day, quantity_each_time, description_usage, date)  VALUES("
                + freq.getTimesPerDay() + ","
                + freq.getQuantityEachTime() + ",'"
                + freq.getDescriptionUsage() + "','"
                + freq.getDate() + "')";

        System.out.println("insert : " + query);
        try
        { // insert new frequency
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in frequency db: " + ex);
        }
        return (rc);
    }

    public int updateFrequency(Frequency freq)
    {
        Frequency freqObj = freq;
        int rc = -1;

        String query = "UPDATE frequency SET "
                + "times_per_day = " + freqObj.getTimesPerDay() + " "
                + "quantity_each_time = " + freqObj.getQuantityEachTime() + " "
                + "description_usage = '" + freqObj.getDescriptionUsage() + "' "
                + "date = '" + freqObj.getDate() + "' "
                + " WHERE frequency_id = " + freqObj.getFrequencyID();
        System.out.println("Update query:" + query);
        try
        { // update frequency
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Update exception in frequency db: " + ex);
        }
        return (rc);
    }

    public int deleteFrequency(int frequencyID)
    {
        int rc = -1;

        String query = "DELETE FROM frequency "
                + " WHERE frequency_id = " + frequencyID;
        System.out.println("Update query:" + query);
        try
        { // update frequency
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Delete exception in frequency db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one Frequency object is to be build
    private Frequency singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Frequency freqObj = new Frequency();
        String query = buildQuery(wClause);
        System.out.println("DbFrequency -singelWhere " + query);
        try
        { // read from Frequency
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            if (results.next())
            {
                freqObj = buildFrequency(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select frequency : " + e);
            e.printStackTrace();
        }
        return freqObj;


    }

    //miscWhere is used when more than one Frequency is selected and build
    private ArrayList<Frequency> miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList<Frequency> list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DBFrequency " + query);
        try
        { // read from Frequency
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            while (results.next())
            {
                Frequency freqObj = new Frequency();
                freqObj = buildFrequency(results);
                list.add(freqObj);
                //missing test on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select frequency : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private Frequency buildFrequency(ResultSet results)
    {
        Frequency freqObj = new Frequency();

        try
        {
            freqObj.setFrequencyID(results.getInt(1));
            freqObj.setTimesPerDay(results.getInt(2));
            freqObj.setQuantityEachTime(results.getInt(3));
            freqObj.setDescriptionUsage(results.getString(4));
            freqObj.setDate(results.getString(5));

        }
        catch (Exception Ex)
        {
            System.out.println("building frequency object" + Ex);
        }

        return freqObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM frequency";

        if (wClause.length() > 0)
        {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
