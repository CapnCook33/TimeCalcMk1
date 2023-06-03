/**
 * @author J. Stephen Cook
 * This program was written to help the user calculate the number of days between dates.
 * It was originally intended to be used as part of the gardening program I'm working on.
 * The user will choose if they would like to see a past or future date and the number
 * of days they would like to see calculated.
 *
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

        System.out.println("The point of this program is to help you calculate what the date will be in a certain" +
                " number of days, or what the date was a certain number of days ago. Intended to help with" +
                " figuring out when to plant and harvest your garden.\n");

        boolean runAgain = false;
        do {
            System.out.println("The current Date and Time is: " + dtf.format(now));
            System.out.println("\nThe date in 100 days is: " + dtf.format(now.plusDays(100)));
            System.out.println("The date 100 days ago was: " + dtf.format(now.minusDays(100)) + "\n");

            /* These will get put into an if statement or something similar to
               allow the user to state if they'd like to see past or future dates. */
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

    /**
     * This method takes input from the user and calculates
     * that many days ahead of the current date.
     * @params None.
     * @return String - This returns the calculated future date.
     */
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

    /**
     * This method takes input from the user and calculates
     * that many days behind the current date.
     * @params None.
     * @return String - This returns the calculated past date.
     */
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