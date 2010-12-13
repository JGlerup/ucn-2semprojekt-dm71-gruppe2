/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Glerup
 */
public class Reservation {

    private int reservationID;
    private int carID;
    private int employeeID;
    private int clientID;
    private String startDate;
    private String endDate;
    private String reservationDate;

    public Reservation() {

    }

    public Reservation(int reservationID, int carID, int employeeID, int clientID, String startDate, String endDate, String reservationDate) {
        this.reservationID = reservationID;
        this.carID = carID;
        this.employeeID = employeeID;
        this.clientID = clientID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationDate = reservationDate;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }



}
