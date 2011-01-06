package ControlLayer;


import DBLayer.DBClient;
import DBLayer.DBErrorHandlingMedicine;
import DBLayer.DBExternalContact;
import DBLayer.DBFrequency;
import DBLayer.DBMedicine;
import DBLayer.IFDBClient;
import DBLayer.IFDBErrorHandMed;
import DBLayer.IFDBExtCon;
import DBLayer.IFDBFreq;
import DBLayer.IFDBMedi;
import ExceptionsPack.NoManagerNumberErrorHandling;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.ErrorHandlingMedicine;
import ModelLayer.ExternalContact;
import ModelLayer.Frequency;
import ModelLayer.Medicine;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrMedi
{

    private String managerMessage;

    /**
     * Constructor
     */

    public CtrMedi()
    {
        managerMessage = null;
    }

    /** 
     * @param clientID the ID of the client
     * @param name the name of the medicine
     * @return an instance of Medicine
     */

    public Medicine findMedicineByClientIDAndName(int clientID, String name)
    {
        IFDBMedi dbMedi = new DBMedicine();
        return dbMedi.findMedicineByClientIDAndName(clientID, name, true);
    }

    /**
     * @param medicineID the ID of the medicine
     * @return an instance of Medicine
     */
    public Medicine findMedicineByID(int medicineID)
    {
        Medicine medi = new Medicine();
        try
        {
            IFDBMedi dbMedi = new DBMedicine();
            medi = dbMedi.findMedicineByID(medicineID, true);
        }//end try
        catch (Exception e)
        {
            System.out.println("Query exception - select medicine : " + e);
        }//end catch
        return medi;
    }

    /**
     * @return an ArrayList of all Medicine
     */
    public ArrayList<Medicine> getAllMedicine()
    {
        IFDBMedi dbMedi = new DBMedicine();
        ArrayList<Medicine> allMedi = new ArrayList<Medicine>();
        allMedi = dbMedi.getAllMedicine(false);
        return allMedi;
    }

    /**
     * @param frequencyID the ID of the frequency
     * @param externalContactID the ID of the externalContact
     * @param clientID the ID of the client
     * @param name the name of the medicine
     * @param desciption the description of the medicine
     * @param quantity the quantity of the medicine
     */
    public void insertMedicine(int frequencyID, int externalContactID, int clientID, String name, String description, int quantity)
    {
        Medicine medi = new Medicine();
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
        }//end try
        catch (Exception ex)
        {
            System.out.println("Insert exception in medicine db: " + ex);
        }//end catch
    }

    /**
     * @param medicineID the ID of the medicine
     * @param frequencyID the ID of the frequency
     * @param externalContactID the ID of the externalContact
     * @param clientID the ID of the client
     * @param name the name of the medicine
     * @param desciption the description of the medicine
     * @param quantity the quantity of the medicine
     */
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
        }//end try
        catch (Exception Ex)
        {
            System.out.println("Update exception in medicine db: " + Ex);
        }//end catch
    }

     /**
     * @param medicineID the ID of the medicine
     */
    public void deleteMedicine(int medicineID)
    {
        IFDBMedi dbMedi = new DBMedicine();
        dbMedi.deleteMedicine(medicineID);
    }

     /**
     * @param errorHnadlingMedicineID the ID of the errorHandlingMedicine
     * @return an instance of ErrorHandlingMedicine
     */
    public ErrorHandlingMedicine findErrorHandlingMedicineByID(int errorHandlingMedicineID)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        return dbErHaMed.findErrorHandlingMedicineByID(errorHandlingMedicineID, true);
    }

     /**
     * @param episode the episode of ErrorHandlingMedicien
     * @return an instance of ErrorHandlingMedicine
     */
    public ErrorHandlingMedicine findErrorHandlingMedicineByEpisode(String episode)
    {
        IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
        return dbErHaMed.findErrorHandlingMedicineByEpisode(episode, true);
    }

    /**
     * @return an ArrayList of ErrorHandlingMedicine
     */
    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicine()
    {
        IFDBErrorHandMed dbAllErHaMed = new DBErrorHandlingMedicine();
        ArrayList<ErrorHandlingMedicine> allErHaMed = new ArrayList<ErrorHandlingMedicine>();
        allErHaMed = dbAllErHaMed.getAllErrorHandlingMedicines(false);
        return allErHaMed;
    }

    /**
     * @param date the date of the ErrorHandlingMedicine
     * @return an ArrayList of ErrorHandlingMedicine
     */
    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicineByDate(String date)
    {
        IFDBErrorHandMed dbAllErHaMedDa = new DBErrorHandlingMedicine();
        ArrayList<ErrorHandlingMedicine> allErHaMedDa = new ArrayList<ErrorHandlingMedicine>();
        allErHaMedDa = dbAllErHaMedDa.getAllErrorHandlingMedicinesByDate(date, false);
        return allErHaMedDa;
    }

    /**
     * @param medicineID the ID of the Medicine
     * @param clientID the ID of the Client
     * @param employeeID the ID of the Employee
     * @param episode the episode of the ErrorHandlingMedicine
     * @param quantity the quantity of the Medicine
     * @param managerNo the employeeNo the manager of the Employee
     */
    public void insertErrorHandlingMedicine(int medicineID, int clientID, int employeeID, String episode, int quantity, String managerNo) throws NoManagerNumberErrorHandling
    {
        Medicine medi = new Medicine();
        medi = findMedicineByID(medicineID);
        if(medi.getExternalContactID() != 0)
        {
            int newQuantity = medi.getQuantity() - quantity;
            if(medi.getQuantity() > 0 && newQuantity >= 0)
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
                    if(managerNo != null)
                    {
                        sendEmailToManager(findManager(managerNo));
                        managerMessage = getManagerMessage() + " om hændelsen.";
                    }//end if
                    
                }//end if
                else
                {
                    throw new NoManagerNumberErrorHandling("Fejl i indtastning");
                }//end else
        }//end if
    }
        
    /**
     * @param errorHandlingMedicineID the ID of the Medicine
     * @param medicineID the ID of the Medicine
     * @param clientID the ID of the Client
     * @param employeeID the ID of the Employee
     * @param episode the episode of the ErrorHandlingMedicine
     * @param quantity the quantity of the Medicine
     * @param managerNo the employeeNo the manager of the Employee
     */
    public void updateErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int clientID, int employeeID, String date, String episode, int quantity, String managerNo)
    {
        Medicine medi = new Medicine();
        ErrorHandlingMedicine erHaMed = new ErrorHandlingMedicine();
        erHaMed = findErrorHandlingMedicineByID(errorHandlingMedicineID);
        medi = findMedicineByID(medicineID);
        if(medi.getExternalContactID() != 0 && erHaMed.getQuantity() != quantity)
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
                if(managerNo != null)
                {
                    sendEmailToManager(findManager(managerNo));
                    managerMessage = getManagerMessage() + " om opdateringen.";
                }//end if
            }//end try
            catch (Exception Ex)
            {
                System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
            }//end catch
        }//end if
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
                if(managerNo != null)
                {
                    sendEmailToManager(findManager(managerNo));
                    managerMessage = getManagerMessage() + " om opdateringen.";
                }//end if
            }//end try
            catch (Exception Ex)
            {
                System.out.println("Update exception in errorHandlingMedicine db: " + Ex);
            }//end catch
        }//end else
    }

     /**
     * @param errorHandlingMedicineID the ID of the Medicine
     * @param medicineID the ID of the Medicine
     * @param quantity the quantity of the Medicine
     */
    public void deleteErrorHandlingMedicine(int errorHandlingMedicineID, int medicineID, int quantity)
    {
        try
        {
            IFDBErrorHandMed dbErHaMed = new DBErrorHandlingMedicine();
            Medicine medi = findMedicineByID(medicineID);
            updateMedicine(medicineID, medi.getFrequencyID(), medi.getExternalContactID(), medi.getClientID(), medi.getName(), medi.getDescription(), medi.getDate(), (medi.getQuantity()+ quantity));
            dbErHaMed.deleteErrorHandlingMedicine(errorHandlingMedicineID);
        }//end try
        catch (Exception ex)
        {
            System.out.println("Delete exception in errorHandlingMedicine db: " + ex);
        }//end catch
    }

    /**
     * @param managerNo the employeeNo the manager of the Employee
     * @return an instance of an Employee
     */
    public Employee findManager(String managerNo)
    {
        CtrEmp ctrEmpObj = new CtrEmp();
        Employee manager = new Employee();
        manager = ctrEmpObj.findEmployee(managerNo);
        return manager;
    }

    /**
     * @param manager an object of Employee
     */
    public void sendEmailToManager(Employee manager)
    {
        Employee m = manager;
        managerMessage = "Der er sendt besked til " + m.getFirstName() + " " + m.getMiddleName() + " " + m.getLastName();
    }

    /**
     * @return a String
     */
    public String getManagerMessage()
    {
        return managerMessage;
    }

    /**
     * @param managerMessage a String
     */
    public void setManagerMessage(String managerMessage)
    {
        this.managerMessage = managerMessage;
    }

    /**
     * @param errorHandlingMedicineID the ID of the Medicine
     * @param medicineID the ID of the Medicine
     * @param clientID the ID of the Client
     * @param employeeID the ID of the Employee
     * @param episode the episode of the ErrorHandlingMedicine
     * @param quantity the quantity of the Medicine
     * @param managerNo the employeeNo the manager of the Employee
     */
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

    public Client findClientByID(int clientID, boolean retrieveAssociation)
    {
        Client client = new Client();
        try
        {
            IFDBClient dbClient = new DBClient();
            client = dbClient.findClientByID(clientID, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select client : " + e);
        }
        return client;
    }

    public ExternalContact findExternalContact(int extConID, boolean retrieveAssociation)
    {
        ExternalContact extCon = new ExternalContact();
        try
        {
            IFDBExtCon dbExternalContact = new DBExternalContact();
            extCon = dbExternalContact.findExternalContact(extConID, true);
        }
        catch (Exception e)
        {
            System.out.println("Query exception - select externalContact : " + e);
        }
        return extCon;
    }
}
