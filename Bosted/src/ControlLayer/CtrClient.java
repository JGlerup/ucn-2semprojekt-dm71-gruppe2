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

    public void insertClient(String clientNo, String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        cObj.setClientNo(clientNo);
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
        dbClient.insertClient(cObj);


        
    }

    public void updateClient(String clientOld, String clientNoNew, String description, String interests, String health, String ssn, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        int clientID = findClientByClientNo(clientOld).getClientID();
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

    public void deleteClient(String clientNo) {
        IFDBClient dbClient = new DBClient();
        dbClient.deleteClient(clientNo);
    }
}
