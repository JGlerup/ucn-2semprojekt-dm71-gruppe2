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
public class Milestone {

    private int milestoneID;
    private int clientID;
    private String text;
    private String date;
    private Date succesdate;


public Milestone(int milestoneID, int clientID, String text, String date, Date succesdate)
{
    this.milestoneID = milestoneID;
    this.clientID = clientID;
    this.text = text;
    this.date = date;
    this.succesdate = succesdate;
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

    public int getMilestoneID() {
        return milestoneID;
    }

    public void setMilestoneID(int milestoneID) {
        this.milestoneID = milestoneID;
    }

    public Date getSuccesdate() {
        return succesdate;
    }

    public void setSuccesdate(Date succesdate) {
        this.succesdate = succesdate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }















}
