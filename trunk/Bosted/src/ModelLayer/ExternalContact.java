/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Erik M. Gravesen
 */
public class ExternalContact {

    private int externalContactID;
    private String cbr;
    private String occupation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int locationID;
    private int phoneNo;
    private String email;

    public ExternalContact() {
    }

    public ExternalContact(int externalContactID, String cbr, String occupation, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email) {
        this.externalContactID = externalContactID;
        this.cbr = cbr;
        this.occupation = occupation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.locationID = locationID;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCbr() {
        return cbr;
    }

    public void setCbr(String cbr) {
        this.cbr = cbr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExternalContactID() {
        return externalContactID;
    }

    public void setExternalContactID(int externalContactID) {
        this.externalContactID = externalContactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String toString()
    {
        return firstName + " " + middleName + " " + lastName;
    }
}
