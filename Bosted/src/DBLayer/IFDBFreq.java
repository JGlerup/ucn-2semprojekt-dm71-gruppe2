package DBLayer;

import ModelLayer.Frequency;
import java.util.ArrayList;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public interface IFDBFreq
{
    public Frequency findFrequencyByTimesPerDayAndQuantityEachTime(int timesPerDay, int quantityEachTime, boolean retrieveAssociation);
    //find one frequency having the timesPerDay and quantityEachTime

    public Frequency findFrequencyByID(int frequencyID, boolean retrieveAssociation);
    //find one frequency having the frequencyID

    public ArrayList<Frequency> getAllFrequency(boolean retriveAssociation);
    //find all frequency

    public int insertFrequency(Frequency freq);
    //update information about a frequency

    public int updateFrequency(Frequency freq);
    //update information about a frequency

    public int deleteFrequency(int frequencyID);
    //delete a frequency
}
