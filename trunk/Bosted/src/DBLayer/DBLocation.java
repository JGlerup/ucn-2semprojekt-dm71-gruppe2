package DBLayer;

import ModelLayer.Location;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBLocation implements IFDBLoca
{

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBLocation()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Location findLocation(int locationID, boolean retrieveAssociation)
    {
        Location locaObj = new Location();
        locaObj = singleWhere("locationID = '" + locationID + "'", false);
        return locaObj;
    }

    public ArrayList<Location> getAllLocations(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public int insertLocation(Location loca)
    {  //call to get the next ssn number
        int locationID = GetMax.getMaxId("Select max(locationID) from location");
        locationID = locationID + 1;
        System.out.println("next locationID = " + locationID);

        int rc = -1;
        String query = "INSERT INTO location(locationID, zipcode, city)  VALUES('"
                + locationID + "','"
                + loca.getZipCode() + "','"
                + loca.getCity() + "'";


        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in location db: " + ex);
        }
        return (rc);
    }

    public int updateLocation(Location loca)
    {
        Location locaObj = loca;
        int rc = -1;

        String query = "UPDATE location SET "
                + "locationID ='" + locaObj.getLocationID() + "', "
                + "zipcode ='" + locaObj.getZipCode() + "' "
                + " WHERE city = '" + locaObj.getCity() + "'";
        System.out.println("Update query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Update exception in location db: " + ex);
        }
        return (rc);
    }

    public int deleteLocation(int locationID)
    {
        int rc = -1;

        String query = "DELETE FROM location "
                + " WHERE locationID = '" + locationID + "'";
        System.out.println("Update query:" + query);
        try { // update location
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Delete exception in location db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Location singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Location locaObj = new Location();
        String query = buildQuery(wClause);
        System.out.println("DbLocation -singelWhere " + query);
        try { // read from location
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                locaObj = buildLocation(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select location : " + e);
            e.printStackTrace();
        }
        return locaObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbLocation " + query);
        try { // read from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Location locaObj = new Location();
                locaObj = buildLocation(results);
                list.add(locaObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select location : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private Location buildLocation(ResultSet results)
    {
        Location locaObj = new Location();

        try
        {
            locaObj.setLocationID(results.getInt(2));
            locaObj.setZipCode(results.getInt(3));
            locaObj.setCity(results.getString(4));


        }
        catch (Exception e)
        {
            System.out.println("building location object");
        }

        return locaObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM location";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
