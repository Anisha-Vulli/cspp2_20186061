/**
 * Author : Anisha Vulli.
 * Date : 29th Aug 2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * GCD calculation function.
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    static int gcd(final int n1, final int n2) {
        int min = Math.min(n1, n2);
        int minval = min + 1;
        for (int i = minval; i >= 1; i--) {
            if ((n1 % i == 0) && (n2 % i == 0)) {
                return (i);
            }
        }

        return 0;

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.gcd(n1, n2));
    }
}
