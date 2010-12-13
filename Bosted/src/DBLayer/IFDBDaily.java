package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBDaily {

    public Employee findDailyreport(String clientID, boolean retrieveAssociation);
    //find one clientID having the clientID

    public ArrayList<Dailyreport> getAllDailyreports(boolean retriveAssociation);
    //show all dailyreports

    public int insertDailyreport(Employee emp);
    //insert an employee into database

    public int updateEmployee(Dailyreport daily);
    //update information about an employee

    public int deleteDailyreport(int clientID);
    //delete an employee

    public ArrayList<Dailyreport> buildListOfDailyreports(int clientID);

}
