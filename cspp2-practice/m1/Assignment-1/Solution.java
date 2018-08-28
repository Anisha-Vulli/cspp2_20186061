/**

    * Author: Anisha Vulli.
    * Date: 28th Aug 2018

*/
import java.util.Scanner;
/**
  * Conversion of degrees to farenheit.
*/
public final class Solution {
    /*Public class*/
    /**
       * Constructor.
    */

    private Solution() {
    // Empty constructor
    }

    /**
    *
    * @param args of type String
    */
    public static void main(final String[] args) {
        /*Main function*/
        String name, rollno;
        System.out.println("Enter name and roll number");
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        rollno = s.nextLine();
        System.out.println("Name : " + name + "\n" + "Roll Number : " + rollno);
    }
}
