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
        double c, f;
        System.out.println("Enter celcius temperature");
        Scanner j = new Scanner(System.in);
        c = j.nextInt();
        f = (1.8 * c) + 32;
        System.out.println("Farenheit" + f);
    }
}
