package ControlLayer;

import ModelLayer.ErrorHandlingMedicine;
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
    public void testFindMedicineByClientIDAndName()
    {

        System.out.println("findMedicineByClientIDAndName");
        int clientID = 1;
        String name = "fløde";
        CtrMedi instance = new CtrMedi();
        Medicine expResult = new Medicine();
        expResult.setMedicineID(16);
        expResult.setFrequencyID(1);
        expResult.setExternalContactID(1);
        expResult.setClientID(1);
        expResult.setName("fløde");
        expResult.setDescription("ØreGas");
        Medicine result = instance.findMedicineByClientIDAndName(clientID, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }

    @Test
    public void testFindMedicineByID()
    {

    }

    @Test
    public void testFindErrorHandleMedicine()
    {
        
    }

    @Test
    public void testFindFrequencyByID()
    {

    }

    

    @Test
    public void testDeleteMedicine()
    {

    }

    @Test
    public void testDeleteErrorHandlingMedicine()
    {

    }

    @Test
    public void testGetAllMedicine()
    {

    }

    @Test
    public void testAllErrorHandlingMedicine()
    {

    }

    @Test
    public void testAllErrorHandlingMedicineByDate()
    {

    }

//    @Test
//    public void testInsertMedicine()
//    {
//        System.out.println("insert");
//        int frequencyID = 1;
//        int externalContactID = 1;
//        int clientID = 1;
//        String name = "bananflue";
//        String description = "ØreMedicin";
//        int quantity = 40;
//        CtrMedi instance = new CtrMedi();
//        instance.insertMedicine(frequencyID, externalContactID, clientID, name, description, quantity);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Medicine result = instance.findMedicineByClientIDAndName(1, "bananflue");
//        assertEquals(1, result.getFrequencyID());
//        assertEquals(1, result.getExternalContactID());
//        assertEquals(1, result.getClientID());
//        assertEquals("bananflue", result.getName());
//        assertEquals("ØreMedicin", result.getDescription());
//        assertEquals(40, result.getQuantity());
//        instance.deleteMedicine(result.getMedicineID());
//    }
//
//    @Test
//    public void testInsertErrorHandlingMedicine()
//    {
//
//        System.out.println("insert");
//        int medicineID = 1;
//        int clientID = 1;
//        int employeeID = 2;
//        String episode = "TEST TEST Hunden spiste den";
//        int quantity = 1;
//        String managerNo = "1";
//        CtrMedi instance = new CtrMedi();
//        instance.insertErrorHandlingMedicine(medicineID, clientID, employeeID, episode, quantity, managerNo);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        ErrorHandlingMedicine result = instance.findErrorHandlingMedicineByEpisode(episode);
//        assertEquals(1 , result.getMedicineID());
//        assertEquals(1, result.getClientID());
//        assertEquals(2, result.getEmployeeID());
//        assertEquals("TEST TEST Hunden spiste den", result.getEpisode());
//        assertEquals(1, result.getQuantity());
//        instance.deleteErrorHandlingMedicine(result.getErrorHandlingMedicineID(),result.getMedicineID(), result.getQuantity());
//    }
//
//    @Test
//    public void testUpdateMedicine()
//    {
//        System.out.println("insert");
//        int frequencyID = 1;
//        int externalContactID = 1;
//        int clientID = 1;
//        String name = "bananflue";
//        String description = "ØreMedicin";
//        int quantity = 40;
//        CtrMedi instance = new CtrMedi();
//        instance.insertMedicine(frequencyID, externalContactID, clientID, name, description, quantity);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        System.out.println("UpdateMedicine");
//        int medID = (instance.findMedicineByClientIDAndName(1, "bananflue")).getMedicineID();
//        int frequencyIDNew = 1;
//        int externalContactIDNew = 1;
//        int clientIDNew = 1;
//        String nameNew = "fløde";
//        String descriptionNew = "ØreGas";
//        int quantityNew = 10;
//        String date = (instance.findMedicineByClientIDAndName(1, "bananflue")).getDate();
//        instance.updateMedicine(medID, frequencyIDNew, externalContactIDNew, clientIDNew, nameNew, descriptionNew, date, quantityNew);
//        Medicine result = instance.findMedicineByClientIDAndName(clientIDNew, nameNew);
//        assertEquals(1, result.getFrequencyID());
//        assertEquals(1, result.getExternalContactID());
//        assertEquals(1, result.getClientID());
//        assertEquals("bananflue", result.getName());
//        assertEquals("ØreMedicin", result.getDescription());
//        assertEquals(40, result.getQuantity());
//        instance.deleteMedicine(result.getMedicineID());
//    }

    @Test
    public void testUpdateErrorHandleMedicine()
    {

    }


}