/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBMedi
{

    public Medicine findMedicineByClientIDAndName(int clientID, String name, boolean retrieveAssociation);
    //find one employee having the employeeNo

    public ArrayList<Medicine> getAllMedicine(boolean retriveAssociation);
    //find one medicine having the fname
    public int insertMedicine(Medicine medi);
    //update information about an medicine

    public int updateMedicine(Medicine medi);
    //update information about an employee

    public int deleteMedicine(String name);
    //delete an employee

}
