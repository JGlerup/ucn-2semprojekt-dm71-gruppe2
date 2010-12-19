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

    private String managerMessage;

    public CtrMedi()
    {
        managerMessage = null;
    }

    public Medicine findMedicineByClientIDAndName(int clientID, String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        return dbMedi.findMedicineByClientIDAndName(clientID, name, true);
    }

    public Medicine findMedicineByID(int medicineID)
    {
        Medicine medi = new Medicine();
        try
        {
            IFDBMedi dbMedi = new DBMedicine();
            medi = dbMedi.findMedicineByID(medicineID, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : " + e);
        }
        return medi;
    }

    public ArrayList<Medicine> getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList<Medicine> allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    public void insertMedicine(int frequencyID, int externalContactID, int clientID, String name, String description, int quantity)
    {
        try
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
        catch (Exception ex)
        {
            System.out.println("Insert exception in medicine db: " + ex);
        }
    }

    public void updateMedicine(int medicineID, int frequencyID, int externalContactID, int clientID, String name, String description, String date, int quantity)
    {
        try
        {
            IFDBMedi dbMedi = new DBMedicine();
            Medicine mediObj = new Medicine();
            mediObj = findMedicineByID(medicineID);
            mediObj.setFrequencyID(frequencyID);
            mediObj.setExternalContactID(externalContactID);
            mediObj.setClientID(clientID);
            mediObj.setName(name);
            mediObj.setDescription(description);
            mediObj.setDate(date);
            mediObj.setQuantity(quantity);
            dbMedi.updateMedicine(mediObj);
        }
        catch (Exception Ex)
        {
            System.out.println("Update exception in medicine db: " + Ex);
        }
    }

    public void deleteMedicine(int medicineID)
    {
        IFDBMedi dbMedi = new DBMedicine();
        dbMedi.deleteMedicine(medicineID);
    }

    public ErrorHandlingMedicine findErrorHandlingMedicineByID(int errorHandlingMedicineID)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        return dbErHaMed.findErrorHandlingMedicineByID(errorHandlingMedicineID, true);
    }

    public ErrorHandlingMedicine findErrorHandlingMedicineByEpisode(String episode)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        return dbErHaMed.findErrorHandlingMedicineByEpisode(episode, true);
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
        ArrayList<ErrorHandlingMedicine> allErHaMedDa = new ArrayList<ErrorHandlingMedicine>();
        allErHaMedDa = dbAllErHaMedDa.getAllErrorHandlingMedicinesByDate(date, false);
        return allErHaMedDa;
    }

    public void insertErrorHandlingMedicine(int medicineID, int clientID, int employeeID, String episode, int quantity, String managerNo)
    {
        Medicine medi = new Medicine();
        medi = findMedicineByID(medicineID);
        if(medi.getExternalContactID() != 0)
        {
            int newQuantity = medi.getQuantity() - quantity;
            if(medi.getQuantity() > 0 || newQuantity >= 0)
            {
                try
                {
                    IFDBErrorHandMed dbErHaMedDa = new DBErrorHandlingMedicine();
                    ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
                    medi.setQuantity(newQuantity);
                    updateMedicine(medicineID, medi.getFrequencyID(), medi.getExternalContactID(), medi.getClientID(), medi.getName(), medi.getDescription(), medi.getDate(), medi.getQuantity());
                    erHaMedObj.setMedicineID(medicineID);
                    erHaMedObj.setClientID(clientID);
                    erHaMedObj.setEmployeeID(employeeID);
                    erHaMedObj.setThisDate();
                    erHaMedObj.setEpisode(episode);
                    erHaMedObj.setQuantity(quantity);
                    dbErHaMedDa.insertErrorHandlingMedicine(erHaMedObj);
                    sendEmailToManager(findManager(managerNo));
                    managerMessage = getManagerMessage() + " om hændelsen.";
                }
                catch (Exception Ex)
                {
                    System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
                }
            }
        }
        
    }

    public void updateErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int clientID, int employeeID, String date, String episode, int quantity, String managerNo)
    {
        String managermessage = null;
        Medicine medi = new Medicine();
        ErrorHandlingMedicine erHaMed = new ErrorHandlingMedicine();
        erHaMed = findErrorHandlingMedicineByID(errorHandlingMedicineID);
        medi = findMedicineByID(medicineID);
        if(medi.getExternalContactID() != 0 || erHaMed.getQuantity() != quantity)
        {
             try
            {
                int newQuantity = medi.getQuantity() + erHaMed.getQuantity() - quantity;
                medi.setQuantity(newQuantity);
                IFDBMedi dbMed = new DBMedicine();
                dbMed.updateMedicine(medi);
                IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
                ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
                erHaMedObj.setErrorHandlingMedicineID(errorHandlingMedicineID);
                erHaMedObj.setMedicineID(medicineID);
                erHaMedObj.setClientID(clientID);
                erHaMedObj.setEmployeeID(employeeID);
                erHaMedObj.setDate(date);
                erHaMedObj.setEpisode(episode);
                erHaMedObj.setQuantity(quantity);
                dbErHaMed.updateErrorHandlingMedicine(erHaMedObj);
                sendEmailToManager(findManager(managerNo));
                managerMessage = getManagerMessage() + " om opdateringen.";
            }
            catch (Exception Ex)
            {
                System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
            }
        }
        else
        {
            try
            {
                IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
                ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
                erHaMedObj.setErrorHandlingMedicineID(errorHandlingMedicineID);
                erHaMedObj.setMedicineID(medicineID);
                erHaMedObj.setClientID(clientID);
                erHaMedObj.setEmployeeID(employeeID);
                erHaMedObj.setDate(date);
                erHaMedObj.setEpisode(episode);
                erHaMedObj.setQuantity(quantity);
                dbErHaMed.updateErrorHandlingMedicine(erHaMedObj);
                sendEmailToManager(findManager(managerNo));
                managerMessage = getManagerMessage() + " om opdateringen.";
            }
            catch (Exception Ex)
            {
                System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
            }
        }
    }

    public void deleteErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int quantity)
    {
        try
        {
            IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
            Medicine medi = findMedicineByID(medicineID);
            updateMedicine(medicineID, medi.getFrequencyID(), medi.getExternalContactID(), medi.getClientID(), medi.getName(), medi.getDescription(), medi.getDate(), (medi.getQuantity()+ quantity));
            dbErHaMed.deleteErrorHandlingMedicine(errorHandlingMedicineID);
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

    public void sendEmailToManager(Employee manager)
    {
        Employee m = manager;
        managerMessage = "Der er sendt besked til " + m.getFirstName() + " " + m.getMiddleName() + " " + m.getLastName();
    }

    public String getManagerMessage()
    {
        return managerMessage;
    }

    public void setManagerMessage(String ManagerMessage)
    {
        this.managerMessage = ManagerMessage;
    }

    public Frequency findFrequencyByTimesPerDayAndQuantityEachTime(int timesPerDay, int quantityEachTime, boolean retrieveAssociation)
    {
        Frequency freq = new Frequency();
        try
        {
            IFDBFreq dbFreq = new DBFrequency();
            freq = dbFreq.findFrequencyByTimesPerDayAndQuantityEachTime(timesPerDay, quantityEachTime, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select frequency : " + e);
        }
        return freq;
    }

    public Frequency findFrequencyByID(int frequencyID, boolean retrieveAssociation)
    {
        Frequency freq = new Frequency();
        try
        {
            IFDBFreq dbFreq = new DBFrequency();
            freq = dbFreq.findFrequencyByID(frequencyID, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select frequency : " + e);
        }
        return freq;
    }

    public ArrayList<Frequency> getAllFrequency(boolean retriveAssociation)
    {
        IFDBFreq dbFreq = new DBFrequency();
        ArrayList<Frequency> allFreq = new ArrayList<Frequency>();
        allFreq = dbFreq.getAllFrequency(false);
        return allFreq;
    }
    public void insertFrequency(int timesPerDay, int quantityEachTime, String descriptionUsage)
    {
        try
        {
            IFDBFreq dbFreq = new DBFrequency();
            Frequency freqObj = new Frequency();
            freqObj.setTimesPerDay(timesPerDay);
            freqObj.setQuantityEachTime(quantityEachTime);
            freqObj.setDescriptionUsage(descriptionUsage);
            freqObj.setThisDate();
            dbFreq.insertFrequency(freqObj);
        }
        catch (Exception ex)
        {
            System.out.println("Insert exception in frequency db: " + ex);
        }
    }

    public void updateFrequency(int frequencyID, int timesPerDay, int quantityEachTime, String descriptionUsage, String date)
    {
        try
        {
            IFDBFreq dbFreq = new DBFrequency();
            Frequency freqObj = new Frequency();
            freqObj = findFrequencyByID(frequencyID, true);
            freqObj.setTimesPerDay(timesPerDay);
            freqObj.setQuantityEachTime(quantityEachTime);
            freqObj.setDescriptionUsage(descriptionUsage);
            freqObj.setDate(date);
            dbFreq.updateFrequency(freqObj);
        }
        catch (Exception Ex)
        {
            System.out.println("Update exception in frequency db: " + Ex);
        }

    }

    public void deleteFrequency(int frequencyID)
    {
        try
        {
            IFDBFreq dbFreq = new DBFrequency();
            dbFreq.deleteFrequency(frequencyID);
        }
        catch (Exception ex)
        {
            System.out.println("Delete exception in frequency db: " + ex);
        }
    }

    public void giveMedicine(int medicineID, int quantity)
    {
        Medicine md = findMedicineByID(medicineID);
        md.setQuantity(md.getQuantity() - quantity);
    }

    public void updateStock(int medicineID, int quantity)
    {
        Medicine md = findMedicineByID(medicineID);
        md.setQuantity(md.getQuantity() + quantity);
    }
}
