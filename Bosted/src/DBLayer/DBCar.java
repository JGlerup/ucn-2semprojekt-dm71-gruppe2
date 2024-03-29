package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Car;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBCar implements IFDBCar
{

    private Connection con;

    public DBCar()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    /**
     * 
     * @param carID the carID
     * @param retrieveAssociation
     * @return an instance of car
     */
    public Car findCarByID(int carID, boolean retrieveAssociation)
    {
        Car cObj = new Car();
        cObj = singleWhere("car_id = " + carID, false);
        return cObj;
    }

    public Car findCar(String regNo, boolean retrieveAssociation)
    {
        Car cObj = new Car();
        cObj = singleWhere("registrationsno = '" + regNo + "'", false);
        return cObj;
    }

    public ArrayList<Car> getAllCars(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public ArrayList<Car> getAllCarsByDate(String date, boolean retriveAssociation)
    {
        return miscWhere("startdate = '" + date + "'", retriveAssociation);
    }

    public int insertCar(Car c)
    {
        int rc = -1;
        String query = "INSERT INTO car(registrationsno, description)  VALUES('"
                + c.getRegNo() + "','"
                + c.getDescription() + "')";

        System.out.println("insert : " + query);
        try
        { // insert new car
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in car db: " + ex);
        }//end catch
        return (rc);
    }

    public int updateCar(Car c)
    {
        Car cObj = c;
        int rc = -1;

        String query = "UPDATE car SET "
                + "registrationsno = '" + cObj.getRegNo() + "', "
                + "description ='" + cObj.getDescription() + "' "
                + " WHERE car_id ='" + cObj.getCarID() + "'";
        System.out.println("Update query:" + query);
        try
        { // update car
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Update exception in car db: " + ex);
        }//end catch
        return (rc);
    }

    public int deleteCar(String regNo)
    {
        int rc = -1;

        String query = "DELETE FROM car "
                + " WHERE registrationsno = '" + regNo + "'";
        System.out.println("Delete query:" + query);
        try 
        { // delete car
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex)
        {
            System.out.println("Delete exception in car db: " + ex);
        }//end catch
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Car singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Car cObj = new Car();
        String query = buildQuery(wClause);
        System.out.println("DBCar -singelWhere " + query);
        try
        { // read from car
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next())
            {
                cObj = buildCar(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select car : " + e);
            e.printStackTrace();
        }//end catch
        return cObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbCar " + query);
        try
        { // read from car
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next())
            {
                Car cObj = new Car();
                cObj = buildCar(results);
                list.add(cObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select car : " + e);
            e.printStackTrace();
        }//end catch
        return list;
    }

    public Car buildCar(ResultSet results)
    {
        Car cObj = new Car();

        try
        {
            cObj.setCarID(results.getInt(1));
            cObj.setRegNo(results.getString(2));
            cObj.setDescription(results.getString(3));
        }//end try
        catch (Exception e)
        {
            System.out.println("building car object");
        }//end catch

        return cObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM car";

        if (wClause.length() > 0)
        {
            query = query + " WHERE " + wClause;
        }//end if

        return query;
    }

}
