/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.ErrorHandlingMedicine;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBErrorHandMed
{
     public ErrorHandlingMedicine findErrorHandlingMedicine(int errorHandlingMedicineNo, boolean retrieveAssociation);
    //find one errorHandlingMedicine having the errorHandlingMedicineNo

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicines(boolean retriveAssociation);
    //find one errorHandlingMedicine having the errorHandlingMedicine????????????

    public int insertErrorHandlingMedicine(ErrorHandlingMedicine ehm);
    //update information about an errorHandlingMedicine

    public int updateErrorHandlingMedicine(ErrorHandlingMedicine ehm);
    //update information about an errorHandlingMedicine

    public int deleteErrorHandlingMedicine(int ErrorHandlingMedicineNo);
    //delete an errorHandlingMedicine
}
