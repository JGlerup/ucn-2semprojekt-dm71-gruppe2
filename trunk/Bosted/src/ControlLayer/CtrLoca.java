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

    public ArrayList getAllLocotions() {
        IFDBLoca dbLoca = new DBLocation();
        ArrayList allLoca = new ArrayList<Location>();
        allLoca = dbLoca.getAllLocations(false);
        return allLoca;
    }

    public void insert(int locationID, int zipCode, String city) {
        IFDBLoca dbLoca = new DBLocation();
        Location locaObj = new Location();
        locaObj.setLocationID(locationID);
        locaObj.setZipCode(zipCode);
        locaObj.setCity(city);


    }

    public void updateLoca(int locationID, int zipCode, String city) {
        IFDBLoca dbLoca = new DBLocation();
        Location locaObj = new Location();
        locaObj.setLocationID(locationID);
        locaObj.setZipCode(zipCode);
        locaObj.setCity(city);

    }

    public void deleteLoca(int locationID) {
        IFDBLoca dbLoca = new DBLocation();
        dbLoca.deleteLocation(locationID);
    }
}
