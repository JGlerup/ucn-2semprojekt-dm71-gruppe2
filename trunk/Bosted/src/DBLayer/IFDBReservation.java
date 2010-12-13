/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;
/**
 *
 * @author Glerup
 */
public interface IFDBReservation {

    public Reservation findReservation(int carID, String reservationDate, boolean retrieveAssociation);
    //find one car having the carID and the reservationDate

    public ArrayList<Reservation> getAllReservations(boolean retriveAssociation);

    public int insertReservation(Reservation r);
    //insert information about an reservation

    public int updateReservation(Reservation r);
    //update information about an reservation

    public int deleteCar(int carID, String reservationDate);
    //delete a reservation

}
