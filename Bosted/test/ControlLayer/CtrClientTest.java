package ControlLayer;

import ModelLayer.Location;
import ModelLayer.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erik
 */
public class CtrClientTest {

    public CtrClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findClientByClientNo method, of class CtrClient.
     */
//    @Test
//    public void testFindClientByClientNo() {
//        System.out.println("findClientByClientNo");
//        String clientNo = "";
//        CtrClient instance = new CtrClient();
//        Client expResult = null;
//        Client result = instance.findClientByClientNo(clientNo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAllClient method, of class CtrClient.
     */
//    @Test
//    public void testGetAllClient() {
//        System.out.println("getAllClient");
//        CtrClient instance = new CtrClient();
//        ArrayList expResult = null;
//        ArrayList result = instance.getAllClients();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of insert method, of class CtrClient.
     */
    @Test
    public void testInsertClient() {
        System.out.println("insert");
        String description = "jeg leger med aber";
        String interests = "jeg elsker bananer";
        String health = "???";
        String ssn = "123456-1234";
        String firstName = "banan";
        String middleName = "and";
        String lastName = "mand";
        String address = "banangade 14";
        Location location = new Location();
        CtrLoca ctrLoca = new CtrLoca();
        try
        {
            location = ctrLoca.findLocationByZipCode(9000);
        }
        catch (Exception e)
        {
            fail("Exception:" + e.getMessage());
        }
        int phoneNo = 98163044;
        String email = "bananmand@junglen.dk";
        String startDate = "2000-10-1";
        String inUse = "Yes";
        String stopDate = "2010-10-10";
        CtrClient instance = new CtrClient();
        try {
            instance.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, location, phoneNo, email, startDate, inUse, stopDate);
        } catch (Exception e) {
            fail("Exception:" + e.getMessage());
        }
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
        assertEquals(9000, result.getLocation().getZipCode());
        assertEquals(98163044, result.getPhoneNo());
        assertEquals("bananmand@junglen.dk", result.getEmail());
        instance.deleteClient("banan123456");
    }

    /**
     * Test of updateClient method, of class CtrClient.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("insert");
        String description = "jeg leger med aber";
        String interests = "jeg elsker bananer";
        String health = "???";
        String ssn = "123456-1234";
        String firstName = "banan";
        String middleName = "and";
        String lastName = "mand";
        String address = "banangade 14";
        Location location = new Location();
        CtrLoca ctrLoca = new CtrLoca();
        try
        {
            location = ctrLoca.findLocationByZipCode(9000);
        }
        catch (Exception e)
        {
            fail("Exception:" + e.getMessage());
        }
        int phoneNo = 9816344;
        String email = "bananmand@junglen.dk";
        String startDate = "2000-10-1";
        String inUse = "Yes";
        String stopDate = "";
        CtrClient instance = new CtrClient();
        try {
            instance.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, location, phoneNo, email, startDate, inUse, stopDate);
        } catch (Exception e) {
            fail("Exception:" + e.getMessage());
        }
        String clientNoCurrent = "banan123456";

        System.out.println("updateClient");
        String clientNoNew = "weotpk235";
        description = "wetoji";
        interests = "wtojitew";
        health = "ktprytry";
        ssn = "975313-5633";
        firstName = "pkwet";
        middleName = "98awytehph";
        lastName = "aiwhpt9";
        address = "atpijoew";
        location = new Location();
        try
        {
            location = ctrLoca.findLocationByZipCode(9000);
        }
        catch (Exception e)
        {
            fail("Exception:" + e.getMessage());
        }
        phoneNo = 983252010;
        email = "test@junglen.dk";
        startDate = "2000-10-1";
        inUse = "Yes";
        stopDate = "2010-10-10";
        try {
            instance.updateClient(clientNoCurrent, clientNoNew, description, interests, health, ssn, firstName, middleName, lastName, address, location, phoneNo, email, inUse);
        } catch (Exception e) {
            fail("Exception:" + e.getMessage());
        }
        Client result = instance.findClientByClientNo("weotpk235");
        assertEquals("weotpk235", result.getClientNo());
        assertEquals("wetoji", result.getDescription());
        assertEquals("wtojitew", result.getInterests());
        assertEquals("ktprytry", result.getHealth());
        assertEquals("975313-5633", result.getSsn());
        assertEquals("pkwet", result.getFirstName());
        assertEquals("98awytehph", result.getMiddleName());
        assertEquals("aiwhpt9", result.getLastName());
        assertEquals("atpijoew", result.getAddress());
        assertEquals(9000, result.getLocation().getZipCode());
        assertEquals(983252010, result.getPhoneNo());
        assertEquals("test@junglen.dk", result.getEmail());
        instance.deleteClient(clientNoNew);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteClient method, of class CtrClient.
     */
    @Test
    public void testDeleteClient() {
        System.out.println("deleteClient");
        System.out.println("insert");
        String description = "jeg leger med aber";
        String interests = "jeg elsker bananer";
        String health = "???";
        String ssn = "123456-4444";
        String firstName = "banan";
        String middleName = "and";
        String lastName = "mand";
        String address = "banangade 14";
        Location location = new Location();
        CtrLoca ctrLoca = new CtrLoca();
        try
        {
            location = ctrLoca.findLocationByZipCode(9000);
        }
        catch (Exception e)
        {
            fail("Exception:" + e.getMessage());
        }
        int phoneNo = 98163000;
        String email = "bananmand@junglen.dk";
        String startDate = "2000-10-1";
        String inUse = "Yes";
        String stopDate = null;
        CtrClient instance = new CtrClient();
        try {
            instance.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, location, phoneNo, email, startDate, inUse, stopDate);
        } catch (Exception e) {
            fail("Exception:" + e.getMessage());
        }
        instance.deleteClient("banan123456");
        Client result = instance.findClientByClientNo("test123456");
        assertNull(null, result.getClientNo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
