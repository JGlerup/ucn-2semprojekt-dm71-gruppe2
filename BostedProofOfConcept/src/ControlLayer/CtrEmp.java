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

    public Employee findEmployee(int employeeNo) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployee(employeeNo, true);
    }

    public ArrayList getAllEmployee() {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(int employeeNo, int managerNo, String jobTitle) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        dbEmp.insertEmployee(empObj);
    }

    public void updateEmp(int employeeNo, int managerNo, String jobTitle) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        dbEmp.updateEmployee(empObj);
    }

    public void deleteEmp(int employeeNo) {
        IFDBEmp dbEmp = new DBEmployee();
        dbEmp.deleteEmployee(employeeNo);
    }
}
