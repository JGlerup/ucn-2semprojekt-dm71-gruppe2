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
private int clientID;
private String text;
private String date;
private String source;
private String author;


public ExternalDocument(int externalDocument, int clientID, String text, String date, String source, String author)
{
    this.externalDocumentID = externalDocumentID;
    this.clientID = clientID;
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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
