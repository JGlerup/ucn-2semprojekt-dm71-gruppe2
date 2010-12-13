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
public class Dailyreport {

private int clientID;
private int employeeID;
private String text;
private String date;



public Dailyreport()
{

}


public Dailyreport(int clientID, int employeeID, String text, String date)
{
    this.clientID = clientID;
    this.employeeID = employeeID;
    this.text = text;
    this.date = date;
}

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }












}


