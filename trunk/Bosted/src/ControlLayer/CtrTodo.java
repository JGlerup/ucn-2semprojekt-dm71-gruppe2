/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import DBLayer.DBClient;
import DBLayer.DBEmployee;
import DBLayer.DBTodo;
import DBLayer.IFDBClient;
import DBLayer.IFDBEmp;
import DBLayer.IFDBTodo;
import ExceptionsPack.NullValueException;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Todo;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public class CtrTodo {

    public Todo findTodoByID(int todoID) {
        IFDBTodo dbTodo = new DBTodo();
        return dbTodo.findTodo(todoID, true);
    }

    public ArrayList getAllTodo() {
        IFDBTodo dbTodo = new DBTodo();
        ArrayList todoList = new ArrayList<Todo>();
        todoList = dbTodo.getAllTodo(false);
        return todoList;
    }

    public void insertTodo(int employeeID, String date, String text) throws NullValueException {
        if (date != null && !text.trim().equals("")) {
            IFDBTodo dbTodo = new DBTodo();
            Todo tObj = new Todo();
            tObj.setEmployeeID(employeeID);
            tObj.setDate(date);
            tObj.setText(text);
            dbTodo.insertTodo(tObj);
        }
        else{
            throw new NullValueException("Fejl: Tjek om alle felter er udfyldt");
        }
    }

    public void updateTodo(int todoID, int employeeID, String date, String text) throws NullValueException  {
        if (!date.trim().equals("") && !text.trim().equals("")) {
            IFDBTodo dbTodo = new DBTodo();
            Todo tObj = new Todo();
            tObj.setTodoID(todoID);
            tObj.setEmployeeID(employeeID);
            tObj.setDate(date);
            tObj.setText(text);
            dbTodo.updateTodo(tObj);
                }
        else{
            throw new NullValueException("Fejl: Tjek om alle felter er udfyldt");
        }
    }

    public void deleteTodo(int todoID) {
        IFDBTodo dbTodo = new DBTodo();
        dbTodo.deleteTodo(todoID);
    }

    public Todo findLatestTodo() {
        IFDBTodo dbTodo = new DBTodo();
        Todo tObj = new Todo();
        tObj = dbTodo.findLatestTodo();
        return tObj;
    }
}
