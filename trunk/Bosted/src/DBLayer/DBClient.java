package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Client;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBClient implements IFDBClient {

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBClient() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Client findClient(int clientNo, boolean retrieveAssociation) {
        Client cObj = new Client();
        cObj = singleWhere("clientno = '" + clientNo + "'", false);
        return cObj;
    }

    public ArrayList<Client> getAllClient(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertClient(Client c) {  //call to get the next ssn number
        int clientID = GetMax.getMaxId("Select max(clientID) from employee");
        clientID = clientID + 1;
        System.out.println("next clientID = " + clientID);

        int rc = -1;
        String query = "INSERT INTO client(clientid, clientno, description, interests, health)  VALUES('"
                + clientID + "','"
                + c.getClientNo() + "','"
                + c.getDescription() + "','"
                + c.getInterests() + "','"
                + c.getHealth() + "'";


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
                + "description ='" + cObj.getDescription() + "', "
                + "interests ='" + cObj.getInterests() + "' "
                + "health ='" + cObj.getHealth() + "' "
                + " WHERE clientno = '" + cObj.getClientNo() + "'";
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

    public int deleteClient(int clientNo) {
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
                //missing the test on retriveassociation

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
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select client : " + e);
            e.printStackTrace();
        }
        return list;
    }

    private Client buildClient(ResultSet results) {
        Client cObj = new Client();

        try {
            cObj.setClientNo(results.getInt(1));
            cObj.setDescription(results.getString(2));
            cObj.setInterests(results.getString(3));
            cObj.setHealth(results.getString(4));

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
}
