/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;
import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public class CtrEmp {

    public CtrEmp() {
    }

    public ArrayList getAllEmployee() {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(String fname, String lname, String initial, String adresse, int tlfnr, String email) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setFname(fname);
        empObj.setLname(lname);
        empObj.setInitial(initial);
        empObj.setAdresse(adresse);
        empObj.setTlfnr(tlfnr);
        empObj.setEmail(email);
        dbEmp.insertEmployee(empObj);
    }
}
