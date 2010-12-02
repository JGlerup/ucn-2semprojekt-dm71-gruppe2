/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;
import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class CtrMedi {

    public CtrMedi() {
    }

    public ArrayList getAllMedicine() {
        IFDBMedi dbmedi = new DBMedicine();
        ArrayList allMedi = new ArrayList<Medicine>();
        allMedi = dbmedi.getAllMedicine(false);
        return allMedi;
    }

    public void insert(String name, String description, Date date, int quantity) {
        IFDBMedi DBMedi = new DBMedicine();
        Medicine mediObj = new Medicine();
        mediObj.setName(name);
        mediObj.setDescription(description);
        mediObj.setDate(date);
        mediObj.setQuantity(quantity);

    }
}
