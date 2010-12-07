package ModelLayer;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Employee
{

    private int employeeID;
    private String employeeNo;
    private String password;
    private int managerNo;
    private String jobTitle;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int locationID;
    private int phoneNo;
    private String email;
    private String ssn;

    public Employee(int employeeID, String password, int managerNo, String jobTitle, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String ssn)
    {
        this.employeeID = employeeID;
        this.employeeNo = null;
        this.password = password;
        this.managerNo = managerNo;
        this.jobTitle = jobTitle;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.locationID = locationID;
        this.phoneNo = phoneNo;
        this.email = email;
        this.ssn = ssn;
        createEmployeeNo();
    }


    public Employee()
    {

    }

     public int getEmployeeID()
    {
        return employeeID;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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

    public int getLocationID()
    {
        return locationID;
    }

    public void setLocationID(int locationID)
    {
        this.locationID = locationID;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public String createEmployeeNo()
    {
        String createdEmployeeNo = "";

        if(firstName.length() > 5)
        {
            createdEmployeeNo = firstName.substring(0,5) + ssn.substring(0, 6);
        }
        else
        {
            createdEmployeeNo = firstName + ssn.substring(0, 6);
        }
        
        setEmployeeNo(createdEmployeeNo);
        return createdEmployeeNo;
    }

}

   
