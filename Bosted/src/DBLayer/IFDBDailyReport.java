package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBDailyReport {

    public DayliReport findDailyReportByClientID(int clientID, boolean retrieveAssociation);
    //find one daily report having the clientID

    public DayliReport findDailyReportByEmployeeID(int employeeID, boolean retrieveAssociation);

    public DayliReport findDailyReportByDailyReportID(int dailyReportID, boolean retrieveAssociation);

    public ArrayList<DayliReport> getAllDailyReports(boolean retriveAssociation);
    //show all daily reports

    public int insertDailyReport(DayliReport dr);
    //insert an daily report into database

    public int updateDailyReport(DayliReport dr);
    //update information about a daily report

    public int deleteDailyReport(int dailyReportID);
    //delete an daily report

    public ArrayList<DayliReport> buildListOfDailyreports(int clientID);
}
