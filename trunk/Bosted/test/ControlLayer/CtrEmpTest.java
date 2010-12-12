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
        String crudClient = "Yes";
        String crudEmployee = "Yes";
        String crudMedicine = "Yes";
        String crudCar = "Yes";
        String ssn = "123456-1234";
        String firstName = "Mjød";
        String middleName = "Von";
        String lastName = "Hansen";
        String address = "Dannebrogsgade 63";
        int locationID = 1;
        int phoneNo = 98674033;
        String email = "Von@dannebrogsgade.dk";
        String password = "123456";
        String inUse = "Yes";
        CtrEmp instance = new CtrEmp();
        try{
        instance.insert(managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password, inUse);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Employee result = instance.findEmployee("Mjød123456");
        assertEquals("1", result.getManagerNo());
        assertEquals("Direktør", result.getJobTitle());
        assertEquals("Yes", result.getCrudClient());
        assertEquals("Yes", result.getCrudEmployee());
        assertEquals("Yes", result.getCrudMedicine());
        assertEquals("Yes", result.getCrudCar());
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
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Test of updateEmp method, of class CtrEmp.
     */
    @Test
    public void testUpdateEmp()
    {
        System.out.println("insert");
        String managerNo = "2";
        String jobTitle = "Direktør";
        String crudClient = "Yes";
        String crudEmployee = "Yes";
        String crudMedicine = "Yes";
        String crudCar = "Yes";
        String ssn = "12345678";
        String firstName = "Karl";
        String middleName = "Von";
        String lastName = "Hansen";
        String address = "Dannebrogsgade 63";
        int locationID = 1;
        int phoneNo = 98674033;
        String email = "Von@dannebrogsgade.dk";
        String password = "123456";
        String inUse = "Yes";
        CtrEmp instance = new CtrEmp();
        try{
        instance.insert(managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password, inUse);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("updateEmp");
        String employeeNoNew = "uhiu8";
        managerNo = "2";
        jobTitle = "Landstryger";
        crudClient = "No";
        crudEmployee = "No";
        crudMedicine = "No";
        crudCar = "No";
        ssn = "123450-8888";
        firstName = "Jacob";
        middleName = "Jul";
        lastName = "Glerup";
        address = "Lærkevej 9";
        locationID = 1;
        phoneNo = 98765443;
        email = "Glerup9@gmail.com";
        password = "123456789";
        instance.updateEmp("Karl123456", employeeNoNew,  managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password);
        Employee result = instance.findEmployee("uhiu8");
        assertEquals("2", result.getManagerNo());
        assertEquals("Landstryger", result.getJobTitle());
        assertEquals("No", result.getCrudClient());
        assertEquals("No", result.getCrudEmployee());
        assertEquals("No", result.getCrudMedicine());
        assertEquals("No", result.getCrudCar());
        assertEquals("123450-8888", result.getSsn());
        assertEquals("Jacob", result.getFirstName());
        assertEquals("Jul", result.getMiddleName());
        assertEquals("Glerup", result.getLastName());
        assertEquals("Lærkevej 9", result.getAddress());
        assertEquals(1, result.getLocationID());
        assertEquals(98765443, result.getPhoneNo());
        assertEquals("Glerup9@gmail.com", result.getEmail());
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
        String crudClient = "Yes";
        String crudEmployee = "Yes";
        String crudMedicine = "Yes";
        String crudCar = "Yes";
        String ssn = "123456789";
        String firstName = "Mjød";
        String middleName = "Von";
        String lastName = "Hansen";
        String address = "Dannebrogsgade 63";
        int locationID = 1;
        int phoneNo = 98674033;
        String email = "Von@dannebrogsgade.dk";
        String password = "123456";
        String inUse = "Yes";
        CtrEmp instance = new CtrEmp();
        try{
        instance.insert(managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, password, inUse);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("deleteEmp");
        instance.deleteEmp("Mjød123456");
        Employee result = instance.findEmployee("Mjød123456");
        assertNull(null, result.getEmployeeNo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}