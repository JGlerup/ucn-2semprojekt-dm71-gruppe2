package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Employee;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBEmployee implements IFDBEmp
{

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBEmployee()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Employee findEmployee(String employeeNo, boolean retrieveAssociation)
    {
        Employee empObj = new Employee();
        empObj = singleWhere("employeeno = '" + employeeNo + "'", false);
        return empObj;
    }

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }

    public int insertEmployee(Employee emp)
    {  //call to get the next ssn number
        int employeeID = GetMax.getMaxId("Select max(employeeid) from employee");
        employeeID = employeeID + 1;
        System.out.println("next employeeid = " + employeeID);

        int rc = -1;
        String query = "INSERT INTO employee(employeeid, employeeno, managerno, jobtitle)  VALUES('"
                + employeeID + "','"
                + emp.getEmployeeNo() + "','"
                + emp.getManagerNo() + "','"
                + emp.getJobTitle() + "'";


        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in employee db: " + ex);
        }
        return (rc);
    }

    public int updateEmployee(Employee emp)
    {
        Employee empObj = emp;
        int rc = -1;

        String query = "UPDATE employee SET "
                + "jobtitle ='" + empObj.getJobTitle() + "', "
                + "managerno ='" + empObj.getManagerNo() + "' "
                + " WHERE employeeno = '" + empObj.getEmployeeNo() + "'";
        System.out.println("Update query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Update exception in employee db: " + ex);
        }
        return (rc);
    }

    public int deleteEmployee(int employeeNo)
    {
        int rc = -1;

        String query = "DELETE FROM employee "
                + " WHERE employeeno = '" + employeeNo + "'";
        System.out.println("Update query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Delete exception in employee db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Employee singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Employee empObj = new Employee();
        String query = buildQuery(wClause);
        System.out.println("DbEmployee -singelWhere " + query);
        try { // read from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                empObj = buildEmployee(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select employee : " + e);
            e.printStackTrace();
        }
        return empObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbEmployee " + query);
        try { // read from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Employee empObj = new Employee();
                empObj = buildEmployee(results);
                list.add(empObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//end try
        catch (Exception e) {
            System.out.println("Query exception - select employee : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private Employee buildEmployee(ResultSet results)
    {
        Employee empObj = new Employee();

        try
        {
            empObj.setEmployeeNo(results.getString(2));
            empObj.setPassword(results.getString(3));
            empObj.setManagerNo(results.getInt(4));
            empObj.setJobTitle(results.getString(5));
            empObj.setSsn(results.getString(6));
            empObj.setFirstName(results.getString(7));
            empObj.setMiddleName(results.getString(8));
            empObj.setLastName(results.getString(9));
            empObj.setAddress(results.getString(10));
            empObj.setLocationID(results.getInt(11));
            empObj.setPhoneNo(results.getInt(12));
            empObj.setEmail(results.getString(13));

        } 
        catch (Exception e)
        {
            System.out.println("building employee object");
        }

        return empObj;

    }
    //method to build the query

    private String buildQuery(String wClause)
    {
        String query = "SELECT * FROM employee";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
