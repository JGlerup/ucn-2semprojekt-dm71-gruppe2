package DBLayer;

import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.ErrorHandlingMedicine;
import ModelLayer.Medicine;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBErrorHandlingMedicine implements IFDBErrorHandMed
{

    private Connection con;

    /** 
     * Creates a new instance of DBErrorHandlingMedicine
     */
    public DBErrorHandlingMedicine()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ErrorHandlingMedicine findErrorHandlingMedicineByID(int errorHandlingMedicineID, boolean retrieveAssociation)
    {
        ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
        ehmObj = singleWhere("errorhandlingmedicine_id = " + errorHandlingMedicineID, false);
        return ehmObj;
    }

    public ErrorHandlingMedicine findErrorHandlingMedicineByEpisode(String episode, boolean retrieveAssociation)
    {
        ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
        ehmObj = singleWhere("episode = '" + episode + "'", false);
        return ehmObj;
    }

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicines(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicinesByDate(String date, boolean retriveAssociation)
    {
        return miscWhere("date = '" + date + "'", retriveAssociation);
    }

    public int insertErrorHandlingMedicine(ErrorHandlingMedicine ehm)
    {  
        int rc = -1;
        String query = "INSERT INTO errorHandlingMedicine(medicine_id, client_id, employee_id, date, episode, quantity)  VALUES("
                + ehm.getMedicine().getMedicineID() + ","
                + ehm.getClient().getClientID() + ","
                + ehm.getEmployee().getEmployeeID() + ",'"
                + ehm.getDate() + "','"
                + ehm.getEpisode() + "',"
                + ehm.getQuantity() + ")";


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
                + "medicine_id = " + ehmObj.getMedicine().getMedicineID() + ", "
                + "client_id = " + ehmObj.getClient().getClientID() + ", "
                + "employee_id = " + ehmObj.getEmployee().getEmployeeID() + ", "
                + "date ='" + ehmObj.getDate() + "', "
                + "episode ='" + ehmObj.getEpisode() + "', "
                + "quantity =" + ehmObj.getQuantity() + " "
                + " WHERE errorhandlingmedicine_id = " + ehmObj.getErrorHandlingMedicineID();
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

    public int deleteErrorHandlingMedicine(int errorHandlingMedicineID)
    {
        int rc = -1;

        String query = "DELETE FROM errorHandlingMedicine "
                + " WHERE errorHandlingMedicine_id = '" + errorHandlingMedicineID + "'";
        System.out.println("Update query:" + query);
        try
        { // delete errorHandlingMedicine
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
            if (results.next())
            {
                IFDBMedi dbMedi = new DBMedicine();
                ehmObj.setMedicine(dbMedi.findMedicineByID(ehmObj.getMedicine().getMedicineID(), false));
                IFDBEmp dbEmp = new DBEmployee();
                ehmObj.setEmployee(dbEmp.findEmployeeByID(ehmObj.getEmployee().getEmployeeID(), false));
                IFDBClient dbCli = new DBClient();
                ehmObj.setClient(dbCli.findClientByID(ehmObj.getClient().getClientID(), false));
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

    private ArrayList<ErrorHandlingMedicine> miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList<ErrorHandlingMedicine> list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbErrorHandlingMedicine " + query);
        try
        { // read from errorHandlingMedicine
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            while (results.next())
            {
                ErrorHandlingMedicine ehmObj = new ErrorHandlingMedicine();
                ehmObj = buildErrorHandlingMedicine(results);
                list.add(ehmObj);
                //missing test on retriveAssociation
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
            ehmObj.setErrorHandlingMedicineID(results.getInt(1));
            Medicine medicine = new Medicine();
            medicine.setMedicineID(results.getInt(2));
            ehmObj.setMedicine(medicine);
            Client client = new Client();
            client.setClientID(results.getInt(3));
            ehmObj.setClient(client);
            Employee employee = new Employee();
            employee.setEmployeeID(results.getInt(4));
            ehmObj.setEmployee(employee);
            ehmObj.setDate(results.getString(5));
            ehmObj.setEpisode(results.getString(6));
            ehmObj.setQuantity(results.getInt(7));

        } catch (Exception Ex)
        {
            System.out.println("building errorHandlingMedicine object" + Ex);
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