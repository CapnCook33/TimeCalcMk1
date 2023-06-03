/* First attempt at a basic time calculator. The user can enter the current date, or choose desired dates
 * to calculate between, and the program will return the number of days between two dates.
 * --Additional features to be added later.
 * --This may later be added to the PlantPlanner/Personal Gardener app/program I've had in mind.
 */

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TimeCalcMk1 {
    public static void main(String[] args) {

        //int t120 = 120, t100 = 100, t75 = 75, t50 = 50, t30 = 30, t15 = 15;
        //int[] commDates = {t120, t100, t75, t50, t30, t15};
        Scanner keyboard = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("The point of this program is to help you calculate the number of days between certain " +
                "dates.\nIt was originally thought of to assist me with when to plant and harvest my garden,\n" +
                "hence why the default dates correlate to common plant harvest times. \n");

        boolean runAgain = false;
        do {
            System.out.println("The current Date and Time is: " + dtf.format(now));
            System.out.println("\nThe date in 100 days is: " + dtf.format(now.plusDays(100)));
            System.out.println("The date 100 days ago was: " + dtf.format(now.minusDays(100)) + "\n");

            System.out.println(getFuture());
            System.out.println(getPast());

            System.out.println("Do you want to see more Dates? (Press 1 for Yes, 0 (zero) for No.)");
            int userChoice = keyboard.nextInt();
            if(userChoice == 1){
                runAgain = true;
            } else{
                runAgain = false;
            }
        }while(runAgain);
    }

    public static String getCurrentDateTime(){
        //Used to design how I want the Date/Time returned.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //Variable 'now' to indicate we want current information.
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    //Works.

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        Date today = new Date();

        return sdf.format(today);
    }
    //Works.

    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    //Works.

    public static String getFuture(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("How many days ahead would you like to see?");
        Scanner keyboard = new Scanner(System.in);
        int userDays = keyboard.nextInt();
        LocalDateTime userDate = now.plusDays(userDays);

        System.out.print("The date in " +userDays+ " days is: ");
        return dtf.format(userDate);
    }

    public static String getPast(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("How many days behind would you like to see?");
        Scanner keyboard = new Scanner(System.in);
        int userDays = keyboard.nextInt();
        LocalDateTime userDate = now.minusDays(userDays);

        System.out.print("The date " + userDays+ " days ago was: ");
        return dtf.format(userDate);
    }
}




/*  IDEAS FOR FEATURES
 *
 * Harvest Notifications
 * Local Weather Information
 * Sowing Notifications
 * Severe Weather Notifications (Heat, Cold, Rain, Wind)
 * Day of the Week (Ex. "Today is Wednesday, May 31st")
 *
 *
 *  - This can certainly be added to the Plant Planner later on, but for now the focus is getting the basic date
 *  - and time commands down and figuring out how to best interact with the user. Really just myself, for now.
 */

//Quick notes to self:
/* I want to also get started on a GUI to display this information and learn how to send myself a daily
        or weekly email that will give me a readout of the above information and whatever else I add.

        Occam's Razor. I do also want to create something to turn my yy/MM/dd format into
        the appropriate month name and day (ex. February/Feb. 15th). Telling the day of the week would
        be a nice addition too. */