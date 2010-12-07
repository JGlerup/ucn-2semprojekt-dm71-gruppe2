/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import ModelLayer.Employee;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristian Byrialsen
 */
public class CtrEmpTest {

    public CtrEmpTest() {
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
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findEmployee method, of class CtrEmp.
     */
//    @Test
//    public void testFindEmployee()
//    {
//        System.out.println("findEmployee");
//        String employeeNo = "";
//        CtrEmp instance = new CtrEmp();
//        Employee expResult = null;
//        Employee result = instance.findEmployee(employeeNo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAllEmployee method, of class CtrEmp.
     */
//    @Test
//    public void testGetAllEmployee()
//    {
//        System.out.println("getAllEmployee");
//        CtrEmp instance = new CtrEmp();
//        ArrayList expResult = null;
//        ArrayList result = instance.getAllEmployee();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insert method, of class CtrEmp.
     */
    @Test
    public void testInsert()
    {
        System.out.println("insert");
        String managerNo = "1";
        String jobTitle = "Direktør";
        String ssn = "123456-1234";
        String firstName = "Mjød";
        String middleName = "Von";
        String lastName = "Hansen";
        String address = "Dannebrogsgade 63";
        int locationID = 1;
        int phoneNo = 98674033;
        String email = "Von@dannebrogsgade.dk";
        String password = "123456";
        CtrEmp instance = new CtrEmp();
        instance.insert( managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Employee result = instance.findEmployee("Mjød123456");
        assertEquals("1", result.getManagerNo());
        assertEquals("Direktør", result.getJobTitle());
        assertEquals("123456-1234", result.getSsn());
        assertEquals("Mjød", result.getFirstName());
        assertEquals("Von", result.getMiddleName());
        assertEquals("Hansen", result.getLastName());
        assertEquals("Dannebrogsgade 63", result.getAddress());
        assertEquals(1, result.getLocationID());
        assertEquals(98674033, result.getPhoneNo());
        assertEquals("Von@dannebrogsgade.dk", result.getEmail());
        assertEquals("123456", result.getPassword());
        


    }

    /**
     * Test of updateEmp method, of class CtrEmp.
     */
    @Test
    public void testUpdateEmp()
    {
        System.out.println("updateEmp");
        String employeeNo = "";
        String managerNo = "";
        String jobTitle = "";
        String ssn = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String address = "";
        int locationID = 0;
        int phoneNo = 0;
        String email = "";
        String password = "";
        CtrEmp instance = new CtrEmp();
        instance.updateEmp(employeeNo, managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmp method, of class CtrEmp.
     */
    @Test
    public void testDeleteEmp()
    {   System.out.println("insert");
        String managerNo = "1";
        String jobTitle = "Direktør";
        String ssn = "123456789";
        String firstName = "Mjød";
        String middleName = "Von";
        String lastName = "Hansen";
        String address = "Dannebrogsgade 63";
        int locationID = 1;
        int phoneNo = 98674033;
        String email = "Von@dannebrogsgade.dk";
        String password = "123456";
        CtrEmp instance = new CtrEmp();
        instance.insert( managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        System.out.println("deleteEmp");
        instance.deleteEmp("Mjød123456");
        Employee result = instance.findEmployee("Mjød123456");
        assertNull(null, result.getEmployeeNo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}