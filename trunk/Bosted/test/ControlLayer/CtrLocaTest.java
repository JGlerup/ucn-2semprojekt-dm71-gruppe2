/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;

import ModelLayer.Location;
import ExceptionsPack.NoSuchZipCodeException;
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
public class CtrLocaTest {

    public CtrLocaTest() {
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
     * Test of findLocation method, of class CtrLoca.
     */
//    @Test
//    public void testFindLocation() {
//        System.out.println("findLocation");
//        int locationID = 0;
//        CtrLoca instance = new CtrLoca();
//        Location expResult = null;
//        Location result = instance.findLocation(locationID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of findLocationIDByZipCode method, of class CtrLoca.
     */
    @Test
    public void testFindLocationByZipCode() {
        System.out.println("findLocationByZipCode");
        int zipCode = 9000;
        CtrLoca instance = new CtrLoca();
        String expResult = "Aalborg";
        try {
            Location result = instance.findLocationByZipCode(zipCode);
            assertEquals(expResult, result.getCity());
        } catch (NoSuchZipCodeException e) {
            System.out.print(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllLocations method, of class CtrLoca.
     */
//    @Test
//    public void testGetAllLocations() {
//        System.out.println("getAllLocations");
//        CtrLoca instance = new CtrLoca();
//        ArrayList expResult = null;
//        ArrayList result = instance.getAllLocations();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of insert method, of class CtrLoca.
     */
    @Test
    public void testInsert() {
        System.out.println("insert location");
        int zipCode = 10001;
        String city = "Super secret city";
        CtrLoca instance = new CtrLoca();
        instance.insert(zipCode, city);
        try {
            Location result = instance.findLocationByZipCode(zipCode);
            assertEquals(zipCode, result.getZipCode());
            assertEquals(city, result.getCity());
            instance.deleteLoca(result.getLocationID());
        } catch (NoSuchZipCodeException e) {
            System.out.println(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

    }

    /**
     * Test of updateLoca method, of class CtrLoca.
     */
    @Test
    public void testUpdateLoca() {
        CtrLoca instance = new CtrLoca();

        System.out.println("insert location");
        int zipCode = 10002;
        String city = "Rapture";
        instance.insert(zipCode, city);
        try {
            int zipCodeCurrent = instance.findLocationByZipCode(zipCode).getZipCode();
            System.out.println("update location");
            int zipCodeNew = 10003;
            city = "Las Vegas";
            instance.updateLoca(zipCodeCurrent, zipCodeNew, city);
            Location result = instance.findLocationByZipCode(zipCodeNew);
            assertEquals(zipCodeNew, result.getZipCode());
            assertEquals(city, result.getCity());
            instance.deleteLoca(result.getLocationID());
        } catch (NoSuchZipCodeException e) {
            System.out.println(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of deleteLoca method, of class CtrLoca.
     */
//    @Test
//    public void testDeleteLoca() {
//        System.out.println("deleteLoca");
//        int locationID = 0;
//        CtrLoca instance = new CtrLoca();
//        instance.deleteLoca(locationID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
