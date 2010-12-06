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
    private int errorHandlingMedicineNo;

    public ErrorHandlingMedicine() {
    }

    public ErrorHandlingMedicine(Date date, String episode, int quantity) {
        this.date = date;
        this.episode = episode;
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public String getEpisode() {
        return episode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getErrorHandlingMedicineNo() {
        return errorHandlingMedicineNo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setErrorHandlingMedicineNo(int errorHandlingMedicineNo) {
        this.errorHandlingMedicineNo = errorHandlingMedicineNo;
    }
}
