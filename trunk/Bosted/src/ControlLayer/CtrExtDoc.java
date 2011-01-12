/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLayer;

import DBLayer.DBExternalDocument;
import DBLayer.IFDBExtDoc;
import ExceptionsPack.NullValueException;
import ModelLayer.Client;
import ModelLayer.ExternalDocument;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public class CtrExtDoc {

    public CtrExtDoc() {
    }

    public ExternalDocument findExternalDocument(int externalContactID) {
        IFDBExtDoc dbExtDoc = new DBExternalDocument();
        return dbExtDoc.findExternalDocument(externalContactID, true);
    }

    public ArrayList getAllExternalDocuments() {
        IFDBExtDoc dbExtDoc = new DBExternalDocument();
        ArrayList<ExternalDocument> allExtCon = new ArrayList<ExternalDocument>();
        allExtCon = dbExtDoc.getAllExternalDocuments(false);
        return allExtCon;
    }

    public void insertExternalDocument(Client client, String text, String date, String source, String author) throws NullValueException {
        IFDBExtDoc dbExtDoc = new DBExternalDocument();
        ExternalDocument extDocObj = new ExternalDocument();
        extDocObj.setClient(client);
        extDocObj.setText(text);
        extDocObj.setDate(date);
        extDocObj.setAuthor(author);
        dbExtDoc.insertExternalDocument(extDocObj);
    }

    public void updateExternalDocument(int externalDocumentID, Client client, String text, String date, String source, String author) {
        IFDBExtDoc dbExtDoc = new DBExternalDocument();
        ExternalDocument extDocObj = new ExternalDocument();
        extDocObj.setExternalDocumentID(externalDocumentID);
        extDocObj.setClient(client);
        extDocObj.setText(text);
        extDocObj.setDate(date);
        extDocObj.setAuthor(author);
        dbExtDoc.updateExternalDocument(extDocObj);
    }

    public void deleteClient(int externalContactID) {
        IFDBExtDoc dbExtDoc = new DBExternalDocument();
        dbExtDoc.deleteExternalDocument(externalContactID);
    }
}
