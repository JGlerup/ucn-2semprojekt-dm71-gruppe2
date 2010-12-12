/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;

import ModelLayer.ExternalContact;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public interface IFDBExtCon {

    public ExternalContact findExternalContact(int externalContactID, boolean retrieveAssociation);
    //find one ExternalContact having the employeeNo

    public ArrayList<ExternalContact> getAllExternalContacts(boolean retriveAssociation);
    //show all employees

    public int insertExternalContact(ExternalContact extCon);
    //insert an ExternalContact into database

    public int updateExternalContact(ExternalContact extCon);
    //update information about an ExternalContact

    public int deleteExternalContact(int externalContactID);
    //delete an ExternalContact
}
