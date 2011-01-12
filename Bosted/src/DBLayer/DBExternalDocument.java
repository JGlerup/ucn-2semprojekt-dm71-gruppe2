/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;

import ModelLayer.Client;
import ModelLayer.ExternalDocument;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */
public class DBExternalDocument implements IFDBExtDoc {

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBExternalDocument() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ExternalDocument findExternalDocument(int externalContactID, boolean retrieveAssociation) {
        ExternalDocument cObj = new ExternalDocument();
        cObj = singleWhere("externalcontact_id = '" + externalContactID + "'", retrieveAssociation);
        return cObj;
    }

    public ArrayList<ExternalDocument> getAllExternalDocuments(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertExternalDocument(ExternalDocument extDoc) {  //call to get the next ssn number
        int rc = -1;
        String query = "INSERT INTO externaldocument(client_id, text, date, source, author)  VALUES('"
                + extDoc.getClient().getClientID() + "','"
                + extDoc.getText() + "','"
                + extDoc.getDate() + "','"
                + extDoc.getSource() + "','"
                + extDoc.getAuthor() + ")";

        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in external document db: " + ex);
        }
        return (rc);
    }

    public int updateExternalDocument(ExternalDocument extDoc) {
        ExternalDocument extDocObj = extDoc;
        int rc = -1;

        String query = "UPDATE externalcontact SET "
                + "client_id = '" + extDocObj.getClient().getClientID() + "', "
                + "text ='" + extDocObj.getText() + "', "
                + "date ='" + extDocObj.getDate() + "', "
                + "source ='" + extDocObj.getSource() + "', "
                + "author ='" + extDocObj.getAuthor() + "'"
                + " WHERE externaldocument_id ='" + extDocObj.getExternalDocumentID() + "'";
        System.out.println("Update query:" + query);
        try { // update cloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in external document db: " + ex);
        }
        return (rc);
    }

    public int deleteExternalDocument(int externalDocumentID) {
        int rc = -1;

        String query = "DELETE FROM externaldocument "
                + " WHERE externaldocument_id = '" + externalDocumentID + "'";
        System.out.println("Delete query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in external document db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private ExternalDocument singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ExternalDocument extDocObj = new ExternalDocument();
        String query = buildQuery(wClause);
        System.out.println("DBExternalDocument -singelWhere " + query);
        try { // read from externalcontact
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                extDocObj = buildExternalDocument(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select external document : " + e);
            e.printStackTrace();
        }
        return extDocObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DBExternalDocument " + query);
        try { // read from client
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                ExternalDocument extConObj = new ExternalDocument();
                extConObj = buildExternalDocument(results);
                list.add(extConObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select external contact : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public ExternalDocument buildExternalDocument(ResultSet results) {
        ExternalDocument extDocObj = new ExternalDocument();

        try {
            extDocObj.setExternalDocumentID(results.getInt(1));
            extDocObj.setClient(new Client());
            extDocObj.getClient().setClientID(results.getInt(2));
            extDocObj.setText(results.getString(3));
            extDocObj.setDate(results.getString(4));
            extDocObj.setAuthor(results.getString(5));
        } catch (Exception e) {
            System.out.println("building external document object");
        }

        return extDocObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM externaldocument";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }
}
