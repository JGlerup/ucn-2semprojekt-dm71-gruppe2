/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.Employee;
import ModelLayer.Todo;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public interface IFDBTodo {

    public Todo findTodo(int todoID, boolean retrieveAssociation);
    //find one Todo having the TodoNo

    public ArrayList<Todo> getAllTodo(boolean retriveAssociation);
    //find one Todo having the fname

    public int insertTodo(Todo t);
    //update information about an Todo

    public int updateTodo(Todo t);
    //update information about an Todo

    public int deleteTodo(int todoID);
    //delete a Todo

    public Todo findLatestTodo();
}
