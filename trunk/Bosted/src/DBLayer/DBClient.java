package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Location;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBClient implements IFDBClient
{

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBClient()
    {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Client findClient(String clientNo, boolean retrieveAssociation)
    {
        Client cObj = new Client();
        cObj = singleWhere("clientno = '" + clientNo + "'", retrieveAssociation);
        return cObj;
    }

    /**
     *
     * @param clientID the clientID
     * @param retrieveAssociation
     * @return an instance of Client
     */
    public Client findClientByID(int clientID, boolean retrieveAssociation)
    {
        Client clientObj = new Client();
        clientObj = singleWhere("client_id = " + clientID, retrieveAssociation);
        return clientObj;
    }

    public ArrayList<Client> getAllClients(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertClient(Client c) {  //call to get the next ssn number
        int rc = -1;
        String query = "INSERT INTO client(clientno, description, interests, health, ssn, firstname, middlename, lastname, address, location_id, phoneno, email, start_date, in_use, stop_date)  VALUES('"
                + c.getClientNo() + "','"
                + c.getDescription() + "','"
                + c.getInterests() + "','"
                + c.getHealth() + "','"
                + c.getSsn() + "','"
                + c.getFirstName() + "','"
                + c.getMiddleName() + "','"
                + c.getLastName() + "','"
                + c.getAddress() + "','"
                + c.getLocation().getLocationID() + "','"
                + c.getPhoneNo() + "','"
                + c.getEmail() + "','"
                + c.getStartDate() + "','"
                + c.getInUse() + "',"
                + c.getStopDate() + ")";

        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in client db: " + ex);
        }
        return (rc);
    }

    public int updateClient(Client c) {
        Client cObj = c;
        int rc = -1;

        String query = "UPDATE client SET "
                + "clientno = '" + cObj.getClientNo() + "', "
                + "description ='" + cObj.getDescription() + "', "
                + "interests ='" + cObj.getInterests() + "', "
                + "health ='" + cObj.getHealth() + "', "
                + "ssn ='" + cObj.getSsn() + "', "
                + "firstname ='" + cObj.getFirstName() + "', "
                + "middlename ='" + cObj.getMiddleName() + "', "
                + "lastname ='" + cObj.getLastName() + "', "
                + "address ='" + cObj.getAddress() + "', "
                + "location_id =" + cObj.getLocation().getLocationID() + ", "
                + "phoneno =" + cObj.getPhoneNo() + ", "
                + "email ='" + cObj.getEmail() + "', "
                + "start_date ='" + cObj.getStartDate() + "', "
                + "in_use ='" + cObj.getInUse() + "', "
                + "stop_date ='" + cObj.getStopDate() + "'"
                + " WHERE client_id =" + cObj.getClientID();
        System.out.println("Update query:" + query);
        try { // update cloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in client db: " + ex);
        }
        return (rc);
    }

    public int deleteClient(String clientNo) {
        int rc = -1;

        String query = "DELETE FROM client "
                + " WHERE clientno = '" + clientNo + "'";
        System.out.println("Delete query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in client db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Client singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Client cObj = new Client();
        String query = buildQuery(wClause);
        System.out.println("DbClient -singelWhere " + query);
        try { // read from client
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                cObj = buildClient(results);
                if(retrieveAssociation)
                {
                    IFDBLoca dbLoca = new DBLocation();
                    cObj.setLocation(dbLoca.findLocation(cObj.getLocation().getLocationID(), false));
                    cObj.setEmployeeList(findClientsEmployees(cObj.getClientID()));
                }
            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return cObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbClient " + query);
        try { // read from client
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Client cObj = new Client();
                cObj = buildClient(results);
                list.add(cObj);
                if(retrieveAssociation)
                {
                    IFDBLoca dbLoca = new DBLocation();
                    cObj.setLocation(dbLoca.findLocation(cObj.getLocation().getLocationID(), false));
                    cObj.setEmployeeList(findClientsEmployees(cObj.getClientID()));
                }
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public Client buildClient(ResultSet results) {
        Client cObj = new Client();

        try {
            cObj.setClientID(results.getInt(1));
            cObj.setClientNo(results.getString(2));
            cObj.setDescription(results.getString(3));
            cObj.setInterests(results.getString(4));
            cObj.setHealth(results.getString(5));
            cObj.setSsn(results.getString(6));
            cObj.setFirstName(results.getString(7));
            cObj.setMiddleName(results.getString(8));
            cObj.setLastName(results.getString(9));
            cObj.setAddress(results.getString(10));
            Location loca = new Location();
            loca.setLocationID(results.getInt(11));
            cObj.setLocation(loca);
            cObj.setLocation(loca);
            cObj.setPhoneNo(results.getInt(12));
            cObj.setEmail(results.getString(13));
        } catch (Exception e) {
            System.out.println("building client object");
        }

        return cObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM client";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

    public ArrayList<Client> buildListOfClients(int employeeID) {
        ResultSet results;
        ArrayList<Client> list = new ArrayList<Client>();
        String query = "SELECT * FROM client WHERE client_id in(SELECT client_id FROM employee_client WHERE employee_id =  " + employeeID + ")";
        try { // read from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Client cObj = new Client();
                cObj = buildClient(results);
                list.add(cObj);
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

    public ArrayList<Employee> findClientsEmployees(int clientID)
    {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList =  dbEmp.buildListOfEmployees(clientID);
        return employeeList;
    }
}
