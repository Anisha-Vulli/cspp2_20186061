/**.

    * Author: Anisha Vulli.
    * Date: 27th Aug

*/
import java.util.Scanner;
/**
  * Conversion of degrees to farenheit.
*/
public final class Conversion {
    /*Public class*/
    /**
       * Constructor.
    */

    private Conversion() {
    // Empty constructor
    }

    /**
    *
    * @param args of type String
    */
    public static void main(final String[] args) {
        /*Main function*/
        final double c, f;
        final double a = 1.8;
        final int b = 32;
        System.out.println("Enter celcius temperature");
        Scanner j = new Scanner(System.in);
        c = j.nextInt();
        f = (a * c) + b;
        System.out.println("Farenheit = " + f);
    }
}
