/**
 * ArrayList.
 */
import java.util.ArrayList;
/**
 * Scanner class.
 */
import java.util.Scanner;
/**
 * Arrays.
 */
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
    /**
     * Movie name.
     */
    private String mvename;
    /**
     * Show time string.
     */
    private String showtime;
    /**
     * Seats in a string array.
     */
    private String[] seats;
    /**
     * Constructs the object.
     *
     * @param      mvename   The mvename
     * @param      showtime  The showtime
     * @param      seats     The seats
     */
    Show(final String mvename,
        final String showtime, final String[] seats) {
        this.mvename = mvename;
        this.showtime = showtime;
        this.seats = seats;
    }
    /**
     * Getting movie name.
     *
     * @return     { Movie name }
     */
    String getmve() {
        return mvename;
    }
    /**
     * Getting show time.
     *
     * @return     { showtime string }
     */
    String getshowtime() {
        return showtime;
    }
    /**
     * Seats in the form of string array.
     *
     * @return     { Seats array }
     */
    String[] getseats() {
        return seats;
    }
    /**
     * Sets the seat na.
     *
     * @param      index  The index
     */
    void setSeatNA(final int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return mvename + "," + showtime;
    }
}
/**
 * Class for patron.
 */
class Patron {
    /**
     * Name of the user.
     */
    private String name;
    /**
     * Mobile number of the user.
     */
    private String mobile;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      mobile  The mobile
     */
    Patron(final String name, final String mobile) {
        this.name = name;
        this.mobile = mobile;
    }
    /**
     * Getting the name.
     *
     * @return     { user name }
     */
    String getname() {
        return name;
    }
    /**
     * Mobile number.
     *
     * @return     { Mobile number }
     */
    String getnum() {
        return mobile;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + " " + mobile;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * Showlist in the form of array list.
     */
    private ArrayList<Show> showlist;
    /**
     * Tickets in the form of ticket list.
     */
    private ArrayList<String> ticketlist;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        showlist = new ArrayList<>();
        ticketlist = new ArrayList<>();
    }
    /**
     * Adds a show.
     *
     * @param      show  The show
     */
    void addAShow(final Show show) {
        showlist.add(show);
    }
    /**
     * Gets a show.
     *
     * @param      mvename   The mvename
     * @param      showtime  The showtime
     *
     * @return     A show.
     */
    Show getAShow(final String mvename, final String showtime) {
        for (Show show : showlist) {
            if (show.getmve().equals(mvename)
                && show.getshowtime().equals(showtime)) {
                return show;
            }
        }

        return null;
    }
    /**
     * Booking a show.
     *
     * @param      mvename   The movie name
     * @param      showtime  The showtime
     * @param      patron    The patron
     * @param      seats     The seats
     */
    void bookAShow(final String mvename, final String showtime,
        final Patron patron, final String[] seats) {
        Show show = getAShow(mvename, showtime);
        boolean flag = false;
        if (show == null) {
            System.out.println("No show");
            return;
        }

        String[] sseats = show.getseats();
            for (String seat : seats) {
                for (int i = 0; i < sseats.length; i++) {
                    if (seat.equals(sseats[i])) {
                        show.setSeatNA(i);
                        flag = true;
                    }
                }
            }

        if (flag) {
            ticketlist.add(patron.getnum() + " " + mvename + " " + showtime);
        }
    }
    /**
     * Printing the booked ticket.
     *
     * @param      movie     The movie
     * @param      showtime  The showtime
     * @param      mobile    The mobile
     */
    void printTicket(final String movie, final String showtime,
        final String mobile) {
        String t = mobile + " " + movie + " " + showtime;
        if (ticketlist.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show show : showlist) {
            System.out.println(show.toString() + ","
                + Arrays.toString(show.getseats()).replace(" ", ""));
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
