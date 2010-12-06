/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class ErrorHandlingMedicine {

    private Date date;
    private String episode;
    private int quantity;
    private int errorHandlingMedicineID;

    public ErrorHandlingMedicine() {
    }

    public ErrorHandlingMedicine(Date date, String episode, int quantity, int errorHandlingMedicineID) {
        this.date = date;
        this.episode = episode;
        this.quantity = quantity;
        this.errorHandlingMedicineID = errorHandlingMedicineID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public int getErrorHandlingMedicineID() {
        return errorHandlingMedicineID;
    }

    public void setErrorHandlingMedicineID(int errorHandlingMedicineID) {
        this.errorHandlingMedicineID = errorHandlingMedicineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
