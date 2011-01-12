/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlLayer;

import DBLayer.DBMilestone;
import DBLayer.IFDBMilestone;
import ModelLayer.Client;
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

    public void insertMilestone(Client client, String text, Date succesDate) {
            IFDBMilestone dbMilestone = new DBMilestone();
            Milestone mObj = new Milestone();
            mObj.setClient(client);
            mObj.setText(text);
            mObj.setSuccesDate(succesDate);
            dbMilestone.insertMilestone(mObj);

    }

    public void updateMilestone(Client client, String text, Date succesDate) {

            IFDBMilestone dbMilestone = new DBMilestone();
            Milestone mObj = new Milestone();
            mObj.setClient(client);
            mObj.setText(text);
            mObj.setSuccesDate(succesDate);
            dbMilestone.updateMilestone(mObj);
    }

    public void deleteMilestone(int clientID) {
        IFDBMilestone dbMilestone = new DBMilestone();
        dbMilestone.deleteMilestone(clientID);
    }

        public ArrayList<Milestone> buildListOfMilestones(int clientID)
    {
        IFDBMilestone dbMile = new DBMilestone();
        ArrayList mileList = new ArrayList<Milestone>();
        mileList = dbMile.buildListOfMilestones(clientID);
        return mileList;
    }
}


