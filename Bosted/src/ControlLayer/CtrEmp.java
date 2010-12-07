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

    public Employee findEmployee(String employeeNo) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployee(employeeNo, true);
    }

    public ArrayList getAllEmployee() {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(String employeeNo, String managerNo, String jobTitle, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String password) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        empObj.setSsn(ssn);
        empObj.setFirstName(firstName);
        empObj.setMiddleName(middleName);
        empObj.setLastName(lastName);
        empObj.setAddress(address);
        empObj.setLocationID(locationID);
        empObj.setPhoneNo(phoneNo);
        empObj.setEmail(email);
        empObj.setPassword(password);
        dbEmp.insertEmployee(empObj);
        
    }

    public void updateEmp(String employeeNo, String managerNo, String jobTitle, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String password) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        empObj.setSsn(ssn);
        empObj.setFirstName(firstName);
        empObj.setMiddleName(middleName);
        empObj.setLastName(lastName);
        empObj.setAddress(address);
        empObj.setLocationID(locationID);
        empObj.setPhoneNo(phoneNo);
        empObj.setEmail(email);
        empObj.setPassword(password);
        dbEmp.updateEmployee(empObj);
    }

    public void deleteEmp(String employeeNo) {
        IFDBEmp dbEmp = new DBEmployee();
        dbEmp.deleteEmployee(employeeNo);
    }
}
