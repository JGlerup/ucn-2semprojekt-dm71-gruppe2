/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import ModelLayer.Client;
import java.util.ArrayList;
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
    public void testInsert() {
        System.out.println("insert");
        String clientNo = "bp1234";
        String description = "jeg leger med aber";
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
        instance.insert(clientNo, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Client result = instance.findClientByClientNo(clientNo);
        assertEquals("bp1234", result.getClientNo());
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
    }

    /**
     * Test of updateClient method, of class CtrClient.
     */
//    @Test
//    public void testUpdateClient() {
//
//        System.out.println("updateClient");
//        String clientNo = "";
//        String description = "";
//        String interests = "";
//        String health = "";
//        String ssn = "";
//        String firstName = "";
//        String middleName = "";
//        String lastName = "";
//        String address = "";
//        int locationID = 0;
//        int phoneNo = 0;
//        String email = "";
//        CtrClient instance = new CtrClient();
//        instance.updateClient(clientNo, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteClient method, of class CtrClient.
     */
//    @Test
//    public void testDeleteClient() {
//        System.out.println("deleteClient");
//        String clientNo = "";
//        CtrClient instance = new CtrClient();
//        instance.deleteClient(clientNo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}