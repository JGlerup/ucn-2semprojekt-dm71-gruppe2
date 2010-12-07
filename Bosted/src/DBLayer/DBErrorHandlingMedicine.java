package DBLayer;

import ModelLayer.ErrorHandlingMedicine;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBErrorHandlingMedicine implements IFDBErrorHandMed
{

    private Connection con;

    /** Creates a new instance of DBErrorHandlingMedicine */
    public DBErrorHandlingMedicine()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ErrorHandlingMedicine findErrorHandlingMedicine(int errorHandlingMedicineNo, boolean retrieveAssociation)
    {
        ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
        ehmObj = singleWhere("errorHandlingMedicineno = '" + errorHandlingMedicineNo + "'", false);
        return ehmObj;
    }

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicines(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public int insertErrorHandlingMedicine(ErrorHandlingMedicine ehm)
    {  //call to get the next ssn number

        int rc = -1;
        String query = "INSERT INTO errorHandlingMedicine(medicin_id, client_id, employee_id, date, episode, quantity)  VALUES("
                + ehm.getMedicineID() + ","
                + ehm.getClientID() + ","
                + ehm.getEmployeeID() + ","
                + ehm.getDate() + ",'"
                + ehm.getEpisode() + "',"
                + ehm.getQuantity();


        System.out.println("insert : " + query);
        try
        { // insert new errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in errorHandlingMedicine db: " + ex);
        }
        return (rc);
    }

    public int updateErrorHandlingMedicine(ErrorHandlingMedicine ehm)
    {
        ErrorHandlingMedicine ehmObj = ehm;
        int rc = -1;

        String query = "UPDATE errorHandlingMedicine SET "
                + "medicine_id ='" + ehmObj.getMedicineID() + "', "
                + "client_id ='" + ehmObj.getClientID() + "', "
                + "employee_id ='" + ehmObj.getEmployeeID() + "', "
                + "date ='" + ehmObj.getDate() + "', "
                + "episode ='" + ehmObj.getEpisode() + "' "
                + "quantity ='" + ehmObj.getQuantity() + "' "
                + " WHERE errorHandlingMedicineid = '" + ehmObj.getErrorHandlingMedicineID() + "'";
        System.out.println("Update query:" + query);
        try
        { // update errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Update exception in errorHandlingMedicine db: " + ex);
        }
        return (rc);
    }

    public int deleteErrorHandlingMedicine(int errorHandlingMedicineNo)
    {
        int rc = -1;

        String query = "DELETE FROM errorHandlingMedicine "
                + " WHERE errorHandlingMedicineno = '" + errorHandlingMedicineNo + "'";
        System.out.println("Update query:" + query);
        try
        { // update errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Delete exception in errorHandlingMedicine db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one errorHandlingMedicine object is to be build
    private ErrorHandlingMedicine singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
        String query = buildQuery(wClause);
        System.out.println("DbErrorHandlingMedicine -singelWhere " + query);
        try
        { // read from errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next())
            {
                ehmObj = buildErrorHandlingMedicine(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select errorHandlingMedicine : " + e);
            e.printStackTrace();
        }
        return ehmObj;


    }
    //miscWhere is used when more than one errorHandlingMedicine is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbErrorHandlingMedicine " + query);
        try
        { // read from errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next())
            {
                ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
                ehmObj = buildErrorHandlingMedicine(results);
                list.add(ehmObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select errorHandlingMedicine : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private ErrorHandlingMedicine buildErrorHandlingMedicine(ResultSet results)
    {
        ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();

        try
        {
            ehmObj.setMedicineID(results.getInt(2));
            ehmObj.setClientID(results.getInt(3));
            ehmObj.setEmployeeID(results.getInt(4));
            ehmObj.setDate(results.getDate(5));
            ehmObj.setEpisode(results.getString(6));
            ehmObj.setQuantity(results.getInt(7));

        } catch (Exception e)
        {
            System.out.println("building errorHandlingMedicine object");
        }

        return ehmObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM errorHandlingMedicine";

        if (wClause.length() > 0)
        {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}