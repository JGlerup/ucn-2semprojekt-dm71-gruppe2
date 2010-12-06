package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Employee {

    private int employeeID;
    private String employeeNo;
    private String password;
    private int managerNo;
    private String jobTitle;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int zipCode;
    private String city;
    private int phoneNo;
    private String email;
    private String ssn;

    public Employee(int employeeID, String employeeNo, String password, int managerNo, String jobTitle, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email, String ssn)
    {
        this.employeeID = employeeID;
        this.employeeNo = employeeNo;
        this.password = password;
        this.managerNo = managerNo;
        this.jobTitle = jobTitle;
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

    public Employee()
    {

    }

     public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

   public String getEmployeeNo()
   {
        return employeeNo;
   }

    public void setEmployeeNo(String employeeNo)
    {
        this.employeeNo = employeeNo;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getManagerNo()
    {
        return managerNo;
    }

    public void setManagerNo(int managerNo)
    {
        this.managerNo = managerNo;
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

   
