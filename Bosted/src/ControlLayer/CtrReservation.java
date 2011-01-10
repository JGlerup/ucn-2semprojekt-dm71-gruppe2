package ControlLayer;


import DBLayer.DBReservation;
import DBLayer.IFDBReservation;
import ExceptionsPack.NullValueException;
import ModelLayer.Reservation;
import ModelLayer.ToDaysDate;
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
        if(carID != 0 && !startDate.trim().equals(""))
        {
            IFDBReservation dbReservation = new DBReservation();
            return dbReservation.findReservation(carID, startDate, true);
        }//end if
        else
        {
            throw new NullValueException("Reservationen findes ikke,\nda der mangler oplysninger.\nPrøv igen.");
        }//end else
    }

    /**
     *
     * @return list of all reservations
     */
    public ArrayList<Reservation> getAllreservation()
    {
        ArrayList<Reservation> allReservation = new ArrayList<Reservation>();
        try
        {
            IFDBReservation dbReservation = new DBReservation();
            allReservation = dbReservation.getAllReservations(false);
        }//end try
        catch(Exception e)
        {
            System.out.println("Query exception - select reservation : " + e);
        }//end catch
        return allReservation;
    }

    /**
     *
     * @return list of all reservations from this day forward
     */
    public ArrayList<Reservation> getAllreservationsFromThisDate()
    {
        ArrayList<Reservation> allReservation = new ArrayList<Reservation>();
        ArrayList<Reservation> allReservationsFromThisDate = new ArrayList<Reservation>();
        try
        {
            IFDBReservation dbReservation = new DBReservation();
            allReservation = dbReservation.getAllReservations(false);
        }//end try
        catch(Exception e)
        {
            System.out.println("Query exception - select reservation : " + e);
        }//end catch

        String toDaysDate = findToDaysDate();
        int year = setYearToInt(toDaysDate);
        int month = setMonthToInt(toDaysDate);
        int date = setDateToInt(toDaysDate);

        if(!allReservation.isEmpty())
        {
            for(Reservation res : allReservation)
            {
                if(setYearToInt(res.getStartDate()) >= year)
                {
                    if(setMonthToInt(res.getStartDate()) >= month)
                    {
                        if(setDateToInt(res.getStartDate()) >= date)
                        {
                            allReservationsFromThisDate.add(res);
                        }//end if
                    }//end if
                }//end if
            }//end for
        }//en if
        return allReservationsFromThisDate;
    }

   /**
    *  
    * @param date a date
    * @return list of all reservations on a specific date
    */
    public ArrayList<Reservation> getAllReservationsByDate(String date)
    {
        ArrayList<Reservation> allReservation = new ArrayList<Reservation>();
        try
        {
            IFDBReservation dbReservation = new DBReservation();
            allReservation = dbReservation.getAllReservationsByDate(date, false);
        }//end try
        catch(Exception e)
        {
            System.out.println("Query exception - select reservation : " + e);
        }//end catch
        return allReservation;
    }

   /**
    *
    * @param employeeID the employeeID of the employee logged in
    * @return list of all reservations for the employee logged in from this day forward
    */
    public ArrayList<Reservation> getAllReservationsByEmployee(int employeeID)
    {
        ArrayList<Reservation> allReservation = new ArrayList<Reservation>();
        ArrayList<Reservation> allReservationsEmployee = new ArrayList<Reservation>();
        try
        {
            IFDBReservation dbReservation = new DBReservation();
            allReservation = dbReservation.getAllReservationsByEmployee(employeeID, false);
        }//end try
        catch(Exception e)
        {
            System.out.println("Query exception - select reservation : " + e);
        }//end catch

        String toDaysDate = findToDaysDate();
        int year = setYearToInt(toDaysDate);
        int month = setMonthToInt(toDaysDate);
        int date = setDateToInt(toDaysDate);

        if(!allReservation.isEmpty())
        {
            for(Reservation res : allReservation)
            {
                if(setYearToInt(res.getStartDate()) >= year)
                {
                    if(setMonthToInt(res.getStartDate()) >= month)
                    {
                        if(setDateToInt(res.getStartDate()) >= date)
                        {
                            allReservationsEmployee.add(res);
                        }//end if
                    }//end if
                }//end if
            }//end for
        }//en if
        return allReservationsEmployee;
    }

    /**
     *
     * @return the date of today
     */
    public String findToDaysDate()
    {
        ToDaysDate tdd = new ToDaysDate();
        String toDaysDate = tdd.toString();
        return toDaysDate;
    }

    /**
     *
     * @param date a date
     * @return year as an int
     */
    public int setYearToInt(String date)
    {
        String strYear = date.substring(0, 4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }

    /**
     *
     * @param date a date
     * @return month as an int
     */
    public int setMonthToInt(String date)
    {
        String strMonth = date.substring(5, 7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }

    /**
     *
     * @param date a date
     * @return the date as an int
     */
    public int setDateToInt(String date)
    {
        String strDate = date.substring(8);
        int intDate = Integer.parseInt(strDate);
        return intDate;
    }

    /**
     *
     * @param carID the id of car
     * @param employeeID the id of employee
     * @param clientID the id of client
     * @param date
     */
    public void insertReservation(int carID, int employeeID, int clientID, String date)throws NullValueException
    {
        if(carID != 0 && employeeID != 0 && clientID != 0 && !date.trim().equals(""))
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
        else
        {
            throw new NullValueException("Reservationen kan ikke gemmes,\nda der mangler oplysninger.\nPrøv igen.");
        }//end catch
            
    }

    public void updateReservation(int reservationID, int carID, int employeeID, int clientID, String startDate, String endDate, String reservationDate)
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

    public void deleteReservation(int reservationID)
    {
        IFDBReservation dbReservation = new DBReservation();
        dbReservation.deleteReservation(reservationID);
    }

}
