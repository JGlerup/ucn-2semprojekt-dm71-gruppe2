package DBLayer;

import ModelLayer.Client;
import ModelLayer.ExternalContact;
import ModelLayer.Frequency;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Medicine;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBMedicine implements IFDBMedi
{

    private Connection con;

    /** Creates a new instance of DBMedicine */
    public DBMedicine()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Medicine findMedicineByClientIDAndName(int clientID, String name, boolean retrieveAssociation)
    {
        Medicine mediObj = new Medicine();
        mediObj = singleWhere("client_id = " + clientID + " AND name = '" + name + "'", false);
        return mediObj;
    }

    public Medicine findMedicineByID(int medicineID, boolean retrieveAssociation)
    {
        Medicine mediObj = new Medicine();
        mediObj = singleWhere("medicine_id = " + medicineID , false);
        return mediObj;
    }


    public ArrayList<Medicine> getAllMedicine(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public ArrayList<Medicine> getAllMedicineByClientID(int clientID, boolean retriveAssociation)
    {
        return miscWhere("client_id = " + clientID, retriveAssociation);
    }

    public int insertMedicine(Medicine medi)
    {  
        int rc = -1;
        String query = "INSERT INTO medicine(frequency_id, externalcontact_id, client_id, name, description, date, quantity)  VALUES("
                + medi.getFrequency().getFrequencyID() + ","
                + medi.getExternalContact().getExternalContactID() + ","
                + medi.getClient().getClientID() + ",'"
                + medi.getName() + "','"
                + medi.getDescription() + "','"
                + medi.getDate() + "',"
                + medi.getQuantity() + ")";

        System.out.println("insert : " + query);
        try
        { // insert new medicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in medicine db: " + ex);
        }
        return (rc);
    }

    public int updateMedicine(Medicine medi)
    {
        Medicine mediObj = medi;
        int rc = -1;

        String query = "UPDATE medicine SET "
                + "frequency_id = " + mediObj.getFrequency().getFrequencyID() + ","
                + "externalcontact_id = " + mediObj.getExternalContact().getExternalContactID() + ","
                + "client_id = " + mediObj.getClient().getClientID() + ","
                + "name = '" + mediObj.getName() + "',"
                + "description = '" + mediObj.getDescription() + "',"
                + "date = '" + mediObj.getDate() + "',"
                + "quantity = " + mediObj.getQuantity()
                + " WHERE medicine_id = " + mediObj.getMedicineID();
        System.out.println("Update query:" + query);
        try
        { // update medicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Update exception in medicine db: " + ex);
        }
        return (rc);
    }

    public int deleteMedicine(int medicineID)
    {
        int rc = -1;

        String query = "DELETE FROM medicine "
                + " WHERE medicine_id = " + medicineID;
        System.out.println("Delete query:" + query);
        try
        { // delete medicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Delete exception in medicine db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one medicine object is to be build
    private Medicine singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Medicine mediObj = new Medicine();
        String query = buildQuery(wClause);
        System.out.println("DbMedicine -singelWhere " + query);
        try
        { // read from medicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            if (results.next())
            {
                mediObj = buildMedicine(results);
//                IFDBFreq dbFreq = new DBFrequency();
//                mediObj.setFrequency(dbFreq.findFrequencyByID(mediObj.getFrequency().getFrequencyID(), false));
//                IFDBExtCon dbExtCon = new DBExternalContact();
//                mediObj.setExternalContact(dbExtCon.findExternalContact(mediObj.getExternalContact().getExternalContactID(), false));
//                IFDBClient dbCli = new DBClient();
//                mediObj.setClient(dbCli.findClientByID(mediObj.getClient().getClientID(), false));
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : " + e);
            e.printStackTrace();
        }
        return mediObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList<Medicine> miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList<Medicine> list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbMedicine " + query);
        try
        { // read from medicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            while (results.next())
            {
                Medicine mediObj = new Medicine();
                mediObj = buildMedicine(results);
                list.add(mediObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : ");
            e.printStackTrace();
        }
        return list;
    }

    private Medicine buildMedicine(ResultSet results)
    {
        Medicine mediObj = new Medicine();

        try
        {
            mediObj.setMedicineID(results.getInt(1));
            Frequency frequency = new Frequency();
            frequency.setFrequencyID(results.getInt(2));
            mediObj.setFrequency(frequency);
            ExternalContact extCon = new ExternalContact();
            extCon.setExternalContactID(results.getInt(3));
            mediObj.setExternalContact(extCon);
            Client client = new Client();
            client.setClientID(results.getInt(4));
            mediObj.setClient(client);
            mediObj.setName(results.getString(5));
            mediObj.setDescription(results.getString(6));
            mediObj.setDate(results.getString(7));
            mediObj.setQuantity(results.getInt(8));
        } 
        catch (Exception e)
        {
            System.out.println("building medicine object");
        }

        return mediObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM medicine";

        if (wClause.length() > 0)
        {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
