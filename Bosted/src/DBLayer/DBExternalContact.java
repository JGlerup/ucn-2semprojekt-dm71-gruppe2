/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.ExternalContact;
import ModelLayer.Location;

/**
 *
 * @author Erik M. Gravesen
 */
public class DBExternalContact implements IFDBExtCon{

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBExternalContact() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ExternalContact findExternalContact(int externalContactID, boolean retrieveAssociation) {
        ExternalContact cObj = new ExternalContact();
        cObj = singleWhere("externalcontact_id = '" + externalContactID + "'", false);
        return cObj;
    }

    public ArrayList<ExternalContact> getAllExternalContacts(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertExternalContact(ExternalContact extCon) {  //call to get the next ssn number
        int rc = -1;
        String query = "INSERT INTO externalcontact(cbr, occupation, firstname, middlename, lastname, address, location_id, phoneno, email)  VALUES('"
                + extCon.getCbr() + "','"
                + extCon.getOccupation() + "','"
                + extCon.getFirstName() + "','"
                + extCon.getMiddleName() + "','"
                + extCon.getLastName() + "','"
                + extCon.getAddress() + "','"
                + extCon.getLocation().getLocationID() + "','"
                + extCon.getPhoneNo() + "','"
                + extCon.getEmail() + ")";

        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in external contact db: " + ex);
        }
        return (rc);
    }

    public int updateExternalContact(ExternalContact extCon) {
        ExternalContact extConObj = extCon;
        int rc = -1;

        String query = "UPDATE externalcontact SET "
                + "cbr = '" + extConObj.getCbr() + "', "
                + "occupation ='" + extConObj.getOccupation() + "', "
                + "firstname ='" + extConObj.getFirstName() + "', "
                + "middlename ='" + extConObj.getMiddleName() + "', "
                + "lastname ='" + extConObj.getLastName() + "', "
                + "address ='" + extConObj.getAddress() + "', "
                + "location_id ='" + extConObj.getLocation().getLocationID() + "', "
                + "phoneno ='" + extConObj.getPhoneNo() + "', "
                + "email ='" + extConObj.getEmail() + "' "
                + " WHERE externalcontact_id ='" + extConObj.getExternalContactID() + "'";
        System.out.println("Update query:" + query);
        try { // update cloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in external contact db: " + ex);
        }
        return (rc);
    }

    public int deleteExternalContact(int externalContactID) {
        int rc = -1;

        String query = "DELETE FROM externalcontact "
                + " WHERE externalcontact_id = '" + externalContactID + "'";
        System.out.println("Delete query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in external contact db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private ExternalContact singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ExternalContact extConObj = new ExternalContact();
        String query = buildQuery(wClause);
        System.out.println("DBExternalContact -singelWhere " + query);
        try { // read from externalcontact
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                IFDBLoca dbLoca = new DBLocation();
                extConObj.setLocation(dbLoca.findLocation(extConObj.getLocation().getLocationID(), false));
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select externalcontact : " + e);
            e.printStackTrace();
        }
        return extConObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DBExternalContact " + query);
        try { // read from client
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                ExternalContact extConObj = new ExternalContact();
                extConObj = buildExternalContact(results);
                list.add(extConObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select external contact : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public ExternalContact buildExternalContact(ResultSet results) {
        ExternalContact extConObj = new ExternalContact();

        try {
            extConObj.setExternalContactID(results.getInt(1));
            extConObj.setCbr(results.getString(2));
            extConObj.setOccupation(results.getString(3));
            extConObj.setFirstName(results.getString(4));
            extConObj.setMiddleName(results.getString(5));
            extConObj.setLastName(results.getString(6));
            extConObj.setAddress(results.getString(7));
            Location location = new Location();
            location.setLocationID(results.getInt(8));
            extConObj.setLocation(location);
            extConObj.setPhoneNo(results.getInt(9));
            extConObj.setEmail(results.getString(10));
        } catch (Exception e) {
            System.out.println("building external contact object");
        }

        return extConObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM externalcontact";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
