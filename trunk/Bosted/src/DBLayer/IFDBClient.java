package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBClient {

    public Client findClient(String clientNo, boolean retrieveAssociation);
    //find one client having the clientNo

    public ArrayList<Client> getAllClients(boolean retriveAssociation);
    //find one client having the fname

    public int insertClient(Client c);
    //update information about an client

    public int updateClient(Client c);
    //update information about an client

    public int deleteClient(String clientNo);
    //delete a client

    public ArrayList<Client>buildListOfClients(int employeeID);
}
