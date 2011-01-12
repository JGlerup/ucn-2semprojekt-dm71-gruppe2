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
    private Employee employee;
    private Client client;
    private String startDate;
    private String endDate;
    private String reservationDate;

    public Reservation()
    {

    }

    public Reservation(int reservationID, Car car, Employee employee, Client client, String startDate, String endDate, String reservationDate)
    {
        this.reservationID = reservationID;
        this.car = car;
        this.employee = employee;
        this.client = client;
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

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
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
        
        return startDate + ", " + client.toString() + ", " + car.toString();
    }

}
