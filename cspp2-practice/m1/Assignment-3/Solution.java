/**

    * Author: Anisha Vulli.
    * Date: 28th Aug 2018

*/
import java.util.Scanner;
/**
  * Calculating area of the triangle.
*/
public final class Solution {
    /*Public class*/
    /**
       * Constructor.
    */

    private Solution() {
    // Empty constructor.
    }

    /**
        * @param args of type String
    */
    public static void main(final String[] args) {
        /**
           * Main function.
        */
        final double degreesCelsius;
        // System.out.println("Enter base and height values");
        Scanner scan = new Scanner(System.in);
        degreesCelsius = scan.nextDouble();
        Solution temp = new Solution();
        System.out.println(
            temp.calculateFromDegreesToFarenheit(degreesCelsius));
    }

    /**
        * Main function.
    */
    /**
        * @param degreesCelsius of type double.
        * @return of type return.
    */
    public double calculateFromDegreesToFarenheit(final double degreesCelsius) {
        final double a = 1.8;
        final int b = 32;
        double f = (a * degreesCelsius) + b;
        return f;
    }
}
