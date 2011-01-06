package DBLayer;

import java.sql.*;
import ModelLayer.Employee;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBEmployeeClient implements IFDBEmployeeClient {

    private Connection con;

    /** Creates a new instance of DBEmployee*/
    public DBEmployeeClient() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public int associateClientToEmployee(int employeeID, int clientID) {
        int rc = -1;
        String query = "INSERT INTO employee_client(employee_id, client_id)  VALUES('"
                + employeeID + "','"
                + clientID + "')";


        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in employee_client db: " + ex);
        }
        return (rc);
    }

    public int disassociateClientFromEmployee(int employeeID, int clientID) {
                int rc = -1;

        String query = "DELETE FROM employee_client "
                + " WHERE employee_id = '" + employeeID + "'" + " and " + "client_id = '" + clientID + "'";
        System.out.println("Update query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Delete exception in employee_client db: " + ex);
        }
        return (rc);
    }
}
