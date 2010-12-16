package ControlLayer;

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
        int frequencyID = 1;
        int externalContactID = 1;
        int clientID = 1;
        String name = "TEST MedicinNavn";
        String description = "TEST MedicinBeskrivelse";
        int quantity = 100;
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj.setThisDate();
        instance.insertMedicine(frequencyID, externalContactID, clientID, name, description, quantity);//(int frequencyID, int externalContactID, int clientID, String name, String description, int quantity)
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn");
        assertEquals(1, result.getFrequencyID());
        assertEquals(1, result.getExternalContactID());
        assertEquals(1, result.getClientID());
        assertEquals("TEST MedicinNavn", result.getName());
        assertEquals("TEST MedicinBeskrivelse", result.getDescription());
        assertEquals(mediObj.getDate(), result.getDate());
        assertEquals(100, result.getQuantity());
    }
    
    @Test
    public void testFindMedicineByClientIDAndName()
    {
        System.out.println("findMedicineByClientIDAndName");
        int frequencyID = 1;
        int externalContactID = 1;
        int clientID = 1;
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
        assertEquals(frequencyID, result.getFrequencyID());
        System.out.println("FrequencyID " + result.getFrequencyID());
        assertEquals(externalContactID, result.getExternalContactID());
        System.out.println("ExternalContactID " + result.getExternalContactID());
        assertEquals(clientID, result.getClientID());
        System.out.println("ClientID " + result.getClientID());
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
        int frequencyID = 1;
        int externalContactID = 1;
        int clientID = 1;
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
        assertEquals(frequencyID, result.getFrequencyID());
        System.out.println("FrequencyID " + result.getFrequencyID());
        assertEquals(externalContactID, result.getExternalContactID());
        System.out.println("ExternalContactID " + result.getExternalContactID());
        assertEquals(clientID, result.getClientID());
        System.out.println("ClientID " + result.getClientID());
        assertEquals(name, result.getName());
        System.out.println("Name " + result.getName());
        assertEquals(description, result.getDescription());
        System.out.println("Description " + result.getDescription());
        assertEquals(date,result.getDate());
        System.out.println("Date " + result.getDate());
        assertEquals(quantity, result.getQuantity());
        System.out.println("Quantity " + result.getQuantity());
    }

    @Test
    public void testGetAllMedicine()
    {//if id at max is 100
        System.out.println("getAllMedicine");
        CtrMedi instance = new CtrMedi();
        ArrayList<Medicine> expResult = new ArrayList<Medicine>();
        for(int id = 1; id < 100; id++)
        {
            Medicine obj = instance.findMedicineByID(id);
            if(obj.getClientID() != 0)
            {
                expResult.add(obj);
            }
        }
        ArrayList<Medicine> result = instance.getAllMedicine();
        assertEquals(expResult.size(), result.size());
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateMedicine()
    {
        System.out.println("findMedicineByNameAndClientID");
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNavn");
        int medicineID = mediObj.getMedicineID();
        int frequencyID = 1;
        int externalContactID = 1;
        int clientID = 1;
        String name = "TEST MedicinNytNavn";
        String description = "TEST MedicinNyBeskrivelse";
        String date = "2010-01-01";
        int quantity = 10;
        System.out.println("updateMedicine");
        instance.updateMedicine(medicineID, frequencyID, externalContactID, clientID, name, description, date, quantity);//(int medicineID, int frequencyID, int externalContactID, int clientID, String name, String description, String date, int quantity)
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        assertEquals(medicineID, result.getMedicineID());
        assertEquals(1, result.getFrequencyID());
        assertEquals(1, result.getExternalContactID());
        assertEquals(1, result.getClientID());
        assertEquals("TEST MedicinNytNavn", result.getName());
        assertEquals("TEST MedicinNyBeskrivelse", result.getDescription());
        assertEquals("2010-01-01",result.getDate());
        assertEquals(10, result.getQuantity());
    }

    @Test
    public void testInsertErrorHandlingMedicine()
    {
        System.out.println("insert");
        CtrMedi instance = new CtrMedi();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByClientIDAndName(1, "TEST MedicinNytNavn");
        System.out.println(mediObj.getMedicineID());
        int medicineID = mediObj.getMedicineID();
        int oldQuantity = mediObj.getQuantity();
        int clientID = 1;
        int employeeID = 2;
        String episode = "TEST TEST Hunden spiste den";
        int quantity = 1;
        int newQuantity = oldQuantity - quantity;
        String managerNo = "1";
        instance.insertErrorHandlingMedicine(medicineID, clientID, employeeID, episode, quantity, managerNo);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        ErrorHandlingMedicine eResult = instance.findErrorHandlingMedicineByEpisode(episode);
        Medicine mResult = instance.findMedicineByID(medicineID);
        assertEquals(medicineID , eResult.getMedicineID());
        assertEquals(1, eResult.getClientID());
        assertEquals(2, eResult.getEmployeeID());
        assertEquals("TEST TEST Hunden spiste den", eResult.getEpisode());
        assertEquals(1, eResult.getQuantity());
        assertEquals(medicineID, mResult.getMedicineID());
        assertEquals(1, mResult.getClientID());
        assertEquals("TEST MedicinNytNavn", mResult.getName());
        assertEquals(newQuantity, mResult.getQuantity());
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
        System.out.println("MedicineID " + result.getMedicineID());
        assertEquals(clientID, result.getClientID());
        System.out.println("clientID " + result.getClientID());
        assertEquals(employeeID, result.getEmployeeID());
        System.out.println("EmployeeID " + result.getEmployeeID());
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
        int medicineID = erHaMedObj.getMedicineID();
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByID(medicineID);
        int oldQuantity = mediObj.getQuantity();
        int quantity = 5;
        int newQuantity = (oldQuantity + erHaMedObj.getQuantity()) - quantity;
        int clientID = 1;
        int employeeID = 2;
        String episode = "TEST TEST Katten spiste dem";
        String managerNo = "1";
        System.out.println("updateErrorHandlingMedicine");
        instance.updateErrorHandlingMedicine(errrorHandlingMedicineID, medicineID, clientID, employeeID, date, episode, quantity, managerNo);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine mResult = instance.findMedicineByID(medicineID);
        ErrorHandlingMedicine eResult = instance.findErrorHandlingMedicineByID(errrorHandlingMedicineID);
        assertEquals(medicineID, mResult.getMedicineID());
        assertEquals(newQuantity, mResult.getQuantity());
        assertEquals(medicineID, eResult.getMedicineID());
        assertEquals(1, eResult.getClientID());
        assertEquals(2, eResult.getEmployeeID());
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
        int medicineID = erHaMedObj.getMedicineID();
        int quantity = erHaMedObj.getQuantity();
        System.out.println("findMedicineByID");
        Medicine mediObj = new Medicine();
        mediObj = instance.findMedicineByID(medicineID);
        int oldQuantity = mediObj.getQuantity();
        int newQuantity = oldQuantity + quantity;
        System.out.println("deleteErrorHandlingMedicine");
        instance.deleteErrorHandlingMedicine(errorHandlingMedicineID, medicineID, quantity);
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

    @Test
    public void testFindFrequencyByID()
    {

    }

    @Test
    public void testGetAllErrorHandlingMedicine()
    {

    }

    @Test
    public void testGetAllErrorHandlingMedicineByDate()
    {

    }

}