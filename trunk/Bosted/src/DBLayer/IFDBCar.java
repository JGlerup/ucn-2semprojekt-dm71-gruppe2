package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBCar
{
    public Car findCarByID(int carID, boolean retrieveAssociation);
    //find one car having the carID

    public Car findCar(String regNo, boolean retrieveAssociation);
    //find one car having the regNo

    public ArrayList<Car> getAllCars(boolean retriveAssociation);
    //get all cars

   public int insertCar(Car c);
    //update information about an car

    public int updateCar(Car c);
    //update information about an car

    public int deleteCar(String regNo);
    //delete a car

}
