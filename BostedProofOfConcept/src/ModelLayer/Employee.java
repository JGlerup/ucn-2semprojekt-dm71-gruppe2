/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Erik
 */
public class Employee extends Ssn {

    private int employeeNo;
    private int managerNo;
    private String jobTitle;
 
    public Employee(String ssn, int employeeNo, int managerNo, String jobTitle, String firstName, String middleName, String lastName, String address, int zipCode, String city, int phoneNo, String email) {
        super(ssn, firstName, middleName, lastName, address, zipCode, city, phoneNo, email);
        this.employeeNo = employeeNo;
        this.managerNo = managerNo;
        this.jobTitle = jobTitle;
       
    }

    public Employee()
    {

    }




    public int getEmployeeNo()
    {
        return employeeNo;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public int getManagerNo()
    {
        return managerNo;
    }

    public void setEmployeeNo(int employeeNo)
    {
        this.employeeNo = employeeNo;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public void setManagerNo(int managerNo)
    {
        this.managerNo = managerNo;
    }
}

   
