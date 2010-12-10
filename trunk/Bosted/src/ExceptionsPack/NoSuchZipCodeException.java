/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExceptionsPack;

/**
 *
 * @author Erik
 */
public class NoSuchZipCodeException extends Exception {
    private String text;

    public NoSuchZipCodeException(String text)
    {
        this.text = text;
    }
}
