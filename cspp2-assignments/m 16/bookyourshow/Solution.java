import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Show {
    String mvename;
    String showtime;
    String[] seats;
    Show(final String mvename, final String showtime, final String[] seats) {
        this.mvename = mvename;
        this.showtime = showtime;
        this.seats = seats;
    }

    String getmve() {
        return mvename;
    }

    String getshowtime() {
        return showtime;
    }

    String[] getseats() {
        return seats;
    }

    void setSeatNA(int index) {
        seats[index] = "N/A";
    }

    public String toString() {
        return mvename + " " + showtime;
    }
}

class Patron {
    private String name;
    private String mobile;

    Patron(final String name, final String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    String getname() {
        return name;
    }

    String getnum() {
        return mobile;
    }

    public String toString() {
        return name + "," + mobile;
    }
}

class BookYourShow {
    ArrayList<Show> showlist;
    ArrayList<String> ticketlist;

    BookYourShow() {
        showlist = new ArrayList<>();
        ticketlist = new ArrayList<>();
    }

    void addAShow(Show show) {
        showlist.add(show);
    }

    Show getAShow(String mvename, String showtime) {
        for (Show show : showlist) {
            if (show.getmve().equals(mvename) && show.getshowtime().equals(showtime)) {
                return show;
            }
        }

        return null;
    }

    void bookAShow(String mvename, String showtime, Patron patron, String[] seats) {
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
            ticketlist.add(mvename + " " + showtime + " " + patron.getnum());
        }
    }

    void printTicket(String movie, String showtime, String mobile) {
        String t = movie + "" + showtime + "" + mobile;
        if (ticketlist.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }

    void showAll() {
        for (Show show : showlist) {
            System.out.println(show.toString() + "," +
                Arrays.toString(show.getseats()).replace(" ",""));
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
