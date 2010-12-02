/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */
public interface IFDBMedi {

    public ArrayList<Medicine> getAllMedicine(boolean retriveAssociation);
    //find one medicine having the fname
    public int insertMedicine(Medicine medi);
    //update information about an medicine
}
