package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Todo;
import ModelLayer.Employee;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class DBTodo implements IFDBTodo {

    private Connection con;

    /** Creates a new instance of DBWorksOn */
    public DBTodo() {
        con = DbConnection1.getInstance().getDBcon();
    }

    public Todo findTodo(int todoID, boolean retrieveAssociation) {
        Todo t = new Todo();
        t = singleWhere("todo_id = '" + todoID + "'", false);
        return t;
    }

    public ArrayList<Todo> getAllTodo(boolean retriveAssociation) {
        return miscWhere("", retriveAssociation);
    }

    public int insertTodo(Todo t) {  //call to get the next ssn number
        int rc = -1;
        String query = "INSERT INTO todo(employee_id, text, date)  VALUES('"
                + t.getEmployeeID() + "','"
                + t.getText() + "','"
                + t.getDate() + "')";

        System.out.println("insert : " + query);
        try { // insert new deptloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (Exception ex) {
            System.out.println("Insert exception in todo db: " + ex);
        }
        return (rc);
    }

    public int updateTodo(Todo t) {
        Todo tObj = t;
        int rc = -1;

        String query = "UPDATE todo SET "
                + "employee_id = '" + tObj.getEmployeeID() + "', "
                + "text = '" + tObj.getText() + "'"
                + " WHERE todo_id ='" + tObj.getTodoID() + "'";
        System.out.println("Update query:" + query);
        try { // update cloyee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in todo db: " + ex);
        }
        return (rc);
    }

    public int deleteTodo(int todoID) {
        int rc = -1;

        String query = "DELETE FROM todo "
                + " WHERE todo_id = '" + todoID + "'";
        System.out.println("Delete query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in todo db: " + ex);
        }
        return (rc);
    }

    //singlewhere is used when only one employee object is to be build
    private Todo singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Todo tObj = new Todo();
        String query = buildQuery(wClause);
        System.out.println("DBTodo -singelWhere " + query);
        try { // read from client
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            int snr = 0;
            if (results.next()) {
                tObj = buildTodo(results);
                //missing the test on retriveassociation

            }//end if
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select todo : " + e);
            e.printStackTrace();
        }
        return tObj;


    }
    //miscWhere is used when more than one employee is selected and build

    private ArrayList miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList list = new ArrayList();

        String query = buildQuery(wClause);
        System.out.println("DBTodo " + query);
        try { // read from todo
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);

            int snr = 0;
            while (results.next()) {
                Todo tObj = new Todo();
                tObj = buildTodo(results);
                list.add(tObj);
                //missing tes on retriveAssociation
            }//end while
            stmt.close();
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select todo : " + e);
            e.printStackTrace();
        }
        return list;
    }

    public Todo buildTodo(ResultSet results) {
        Todo tObj = new Todo();

        try {
            tObj.setTodoID(results.getInt(1));
            tObj.setEmployeeID(results.getInt(2));
            tObj.setText(results.getString(3));
            tObj.setDate(results.getString(4));
        } catch (Exception e) {
            System.out.println("building client object");
        }

        return tObj;

    }
    //method to build the query

    private String buildQuery(String wClause) {
        String query = "SELECT * FROM todo";

        if (wClause.length() > 0) {
            query = query + " WHERE " + wClause;
        }

        return query;
    }

    public Todo findLatestTodo() {
        String query = "date = (SELECT MAX(date) FROM todo)";
        Todo tObj = singleWhere(query, false);
        return tObj;
    }
}
