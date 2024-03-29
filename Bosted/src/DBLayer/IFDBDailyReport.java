package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBDailyReport {

    public DailyReport findDailyReportByClientID(int clientID, boolean retrieveAssociation);
    //find one daily report having the clientID

    public DailyReport findDailyReportByEmployeeID(int employeeID, boolean retrieveAssociation);
    //find one daily report having the employeeID

    public DailyReport findDailyReportByDailyReportID(int dailyReportID, boolean retrieveAssociation);
    //find one daily report having the dailyReportID

    public ArrayList<DailyReport> getAllDailyReports(boolean retriveAssociation);
    //show all daily reports

    public int insertDailyReport(DailyReport dr);
    //insert an daily report into database

    public int updateDailyReport(DailyReport dr);
    //update information about a daily report

    public int deleteDailyReport(int dailyReportID);
    //delete an daily report

    public ArrayList<DailyReport> buildListOfDailyreports(int clientID);
    //show all daily reports for a specific client

    public DailyReport findLatestDayliReport(int clientID, boolean retrieveAssociation);
    //find the latest daily report for a specific client
}
