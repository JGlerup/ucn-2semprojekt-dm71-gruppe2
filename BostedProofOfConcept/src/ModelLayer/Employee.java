/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelLayer;

/**
 *
 * @author Erik
 */
public class Employee {

    private String fname;
    private String lname;
    private String initial;
    private String adresse;
    private int tlfnr;
    private String email;

    public Employee() {

    }

    public Employee(String fname, String lname, String initial, String adresse, int tlfnr, String email) {
        this.fname = fname;
        this.lname = lname;
        this.initial = initial;
        this.adresse = adresse;
        this.tlfnr = tlfnr;
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getInitial() {
        return initial;
    }

    public String getLname() {
        return lname;
    }

    public int getTlfnr() {
        return tlfnr;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setTlfnr(int tlfnr) {
        this.tlfnr = tlfnr;
    }
}
