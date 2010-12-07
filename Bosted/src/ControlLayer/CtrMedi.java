package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrMedi
{

    public CtrMedi() 
    {

    }

    public Medicine findMedicineByName(String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        return dbMedi.findMedicineByName(name, true);
    }

    public ArrayList getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    public void insert(String name, String description, Date date, int quantity)
    {
        IFDBMedi dbMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setDate(date);
        mediObj.setQuantity(quantity);
        dbMedi.insertMedicine(mediObj);
    }

    public void updateMedic(String name, String description, Date date, int quantity)
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
