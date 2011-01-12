/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Glerup
 */
public class Car
{

    private int carID;
    private String regNo;
    private String description;

    public Car()
    {

    }

    public Car(int carID, String regNo, String description)
    {
        this.carID = carID;
        this.regNo = regNo;
        this.description = description;
    }

    public int getCarID()
    {
        return carID;
    }

    public void setCarID(int carID)
    {
        this.carID = carID;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRegNo()
    {
        return regNo;
    }

    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }

    public String toString()
    {
        return description;
    }

}
