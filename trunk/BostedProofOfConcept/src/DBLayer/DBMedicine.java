package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Medicine;

/**
 * DBEmployee.java
 * @author Kristian Byrialsen
 * @version 2. dec 2010
 */
public class DBMedicine implements IFDBMedi {
    private  Connection con;
    /** Creates a new instance of DBWorksOn */
    public DBMedicine() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ArrayList<Medicine> getAllMedicine(boolean retriveAssociation) {
                return miscWhere("", retriveAssociation);
    }

        public int insertMedicine(Medicine medi) {  //call to get the next ssn number

        int rc = -1;
        String query = "INSERT INTO employee(name, description, date, quantity)  VALUES('"
                + medi.getName() + "','"
                + medi.getDescription() + "','"
                + medi.getDate() + "','"
                + medi.getQuantity() + ",";

        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in medicin db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Medicine singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Medicine mediObj = new Medicine();
        String query =  buildQuery(wClause);
        System.out.println("DbEmployee -singelWhere " + query);
        try{ // read from medicine
	   Statement stmt = con.createStatement();
	   stmt.setQueryTimeout(5);
	   results = stmt.executeQuery(query);
	   int snr=0;
	   if( results.next() ){
	       mediObj = buildMedicine(results);
               //missing the test on retriveassociation

           }//end if
	   stmt.close();
	}//slut try
	catch(Exception e){
	   System.out.println("Query exception - select medicine : "+e);
	   e.printStackTrace();
        }
	return mediObj;


    }
    //miscWhere is used when more than one employee is selected and build
    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList list = new ArrayList();

		String query =  buildQuery(wClause);
                System.out.println("DbMedicine " + query);
  		try{ // read from medicine
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

			int snr=0;
			while( results.next() ){
		     	 Medicine mediObj = new Medicine();
			 mediObj = buildMedicine(results);
                         list.add(mediObj);
                         //missing tes on retriveAssociation
			}//end while
			stmt.close();
		}//slut try
	 	catch(Exception e){
	 		System.out.println("Query exception - select medicine : "+e);
			e.printStackTrace();
	 	}
		return list;
	}
    private Medicine buildMedicine(ResultSet results)
    {
       Medicine mediObj = new Medicine();

         try{
               mediObj.setName(results.getString(1));
               mediObj.setDescription(results.getString(2));
               mediObj.setDate(results.getDate(3));
               mediObj.setQuantity(results.getInt(4));
          }
         catch(Exception e)
         {
             System.out.println("building medicine object");
         }

        return mediObj;

    }
    //method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM medicine";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
}
