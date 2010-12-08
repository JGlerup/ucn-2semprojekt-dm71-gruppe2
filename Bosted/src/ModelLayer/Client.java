package ModelLayer;

import java.util.Date;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Client {

    private int clientID;
    private String clientNo;
    private int locationID;
    private String description;
    private String interests;
    private String health;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int phoneNo;
    private String email;
    private String ssn;
    private String startDate;
    private String inUse;
    private String stopDate;

    public Client() {
    }

    public Client(int clientID, int locationID, String description, String interests, String health, String firstName, String middleName, String lastName, String address, int phoneNo, String email, String ssn) {
        this.clientID = clientID;
        this.clientNo = null;
        this.locationID = locationID;
        this.description = description;
        this.interests = interests;
        this.health = health;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.ssn = ssn;
        createClientNo();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String createClientNo() {
        String createdClientNo = "";

        if (firstName.length() > 5) {
            createdClientNo = firstName.substring(0, 5) + ssn.substring(0, 6);
        } else {
            createdClientNo = firstName + ssn.substring(0, 6);
        }

        setClientNo(createdClientNo);
        return createdClientNo;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public String getStartDate() {
        return startDate.toString();
    }

    public void setStartDate() {
        ToDaysDate toDaysDate = new ToDaysDate();
        startDate = toDaysDate.toString();
    }

    public void setNewStartDate(String newDate) {
        startDate = newDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }
}
