/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.*;
import java.util.ArrayList;
/**
 *
 * @author Glerup
 */
public interface IFDBCar {

    public Car findCar(String regNo, boolean retrieveAssociation);
    //find one car having the regNo

    public ArrayList<Car> getAllCars(boolean retriveAssociation);
    //find one car having the regNo

    public int insertCar(Car c);
    //update information about an car

    public int updateCar(Car c);
    //update information about an car

    public int deleteCar(String regNo);
    //delete a car

}
