/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class ExternalDocument {

    private int externalDocumentID;
    private Client client;
    private String text;
    private String date;
    private String source;
    private String author;

    public ExternalDocument() {
    }

    public ExternalDocument(int externalDocumentID, Client client, String text, String date, String source, String author) {
        this.externalDocumentID = externalDocumentID;
        this.client = client;
        this.text = text;
        this.date = date;
        this.source = source;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExternalDocumentID() {
        return externalDocumentID;
    }

    public void setExternalDocumentID(int externaldocumentID) {
        this.externalDocumentID = externaldocumentID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
