/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import DBLayer.DBClient;
import DBLayer.DBDailyReport;
import DBLayer.DBEmployee;
import DBLayer.IFDBClient;
import DBLayer.IFDBDailyReport;
import DBLayer.IFDBEmp;
import ModelLayer.Client;
import ModelLayer.DayliReport;
import ModelLayer.Employee;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class CrtDailyReport {


    public DayliReport findDailyReportByDayliReportID(int dayliReportID)
    {
        IFDBDailyReport dbDailyReport = new DBDailyReport();
        return dbDailyReport.findDailyReportByDailyReportID(dayliReportID, true);
    }

    public DayliReport findDailyReportByClientID(int clientID)
    {
        IFDBDailyReport dbDailyReport = new DBDailyReport();
        return dbDailyReport.findDailyReportByClientID(clientID, true);
    }

    public ArrayList getAllDailyReports()
    {
        IFDBDailyReport dbDai = new DBDailyReport();
        ArrayList allDai = new ArrayList<DayliReport>();
        allDai = dbDai.getAllDailyReports(true);
        return allDai;
    }

    public void insertDailyreport(int clientID, int employeeID, String text)
    {
        IFDBDailyReport dbDailyreport = new DBDailyReport();
        DayliReport dObj = new DayliReport();
        dObj.setClientID(clientID);
        dObj.setEmployeeID(employeeID);
        dObj.setText(text);
        dObj.setThisDate();
        dbDailyreport.insertDailyReport(dObj);
    }

    public void updateDailyreport(int clientID, int employeeID, String text, String date)
    {
       IFDBDailyReport dbDailyReport = new DBDailyReport();
        DayliReport dObj = new DayliReport();
        int dailyReportID = dbDailyReport.findDailyReportByClientID(clientID, false).getClientID();
        dObj.setClientID(clientID);
        dObj.setEmployeeID(employeeID);
        dObj.setText(text);
        dObj.setDate(date);
        dbDailyReport.updateDailyReport(dObj);
    }

    public void deleteDailyreport(int clientID)
    {
        IFDBDailyReport dbDailyReport = new DBDailyReport();
        dbDailyReport.deleteDailyReport(clientID);
    }

    public ArrayList<Employee> findClientsEmployees(int clientID)
    {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        IFDBClient dbClient = new DBClient();
        employeeList = dbClient.findClientsEmployees(clientID);
        return employeeList;
    }

        public ArrayList<Client> findEmployeesClient(int employeeID)
    {
        ArrayList<Client> clientList = new ArrayList<Client>();
        IFDBEmp dbEmp = new DBEmployee();
        clientList = dbEmp.findEmployeesClients(employeeID);
        return clientList;
    }
}
