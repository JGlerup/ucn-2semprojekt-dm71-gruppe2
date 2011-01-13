package ControlLayer;

import ModelLayer.Employee;
import ModelLayer.Client;
import ModelLayer.ExternalContact;
import ModelLayer.Frequency;
import ExceptionsPack.NoManagerNumberErrorHandling;
import ModelLayer.ErrorHandlingMedicine;
import java.util.ArrayList;
import ModelLayer.Medicine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrMediTest
{

    public CtrMediTest() 
    {

    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {

    }

    @AfterClass
    public static void tearDownClass() throws Exception 
    {

    }

    @Before
    public void setUp() 
    {

    }

    @After
    public void tearDown() 
    {

    }

    @Test
    public void testInsertMedicine()
    {
        System.out.println("insert");
        Frequency frequency = new Frequency();
        int frequencyID = 1;
        frequency.setFrequencyID(frequencyID);
        ExternalContact externalContact = new ExternalContact();
        int externalContactID = 1;
        externalContact.setExternalContactID(externalContactID);
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
       
        String name = "TEST MedicinNavn";
        String description = "TEST MedicinBeskrivelse";
        int quantity = 100;
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj.setThisDate();
        instance.insertMedicine(frequency, externalContact, client, name, description, quantity);//(int frequencyID, int externalContactID, int clientID, String name, String description, int quantity)
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn");
        assertEquals(1, result.getFrequency().getFrequencyID());
        assertEquals(1, result.getExternalContact().getExternalContactID());
        assertEquals(1, result.getClient().getClientID());
        assertEquals("TEST MedicinNavn", result.getName());
        assertEquals("TEST MedicinBeskrivelse", result.getDescription());
        assertEquals(mediObj.getDate(), result.getDate());
        assertEquals(100, result.getQuantity());
    }
    
    @Test
    public void testFindMedicineByClientIDAndName()
    {
        System.out.println("findMedicineByClientIDAndName");
        Frequency frequency = new Frequency();
        int frequencyID = 1;
        frequency.setFrequencyID(frequencyID);
        ExternalContact externalContact = new ExternalContact();
        int externalContactID = 1;
        externalContact.setExternalContactID(externalContactID);
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
        String name = "TEST MedicinNavn";
        String description = "TEST MedicinBeskrivelse";
        Medicine mediObj = new Medicine();
        mediObj.setThisDate();
        String date = mediObj.getDate();
        int quantity = 100;
        CtrMedi instance = new CtrMedi();
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn");
        System.out.println("MedicineID " + result.getMedicineID());
        assertEquals(frequencyID, result.getFrequency().getFrequencyID());
        System.out.println("FrequencyID " + result.getFrequency().getFrequencyID());
        assertEquals(externalContactID, result.getExternalContact().getExternalContactID());
        System.out.println("ExternalContactID " + result.getExternalContact().getExternalContactID());
        assertEquals(clientID, result.getClient().getClientID());
        System.out.println("ClientID " + result.getClient().getClientID());
        assertEquals(name, result.getName());
        System.out.println("Name " + result.getName());
        assertEquals(description, result.getDescription());
        System.out.println("Description " + result.getDescription());
        assertEquals(date, result.getDate());
        System.out.println("Date " + result.getDate());
        assertEquals(quantity, result.getQuantity());
        System.out.println("Quantity " + result.getQuantity());
    }

    @Test
    public void testFindMedicineByID()
    {// Run testFindMedicineByClientIDAndName first to find MedicineID
        System.out.println("findMedicineByID");
        Frequency frequency = new Frequency();
        int frequencyID = 1;
        frequency.setFrequencyID(frequencyID);
        ExternalContact externalContact = new ExternalContact();
        int externalContactID = 1;
        externalContact.setExternalContactID(externalContactID);
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
        String name = "TEST MedicinNavn";
        String description = "TEST MedicinBeskrivelse";
        Medicine mediObj = new Medicine();
        mediObj.setThisDate();
        String date = mediObj.getDate();
        int quantity = 100;
        CtrMedi instance = new CtrMedi();
        Medicine res = instance.findMedicineByClientIDAndName(clientID, name);
        int medicineID = res.getMedicineID();
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByID(medicineID);
        assertEquals(medicineID, result.getMedicineID());
        System.out.println("MedicineID " + result.getMedicineID());
        assertEquals(frequencyID, result.getFrequency().getFrequencyID());
        System.out.println("FrequencyID " + result.getFrequency().getFrequencyID());
        assertEquals(externalContactID, result.getExternalContact().getExternalContactID());
        System.out.println("ExternalContactID " + result.getExternalContact().getExternalContactID());
        assertEquals(clientID, result.getClient().getClientID());
        System.out.println("ClientID " + result.getClient().getClientID());
        assertEquals(name, result.getName());
        System.out.println("Name " + result.getName());
        assertEquals(description, result.getDescription());
        System.out.println("Description " + result.getDescription());
        assertEquals(date,result.getDate());
        System.out.println("Date " + result.getDate());
        assertEquals(quantity, result.getQuantity());
        System.out.println("Quantity " + result.getQuantity());
    }

//    @Test
//    public void testGetAllMedicine()
//    {//if id at max is 100
//        System.out.println("getAllMedicine");
//        CtrMedi instance = new CtrMedi();
//        ArrayList<Medicine> expResult = new ArrayList<Medicine>();
//        for(int id = 1; id < 100; id++)
//        {
//            Medicine obj = instance.findMedicineByID(id);
//            Client c = obj.getClient();
//            if(c == null) {
//            if(obj.getClient().getClientID() != 0)
//            {
//                expResult.add(obj);
//            }
//            }
//        }
//        ArrayList<Medicine> result = instance.getAllMedicine();
//        assertEquals(expResult.size(), result.size());
//        //TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    @Test
    public void testUpdateMedicine()
    {
        System.out.println("findMedicineByNameAndClientID");
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn");
        int medicineID = mediObj.getMedicineID();
        Frequency frequency = new Frequency();
        int frequencyID = 1;
        frequency.setFrequencyID(frequencyID);
        ExternalContact externalContact = new ExternalContact();
        int externalContactID = 1;
        externalContact.setExternalContactID(externalContactID);
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
        String name = "TEST MedicinNytNavn";
        String description = "TEST MedicinNyBeskrivelse";
        String date = "2010-01-01";
        int quantity = 10;
        System.out.println("updateMedicine");
        instance.updateMedicine(medicineID, frequency, externalContact, client, name, description, date, quantity);//(int medicineID, int frequencyID, int externalContactID, int clientID, String name, String description, String date, int quantity)
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        assertEquals(medicineID, result.getMedicineID());
        assertEquals(1, result.getFrequency().getFrequencyID());
        assertEquals(1, result.getExternalContact().getExternalContactID());
        assertEquals(1, result.getClient().getClientID());
        assertEquals("TEST MedicinNytNavn", result.getName());
        assertEquals("TEST MedicinNyBeskrivelse", result.getDescription());
        assertEquals("2010-01-01",result.getDate());
        assertEquals(10, result.getQuantity());
    }

    @Test
    public void testInsertErrorHandlingMedicine()
    {
        try{
        System.out.println("insert");
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        System.out.println(mediObj.getMedicineID());
        Medicine medicine = new Medicine();
        int medicineID = mediObj.getMedicineID();
        medicine.setMedicineID(medicineID);
        int oldQuantity = mediObj.getQuantity();
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
        Employee employee = new Employee();
        int employeeID = 2;
        employee.setEmployeeID(employeeID);
        String episode = "TEST TEST Hunden spiste den";
        int quantity = 1;
        int newQuantity = oldQuantity - quantity;
        String managerNo = "1";
        instance.insertErrorHandlingMedicine(medicine, client, employee, episode, quantity, managerNo);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        ErrorHandlingMedicine eResult = instance.findErrorHandlingMedicineByEpisode(episode);
        Medicine mResult = instance.findMedicineByID(medicineID);
        assertEquals(medicineID , eResult.getMedicine().getMedicineID());
        assertEquals(1, eResult.getClient().getClientID());
        assertEquals(2, eResult.getEmployee().getEmployeeID());
        assertEquals("TEST TEST Hunden spiste den", eResult.getEpisode());
        assertEquals(1, eResult.getQuantity());
        assertEquals(medicineID, mResult.getMedicineID());
        assertEquals(1, mResult.getClient().getClientID());
        assertEquals("TEST MedicinNytNavn", mResult.getName());
        assertEquals(newQuantity, mResult.getQuantity());
        }
        catch(NoManagerNumberErrorHandling e){
            fail("Exception:" + e.getMessage());
        }
        catch(Exception ex){
            fail("Exception:" + ex.getMessage());
        }
    }

    @Test
    public void testFindErrorHandleMedicineByEpisode()
    {
        System.out.println("findErrorHandleMedicineByEpisode");
        CtrMedi instance = new CtrMedi();
        ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
        erHaMedObj.setThisDate();
        int clientID = 1;
        int employeeID = 2;
        String date = erHaMedObj.getDate();
        String episode = "TEST TEST Hunden spiste den";
        int quantity = 1;
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        ErrorHandlingMedicine result = instance.findErrorHandlingMedicineByEpisode(episode);
        System.out.println("MedicineID " + result.getMedicine().getMedicineID());
        assertEquals(clientID, result.getClient().getClientID());
        System.out.println("clientID " + result.getClient().getClientID());
        assertEquals(employeeID, result.getEmployee().getEmployeeID());
        System.out.println("EmployeeID " + result.getEmployee().getEmployeeID());
        assertEquals(date, result.getDate());
        System.out.println("Date " + result.getDate());
        assertEquals(episode, result.getEpisode());
        System.out.println("Episode " + result.getEpisode());
        assertEquals(date,result.getDate());
        System.out.println("Date " + result.getDate());
        assertEquals(quantity, result.getQuantity());
        System.out.println("Quantity " + result.getQuantity());
    }

    @Test
    public void testUpdateErrorHandleMedicine()
    {
        System.out.println("findMedicineByNameAndClientID");
        CtrMedi instance = new CtrMedi();
        ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
        erHaMedObj.setThisDate();
        String date = erHaMedObj.getDate();
        erHaMedObj = instance.findErrorHandlingMedicineByEpisode("TEST TEST Hunden spiste den");
        int errrorHandlingMedicineID = erHaMedObj.getErrorHandlingMedicineID();
        System.out.println("mediID " + erHaMedObj.getMedicine().getMedicineID());
        Medicine medicine = new Medicine();
        int medicineID = erHaMedObj.getMedicine().getMedicineID();
        medicine.setMedicineID(medicineID);
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByID(medicineID);
        int oldQuantity = mediObj.getQuantity();
        int quantity = 5;
        int newQuantity = (oldQuantity + erHaMedObj.getQuantity()) - quantity;
        Client client = new Client();
        int clientID = 1;
        client.setClientID(clientID);
        Employee employee = new Employee();
        int employeeID = 2;
        employee.setEmployeeID(employeeID);
        String episode = "TEST TEST Katten spiste dem";
        String managerNo = "1";
        System.out.println("updateErrorHandlingMedicine");
        instance.updateErrorHandlingMedicine(errrorHandlingMedicineID, medicine, client, employee, date, episode, quantity, managerNo);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine mResult = instance.findMedicineByID(medicineID);
        ErrorHandlingMedicine eResult = instance.findErrorHandlingMedicineByID(errrorHandlingMedicineID);
        assertEquals(medicineID, mResult.getMedicineID());
        assertEquals(newQuantity, mResult.getQuantity());
        assertEquals(medicineID, eResult.getMedicine().getMedicineID());
        assertEquals(1, eResult.getClient().getClientID());
        assertEquals(2, eResult.getEmployee().getEmployeeID());
        assertEquals("TEST TEST Katten spiste dem", eResult.getEpisode());
        assertEquals(date, eResult.getDate());
        assertEquals(5, eResult.getQuantity());
    }

    @Test
    public void testDeleteErrorHandlingMedicine()
    {
        System.out.println("deleteErrorHandlingMedicine");
        CtrMedi instance = new CtrMedi();
        System.out.println("findErrorHnadlingMedicineByEpisode");
        ErrorHandlingMedicine erHaMedObj = new ErrorHandlingMedicine();
        erHaMedObj = instance.findErrorHandlingMedicineByEpisode("TEST TEST Katten spiste dem");
        int errorHandlingMedicineID = erHaMedObj.getErrorHandlingMedicineID();
        Medicine medicine = new Medicine();
        int medicineID = erHaMedObj.getMedicine().getMedicineID();
        medicine.setMedicineID(medicineID);;
        int quantity = erHaMedObj.getQuantity();
        System.out.println("findMedicineByID");
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByID(medicineID);
        int oldQuantity = mediObj.getQuantity();
        int newQuantity = oldQuantity + quantity;
        System.out.println("deleteErrorHandlingMedicine");
        instance.deleteErrorHandlingMedicine(errorHandlingMedicineID, medicine, quantity);
        Medicine mResult = new Medicine();
        mResult = instance.findMedicineByID(medicineID);
        ErrorHandlingMedicine eResult = instance.findErrorHandlingMedicineByEpisode("TEST TEST Katten spiste dem");
        assertEquals(newQuantity, mResult.getQuantity());
        assertEquals(null, eResult.getEpisode());

    }

    @Test
    public void testDeleteMedicine()
    {
        System.out.println("deleteMedicine");
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        int medicineID = mediObj.getMedicineID();
        System.out.println("Name " + mediObj.getName());
        instance.deleteMedicine(medicineID);
        Medicine mediObjResult = new Medicine();
        mediObjResult = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        System.out.println("Name " + mediObjResult.getName());
        assertEquals(null, mediObjResult.getName());
    }

//    @Test
//    public void testFindFrequencyByID()
//    {
//
//    }
//
//    @Test
//    public void testGetAllErrorHandlingMedicine()
//    {
//
//    }
//
//    @Test
//    public void testGetAllErrorHandlingMedicineByDate()
//    {
//
//    }

}