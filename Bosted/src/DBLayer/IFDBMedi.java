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
    //find one medicine having the clientID and medicineName

    public Medicine findMedicineByID(int medicineID, boolean retrieveAssociation);
    //find one medicine having the medicineID

    public ArrayList<Medicine> getAllMedicine(boolean retriveAssociation);
    //find all medicine

    public ArrayList<Medicine> getAllMedicineByClientID(int clientID, boolean retriveAssociation);
    //find all medicine with this clientID

    public int insertMedicine(Medicine medi);
    //update information about a medicine

    public int updateMedicine(Medicine medi);
    //update information about a medicine

    public int deleteMedicine(int medicineID);
    //delete a medicine

}
