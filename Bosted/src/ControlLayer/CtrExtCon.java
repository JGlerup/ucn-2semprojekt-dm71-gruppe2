/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;

import DBLayer.DBExternalContact;
import DBLayer.IFDBExtCon;
import ExceptionsPack.NullValueException;
import ModelLayer.ExternalContact;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public class CtrExtCon {

    public CtrExtCon() {
    }

    public ExternalContact findExternalContact(int externalContactID) {
        IFDBExtCon dbExtCon = new DBExternalContact();
        return dbExtCon.findExternalContact(externalContactID, true);
    }

    public ArrayList getAllExternalContacts() {
        IFDBExtCon dbExtCon = new DBExternalContact();
        ArrayList<ExternalContact> allExtCon = new ArrayList<ExternalContact>();
        allExtCon = dbExtCon.getAllExternalContacts(false);
        return allExtCon;
    }

    public void insertExternalContact(String cbr, String occupation, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email) throws NullValueException {
        IFDBExtCon dbExtCon = new DBExternalContact();
        ExternalContact extConObj = new ExternalContact();
        extConObj.setCbr(cbr);
        extConObj.setOccupation(occupation);
        extConObj.setFirstName(firstName);
        extConObj.setMiddleName(middleName);
        extConObj.setLastName(lastName);
        extConObj.setAddress(address);
        extConObj.setLocationID(locationID);
        extConObj.setPhoneNo(phoneNo);
        extConObj.setEmail(email);
        dbExtCon.insertExternalContact(extConObj);
    }

    public void updateExternalContact(int externalContactID, String cbr, String occupation, String firstName, String middleName, String lastName, String address, int locationID, int phoneNo, String email) {
        IFDBExtCon dbExtCon = new DBExternalContact();
        ExternalContact extConObj = new ExternalContact();
        extConObj.setExternalContactID(externalContactID);
        extConObj.setCbr(cbr);
        extConObj.setOccupation(occupation);
        extConObj.setFirstName(firstName);
        extConObj.setMiddleName(middleName);
        extConObj.setLastName(lastName);
        extConObj.setAddress(address);
        extConObj.setLocationID(locationID);
        extConObj.setPhoneNo(phoneNo);
        extConObj.setEmail(email);
        dbExtCon.updateExternalContact(extConObj);
    }

    public void deleteClient(int externalContactID) {
        IFDBExtCon dbExtCon = new DBExternalContact();
        dbExtCon.deleteExternalContact(externalContactID);
    }
}
