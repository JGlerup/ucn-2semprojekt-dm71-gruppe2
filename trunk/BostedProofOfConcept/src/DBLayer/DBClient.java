package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Client;


/**
 * DBEmployee.java
 * @author Kristian Byrialsen
 * @version 20. oktober 2006
 */
public class DBClient implements IFDBClient {
    private  Connection con;
    /** Creates a new instance of DBWorksOn */
    public DBClient() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ArrayList<Client> getAllClient(boolean retriveAssociation) {
                return miscWhere("", retriveAssociation);
    }

        public int insertClient(Client c) {  //call to get the next ssn number

        int rc = -1;
        String query = "INSERT INTO client(clientNo, description, interests, health)  VALUES('"
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

    //singlewhere is used when only one employee object is to be build
    private Client singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Client cObj = new Client();
        String query =  buildQuery(wClause);
        System.out.println("DbClient -singelWhere " + query);
        try{ // read from client
	   Statement stmt = con.createStatement();
	   stmt.setQueryTimeout(5);
	   results = stmt.executeQuery(query);
	   int snr=0;
	   if( results.next() ){
	       cObj = buildClient(results);
               //missing the test on retriveassociation

           }//end if
	   stmt.close();
	}//slut try
	catch(Exception e){
	   System.out.println("Query exception - select client : "+e);
	   e.printStackTrace();
        }
	return cObj;


    }
    //miscWhere is used when more than one employee is selected and build
    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList list = new ArrayList();

		String query =  buildQuery(wClause);
                System.out.println("DbClient " + query);
  		try{ // read from client
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

			int snr=0;
			while( results.next() ){
		     	 Client cObj = new Client();
			 cObj = buildClient(results);
                         list.add(cObj);
                         //missing tes on retriveAssociation
			}//end while
			stmt.close();
		}//slut try
	 	catch(Exception e){
	 		System.out.println("Query exception - select client : "+e);
			e.printStackTrace();
	 	}
		return list;
	}
    private Client buildClient(ResultSet results)
    {
       Client cObj = new Client();

         try{
               cObj.setClientNo(results.getInt(1));
               cObj.setDescription(results.getString(2));
               cObj.setInterests(results.getString(3));
               cObj.setHealth(results.getString(4));

          }
         catch(Exception e)
         {
             System.out.println("building client object");
         }

        return cObj;

    }
    //method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM client";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
}