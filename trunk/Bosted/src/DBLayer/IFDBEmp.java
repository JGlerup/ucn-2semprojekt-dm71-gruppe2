package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBEmp {

    public Employee findEmployee(String employeeNo, boolean retrieveAssociation);
    //find one employee having the employeeNo

    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation);
    //show all employees

    public int insertEmployee(Employee emp);
    //insert an employee into database

    public int updateEmployee(Employee emp);
    //update information about an employee

    public int deleteEmployee(String employeeNo);
    //delete an employee
    public ArrayList<Client> findEmployeesClients(int employeeID);
}
