/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anita
 */
public class CtrMedicineTest
{

    public CtrMedicineTest()
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
    public void testInsert() //String name, String description, Date date, int quantity
    {
        System.out.println("insert");
        String name = "banan";
        String description = "Etn gul frugt, aber kan lide";
        String interests = "jeg elsker bananer";
        String health = "???";
        String ssn = "123456-1234";
        String firstName = "banan";
        String middleName = "and";
        String lastName = "mand";
        String address = "banangade 14";
        int locationID = 1;
        int phoneNo = 98163044;
        String email = "bananmand@junglen.dk";
        CtrClient instance = new CtrClient();
        instance.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Client result = instance.findClientByClientNo("banan123456");
        assertEquals("jeg leger med aber", result.getDescription());
        assertEquals("jeg elsker bananer", result.getInterests());
        assertEquals("???", result.getHealth());
        assertEquals("123456-1234", result.getSsn());
        assertEquals("banan", result.getFirstName());
        assertEquals("and", result.getMiddleName());
        assertEquals("mand", result.getLastName());
        assertEquals("banangade 14", result.getAddress());
        assertEquals(1, result.getLocationID());
        assertEquals(98163044, result.getPhoneNo());
        assertEquals("bananmand@junglen.dk", result.getEmail());
        instance.deleteClient("banan123456");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}