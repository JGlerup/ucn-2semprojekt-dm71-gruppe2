/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import DBLayer.DBMilestone;
import DBLayer.IFDBMilestone;
import ModelLayer.Milestone;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kristian Byrialsen
 */
public class CrtMile {

//    public Milestone findMilestoneByClientID(int clientID) {
//        IFDBMilestone dbMilestone = new DBMilestone();
//        return dbMilestone.findMilestoneByClientID(clientID, true);
//    }

    public ArrayList getAllCMilestone() {
        IFDBMilestone dbMilestone = new DBMilestone();
        ArrayList milestones = new ArrayList<Milestone>();
        milestones = dbMilestone.getAllMilestones(false);
        return milestones;
    }

    public void insertMilestone(int clientID, String text, String date, Date succesDate) {
            IFDBMilestone dbMilestone = new DBMilestone();
            Milestone mObj = new Milestone();
            mObj.setClientID(clientID);
            mObj.setText(text);
            mObj.setDate(date);
            mObj.setSuccesDate(succesDate);
            dbMilestone.insertMilestone(mObj);

    }

    public void updateMilestone(int clientID, String text, String date, Date succesDate) {

            IFDBMilestone dbMilestone = new DBMilestone();
            Milestone mObj = new Milestone();
            mObj.setClientID(clientID);
            mObj.setText(text);
            mObj.setDate(date);
            mObj.setSuccesDate(succesDate);
            dbMilestone.updateMilestone(mObj);
    }

    public void deleteMilestone(int clientID) {
        IFDBMilestone dbMilestone = new DBMilestone();
        dbMilestone.deleteMilestone(clientID);
    }
}


