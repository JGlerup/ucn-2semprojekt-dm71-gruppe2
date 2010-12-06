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

    public Client findClient(int clientId) {
        IFDBClient dbCli = new DBClient();
        return dbCli.findClient(clientId, true);
    }

    public ArrayList getAllClient() {
        IFDBClient dbCli = new DBClient();
        ArrayList allCli = new ArrayList<Client>();
        allCli = dbCli.getAllClient(false);
        return allCli;
    }

    public void insert(int clientNo, int id, String description, String interests, String health, int ssn, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        cObj.setClientNo(clientNo);
        cObj.setId(id);
        cObj.setDescription(description);
        cObj.setInterests(interests);
        cObj.setHealth(health);
        cObj.setSsn(ssn);
        cObj.setfirstName(firstName);
        cObj.setMiddleName(middleName)
        cObj.setLastName(lastName)
        cObj.setAddress(address)
        cObj.setZipCode(zipCode)
        cObj.setCity(city)
        cObj.setPhoneNo(phoneNo)
        cObj.setEmail(email)
        dbClient.insertClient(cObj);


        
    }

    public void updateClient(int clientNo, int clientid, String description, String interests, String health, int ssn, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email) {
        Client cObj = new Client();
        cObj.setClientNo(clientNo);
        cObj.setClientId(clientid);
        cObj.setDescription(description);
        cObj.setInterests(interests);
        cObj.setHealth(health);
        cObj.setSsn(ssn);
        cObj.setfirstName(firstName);
        cObj.setMiddleName(middleName)
        cObj.setLastName(lastName)
        cObj.setAddress(address)
        cObj.setZipCode(zipCode)
        cObj.setCity(city)
        cObj.setPhoneNo(phoneNo)
        cObj.setEmail(email)
        dbClient.updateClient(cObj);
    }

    public void deleteClient(int clientId) {
        IFDBClient dbClient = new DBClient();
        dbClient.deleteClient(clientId);
    }
}
