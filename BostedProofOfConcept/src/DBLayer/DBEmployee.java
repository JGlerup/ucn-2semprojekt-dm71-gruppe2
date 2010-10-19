
package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Employee;

/**
 * DBEmployee.java
 * @author kbh
 * @version 20. oktober 2006
 */
public class DBEmployee implements IFDBEmp {
    private  Connection con;
    /** Creates a new instance of DBWorksOn */
    public DBEmployee() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation) {
                return miscWhere("", retriveAssociation);
    }

        public int insertEmployee(Employee emp) {  //call to get the next ssn number

        int rc = -1;
        String query = "INSERT INTO employee(fornavn, efternavn, initialer, adresse, tlfnr, email)  VALUES('"
                + emp.getFname() + "','"
                + emp.getLname() + "','"
                + emp.getInitial() + "','"
                + emp.getAdresse() + "',"
                + emp.getTlfnr() + ",'"
                + emp.getEmail() + "')";


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

    //singlewhere is used when only one employee object is to be build
    private Employee singleWhere(String wClause, boolean retrieveAssociation)
    {
        ResultSet results;
        Employee empObj = new Employee();
        String query =  buildQuery(wClause);
        System.out.println("DbEmployee -singelWhere " + query);
        try{ // read from employee
	   Statement stmt = con.createStatement();
	   stmt.setQueryTimeout(5);
	   results = stmt.executeQuery(query);
	   int snr=0;
	   if( results.next() ){
	       empObj = buildEmployee(results);
               //missing the test on retriveassociation

           }//end if
	   stmt.close();
	}//slut try
	catch(Exception e){
	   System.out.println("Query exception - select employee : "+e);
	   e.printStackTrace();
        }
	return empObj;


    }
    //miscWhere is used when more than one employee is selected and build
    private ArrayList miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList list = new ArrayList();

		String query =  buildQuery(wClause);
                System.out.println("DbEmployee " + query);
  		try{ // read from employee
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

			int snr=0;
			while( results.next() ){
		     	 Employee empObj = new Employee();
			 empObj = buildEmployee(results);
                         list.add(empObj);
                         //missing tes on retriveAssociation
			}//end while
			stmt.close();
		}//slut try
	 	catch(Exception e){
	 		System.out.println("Query exception - select employee : "+e);
			e.printStackTrace();
	 	}
		return list;
	}
    private Employee buildEmployee(ResultSet results)
    {
       Employee empObj = new Employee();

         try{
               empObj.setFname(results.getString(1));
               empObj.setLname(results.getString(2));
               empObj.setInitial(results.getString(3));
               empObj.setAdresse(results.getString(4));
               empObj.setTlfnr(results.getInt(5));
               empObj.setEmail(results.getString(6));
          }
         catch(Exception e)
         {
             System.out.println("building employee object");
         }

        return empObj;

    }
    //method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM employee";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
}