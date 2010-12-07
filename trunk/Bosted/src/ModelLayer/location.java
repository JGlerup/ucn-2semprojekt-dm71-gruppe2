/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Rasmus
 */
public class Location 
{
private int locationID;
private int zipcode;
private String city;

    public Location()
    {

    }


    public Location (int locationID, int zipcode, String city)
    {

    this.locationID = locationID;
    this.zipcode = zipcode;
    this.city = city;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getZipCode() {
        return zipcode;
    }

    public void setZipCode(int zipcode) {
        this.zipcode = zipcode;
    }

        
}