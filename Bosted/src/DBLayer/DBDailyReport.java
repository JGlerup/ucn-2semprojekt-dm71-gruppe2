/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.Client;
import ModelLayer.DailyReport;
import ModelLayer.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public class DBDailyReport implements IFDBDailyReport
{

    private Connection con;

    /** Creates a new instance of DBEmployee*/
    public DBDailyReport() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public DailyReport findDailyReportByDailyReportID(int dailyReportID, boolean retrieveAssociation) {
        DailyReport drObj = new DailyReport();
        drObj = singleWhere("dailyreport_id = '" + dailyReportID + "'", retrieveAssociation);
        return drObj;
    }

    public DailyReport findDailyReportByClientID(int clientID, boolean retrieveAssociation) {
        DailyReport drObj = new DailyReport();
        drObj = singleWhere("client_id = '" + clientID + "'", retrieveAssociation);
        return drObj;
    }

    public DailyReport findDailyReportByEmployeeID(int employeeID, boolean retrieveAssociation) {
        DailyReport drObj = new DailyReport();
        drObj = singleWhere("employee_id = '" + employeeID + "'", retrieveAssociation);
        return drObj;
    }

    public DailyReport findLatestDayliReport(int clientID, boolean retrieveAssociation) {
        DailyReport drObj = new DailyReport();
        drObj = singleWhere ("date = (SELECT MAX(date) FROM dailyreport) and client_id = '" + clientID + "'", retrieveAssociation);
        return drObj;
    }

    public ArrayList<DailyReport> getAllDailyReports(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertDailyReport(DailyReport daily) {
        int rc = -1;
        String query = "INSERT INTO dailyreport(client_id, employee_id, text, date)  VALUES( "
                + daily.getClient().getClientID() + ", "
                + daily.getEmployee().getEmployeeID() + ",'"
                + daily.getText() + "','"
                + daily.getDate() + "')";

        System.out.println("insert : " + query);
        try { // insert new dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    public int updateDailyReport(DailyReport daily) {
        DailyReport dailyObj = daily;
        int rc = -1;

        String query = "UPDATE dailyreport SET "
                + "client_ID = " + dailyObj.getClient().getClientID() + ","
                + "employee_ID = " + dailyObj.getEmployee().getEmployeeID() + ","
                + "text ='" + dailyObj.getText() + "',"
                + "date ='" + dailyObj.getDate() + "'"
                + " WHERE dailyreport_id = '" + dailyObj.getDailyReportID() + "'";
        System.out.println("Update query:" + query);
        try { // update dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Update exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    public int deleteDailyReport(int clientID) {
        int rc = -1;

        String query = "DELETE FROM dailyreport "
                + " WHERE client_ID = '" + clientID + "'";
        System.out.println("Update query:" + query);
        try { // update dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Delete exception in dailyreport db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private DailyReport singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        DailyReport dailyObj = new DailyReport();
        String query = buildQuery(wClause);
        System.out.println("DbDailyreport -singelWhere " + query);
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                dailyObj = buildDailyreport(results);
                if(retrieveAssociation)
                {
                    IFDBEmp dbEmp = new DBEmployee();
                    dailyObj.setEmployee(dbEmp.findEmployeeByID(dailyObj.getEmployee().getEmployeeID(), false));
                    IFDBClient dbCli = new DBClient();
                    dailyObj.setClient(dbCli.findClientByID(dailyObj.getClient().getClientID(), retrieveAssociation));
                }
            }//end if
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select dailyreport : " + e);
            e.printStackTrace();
        }
        return dailyObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbDailyreport " + query);
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                DailyReport dailyObj = new DailyReport();
                dailyObj = buildDailyreport(results);
                list.add(dailyObj);
                if(retrieveAssociation)
                {
                    IFDBEmp dbEmp = new DBEmployee();
                    dailyObj.setEmployee(dbEmp.findEmployeeByID(dailyObj.getEmployee().getEmployeeID(), false));
                    IFDBClient dbCli = new DBClient();
                    dailyObj.setClient(dbCli.findClientByID(dailyObj.getClient().getClientID(), retrieveAssociation));
                }
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select dailyreport : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private DailyReport buildDailyreport(ResultSet results) {
        DailyReport dailyObj = new DailyReport();

        try {
            dailyObj.setDailyReportID(results.getInt(1));
            Client cli = new Client();
            cli.setClientID(results.getInt(2));
            dailyObj.setClient(cli);
            Employee emp = new Employee();
            emp.setEmployeeID(results.getInt(3));
            dailyObj.setEmployee(emp);
            dailyObj.setText(results.getString(4));
            dailyObj.setDate(results.getString(5));
            
        } catch (Exception e) {
            System.out.println("building dailyreport object");
        }

        return dailyObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM dailyreport";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

    public ArrayList<DailyReport> buildListOfDailyreports(int clientID) {
        ResultSet results;
        ArrayList<DailyReport> list = new ArrayList<DailyReport>();
        String query = "SELECT * FROM dailyreport WHERE client_id =  '" + clientID + "'";
        try { // read from dailyreport
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                DailyReport dailyObj = new DailyReport();
                dailyObj = buildDailyreport(results);
                list.add(dailyObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return list;
    }

}

    

