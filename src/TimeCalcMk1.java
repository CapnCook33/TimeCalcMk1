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
            System.out.println("\nThe date in 100 days is: " + add100());
            System.out.println("The date 100 days ago was: " + remove100() + "\n");

            System.out.println("How many days would you like to add?\n");
            int userDays = keyboard.nextInt();
            if (userDays == 120) {
                System.out.println("The date in 120 days is: " + add120());
            } else if (userDays == 100) {
                System.out.println("The date in 100 days is: " + add100());
            } else if (userDays == 75) {
                System.out.println("The date in 75 days is: " + add75());
            } else if (userDays == 50) {
                System.out.println("The date in 50 days is: " + add50());
            } else if (userDays == 30) {
                System.out.println("The date in 30 days is: " + add30());
            } else if (userDays == 15) {
                System.out.println("The date in 15 days is: " + add15());
            } else {
                System.out.println("That's not one of the common plant dates. Try again.");
            }

        /* This works, but it can't be the most efficient way. It gets the job done for now, we'll call
        it a placeholder, but this can certainly be improved. I want to also get started on a GUI to
        display this information and learn how to send myself a daily or weekly email that will give
        me a readout of the above information and whatever else I add. */

//        for(int i = 0; i< commDates.length; i++){
//            String s = String.valueOf(commDates[i]);
//            System.out.println("The date in " + commDates[i] + "days is: " + dtf.format(s));
//        }

        /* Occam's Razor. I do want to create something to turn my yy/MM/dd format into
        the appropriate month name and day (ex. February/Feb. 15th). Telling the day of the week would
        be a nice addition too. */

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

    public static String add120(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead120 = now.plusDays(120);

        return dtf.format(ahead120);
    }
    //Works.

    /*
    public static int getFuture(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int userDays = 0;

        System.out.println("How many days would you like to calculate?");
        Scanner keyboard = new Scanner(System.in);
        userDays = keyboard.nextInt();

        System.out.println("You chose to see " +userDays+ " days ahead.");


        return dtf.format();
    }
    */

    public static String remove120(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind120 = now.minusDays(120);

        return dtf.format(behind120);
    }
    //Works.

    public static String add100(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead100 = now.plusDays(100);

        return dtf.format(ahead100);
    }
    //Works.

    public static String remove100(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind100 = now.minusDays(100);

        return dtf.format(behind100);
    }
    //Works.

    public static String add75(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead75 = now.plusDays(75);

        return dtf.format(ahead75);
    }
    //Works.

    public static String remove75(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind75 = now.minusDays(75);

        return dtf.format(behind75);
    }
    //Works.

    public static String add50(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead50 = now.plusDays(50);

        return dtf.format(ahead50);
    }
    //Works.

    public static String remove50(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind50 = now.minusDays(50);

        return dtf.format(behind50);
    }
    //Works.

    public static String add30(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead30 = now.plusDays(30);

        return dtf.format(ahead30);
    }
    //Works.

    public static String remove30(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind30 = now.minusDays(30);

        return dtf.format(behind30);
    }
    //Works.

    public static String add15(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ahead15 = now.plusDays(15);

        return dtf.format(ahead15);
    }
    //Works.

    public static String remove15(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime behind15 = now.minusDays(15);

        return dtf.format(behind15);
    }
    //Works.

    //This was just to get the idea out, this can certainly be consolidated into one add method and
    //one remove method that will use the amount of days the user wants to know.
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