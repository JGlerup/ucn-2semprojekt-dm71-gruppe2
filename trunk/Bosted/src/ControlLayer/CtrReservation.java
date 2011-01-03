package ControlLayer;


import DBLayer.DBReservation;
import DBLayer.IFDBReservation;
import ModelLayer.Reservation;
import java.util.ArrayList;


/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrReservation
{

    public CtrReservation() 
    {

    }

    public Reservation findReservation(int carID, String reservationDate)
    {
        IFDBReservation dbReservation = new DBReservation();
        return dbReservation.findReservation(carID, reservationDate, true);
    }

    public ArrayList getAllreservation()
    {
        IFDBReservation dbReservation = new DBReservation();
        ArrayList allReservation = new ArrayList<Reservation>();
        allReservation = dbReservation.getAllReservations(false);
        return allReservation;
    }

    public void insertReservation(int carID, int employeeID, int clientID, String date)
    {
            IFDBReservation dbreservation = new DBReservation();
            Reservation cObj = new Reservation();
            cObj.setCarID(carID);
	    cObj.setEmployeeID(employeeID);
	    cObj.setClientID(clientID);
	    cObj.setStartDate(date);
	    cObj.setEndDate(date);
	    cObj.setThisReservationDate();
            dbreservation.insertReservation(cObj);
    }

    public void updateReservation(int reservationID, int carID, int employeeID, int clientID, String startDate, String endDate, String reservationDate)
    {
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
            dbreservation.updateReservation(cObj);
        }
    }

    public void deleteReservation(int reservationID)
    {
        IFDBReservation dbReservation = new DBReservation();
        dbReservation.deleteReservation(reservationID);
    }

}
