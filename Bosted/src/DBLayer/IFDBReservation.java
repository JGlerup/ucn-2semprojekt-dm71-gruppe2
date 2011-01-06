package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBReservation
{
    public Reservation findReservation(int carID, String startDate, boolean retrieveAssociation);
    //find one car having the carID and the startDate

    public ArrayList<Reservation> getAllReservations(boolean retriveAssociation);
    //find all reservations

    public ArrayList<Reservation> getAllReservationsByDate(String date, boolean retriveAssociation);
    //find all reservations on a specific date

    public int insertReservation(Reservation r);
    //insert information about an reservation

    public int updateReservation(Reservation r);
    //update information about an reservation

    public int deleteReservation(int reservationID);
    //delete a reservation

}
