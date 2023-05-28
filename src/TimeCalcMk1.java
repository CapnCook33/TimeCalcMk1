/* First attempt at a basic time calculator. The user can enter the current date, or choose desired dates
 * to calculate between, and the program will return the number of days between two dates.
 * --Additional features to be added later.
 * --This may later be added to the PlantPlanner/Personal Gardener app/program I've had in mind.
 */

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeCalcMk1 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHundredDays = now.plusDays(100);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("The point of this program is to help you calculate the number of days between certain " +
                "dates. It was originally thought of to assist me with when to plant and harvest my garden.");
        System.out.println();
        System.out.println("Current Date and Time: " + getCurrentDateTime());
        System.out.println();
        System.out.println("Just with the current Date now: " + getDate());
        System.out.println();
        System.out.println("Just with the current Time now: " + getTime());
        System.out.println();
        System.out.println("Current Date/Time using variable 'now': " + dtf.format(now));
        System.out.println();
        System.out.println("The date in 100 days is: " + dtf.format(oneHundredDays));

        //Everything is working to this point. Java may have some other classes or API's I can use to do this,
        //but I'm going to finish the project and personalize it for my purposes.
    }

    public static String getCurrentDateTime(){
        //Used to design how I want the Date/Time returned.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //Variable 'now' to indicate we want current information.
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        Date today = new Date();

        return sdf.format(today);
    }

    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


}

/*  IDEAS FOR FEATURES
 *
 * Harvest Notifications
 * Local Weather Information
 * Sowing Notifications
 * Severe Weather Notifications (Heat, Cold, Rain, Wind)
 *
 *
 *
 *  - This can certainly be added to your Plant Planner later on, but for now the focus is getting the basic date
 *  - and time commands down and figuring out how to best interact with the user. Really just myself, for now.
 */