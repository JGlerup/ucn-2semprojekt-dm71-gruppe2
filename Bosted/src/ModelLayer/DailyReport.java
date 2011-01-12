/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class DailyReport
{

    private int dailyReportID;
    private Client client;
    private String date;
    private Employee employee;
    private String text;

    public DailyReport()
    {
    }

    public DailyReport(Client client, String date, Employee employee, String text) {
        this.client = client;
        this.date = date;
        this.employee = employee;
        this.text = text;
    }

    public int getDailyReportID() {
        return dailyReportID;
    }

    public void setDailyReportID(int dailyReportID) {
        this.dailyReportID = dailyReportID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
