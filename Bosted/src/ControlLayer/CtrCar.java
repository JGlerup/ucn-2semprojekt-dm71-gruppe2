package ControlLayer;

import DBLayer.DBCar;
import DBLayer.IFDBCar;
import ModelLayer.Car;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class CtrCar {

    public CtrCar() {
    }

    public Car findCarByRegNo(String regNo) {
        IFDBCar dbCar = new DBCar();
        return dbCar.findCar(regNo, true);
    }

    public ArrayList<Car> getAllCars() {
        IFDBCar dbCar = new DBCar();
        ArrayList<Car> allCar = new ArrayList<Car>();
        allCar = dbCar.getAllCars(false);
        return allCar;
    }

    public void insertCar(String regNo, String description) {
            IFDBCar dbCar = new DBCar();
            Car cObj = new Car();
            cObj.setRegNo(regNo);
            cObj.setDescription(description);
            dbCar.insertCar(cObj);

    }

    public void updateCar(String regNo, String description) {
   
            int carID = findCarByRegNo(regNo).getCarID();
            IFDBCar dbCar = new DBCar();
            Car cObj = new Car();
            cObj.setCarID(carID);
            cObj.setRegNo(regNo);
            cObj.setDescription(description);
            dbCar.updateCar(cObj);
    }

    public void deleteCar(String regNo) {
        IFDBCar dbCar = new DBCar();
        dbCar.deleteCar(regNo);
    }
}
