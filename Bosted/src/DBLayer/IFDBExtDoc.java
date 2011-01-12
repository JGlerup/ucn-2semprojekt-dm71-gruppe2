/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.ExternalDocument;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */
public interface IFDBExtDoc {

    public ExternalDocument findExternalDocument(int externalDocumentID, boolean retrieveAssociation);
    //find one ExternalDocument having the ID of the external document

    public ArrayList<ExternalDocument> getAllExternalDocuments(boolean retriveAssociation);
    //show all external documents

    public int insertExternalDocument(ExternalDocument extDoc);
    //insert an external document into database

    public int updateExternalDocument(ExternalDocument extDoc);
    //update information about an external document

    public int deleteExternalDocument(int externalDocumentID);
    //delete an external document
}
