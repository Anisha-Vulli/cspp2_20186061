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
        final int base, height;
        // System.out.println("Enter base and height values");
        Scanner scan = new Scanner(System.in);
        base = scan.nextInt();
        height = scan.nextInt();
        Solution tri = new Solution();
        System.out.println(tri.areaOfTriangle(base, height));
    }

    /**
        * Main function.
    */
    /**
        * @param base of type int.
        * @param height of type int.
        * @return of type return.
    */
    public double areaOfTriangle(final int base, final int height) {
        final double a = 0.5;
        double area = a * base * height;
        return area;
    }
}
