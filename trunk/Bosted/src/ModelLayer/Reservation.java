package ModelLayer;

import DBLayer.DBCar;
import DBLayer.DBClient;
import DBLayer.IFDBCar;
import DBLayer.IFDBClient;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Reservation
{

    private int reservationID;
    private Car car;
    private int employeeID;
    private int clientID;
    private String startDate;
    private String endDate;
    private String reservationDate;

    public Reservation()
    {

    }

    public Reservation(int reservationID, Car car, int employeeID, int clientID, String startDate, String endDate, String reservationDate)
    {
        this.reservationID = reservationID;
        this.car = car;
        this.employeeID = employeeID;
        this.clientID = clientID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationDate = reservationDate;
    }


    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getReservationDate()
    {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate)
    {
        this.reservationDate = reservationDate;
    }

    public int getReservationID()
    {
        return reservationID;
    }

    public void setReservationID(int reservationID)
    {
        this.reservationID = reservationID;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setThisReservationDate()
    {
        ToDaysDate toDaysDate = new ToDaysDate();
        reservationDate = toDaysDate.toString();
    }

    public String toString()
    {
        Car car = new Car();
        IFDBCar dbCar = new DBCar();
        car = dbCar.findCarByID(car.getCarID(), true);
        Client cli = new Client();
        IFDBClient dbCli = new DBClient();
        cli = dbCli.findClientByID(clientID, true);
        return startDate + ", " + cli.toString() + ", " + car.toString();
    }

}
