package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBClient {

    public Client findClient(int clientNo, boolean retrieveAssociation);
    //find one client having the clientNo

    public ArrayList<Client> getAllClient(boolean retriveAssociation);
    //find one client having the fname

    public int insertClient(Client c);
    //update information about an client

    public int updateClient(Client c);
    //update information about an client

    public int deleteClient(int clientNo);
    //delete a client
}
