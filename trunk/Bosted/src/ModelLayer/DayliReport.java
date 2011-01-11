/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class DayliReport
{

    private int dailyReportID;
    private int clientID;
    private String date;
    private int employeeID;
    private String text;

    public DayliReport()
    {
    }

    public DayliReport(int clientID, String date, int employeeID, String text) {
        this.clientID = clientID;
        this.date = date;
        this.employeeID = employeeID;
        this.text = text;
    }

    public int getDailyReportID() {
        return dailyReportID;
    }

    public void setDailyReportID(int dailyReportID) {
        this.dailyReportID = dailyReportID;
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

    public void setThisDate() {
        ToDaysDate toDaysDate = new ToDaysDate();
        date = toDaysDate.toString();
    }

    public void setNewDate(String newDate) {
        date = newDate;
    }

    public String toString()
    {
        return date;
    }
}
