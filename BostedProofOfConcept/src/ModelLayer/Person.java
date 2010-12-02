/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int zipCode;
    private String city;
    private int phoneNo;
    private String email;
   

public Person()
{

}


public Person(String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email)
{
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.zipCode = zipCode;
    this.city = city;
    this.phoneNo = phoneNo;
    this.email = email;

}

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public int getPhoneNo()
    {
        return phoneNo;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }


    
}


