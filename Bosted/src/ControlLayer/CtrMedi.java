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

    public Medicine findMedicineByClientIDAndName(int clientID, String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        return dbMedi.findMedicineByClientIDAndName(clientID, name, true);
    }

    public Medicine findMedicine(int medicineID)
    {
        Medicine medi = new Medicine();
        try
        {
            IFDBMedi dbMedi = new DBMedicine();
            medi = dbMedi.findMedicine(medicineID, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : " + e);
            e.printStackTrace();
        }
        return medi;
    }

    public ArrayList<Medicine> getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    public void insertMedicine(int frequencyID, int externalContactID, int clientID, String name, String description, int quantity)
    {
        IFDBMedi dbMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setFrequencyID(frequencyID);
        mediObj.setExternalContactID(externalContactID);
        mediObj.setClientID(clientID);
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setThisDate();
        mediObj.setQuantity(quantity);
        dbMedi.insertMedicine(mediObj);
    }

    public void updateMedicine(int frequencyID, int externalContactID, int clientID, String name, String description, String date, int quantity)
    {
        IFDBMedi dbMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setFrequencyID(frequencyID);
        mediObj.setExternalContactID(externalContactID);
        mediObj.setClientID(clientID);
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setDate(date);
        mediObj.setQuantity(quantity);
        dbMedi.updateMedicine(mediObj);
    }

    public void deleteMedicine(int medicineID)
    {
        IFDBMedi dbMedi = new DBMedicine();
        dbMedi.deleteMedicine(medicineID);
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
            IFDBMedi dbMedi = new DBMedicine();
            Medicine medi = new Medicine();
            medi = dbMedi.findMedicine(medicineID, true);
            int newQuantity = medi.getQuantity() - quantity;
            if(medi.getQuantity() > 0 || newQuantity >= 0)
            {
                try
                {
                    IFDBErrorHandMed dbErHaMedDa = new DBErrorHandlingMedicine();
                    ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
                    medi.setQuantity(newQuantity);
                    dbMedi.updateMedicine(medi);
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
                    System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : " + e);
            e.printStackTrace();
        }
        return managermessage;
    }

    public void updateErrorHandlingMedicine(int medicineID, int clientID, int employeeID, String date, String episode, int quantity)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
        erHaMedObj.setMedicineID(medicineID);
        erHaMedObj.setClientID(clientID);
        erHaMedObj.setEmployeeID(employeeID);
        erHaMedObj.setDate(date);
        erHaMedObj.setEpisode(episode);
        erHaMedObj.setQuantity(quantity);
        dbErHaMed.updateErrorHandlingMedicine(erHaMedObj);
    }

    public void deleteErrorHandlingMedicine(int ErrorHandlingMedicineID)
    {
        try
        {
            IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
            dbErHaMed.deleteErrorHandlingMedicine(ErrorHandlingMedicineID);
        }
        catch (Exception ex)
        {
            System.out.println("Delete exception in errorHandlingMedicine db: " + ex);
        }
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
