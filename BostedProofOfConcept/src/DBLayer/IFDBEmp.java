/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */
public interface IFDBEmp {

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation);
    //find one employee having the fname
    public int insertEmployee(Employee emp);
    //update information about an employee
}
