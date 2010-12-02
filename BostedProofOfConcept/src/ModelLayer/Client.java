/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class Client {

    private int clientNo;
    private String description;
    private String interests;
    private String health;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int zipCode;
    private String city;
    private int phoneNo;
    private String email;
    private String ssn;

    public Client(int clientNo, String description, String interests, String health, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email, String ssn)
    {
        this.clientNo = clientNo;
        this.description = description;
        this.interests = interests;
        this.health = health;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.email = email;
        this.ssn = ssn;
    }



    public Client()
    {

    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getClientNo()
    {
        return clientNo;
    }

    public void setClientNo(int clientNo)
    {
        this.clientNo = clientNo;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getHealth()
    {
        return health;
    }

    public void setHealth(String health)
    {
        this.health = health;
    }

    public String getInterests()
    {
        return interests;
    }

    public void setInterests(String interests)
    {
        this.interests = interests;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public int getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }






   
   

}