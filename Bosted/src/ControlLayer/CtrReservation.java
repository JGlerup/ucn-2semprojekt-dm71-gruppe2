package ControlLayer;


import DBLayer.DBReservation;
import DBLayer.IFDBReservation;
import ExceptionsPack.NullValueException;
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

    /**
     *
     * @param carID the id of the car
     * @param startDate the (start)date of the reservation
     * @return the reservation
     */
    public Reservation findReservation(int carID, String startDate) throws NullValueException
    {
        if(carID > 0 && !startDate.trim().equals(""))
        {
            IFDBReservation dbReservation = new DBReservation();
            return dbReservation.findReservation(carID, startDate, true);
        }//end if
        else
        {
            throw new NullValueException("Reservationen findes ikke");
        }//end else

    }

    /**
     *
     * @return list of all reservations
     */
    public ArrayList getAllreservation()
    {
        IFDBReservation dbReservation = new DBReservation();
        ArrayList allReservation = new ArrayList<Reservation>();
        allReservation = dbReservation.getAllReservations(false);
        return allReservation;
    }

    /**
     *
     * @param carID the id of car
     * @param employeeID the id of employee
     * @param clientID the id of client
     * @param date
     */
    public void insertReservation(int carID, int employeeID, int clientID, String date)
    {
        try
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
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in reservation db: " + ex);
        }//end catch
            
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
