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
     public ErrorHandlingMedicine findErrorHandlingMedicineByID(int errorHandlingMedicineID, boolean retrieveAssociation);
    //find one errorHandlingMedicine having the errorHandlingMedicineID

    public ErrorHandlingMedicine findErrorHandlingMedicineByEpisode(String episode, boolean retrieveAssociation);
    //find one errorHandlingMedicine having the episode

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicines(boolean retriveAssociation);
    //find all errorHandlingMedicine

    public ArrayList<ErrorHandlingMedicine> getAllErrorHandlingMedicinesByDate(String date, boolean retriveAssociation);
    //find all errorHandlingMedicine on a specific date

    public int insertErrorHandlingMedicine(ErrorHandlingMedicine ehm);
    //update information about an errorHandlingMedicine

    public int updateErrorHandlingMedicine(ErrorHandlingMedicine ehm);
    //update information about an errorHandlingMedicine

    public int deleteErrorHandlingMedicine(int ErrorHandlingMedicineNo);
    //delete an errorHandlingMedicine
}
