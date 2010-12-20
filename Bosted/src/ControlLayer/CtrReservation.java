package ControlLayer;


import DBLayer.DBReservation;
import DBLayer.IFDBReservation;
import ModelLayer.Reservation;
import java.util.ArrayList;


/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrReservation {

    public CtrReservation() {
    }

    public Reservation findReservation (int carID, String reservationID) {
        IFDBReservation dbReservation = new DBReservation();
        return dbReservation.findReservation(carID, reservationID, true);
    }

    public ArrayList getAllreservation() {
        IFDBReservation dbReservation = new DBReservation();
        ArrayList allReservation = new ArrayList<Reservation>();
        allReservation = dbReservation.getAllReservations(false);
        return allReservation;
    }

    public void insertReservation(int reservationID, int carID, int employeeID, int clientID, String startDate, String endDate, String reservationDate) {
            IFDBReservation dbreservation = new DBReservation();
            Reservation cObj = new Reservation();
            cObj.setReservationID(reservationID);
	    cObj.setCarID(carID);
	    cObj.setEmployeeID(employeeID);
	    cObj.setClientID(clientID);
	    cObj.setStartDate(startDate);
	    cObj.setEndDate(endDate);
	    cObj.setReservationDate(reservationDate);
    }

    public void updateReservation(int reservationID, int carID, int employeeID, int clientID, String startDate, String endDate, String reservationDate) {
        {
            IFDBReservation dbreservation = new DBReservation();
            Reservation cObj = new Reservation();
            cObj.setReservationID(reservationID);
	    cObj.setCarID(carID);
	    cObj.setEmployeeID(employeeID);
	    cObj.setClientID(clientID);
	    cObj.setStartDate(startDate);
	    cObj.setEndDate(endDate);
	    cObj.setReservationDate(reservationDate);
        }
    }

    public void deleteReservation(int carID, String reservationID) {
        IFDBReservation dbReservation = new DBReservation();
        dbReservation.deleteReservation(carID, reservationID);
    }

}
