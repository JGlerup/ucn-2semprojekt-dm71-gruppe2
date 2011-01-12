package ModelLayer;

import java.util.ArrayList;



/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class Employee
{

    private int employeeID;
    private ArrayList<Client> clientList;
    private String employeeNo;
    private String password;
    private String managerNo;
    private String jobTitle;
    private String crudClient;
    private String crudEmployee;
    private String crudMedicine;
    private String crudCar;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int locationID;
    private int phoneNo;
    private String email;
    private String ssn;
    private String inUse;
    private String startDate;
    private String stopDate;

    public Employee()
    {
     
    }

    public Employee(int employeeID, ArrayList<Client> clientList, String password, String managerNo, String jobTitle, String crud_Client, String crud_Employee, String crud_Medicine, String crud_Car, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email, String ssn)
    {
        this.clientList = clientList;
        this.employeeID = employeeID;
        this.employeeNo = null;
        this.password = password;
        this.managerNo = managerNo;
        this.jobTitle = jobTitle;
        this.crudClient = crud_Client;
        this.crudEmployee = crud_Employee;
        this.crudMedicine = crud_Medicine;
        this.crudCar = crud_Car;
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

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }
    
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCrudCar()
    {
        return crudCar;
    }

    public void setCrudCar(String crud_car)
    {
        this.crudCar = crud_car;
    }

    public String getCrudClient()
    {
        return crudClient;
    }

    public void setCrudClient(String crudClient)
    {
        this.crudClient = crudClient;
    }

    public String getCrudEmployee()
    {
        return crudEmployee;
    }

    public void setCrudEmployee(String crudEmployee)
    {
        this.crudEmployee = crudEmployee;
    }

    public String getCrudMedicine()
    {
        return crudMedicine;
    }

    public void setCrudMedicine(String crudMedicine)
    {
        this.crudMedicine = crudMedicine;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getEmployeeNo()
    {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo)
    {
        this.employeeNo = employeeNo;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getInUse()
    {
        return inUse;
    }

    public void setInUse(String inUse)
    {
        this.inUse = inUse;
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

    public int getLocationID()
    {
        return locationID;
    }

    public void setLocationID(int locationID)
    {
        this.locationID = locationID;
    }

    public String getManagerNo()
    {
        return managerNo;
    }

    public void setManagerNo(String managerNo)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setThisStartDate() {
        ToDaysDate toDaysDate = new ToDaysDate();
        startDate = toDaysDate.toString();
    }

    public void setNewStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getStopDate()
    {
        return stopDate;
    }

    public void setStopDate(String stopDate)
    {
        this.stopDate = stopDate;
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

    public String toString()
    {
        return firstName + " " + middleName + " " + lastName;
    }

}

   
