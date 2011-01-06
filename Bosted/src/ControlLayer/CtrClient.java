package ControlLayer;


import DBLayer.DBClient;
import DBLayer.DBEmployee;
import DBLayer.IFDBClient;
import DBLayer.IFDBEmp;
import ExceptionsPack.NullValueException;
import ModelLayer.Client;
import ModelLayer.Employee;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrClient {

    public CtrClient() {
    }

    public Client findClientByClientNo(String clientNo) {
        IFDBClient dbCli = new DBClient();
        return dbCli.findClient(clientNo, true);
    }

    public ArrayList getAllClients() {
        IFDBClient dbCli = new DBClient();
        ArrayList allCli = new ArrayList<Client>();
        allCli = dbCli.getAllClients(false);
        return allCli;
    }

    public void insertClient(String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String inUse) throws NullValueException {
        if (!description.trim().equals("") && !interests.trim().equals("") && !health.trim().equals("") && ssn.trim().length() == 11 && ssn.substring(6, 7).equals("-") && !firstName.trim().equals("") && !lastName.trim().equals("") && !address.trim().equals("") && !inUse.trim().equals("")) {
            IFDBClient dbClient = new DBClient();
            Client cObj = new Client();
            cObj.setDescription(description);
            cObj.setInterests(interests);
            cObj.setHealth(health);
            cObj.setSsn(ssn);
            cObj.setFirstName(firstName);
            cObj.setMiddleName(middleName);
            cObj.setLastName(lastName);
            cObj.setAddress(address);
            cObj.setLocationID(locationID);
            cObj.setPhoneNo(phoneNo);
            cObj.setEmail(email);
            cObj.setStartDate();
            cObj.setInUse(inUse);
            cObj.setStopDate(null);
            cObj.createClientNo();
            dbClient.insertClient(cObj);
        }
        else{
            throw new NullValueException("Fejl: Udfyld venligst alle felter (e-mail-feltet må gerne være blankt)");
        }
    }

    public void updateClient(String clientNoCurrent, String clientNoNew, String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String inUse) throws NullValueException  {
        if (!description.trim().equals("") && !interests.trim().equals("") && !health.trim().equals("") && ssn.trim().length() == 11 && ssn.substring(6, 7).equals("-") && !firstName.trim().equals("") && !lastName.trim().equals("") && !address.trim().equals("") && !inUse.trim().equals("")) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        int clientID = findClientByClientNo(clientNoCurrent).getClientID();
        cObj.setClientID(clientID);
        cObj.setClientNo(clientNoNew);
        cObj.setDescription(description);
        cObj.setInterests(interests);
        cObj.setHealth(health);
        cObj.setSsn(ssn);
        cObj.setFirstName(firstName);
        cObj.setMiddleName(middleName);
        cObj.setLastName(lastName);
        cObj.setAddress(address);
        cObj.setLocationID(locationID);
        cObj.setPhoneNo(phoneNo);
        cObj.setEmail(email);
        cObj.setInUse(inUse);
        dbClient.updateClient(cObj);
                }
        else{
            throw new NullValueException("Fejl: Tjek om følgende felter er udfyldt:");
        }
    }

    public void deleteClient(String clientNo) {
        IFDBClient dbClient = new DBClient();
        dbClient.deleteClient(clientNo);
    }

    public ArrayList<Employee> findClientsEmployees(int clientID) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        IFDBClient dbClient = new DBClient();
        employeeList = dbClient.findClientsEmployees(clientID);
        return employeeList;
    }

    public ArrayList<Client> findEmployeesClient(int employeeID) {
        ArrayList<Client> clientList = new ArrayList<Client>();
        IFDBEmp dbEmp = new DBEmployee();
        clientList = dbEmp.findEmployeesClients(employeeID);
        return clientList;
    }
}
