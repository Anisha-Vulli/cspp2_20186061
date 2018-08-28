/**
 * Author : Anisha Vulli.
 * Date : 28th Aug 2018.
 */

import java.util.Scanner;
/**
 * Class for solution.
 */

public final class Solution {
    /**
     * Power calculation function.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     value
     */

    static long power(final int base, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor
    }
    /**
     * Main function
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        final int base = s.nextInt();
        final int exponent = s.nextInt();
        Solution obj = new Solution();
        long result = obj.power(base, exponent);
        System.out.println(result);
    }
}
