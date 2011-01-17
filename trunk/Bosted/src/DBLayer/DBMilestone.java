/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.Client;
import ModelLayer.Milestone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public class DBMilestone implements IFDBMilestone {

    private Connection con;

    public DBMilestone() {
        con = DbConnection1.getInstance().getDBcon();
    }



    public Milestone findMilestone(int clientID, boolean retrieveAssociation) {
        Milestone mObj = new Milestone();
        mObj = singleWhere("clientID = '" + clientID + "'", false);
        return mObj;
    }

    public ArrayList<Milestone> getAllMilestones(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public Milestone findLatestMilestoneMinusSteps(int clientID, int numberOfStepsToGoBack, boolean retrieveAssociation) {
        Milestone mObj = new Milestone();
        mObj = singleWhere ("milestone_id = (select milestone_id from (select ROW_NUMBER() over "
                + "(order by milestone_id) as Row, milestone_id, client_id, text, date, successdate "
                + "from milestone where client_id = " + clientID + ") id where Row = (select COUNT(*) from (select ROW_NUMBER() "
                + "over (order by milestone_id) as Row, milestone_id, client_id, text, date, "
                + "successdate from milestone where client_id = " + clientID + ") id) - " + numberOfStepsToGoBack + ")"
                , retrieveAssociation);
        return mObj;
    }

    public int insertMilestone(Milestone m) {  //call to get the next ssn number
        int rc = -1;
        String query = "INSERT INTO milestone(client_id, text, date, successdate)  VALUES('"
                + m.getClient().getClientID() + "','"
                + m.getText() + "')"
                + m.getDate() + "')"
                + m.getSuccesDate() + "')";


        System.out.println("insert : " + query);
        try { // insert new milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in milestone db: " + ex);
        }
        return (rc);
    }

    public int updateMilestone(Milestone m) {
        Milestone mObj = m;
        int rc = -1;

        String query = "UPDATE milestone SET "
                + "client = '" + mObj.getClient().getClientID() + "', "
                + "text ='" + mObj.getText() + "' "
                + "date ='" + mObj.getDate() + "' "
                + "succesdate ='" + mObj.getSuccesDate() + "' "
                + " WHERE milestone_id ='" + mObj.getMilestoneID() + "'";
        System.out.println("Update query:" + query);
        try { // update milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in milestone db: " + ex);
        }
        return (rc);
    }

    public int deleteMilestone(int clientID) {
        int rc = -1;

        String query = "DELETE FROM milestone "
                + " WHERE clientID = '" + clientID + "'";
        System.out.println("Delete query:" + query);
        try { // update milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in milestone db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Milestone singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Milestone mObj = new Milestone();
        String query = buildQuery(wClause);
        System.out.println("DBMilestone -singelWhere " + query);
        try { // read from milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                mObj = buildMilestone(results);
                //missing the test on retriveassociation
                if(retrieveAssociation)
                {
                    IFDBClient dbClient = new DBClient();
                    mObj.setClient(dbClient.findClientByID(mObj.getClient().getClientID(), false));
                }

            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select milestone : " + e);
            e.printStackTrace();
        }
        return mObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DbMilestone " + query);
        try { // read from milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Milestone mObj = new Milestone();
                mObj = buildMilestone(results);
                list.add(mObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select car : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public Milestone buildMilestone(ResultSet results) {
        Milestone mObj = new Milestone();

        try {
            mObj.setMilestoneID(results.getInt(1));
            Client client = new Client();
            client.setClientID(results.getInt(2));
            mObj.setClient(client);
            mObj.setText(results.getString(3));
            mObj.setDate(results.getString(4));
            mObj.setSuccesDate(results.getDate(5));
        } catch (Exception e) {
            System.out.println("building milestone object");
        }

        return mObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM milestone";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
    
     public ArrayList<Milestone> buildListOfMilestones(int clientID) {
        ResultSet results;
        ArrayList<Milestone> list = new ArrayList<Milestone>();
        String query = "SELECT * FROM milestone WHERE client_id =  '" + clientID + "'";
        try { // read from milestone
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Milestone mileObj = new Milestone();
                mileObj = buildMilestone(results);
                list.add(mileObj);
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