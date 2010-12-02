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
   }

public Person()
{

}


public Person(String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email)
{
    this.firstName = firstName;
    this.middleName = middelName;
    this.lastName = lastName;
    this.address = address;
    this.zipCode = zipCode;
    this.city = city;
    this.phoneNo = phoneNo;
    this.email = email;
}