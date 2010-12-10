package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;
import ExceptionsPack.*;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrEmp
{

    public CtrEmp()
    {
    }

    public Employee findEmployee(String employeeNo)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployee(employeeNo, true);
    }

    public ArrayList getAllEmployee()
    {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(String managerNo, String jobTitle, String crudClient, String crudEmployee, String crudMedicine, String crudCar, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String password) throws NullValueException{
        if(jobTitle != null && crudClient != null && crudEmployee != null && crudMedicine != null && crudCar != null && ssn.length() == 11 && ssn.substring(6, 7) == "-" && firstName != null && lastName != null && address != null && password != null) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        empObj.setCrudClient(crudClient);
        empObj.setCrudEmployee(crudEmployee);
        empObj.setCrudMedicine(crudMedicine);
        empObj.setCrudCar(crudCar);
        empObj.setSsn(ssn);
        empObj.setFirstName(firstName);
        empObj.setMiddleName(middleName);
        empObj.setLastName(lastName);
        empObj.setAddress(address);
        empObj.setLocationID(locationID);
        empObj.setPhoneNo(phoneNo);
        empObj.setEmail(email);
        empObj.setPassword(password);
        empObj.createEmployeeNo();
        empObj.setStartDate();
        empObj.setInUse("Yes");
        empObj.setStopDate(null);
        dbEmp.insertEmployee(empObj);
        }
        else{
            throw new NullValueException("Hej, nogle værdier er null min kære slutbruger.");
        }
        
    }

    public void updateEmp(String employeeNoCurrent, String employeeNoNew, String managerNo, String jobTitle, String crudClient, String crudEmployee, String crudMedicine, String crudCar, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String password) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        int employeeID = findEmployee(employeeNoCurrent).getEmployeeID();
        empObj.setEmployeeID(employeeID);
        empObj.setEmployeeNo(employeeNoNew);
        empObj.setManagerNo(managerNo);
        empObj.setJobTitle(jobTitle);
        empObj.setCrudClient(crudClient);
        empObj.setCrudEmployee(crudEmployee);
        empObj.setCrudMedicine(crudMedicine);
        empObj.setCrudCar(crudCar);
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

    public void deleteEmp(String employeeNo)
    {
        IFDBEmp dbEmp = new DBEmployee();
        dbEmp.deleteEmployee(employeeNo);
    }

    public ArrayList<Client> findEmployeesClient(int employeeID)
    {
        ArrayList<Client> clientList = new ArrayList<Client>();
        IFDBEmp dbEmp = new DBEmployee();
        clientList = dbEmp.findEmployeesClients(employeeID);
        return clientList;
    }

    

}
