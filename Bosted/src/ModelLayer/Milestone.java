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
    private Date succesDate;

    public Milestone() {
    }


    

public Milestone(int milestoneID, int clientID, String text, String date, Date succesDate)
{
    this.milestoneID = milestoneID;
    this.clientID = clientID;
    this.text = text;
    this.date = date;
    this.succesDate = succesDate;
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

    public Date getSuccesDate() {
        return succesDate;
    }

    public void setSuccesDate(Date succesDate) {
        this.succesDate = succesDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }















}
