package DBLayer;
import java.net.URL;
import java.sql.*;
import java.util.*;
/**
 * @Author Kis Boisen Hansen
 * @Version 2006.10.02 - revised marts 2009 FEN
 * @version 2010.10.07 - new connection 
 * This class is used to create the connection to the database
 * It is implementet as a singelton. The constructor is private to encure that only
 * one object of the class is generated
 * String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
   "databaseName=AdventureWorks;user=MyUserName;password=*****;";
Connection con = DriverManager.getConnection(connectionUrl);

 * Version for Sql Server or MySql lines in comments
 */

public class DbConnection1
{   //constans used to get access to the database
	//SQL Server
   private static final String  driver = "jdbc:sqlserver://balder.ucn.dk";
    private static final String  databaseName = ";databaseName=dm71_2";
//jdbc:sqlserver://localhost\SQLEXPRESS/Databases/EPS:1357;user=epsingall;password=welkom1;
    //SQL Server
    private static String  userName = ";user=DM71_2";
    private static String password = ";password=MaaGodt";
  
    private DatabaseMetaData dma;
    private static Connection con;
    // an instance of the class is generetated
    private static DbConnection1  instance = null;

    // the constructor is private to ensure that only one object of this class is createt
    private DbConnection1()
    {
    	String url = driver + databaseName + userName + password;

        try{
            //load af driver
            //SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Load af class ok");
          
        }
        catch(Exception e){
            System.out.println("Can not find the driver");
            System.out.println(e.getMessage());
        }//end catch
        try{
            //connection to the database
           
            con = DriverManager.getConnection(url);
            //set autocommit
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch(Exception e){

            System.out.println("Problems with the connection to the database");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor
	   
  //closeDb: closes the connection to the database
    public static void closeConnection()
    {
       	try{
            con.close();
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }//end closeDB
		
    //getDBcon: Get-metode, returnerer forbindelsen til databasen
    public  Connection getDBcon()
    {
       return con;
    }
    //this method is used to get the instance of the connection
    public static DbConnection1 getInstance()
    {
        if (instance == null)
        {
          instance = new DbConnection1();
        }
        return instance;
    }

}//end DbConnection
