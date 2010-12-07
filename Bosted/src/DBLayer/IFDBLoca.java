package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBLoca {

    public Location findLocation(int locationID, boolean retrieveAssociation);
    //find one location having the locationID

    public ArrayList<Location> getAllLocations(boolean retriveAssociation);
    //show all location

    public int insertLocation(Location loca);
    //insert an location into database

    public int updateLocation(Location loca);
    //update information about an location

    public int deleteLocation(int locationID);
     //delete an location
}