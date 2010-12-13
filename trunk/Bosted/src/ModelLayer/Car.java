/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Glerup
 */
public class Car {

    private int carID;
    private int regNo;
    private String description;

    public Car() {

    }

    public Car(int carID, int regNo, String description) {
        this.carID = carID;
        this.regNo = regNo;
        this.description = description;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNr) {
        this.regNo = regNo;
    }


}
