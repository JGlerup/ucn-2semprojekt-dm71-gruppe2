package DBLayer;

import ModelLayer.Client;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Employee;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBEmployee implements IFDBEmp {

    private Connection con;

    /** Creates a new instance of DBEmployee*/
    public DBEmployee() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Employee findEmployee(String employeeNo, boolean retrieveAssociation) {
        Employee empObj = new Employee();
        empObj = singleWhere("employeeno = '" + employeeNo + "'", retrieveAssociation);
        return empObj;
    }

    /**
     *
     * @param employeeID the employeeID
     * @param retrieveAssociation
     * @return an instance of Employee
     */
    public Employee findEmployeeByID(int employeeID, boolean retrieveAssociation) {
        Employee empObj = new Employee();
        empObj = singleWhere("employee_id = " + employeeID, false);
        return empObj;
    }

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertEmployee(Employee emp) {
        int rc = -1;
        String query = "INSERT INTO employee(employeeno, password, managerno, jobtitle, crud_client, crud_employee, crud_medicine, crud_car,  ssn, firstname, middlename, lastname, address, location_id, phoneno, email, start_date, in_use, stop_date)  VALUES('"
                + emp.getEmployeeNo() + "','"
                + emp.getPassword() + "','"
                + emp.getManagerNo() + "','"
                + emp.getJobTitle() + "','"
                + emp.getCrudClient() + "','"
                + emp.getCrudEmployee() + "','"
                + emp.getCrudMedicine() + "','"
                + emp.getCrudCar() + "','"
                + emp.getSsn() + "','"
                + emp.getFirstName() + "','"
                + emp.getMiddleName() + "','"
                + emp.getLastName() + "','"
                + emp.getAddress() + "','"
                + emp.getLocationID() + "','"
                + emp.getPhoneNo() + "','"
                + emp.getEmail() + "','"
                + emp.getStartDate() + "','"
                + emp.getInUse() + "','"
                + emp.getStopDate() + "')";


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

    public int updateEmployee(Employee emp) {
        Employee empObj = emp;
        int rc = -1;

        String query = "UPDATE employee SET "
                + "employeeno ='" + empObj.getEmployeeNo() + "',"
                + "password ='" + empObj.getPassword() + "',"
                + "managerno ='" + empObj.getManagerNo() + "',"
                + "jobtitle ='" + empObj.getJobTitle() + "',"
                + "crud_client ='" + empObj.getCrudClient() + "',"
                + "crud_employee ='" + empObj.getCrudEmployee() + "',"
                + "crud_medicine = '" + empObj.getCrudMedicine() + "',"
                + "crud_car = '" + empObj.getCrudCar() + "',"
                + "ssn ='" + empObj.getSsn() + "',"
                + "firstname ='" + empObj.getFirstName() + "',"
                + "middlename ='" + empObj.getMiddleName() + "',"
                + "lastname ='" + empObj.getLastName() + "',"
                + "address ='" + empObj.getAddress() + "',"
                + "location_id ='" + empObj.getLocationID() + "',"
                + "phoneno ='" + empObj.getPhoneNo() + "',"
                + "email ='" + empObj.getEmail() + "' "
                + " WHERE employee_id = '" + empObj.getEmployeeID() + "'";
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

    public int deleteEmployee(String employeeNo) {
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
    private Employee singleWhere(String wClause, boolean retrieveAssociation) {
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
                if (retrieveAssociation == true) {
                    int employeeID = empObj.getEmployeeID();
                    ArrayList<Client> clientList = findEmployeesClients(employeeID);
                    empObj.setClientList(clientList);
                }
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

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
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

    private Employee buildEmployee(ResultSet results) {
        Employee empObj = new Employee();

        try {
            empObj.setEmployeeID(results.getInt(1));
            empObj.setEmployeeNo(results.getString(2));
            empObj.setPassword(results.getString(3));
            empObj.setManagerNo(results.getString(4));
            empObj.setJobTitle(results.getString(5));
            empObj.setCrudClient(results.getString(6));
            empObj.setCrudEmployee(results.getString(7));
            empObj.setCrudMedicine(results.getString(8));
            empObj.setCrudCar(results.getString(9));
            empObj.setSsn(results.getString(10));
            empObj.setFirstName(results.getString(11));
            empObj.setMiddleName(results.getString(12));
            empObj.setLastName(results.getString(13));
            empObj.setAddress(results.getString(14));
            empObj.setLocationID(results.getInt(15));
            empObj.setPhoneNo(results.getInt(16));
            empObj.setEmail(results.getString(17));
            empObj.setNewStartDate(results.getString(18));
            empObj.setInUse(results.getString(19));
            empObj.setStopDate(results.getString(20));

        } catch (Exception e) {
            System.out.println("building employee object");
        }

        return empObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM employee";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

    public ArrayList<Employee> buildListOfEmployees(int clientID) {
        ResultSet results;
        ArrayList<Employee> list = new ArrayList<Employee>();
        String query = "SELCT * FROM employee WHERE employee_id in(SELECT employee_id FROM employee_client WHERE client_id =  " + clientID + ")";
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
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Client> findEmployeesClients(int employeeID) {
        IFDBClient dbCli = new DBClient();
        ArrayList<Client> clientList = new ArrayList<Client>();
        clientList = dbCli.buildListOfClients(employeeID);

        return clientList;
    }
}
