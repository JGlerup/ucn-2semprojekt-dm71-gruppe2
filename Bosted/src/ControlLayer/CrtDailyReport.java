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
import ModelLayer.DailyReport;
import ModelLayer.Employee;
import java.util.ArrayList;


/**
 *
 * @author Kristian Byrialsen
 */
public class CrtDailyReport {


    public DailyReport findDailyReportByDayliReportID(int dayliReportID)
    {
        IFDBDailyReport dbDailyReport = new DBDailyReport();
        return dbDailyReport.findDailyReportByDailyReportID(dayliReportID, true);
    }

    public DailyReport findDailyReportByClientID(int clientID)
    {
        IFDBDailyReport dbDailyReport = new DBDailyReport();
        return dbDailyReport.findDailyReportByClientID(clientID, true);
    }

    public DailyReport findLatestDayliReport(int clientID) {
        IFDBDailyReport dbDayliReport = new DBDailyReport();
        DailyReport drObj = new DailyReport();
        drObj = dbDayliReport.findLatestDayliReport(clientID, true);
        return drObj;
    }

    public ArrayList getAllDailyReports()
    {
        IFDBDailyReport dbDai = new DBDailyReport();
        ArrayList allDai = new ArrayList<DailyReport>();
        allDai = dbDai.getAllDailyReports(true);
        return allDai;
    }

    public void insertDailyreport(Client client, Employee employee, String text)
    {
        IFDBDailyReport dbDailyreport = new DBDailyReport();
        DailyReport dObj = new DailyReport();
        dObj.setClient(client);
        dObj.setEmployee(employee);
        dObj.setText(text);
        dObj.setThisDate();
        dbDailyreport.insertDailyReport(dObj);
    }

    public void updateDailyreport(int dailyReportID, Client client, Employee employee, String text)
    {
       IFDBDailyReport dbDailyReport = new DBDailyReport();
        DailyReport dObj = new DailyReport();
        dObj.setDailyReportID(dailyReportID);
        dObj.setClient(client);
        dObj.setEmployee(employee);
        dObj.setText(text);
        dObj.setThisDate();
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

    public ArrayList<DailyReport> buildListOfDailyreports(int clientID)
    {
        IFDBDailyReport dbDai = new DBDailyReport();
        ArrayList allDai = new ArrayList<DailyReport>();
        allDai = dbDai.buildListOfDailyreports(clientID);
        return allDai;
    }
}
