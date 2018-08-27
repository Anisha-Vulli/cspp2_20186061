/**

    * Author: Anisha Vulli.
    * Date: 27th Aug

*/
import java.util.Scanner;
/**
  * Division two numbers.
*/
public final class Division {
    /*Public class*/
    /**
       * Constructor.
    */

    private Division() {
    // Empty constructor
    }

    /**
    *
    * @param args of type String
    */
    public static void main(final String[] args) {
        /*Main function*/
        int a, b, c, d;
        System.out.println("Enter numbers");
        Scanner j = new Scanner(System.in);
        a = j.nextInt();
        b = j.nextInt();
        c = a / b;
        d = a % b;
        System.out.println("Quotient = " + c + "Remainder = " + d);
    }
}
