/**
 * Author : Anisha Vulli.
 * Date : 28th Aug 2018.
 */

import java.util.Scanner;
import java.lang.Math;
/**
 * Class for solution.
 */

public final class Solution {
    /**
     * Roots calculation.
     *
     * @param      a     a value
     * @param      b     b value
     * @param      c     c value
     *
     * @return     returns null
     */
    /**
     * Constructs the object.
     */
    private Solution() {
    // Empty constructor
    }
    static double rootsOfQuadraticEquation(
           final int a, final int b, final int c) {
        final double r1, r2;
        final int mul = 4;
        r1 = (-b + (Math.sqrt((b * b) - (mul * a * c)))) / (2 * a);
        r2 = (-b - (Math.sqrt((b * b) - (mul * a * c)))) / (2 * a);
        System.out.println(r1 + " " + r2);
        return 0;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        Solution obj = new Solution();
        obj.rootsOfQuadraticEquation(a, b, c);
    }

}
