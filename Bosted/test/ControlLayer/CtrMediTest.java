package ControlLayer;

import java.util.Date;
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
    public void testFindMedicine()
    {

    }

    @Test
    public void testFindErrorHandleMedicine()
    {
        
    }

    @Test
    public void testFindMedicineByClientIDAndName()
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

    @Test
    public void testInsertMedicine()
    {
        System.out.println("insert");
        int frequencyID = 1;
        int externalContactID = 1;
        int clientID = 1;
        String name = "bananflue";
        String description = "ØreMedicin";
        int quantity = 40;
        CtrMedi instance = new CtrMedi();
        instance.insertMedicine(frequencyID, externalContactID, clientID, name, description, quantity);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicineByClientIDAndName(1, "bananflue");
        assertEquals(1, result.getFrequencyID());
        assertEquals(1, result.getExternalContactID());
        assertEquals(1, result.getClientID());
        assertEquals("bananflue", result.getName());
        assertEquals("ØreMedicin", result.getDescription());
        assertEquals(40, result.getQuantity());
        instance.deleteMedicine(result.getMedicineID());
    }

    @Test
    public void testInsertErrorHandlingMedicine()
    {
//
        System.out.println("insert");
        int medicineID = 1;
        int clientID = 1;
        int employeeID = 2;
        String episode = "Hunden spiste den";
        int quantity = 1;
        String managerNo = "1";
        CtrMedi instance = new CtrMedi();
        instance.insertErrorHandlingMedicine(medicineID, clientID, employeeID, episode, quantity, managerNo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Medicine result = instance.findMedicine(1);
        result.setThisDate();
        String date = result.getDate();
//        Arraylist<ErrorHandlingMedicine> results = instance.getAllErrorHandlingMedicineByDate(date);
//        assertEquals(1 , results.getFrequencyID());
//        assertEquals(1, results.getExternalContactID());
//        assertEquals(1, results.getClientID());
//        assertEquals("bananflue", results.getName());
//        assertEquals("ØreMedicin", results.getDescription());
//        assertEquals(40, results.getQuantity());
//        instance.deleteMedicine(result.getMedicineID());
    }

    @Test
    public void testUpdateMedicine()
    {

    }

    @Test
    public void testUpdateErrorHandleMedicine()
    {

    }

    // public void testInsertClient()
//    {
//        System.out.println("insert");
//        String description = "jeg leger med aber";
//        String interests = "jeg elsker bananer";
//        String health = "???";
//        String ssn = "123456-1234";
//        String firstName = "banan";
//        String middleName = "and";
//        String lastName = "mand";
//        String address = "banangade 14";
//        int locationID = 1;
//        int phoneNo = 98163044;
//        String email = "bananmand@junglen.dk";
//        CtrClient instance = new CtrClient();
//        instance.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        Client result = instance.findClientByClientNo("banan123456");
//        assertEquals("jeg leger med aber", result.getDescription());
//        assertEquals("jeg elsker bananer", result.getInterests());
//        assertEquals("???", result.getHealth());
//        assertEquals("123456-1234", result.getSsn());
//        assertEquals("banan", result.getFirstName());
//        assertEquals("and", result.getMiddleName());
//        assertEquals("mand", result.getLastName());
//        assertEquals("banangade 14", result.getAddress());
//        assertEquals(1, result.getLocationID());
//        assertEquals(98163044, result.getPhoneNo());
//        assertEquals("bananmand@junglen.dk", result.getEmail());
//        instance.deleteClient("banan123456");
//
//}

}