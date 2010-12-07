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
    public void testInsertClient() {
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
        instance.insertClient(clientNo, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
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
        instance.deleteClient(clientNo);
    }

    /**
     * Test of updateClient method, of class CtrClient.
     */
    @Test
    public void testUpdateClient() {
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
        instance.insertClient(clientNo, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
        //int clientID = instance.findClientByClientNo(clientNo).getClientID();
        ////////////////////////////////////////////////////////////
        System.out.println("updateClient");
        String clientNoNew = "weotpk235";
        description = "wetoji";
        interests = "wtojitew";
        health = "ktprytry";
        ssn = "porkye";
        firstName = "pkwet";
        middleName = "98awytehph";
        lastName = "aiwhpt9";
        address = "atpijoew";
        locationID = 1;
        phoneNo = 983252010;
        email = "sutmin@junglen.dk";
        instance.updateClient(clientNo, clientNoNew, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
        Client result = instance.findClientByClientNo("weotpk235");
        assertEquals("weotpk235", result.getClientNo());
        assertEquals("wetoji", result.getDescription());
        assertEquals("wtojitew", result.getInterests());
        assertEquals("ktprytry", result.getHealth());
        assertEquals("porkye", result.getSsn());
        assertEquals("pkwet", result.getFirstName());
        assertEquals("98awytehph", result.getMiddleName());
        assertEquals("aiwhpt9", result.getLastName());
        assertEquals("atpijoew", result.getAddress());
        assertEquals(1, result.getLocationID());
        assertEquals(983252010, result.getPhoneNo());
        assertEquals("sutmin@junglen.dk", result.getEmail());
        
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
        String clientNo = "test";
        String description = "jeg leger med aber";
        String interests = "jeg elsker bananer";
        String health = "???";
        String ssn = "123456-4444";
        String firstName = "banan";
        String middleName = "and";
        String lastName = "mand";
        String address = "banangade 14";
        int locationID = 1;
        int phoneNo = 98163000;
        String email = "bananmand@junglen.dk";
        CtrClient instance = new CtrClient();
        instance.insertClient(clientNo, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email);
        instance.deleteClient(clientNo);
        Client result = instance.findClientByClientNo(clientNo);
        assertNull(null, result.getClientNo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}