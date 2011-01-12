/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Erik M. Gravesen
 */
public class Todo {

    private int todoID;
    private Employee employee;
    private String date;
    private String text;

    public Todo() {
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

    public int getTodoID() {
        return todoID;
    }

    public void setTodoID(int todoID) {
        this.todoID = todoID;
    }

    public void setThisDate() {
        ToDaysDate todaysDate = new ToDaysDate();
        date = todaysDate.toString();
    }

    public String toString() {
        return date;
    }
}
