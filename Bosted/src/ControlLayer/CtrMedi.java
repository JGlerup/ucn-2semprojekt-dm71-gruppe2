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
        return dbMedi.findMedicineByClientIDAndName(clientID, name, true);
    }

    public ArrayList<Medicine> getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    public void insertMedicine(String name, String description, int quantity)
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

    public ErrorHandlingMedicine findErrorHandlingMedicineByID(int errorHandlingMedicineID)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        return dbErHaMed.findErrorHandlingMedicine(errorHandlingMedicineID, true);
    }

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicine()
    {
        IFDBErrorHandMed dbAllErHaMed = new DBErrorHandlingMedicine();
        ArrayList<ErrorHandlingMedicine> allErHaMed = new ArrayList<ErrorHandlingMedicine>();
        allErHaMed = dbAllErHaMed.getAllErrorHandlingMedicines(false);
        return allErHaMed;
    }

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicineByDate(String date)
    {
        IFDBErrorHandMed dbAllErHaMedDa = new DBErrorHandlingMedicine();
        ArrayList allErHaMedDa = new ArrayList<Medicine>();
        allErHaMedDa = dbAllErHaMedDa.getAllErrorHandlingMedicinesByDate(date, false);
        return allErHaMedDa;
    }

    public String insertErrorHandlingMedicine(int medicineID, int clientID, int employeeID, String episode, int quantity, String managerNo)
    {
        String managermessage = null;
        try
        {
            IFDBErrorHandMed dbErHaMedDa = new DBErrorHandlingMedicine();
            ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
            erHaMedObj.setMedicineID(medicineID);
            erHaMedObj.setClientID(clientID);
            erHaMedObj.setEmployeeID(employeeID);
            erHaMedObj.setThisDate();
            erHaMedObj.setEpisode(episode);
            erHaMedObj.setQuantity(quantity);
            dbErHaMedDa.insertErrorHandlingMedicine(erHaMedObj);
            managermessage = sendEmailtoManager(findManager(managerNo));
        }
        catch (Exception Ex)
        {
            
        }
        return managermessage;
    }

    public void updateErrorHandlingMedicine(int medicineID, int clientID, int employeeID, String date, String episode, int quantity)
    {
        IFDBErrorHandMed dbErHaMedDa = new DBErrorHandlingMedicine();
        ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
        erHaMedObj.setMedicineID(medicineID);
        erHaMedObj.setClientID(clientID);
        erHaMedObj.setEmployeeID(employeeID);
        erHaMedObj.setDate(date);
        erHaMedObj.setEpisode(episode);
        erHaMedObj.setQuantity(quantity);
        dbErHaMedDa.updateErrorHandlingMedicine(erHaMedObj);
    }

    public void deleteErrorHandlingMedicine(String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        dbMedi.deleteMedicine(name);
    }

    public Employee findManager(String managerNo)
    {
        CtrEmp ctrEmpObj = new CtrEmp();
        Employee manager = new Employee();
        manager = ctrEmpObj.findEmployee(managerNo);
        return manager;
    }

    public String sendEmailtoManager(Employee manager)
    {
        Employee m = manager;
        return "Der er sendt besked til " + m.getFirstName() + " " + m.getMiddleName() + " " + m.getLastName()+ ".";
    }
}
