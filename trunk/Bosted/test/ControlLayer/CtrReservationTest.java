/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

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
            }
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
    }
}