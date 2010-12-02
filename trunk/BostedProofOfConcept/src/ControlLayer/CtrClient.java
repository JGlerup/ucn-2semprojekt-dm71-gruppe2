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

    public Client findClient(int clientNo) {
        IFDBClient dbCli = new DBClient();
        return dbCli.findClient(clientNo, true);
    }

    public ArrayList getAllClient() {
        IFDBClient dbCli = new DBClient();
        ArrayList allCli = new ArrayList<Client>();
        allCli = dbCli.getAllClient(false);
        return allCli;
    }

    public void insert(int clientNo, String description, String interests, String health) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        cObj.setClientNo(clientNo);
        cObj.setDescription(description);
        cObj.setInterests(interests);
        cObj.setHealth(health);
        dbClient.insertClient(cObj);
    }

    public void updateClient(int clientNo, String description, String interests, String health) {
        IFDBClient dbClient = new DBClient();
        Client cObj = new Client();
        cObj.setClientNo(clientNo);
        cObj.setDescription(description);
        cObj.setInterests(interests);
        cObj.setHealth(health);
        dbClient.updateClient(cObj);
    }

    public void deleteClient(int clientNo) {
        IFDBClient dbClient = new DBClient();
        dbClient.deleteClient(clientNo);
    }
}
