/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBLayer;

import ModelLayer.Milestone;
import java.util.ArrayList;

/**
 *
 * @author Kristian Byrialsen
 */
public interface IFDBMilestone {

    public Milestone findMilestone(int clientID, boolean retrieveAssociation);
    //find one car having the regNo

    public ArrayList<Milestone> getAllMilestones(boolean retriveAssociation);
    //find one car having the regNo

    public ArrayList<Milestone> buildListOfMilestones(int clientID);
    // find the milestones belonging to one client

    public int insertMilestone(Milestone m);
    //update information about an car

    public int updateMilestone(Milestone m);
    //update information about a milestone

    public int deleteMilestone(int clientID);
    //delete a milestone

}