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

    public Employee findEmployee(int employeeNo, boolean retrieveAssociation);
    //find one employee having the employeeNo

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation);
    //show all employees

    public int insertEmployee(Employee emp);
    //insert an employee into database

    public int updateEmployee(Employee emp);
    //update information about an employee

    public int deleteEmployee(int employeeNo);
    //delete an employee
}
