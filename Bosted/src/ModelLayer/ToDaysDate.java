package DBLayer;

import java.util.Date;
import java.text.DateFormat;

/**
 * Write a description of class ToDaysDate here.
 *
 * @author (Kis Boisen Hansen)
 * @version (2006.05.16)
 */
public class ToDaysDate {

    private String toDay;

    /**
     * Constructor for objects of class ToDaysDate
     */
    public ToDaysDate()
    {  //find the date and print it out
       toDay = DateFormat.getInstance().format(new Date());
       toDay = toDay.substring(0,8);
       System.out.println(this);

    }

    //return month as string
    public String getMonth()
    {
        int mm = Integer.parseInt(toDay.substring(3,5));
        if(mm < 10){
          return "0" + mm;
        }
        else{
            return "" + mm;
        }
    }
    //return month as int
    public int getMonthInt()
    {
        return Integer.parseInt(toDay.substring(3,5));
    }
    public int getDay()
    {
        return Integer.parseInt(toDay.substring(0,2));
    } //return year as string
    public String getYear()
    {
        int yy = Integer.parseInt(toDay.substring(6,8));
        if(yy < 10){
          return "0" + yy;
        }
        else{
            return "" + yy;
        }
    }
    public int getYearInt()
    {
        return Integer.parseInt(toDay.substring(6,8));
    }
    public String toString()
    {
       return  getYear() + getMonth() + getDay();
    }
}
