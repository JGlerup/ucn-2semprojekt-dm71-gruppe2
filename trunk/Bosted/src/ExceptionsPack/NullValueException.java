/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExceptionsPack;

/**
 *
 * @author Erik
 */
public class NullValueException extends Exception
{
    
	private String text;

	public NullValueException(String text)
	{
		this.text = text;
	}

}
