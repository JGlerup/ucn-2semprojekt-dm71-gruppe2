/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.Dailyreport;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public class DBDailyreport implements IFDBDaily {

    private Connection con;

    /** Creates a new instance of DBEmployee*/
    public DBDailyreport() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Dailyreport findDailyreport(int clientID, boolean retrieveAssociation) {
        Dailyreport dailyObj = new Dailyreport();
        dailyObj = singleWhere("clientID = '" + clientID + "'", false);
        return dailyObj;
    }

    public ArrayList<Dailyreport> getAllDailyreports(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertDailyreport(Dailyreport daily) {
        int rc = -1;
        String query = "INSERT INTO dailyreport(clientID, employeeID, text, date)  VALUES('"
                + daily.getClientID() + "','"
                + daily.getEmployeeID() + "','"
                + daily.getText() + "','"
                + daily.getDate() + "','";

        System.out.println("insert : " + query);
        try { // insert new dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    public int updateDailyreport(Dailyreport daily) {
        Dailyreport dailyObj = daily;
        int rc = -1;

        String query = "UPDATE dailyreport SET "
                + "clientID ='" + dailyObj.getClientID() + "',"
                + "employeeID ='" + dailyObj.getEmployeeID() + "',"
                + "text ='" + dailyObj.getText() + "',"
                + "date ='" + dailyObj.getDate() + "',"
                + " WHERE client_id = '" + dailyObj.getClientID() + "'";
        System.out.println("Update query:" + query);
        try { // update dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Update exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    public int deleteDailyreport(int clientID) {
        int rc = -1;

        String query = "DELETE FROM dailyreport "
                + " WHERE clientID = '" + clientID + "'";
        System.out.println("Update query:" + query);
        try { // update dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Delete exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Dailyreport singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Dailyreport dailyObj = new Dailyreport();
        String query = buildQuery(wClause);
        System.out.println("DbDailyreport -singelWhere " + query);
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                dailyObj = buildDailyreport(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select dailyreport : " + e);
            e.printStackTrace();
        }
        return dailyObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbDailyreport " + query);
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Dailyreport dailyObj = new Dailyreport();
                dailyObj = buildDailyreport(results);
                list.add(dailyObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select dailyreport : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private Dailyreport buildDailyreport(ResultSet results) {
        Dailyreport dailyObj = new Dailyreport();

        try {
            dailyObj.setClientID(results.getInt(1));
            dailyObj.setEmployeeID(results.getInt(2));
            dailyObj.setText(results.getString(3));
            dailyObj.setDate(results.getDate(4));
            
        } catch (Exception e) {
            System.out.println("building dailyreport object");
        }

        return dailyObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM dailyreport";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

    public ArrayList<Dailyreport> buildListOfDailyreports(int clientID) {
        ResultSet results;
        ArrayList<Dailyreport> list = new ArrayList<Dailyreport>();
        String query = "SELCT * FROM dailyreport WHERE client_id in(SELECT client_id FROM employee_client WHERE client_id =  " + clientID + ")";
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Dailyreport dailyObj = new Dailyreport();
                dailyObj = buildDailyreport(results);
                list.add(dailyObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return list;
    }

}

    

