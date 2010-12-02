package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Gruppe 2 - DM71
 */
public interface IFDBClient {

    public ArrayList<Client> getAllClient(boolean retriveAssociation);
    //find one client having the fname
    public int insertClient(Client c);
    //update information about an employee
}