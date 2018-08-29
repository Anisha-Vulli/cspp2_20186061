/**
 * Author: Anisha Vulli.
 * Date: 29th Aug 2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            final int zero = 0;
            final int ten = 10;
            final int seven = 7;
            final int one = 1;
            while (num != zero) {
                if (num % ten == seven) {
                    count = count + one;
                }
                num = num / ten;
            }
        }
        System.out.println(count);
    }
}

