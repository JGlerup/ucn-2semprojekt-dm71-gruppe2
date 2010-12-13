/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class CrtDaily {

}

public Daily findDailyreport(int clientID)
    {
        IFDBDaily dbDaily = new DBClient();
        return dbDaily.findDailyreport(clientID, true);
    }

    public ArrayList getAllDailyreports()
    {
        IFDBDailyreport dbDai = new DBDailyreport();
        ArrayList allDai = new ArrayList<Dailyreport>();
        allDai = dbDai.getAllDailyreports(false);
        return allDai;
    }

    public void insertDailyreport(int clientID, int employeeID, String text, Date date)
    {
        IFDBDaily dbDailyreport = new DBDailyreport();
        Dailyreport dObj = new Dailyreport();
        dObj.setClientID(clientID);
        dObj.setEmployeeID(employeeID);
        dObj.setText(text);
        dObj.setDate(date);
    }

    public void updateClient(String clientNoCurrent, String clientNoNew, String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email)
    {
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
        dbClient.updateClient(cObj);
    }

    public void deleteDailyreport(int clientID)
    {
        IFDBDaily dbDailyreport = new DBDailyreport();
        dbDaily.deleteDailyreport(clientID);
    }

    public ArrayList<Employee> findClientsEmployees(int clientID)
    {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        IFDBClient dbClient = new DBClient();
        employeeList = dbClient.findClientsEmployees(clientID);
        return employeeList;
    }

        public ArrayList<Client> findEmployeesClient(int employeeID)
    {
        ArrayList<Client> clientList = new ArrayList<Client>();
        IFDBEmp dbEmp = new DBEmployee();
        clientList = dbEmp.findEmployeesClients(employeeID);
        return clientList;
    }
}
