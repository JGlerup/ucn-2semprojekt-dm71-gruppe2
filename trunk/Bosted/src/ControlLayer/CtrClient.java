package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrClient
{

    public CtrClient() 
    {

    }

    public Client findClientByClientNo(String clientNo)
    {
        IFDBClient dbCli = new DBClient();
        return dbCli.findClient(clientNo, true);
    }

    public ArrayList getAllClients()
    {
        IFDBClient dbCli = new DBClient();
        ArrayList allCli = new ArrayList<Client>();
        allCli = dbCli.getAllClients(false);
        return allCli;
    }

    public void insertClient(String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email)
    {
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
        cObj.setInUse("Yes");
        cObj.setStopDate(null);
        cObj.createClientNo();
        dbClient.insertClient(cObj);
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

    public void deleteClient(String clientNo)
    {
        IFDBClient dbClient = new DBClient();
        dbClient.deleteClient(clientNo);
    }
}
