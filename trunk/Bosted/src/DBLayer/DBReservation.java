/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Reservation;
/**
 *
 * @author Glerup
 */
public class DBReservation implements IFDBReservation{
    
    private Connection con;

    public Reservation findReservation(int carID, String reservationDate, boolean retrieveAssociation) {
        Reservation rObj = new Reservation();
        rObj = singleWhere("carID = '" + carID + "' AND reservationDate = '" + reservationDate + "'", false);
        return rObj;
    }

    public ArrayList<Reservation> getAllReservations(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertReservation(Reservation r) {
        int rc = -1;
        String query = "INSERT INTO reservation(carID, employeeID, clientID, startDate, endDate, reservationDate)  VALUES('"
                + r.getCarID() + "','"
                + r.getEmployeeID() + "','"
                + r.getClientID() + "','"
                + r.getStartDate() + "','"
                + r.getEndDate() + "','"
                + r.getReservationDate() + "',')";

        System.out.println("insert : " + query);
        try {
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in reservation db: " + ex);
        }
        return (rc);
    }

    public int updateReservation(Reservation r) {
        Reservation rObj = r;
        int rc = -1;

        String query = "UPDATE reservation SET "
                + "carID = '" + rObj.getCarID() + "', "
                + "employeeID ='" + rObj.getEmployeeID() + "', "
                + "clientID ='" + rObj.getClientID() + "', "
                + "startDate ='" + rObj.getStartDate() + "', "
                + "endDate ='" + rObj.getEndDate() + "', "
                + "reservationDate ='" + rObj.getReservationDate() + "', "
                + " WHERE reservation_id ='" + rObj.getReservationID() + "'";
        System.out.println("Update query:" + query);
        try { // update cloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in reservation db: " + ex);
        }
        return (rc);
    }

    public int deleteReservation(int carID, String reservationDate) {
        int rc = -1;

        String query = "DELETE FROM reservation "
                + " WHERE carID = '" + carID + "' AND reservationDate = '" + reservationDate + "'";
        System.out.println("Delete query:" + query);
        try {
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in reservation db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Reservation singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Reservation rObj = new Reservation();
        String query = buildQuery(wClause);
        System.out.println("DbReservation -singelWhere " + query);
        try { // read from reservation
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                rObj = buildReservation(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select reservation : " + e);
            e.printStackTrace();
        }
        return rObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbReservation " + query);
        try { // read from reservation
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Reservation rObj = new Reservation();
                rObj = buildReservation(results);
                list.add(rObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select reservation : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public Reservation buildReservation(ResultSet results) {
        Reservation rObj = new Reservation();

        try {
            rObj.setReservationID(results.getInt(1));
            rObj.setCarID(results.getInt(2));
            rObj.setEmployeeID(results.getInt(3));
            rObj.setClientID(results.getInt(4));
            rObj.setStartDate(results.getString(5));
            rObj.setEndDate(results.getString(6));
            rObj.setReservationDate(results.getString(7));
        } catch (Exception e) {
            System.out.println("building reservation object");
        }

        return rObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM reservation";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

}
