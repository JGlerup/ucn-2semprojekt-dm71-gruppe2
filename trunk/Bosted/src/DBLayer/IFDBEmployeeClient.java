/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

/**
 *
 * @author Erik
 */
public interface IFDBEmployeeClient {
    public int associateClientToEmployee(int employeeID, int clientID);
    //find one employee having the employeeNo

    public int disassociateClientFromEmployee(int employeeID, int clientID);
}
