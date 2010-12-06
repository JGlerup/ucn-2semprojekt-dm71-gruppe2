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

    public Employee findEmployee(int employeeID) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployee(employeeID, true);
    }

    public ArrayList getAllEmployee() {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(String employeeNo, String managerNo, String jobTitle, int clientNo, int id, String description, String interests, String health, int ssn, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        
    }

    public void updateEmp(String employeeNo, int employeeID, int managerNo, String jobTitle, String ssn, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email, String password) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setEmployeeNo(employeeNo);
        empObj.setEmployeeID(employeeID);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        empObj.setSsn(ssn);
        empObj.setFirstName(firstName);
        empObj.setMiddleName(middleName);
        empObj.setLastName(lastName);
        empObj.setAddress(address);
        empObj.setZipCode(zipCode);
        empObj.setCity(city);
        empObj.setPhoneNo(phoneNo);
        empObj.setEmail(email);
        empObj.setPassword(password);
        dbEmp.updateEmployee(empObj);
    }

    public void deleteEmp(int employeeID) {
        IFDBEmp dbEmp = new DBEmployee();
        dbEmp.deleteEmployee(employeeID);
    }
}
