package ModelLayer;

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
public class MedicineTest
{

    public MedicineTest()
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
    public void TestMedicineID()
    {
        System.out.println("MedicineID");
        int medicineID = 1;
        Medicine result = new Medicine();
        result.setMedicineID(medicineID);
        assertEquals(1, result.getMedicineID());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void TestFrequencyID() 
    {
        System.out.println("FrequencyID");
        Frequency frequency = new Frequency();
        int frequencyID = 2;
        frequency.setFrequencyID(frequencyID);
        Medicine result = new Medicine();
        result.setFrequency(frequency);
        assertEquals(2, result.getFrequency().getFrequencyID());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestExternalContactID()
    {
        System.out.println("ExternalContactID");
        ExternalContact externalContact = new ExternalContact();
        int externalContactID = 3;
        externalContact.setExternalContactID(externalContactID);
        Medicine result = new Medicine();
        result.setExternalContact(externalContact);
        assertEquals(3, result.getExternalContact().getExternalContactID());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestClientID()
    {
        System.out.println("ClientID");
        Client client = new Client();
        int clientID = 4;
        client.setClientID(clientID);
        Medicine result = new Medicine();
        result.setClient(client);
        assertEquals(4, result.getClient().getClientID());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestName()
    {
        System.out.println("Name");
        String name = "Testnavn";
        Medicine result = new Medicine();
        result.setName(name);
        assertEquals("Testnavn", result.getName());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestDescription()
    {
        System.out.println("Description");
        String description = "Testbeskrivelse";
        Medicine result = new Medicine();
        result.setDescription(description);
        assertEquals("Testbeskrivelse", result.getDescription());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestDate()
    {
        System.out.println("Date");
        String date = "20100101";
        Medicine result1 = new Medicine();
        Medicine result2 = new Medicine();
        result1.setDate(date);
        result2.setThisDate();
        String newDate = result2.getDate();
        assertEquals("20100101", result1.getDate());
        assertEquals(newDate, result2.getDate());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

    @Test
    public void TestQuantity()
    {
        System.out.println("Quantity");
        int quantity = 100;
        Medicine result = new Medicine();
        result.setQuantity(quantity);
        assertEquals(100, result.getQuantity());
        // TODO review the generated test
        //fail("The test case is a prototype.");
    }

}