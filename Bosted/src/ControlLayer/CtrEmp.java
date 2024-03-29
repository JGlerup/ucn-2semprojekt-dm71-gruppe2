package ControlLayer;

import DBLayer.DBEmployee;
import DBLayer.DBEmployeeClient;
import DBLayer.IFDBEmp;
import DBLayer.IFDBEmployeeClient;
import ExceptionsPack.NullValueException;
import ModelLayer.Employee;
import ModelLayer.Location;
import java.util.ArrayList;


/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrEmp
{

    public CtrEmp()
    {
    }

    public Employee findEmployee(String employeeNo, boolean retrieveAssociation)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployee(employeeNo, retrieveAssociation);
    }

    /**
     *
     * @param employeeID the employeeID
     * @return an instance of Employee
     */
    public Employee findEmployeeByID(int employeeID)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.findEmployeeByID(employeeID, true);
    }

    public ArrayList getAllEmployee()
    {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public void insert(String managerNo, String jobTitle, String crudClient, String crudEmployee, String crudMedicine, String crudCar, String ssn, String firstName, String middleName, String lastName, String address, Location location, int phoneNo, String email, String password, String inUse) throws NullValueException {
        if (!jobTitle.trim().equals("") && !crudClient.trim().equals("") && !crudEmployee.trim().equals("") && !crudMedicine.trim().equals("") && !crudCar.trim().equals("") && ssn.trim().length() == 11 && ssn.substring(6, 7).equals("-") && !firstName.trim().equals("") && !lastName.trim().equals("") && !address.trim().equals("") && !password.trim().equals("") && !inUse.trim().equals("")) {
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
            empObj.setLocation(location);
            empObj.setPhoneNo(phoneNo);
            empObj.setEmail(email);
            empObj.setPassword(password);
            empObj.createEmployeeNo();
            empObj.setThisStartDate();
            empObj.setInUse(inUse);
            empObj.setStopDate("");
            dbEmp.insertEmployee(empObj);
        } else {
            throw new NullValueException("Fejl: Tjek om følgende felter er udfyldt:");
        }

    }

    public void updateEmp(String employeeNoCurrent, String employeeNoNew, String managerNo, String jobTitle, String crudClient, String crudEmployee, String crudMedicine, String crudCar, String ssn, String firstName, String middleName, String lastName, String address, Location location, int phoneNo, String email, String password, String inUse) throws NullValueException {
        if (!jobTitle.trim().equals("") && !crudClient.trim().equals("") && !crudEmployee.trim().equals("") && !crudMedicine.trim().equals("") && !crudCar.trim().equals("") && ssn.trim().length() == 11 && ssn.substring(6, 7).equals("-") && !firstName.trim().equals("") && !lastName.trim().equals("") && !address.trim().equals("") && !password.trim().equals("") && !inUse.trim().equals("")) {
            IFDBEmp dbEmp = new DBEmployee();
            Employee empObj = new Employee();
            int employeeID = findEmployee(employeeNoCurrent, false).getEmployeeID();
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
            empObj.setLocation(location);
            empObj.setPhoneNo(phoneNo);
            empObj.setEmail(email);
            empObj.setPassword(password);
            empObj.setInUse(inUse);
            dbEmp.updateEmployee(empObj);
        } else {
            throw new NullValueException("Fejl: Tjek om følgende felter er udfyldt:");
        }
    }

    public void deleteEmp(String employeeNo) {
        IFDBEmp dbEmp = new DBEmployee();
        dbEmp.deleteEmployee(employeeNo);
    }

//    public ArrayList<Client> findEmployeesClient(int employeeID) {
//        ArrayList<Client> clientList = new ArrayList<Client>();
//        IFDBEmp dbEmp = new DBEmployee();
//        clientList = dbEmp.findEmployeesClients(employeeID);
//        return clientList;
//    }

    public void associateClientToEmployee(int employeeID, int clientID) {
        IFDBEmployeeClient dbEmpCli = new DBEmployeeClient();
        dbEmpCli.associateClientToEmployee(employeeID, clientID);
    }

    public void disassociateClientFromEmployee(int employeeID, int clientID) {
        IFDBEmployeeClient dbEmpCli = new DBEmployeeClient();
        dbEmpCli.disassociateClientFromEmployee(employeeID, clientID);
    }
}
