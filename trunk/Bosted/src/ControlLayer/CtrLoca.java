/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public class CtrLoca {

    public CtrLoca() {
    }

    public Location findLocation(int locationID) {
        IFDBLoca dbLoca = new DBLocation();
        return dbLoca.findLocation(locationID, true);
    }

    public Location findLocationByZipCode(int zipCode) {
        ArrayList<Location> allLoca = new ArrayList<Location>();
        allLoca = getAllLocations();
        boolean found = false;
        Location l = null;
        int index = 0;
        while(index < allLoca.size() && !found){
            if(allLoca.get(index).getZipCode() == zipCode){
                found = true;
                l = allLoca.get(index);
            }
            index++;
        }
        return l;
    }

    public ArrayList getAllLocations() {
        IFDBLoca dbLoca = new DBLocation();
        ArrayList allLoca = new ArrayList<Location>();
        allLoca = dbLoca.getAllLocations(false);
        return allLoca;
    }

    public void insert(int zipCode, String city) {
        IFDBLoca dbLoca = new DBLocation();
        Location locaObj = new Location();
        locaObj.setZipCode(zipCode);
        locaObj.setCity(city);
        dbLoca.insertLocation(locaObj);
    }

    public void updateLoca(int zipCodeCurrent, int zipCodeNew, String city) {
        Location l = findLocationByZipCode(zipCodeCurrent);
        int locationID = l.getLocationID();
        IFDBLoca dbLoca = new DBLocation();
        Location locaObj = new Location();
        locaObj.setLocationID(locationID);
        locaObj.setZipCode(zipCodeNew);
        locaObj.setCity(city);
        dbLoca.updateLocation(locaObj);

    }

    public void deleteLoca(int locationID) {
        IFDBLoca dbLoca = new DBLocation();
        dbLoca.deleteLocation(locationID);
    }
}
