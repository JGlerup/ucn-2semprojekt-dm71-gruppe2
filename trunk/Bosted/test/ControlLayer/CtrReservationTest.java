/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import java.util.ArrayList;
import ExceptionsPack.NullValueException;
import ModelLayer.Car;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Reservation;
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
public class CtrReservationTest
{

    public CtrReservationTest()
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
    public void testInsertReservation()
    {
        System.out.println("insertReservation");
        Car car = new Car();
        int carID = 1;
        CtrCar ctrCar = new CtrCar();
        car = ctrCar.findCarByID(carID);
        Employee emp = new Employee();
        int empID = 2;
        CtrEmp ctrEmp = new CtrEmp();
        emp = ctrEmp.findEmployeeByID(empID);
        Client cli = new Client();
        int cliID = 3;
        CtrClient ctrCli = new CtrClient();
        cli = ctrCli.findClientByID(cliID);
        String date = "2011-11-11";
        CtrReservation instance = new CtrReservation();

        try
        {
            instance.insertReservation(car, emp, cli, date);
            //TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
            Reservation result = new Reservation();
            try
            {
                result = instance.findReservation(carID, date);
                assertEquals(carID, result.getCar().getCarID());
                assertEquals(empID, result.getEmployee().getEmployeeID());
                assertEquals(cliID, result.getClient().getClientID());
                assertEquals(date, result.getStartDate());
            }//end try
            catch(NullValueException e)
            {
                System.out.println(e.getMessage());
            }//end catch
        }//end try
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
    }//end test insert

    @Test
    public void testDeleteReservation()
    {
        System.out.println("deleteReservation");
        int carID = 1;
        String date = "2011-11-11";
        CtrReservation instance = new CtrReservation();
        Reservation resObj = new Reservation();
        try
        {
            resObj = instance.findReservation(carID, date);
            instance.deleteReservation(resObj);
            Reservation result = new Reservation();
            try
            {
                result = instance.findReservation(carID, date);
            }//end try
            catch(NullValueException e)
            {
                System.out.println(e.getMessage());
            }//end catch
            assertEquals(0,result.getReservationID());
        }
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
    }// end test delete reservation

    @Test
    public void testGetAllReservationsByDate()//String date
    {
        System.out.println("getAllReservationsByDate");
        CtrCar ctrCar = new CtrCar();
        Car car1 = new Car();
        int carID1 = 1;
        car1 = ctrCar.findCarByID(carID1);
        Car car2 = new Car();
        int carID2 = 3;
        car2 = ctrCar.findCarByID(carID2);

        CtrEmp ctrEmp = new CtrEmp();
        Employee emp1 = new Employee();
        int empID1 = 2;
        emp1 = ctrEmp.findEmployeeByID(empID1);
        Employee emp2 = new Employee();
        int empID2 = 1;
        emp2 = ctrEmp.findEmployeeByID(empID2);

        CtrClient ctrCli = new CtrClient();
        Client cli1 = new Client();
        int cliID1 = 3;
        cli1 = ctrCli.findClientByID(cliID1);
        Client cli2 = new Client();
        int cliID2 = 2;
        cli2 = ctrCli.findClientByID(cliID2);

        String date = "2011-12-24";
        CtrReservation instance = new CtrReservation();
        Reservation resObj1 = new Reservation();
        Reservation resObj2 = new Reservation();
        ArrayList<Reservation> result = new ArrayList();
        try
        {
            instance.insertReservation(car1, emp1, cli1, date);
        }//end try
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            instance.insertReservation(car2, emp2, cli2, date);
        }//end try
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            result = instance.getAllReservationsByDate(date);
            assertEquals(2, result.size());
            assertEquals(carID1, result.get(0).getCar().getCarID());
            assertEquals(empID1, result.get(0).getEmployee().getEmployeeID());
            assertEquals(cliID1, result.get(0).getClient().getClientID());
            assertEquals(date, result.get(0).getStartDate());
            assertEquals(carID2, result.get(1).getCar().getCarID());
            assertEquals(empID2, result.get(1).getEmployee().getEmployeeID());
            assertEquals(cliID2, result.get(1).getClient().getClientID());
            assertEquals(date, result.get(1).getStartDate());
        }//end try
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            resObj1 = instance.findReservation(carID1, date);
            instance.deleteReservation(resObj1);
        }
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            resObj2 = instance.findReservation(carID2, date);
            instance.deleteReservation(resObj2);
        }
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
    }

    @Test
    public void testFindListOfAvailableCarsByDate()
    {
        System.out.println("getAllReservationsByDate");
        CtrCar ctrCar = new CtrCar();
        Car car1 = new Car();
        int carID1 = 1;
        car1 = ctrCar.findCarByID(carID1);
        Car car2 = new Car();
        int carID2 = 2;
        car2 = ctrCar.findCarByID(carID2);
        Car car3 = new Car();
        int carID3 = 3;
        car3 = ctrCar.findCarByID(carID3);
        Car car4 = new Car();
        int carID4 = 4;
        car4 = ctrCar.findCarByID(carID4);
        Car car5 = new Car();
        int carID5 = 5;
        car5 = ctrCar.findCarByID(carID5);

        CtrEmp ctrEmp = new CtrEmp();
        Employee emp1 = new Employee();
        int empID1 = 1;
        emp1 = ctrEmp.findEmployeeByID(empID1);
        Employee emp2 = new Employee();
        int empID2 = 2;
        emp2 = ctrEmp.findEmployeeByID(empID2);

        CtrClient ctrCli = new CtrClient();
        Client cli1 = new Client();
        int cliID1 = 1;
        cli1 = ctrCli.findClientByID(cliID1);
        Client cli2 = new Client();
        int cliID2 = 2;
        cli2 = ctrCli.findClientByID(cliID2);

        String date = "2011-12-24";

        CtrReservation instance = new CtrReservation();
        Reservation resObj1 = new Reservation();
        Reservation resObj2 = new Reservation();
        ArrayList<Car> result = new ArrayList();

        try
        {
            instance.insertReservation(car1, emp1, cli1, date);
        }//end try
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            instance.insertReservation(car2, emp2, cli2, date);
        }//end try
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch

        result = instance.findListOfAvailableCarsByDate(date);
        assertEquals(3, result.size());
        assertEquals(carID3, result.get(0).getCarID());
        assertEquals(carID4, result.get(1).getCarID());
        assertEquals(carID5, result.get(2).getCarID());
        
        try
        {
            resObj1 = instance.findReservation(carID1, date);
            instance.deleteReservation(resObj1);
        }
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch
        try
        {
            resObj2 = instance.findReservation(carID2, date);
            instance.deleteReservation(resObj2);
        }
        catch(NullValueException e)
        {
            System.out.println(e.getMessage());
        }//end catch

    }
}