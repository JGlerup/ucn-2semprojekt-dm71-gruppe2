/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;

/**
 *
 * @author Erik
 */
public class CtrEmp {

    public CtrEmp() {
    }

    public ArrayList findAllEmployee() {
        IFDBEmp dbEmp = new DBEmployee();
        ArrayList allEmp = new ArrayList<Employee>();
        allEmp = dbEmp.getAllEmployees(false);
        return allEmp;
    }

    public Employee findByFname(String fname) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeFname(fname, true);
    }

    public Employee findByLname(String lname) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeLname(lname, true);
    }

    public Employee findBySsn(String ssn) {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeSsn(ssn, true);
    }

    public int updateEmp(String fname, String lname, String ssn) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee emp = new Employee();
        emp.setSsn(ssn);
        emp.setFname(fname);
        emp.setLname(lname);
        return dbEmp.updateEmployee(emp);


    }

    public void insertNew(String fname, String lname) {
        IFDBEmp dbEmp = new DBEmployee();
        Employee empObj = new Employee();
        empObj.setFname(fname);
        empObj.setLname(lname);
        dbEmp.insertEmployee(empObj);
    }
}
