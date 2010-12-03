/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Kristian Byrialsen
 */
public class Ssn extends Person {

    private String ssn;


public Ssn(String ssn, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email)
{
    super(firstName, middleName, lastName, address, zipCode, city, phoneNo, email);
    this.ssn = ssn;
}

public Ssn()
 {

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
