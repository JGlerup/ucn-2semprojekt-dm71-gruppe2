/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExceptionsPack;

/**
 *
 * @author Glerup
 */
public class NoManagerNumberErrorHandling extends Exception {

    private String text;

    public NoManagerNumberErrorHandling(String text)
    {
        this.text = text;
    }

}
