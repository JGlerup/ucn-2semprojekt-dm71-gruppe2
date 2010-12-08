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
public class Medicine
{

    private String name;
    private String description;
    private String date;
    private int quantity;



public Medicine()
{

}


public Medicine(String name, String description, int quantity)
{

    this.name = name;
    this.description = description;
    this.date = "";
    this.quantity = quantity;
    setThisDate();

}

    public String getDate()
    {
        return date;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setThisDate()
    {
        ToDaysDate toDaysDate = new ToDaysDate();
        date = toDaysDate.toString();
    }
}



