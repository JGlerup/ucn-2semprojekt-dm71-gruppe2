package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrMedi
{

    public CtrMedi()
    {

    }

    public Medicine findMedicineByName(int clientID, String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        return dbMedi.findMedicineByName(clientID, name, true);
    }

    public ArrayList getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    public void insert(String name, String description, int quantity)
    {
        IFDBMedi dbMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setThisDate();
        mediObj.setQuantity(quantity);
        dbMedi.insertMedicine(mediObj);
    }

    public void updateMedicine(String name, String description, String date, int quantity)
    {
        IFDBMedi dbMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setDate(date);
        mediObj.setQuantity(quantity);
        dbMedi.updateMedicine(mediObj);
    }

    public void deleteMedicine(String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        dbMedi.deleteMedicine(name);
    }
}
