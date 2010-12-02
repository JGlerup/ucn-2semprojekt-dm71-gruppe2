/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class Client extends Ssn {

    private int clientNo;
    private String description;
    private String interests;
    private String health;


public Client(String ssn, int clientNo, String description, String interests, String health, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email)
{
    super(ssn, firstName, middleName, lastName, address, zipCode, city, phoneNo, email);
    this.clientNo = clientNo;
    this.description = description;
    this.interests = interests;
    this.health = health;
}

    public Client()
    {

    }





    public int getClientNo()
    {
        return clientNo;
    }

    public String getDescription()
    {
        return description;
    }

    public String getHealth()
    {
        return health;
    }

    public String getInterests()
    {
        return interests;
    }

    public void setClientNo(int clientNo)
    {
        this.clientNo = clientNo;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setHealth(String health)
    {
        this.health = health;
    }

    public void setInterests(String interests)
    {
        this.interests = interests;
    }

   

}