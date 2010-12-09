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
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrEmpTest
{

    public CtrEmpTest() 
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
        instance.insert(managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
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
        instance.deleteEmp("Mjød123456");
        
    }

    /**
     * Test of updateEmp method, of class CtrEmp.
     */
    @Test
    public void testUpdateEmp()
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
        instance.insert(managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);


        System.out.println("updateEmp");
        String employeeNoNew = "2";
        managerNo = "2";
        jobTitle = "Landstryger";
        ssn = "123450-7777";
        firstName = "Jacob";
        middleName = "Jul";
        lastName = "Glerup";
        address = "Lærkevej 9";
        locationID = 1;
        phoneNo = 98765443;
        email = "Glerup9@gmail.com";
        password = "123456789";
        instance.updateEmp("Mjød123456", employeeNoNew,  managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        Employee result = instance.findEmployee("2");
        assertEquals("2", result.getManagerNo());
        assertEquals("Landstryger", result.getJobTitle());
        assertEquals("123456-7777", result.getSsn());
        assertEquals("Jacob", result.getFirstName());
        assertEquals("Jul", result.getMiddleName());
        assertEquals("Glerup", result.getLastName());
        assertEquals("Lærkevej 9", result.getAddress());
        assertEquals(1, result.getLocationID());
        assertEquals(98765443, result.getPhoneNo());
        assertEquals("Gleup9@gmail.com", result.getEmail());
        assertEquals("123456789", result.getPassword());
        instance.deleteEmp(employeeNoNew);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        instance.insert(managerNo, jobTitle, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        System.out.println("deleteEmp");
        instance.deleteEmp("Mjød123456");
        Employee result = instance.findEmployee("Mjød123456");
        assertNull(null, result.getEmployeeNo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}