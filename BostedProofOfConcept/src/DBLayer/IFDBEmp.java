/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import ModelLayer.*;

/**
 *
 * @author Erik
 */
public interface IFDBEmp {

    public Employee searchEmployeeInitial(String empssn, boolean retriveAssociation);
    //find one employee having the fname
    public int insertEmployee(Employee emp);
    //update information about an employee
}
