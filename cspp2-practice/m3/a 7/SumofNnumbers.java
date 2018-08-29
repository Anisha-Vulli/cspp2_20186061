/**
 * Author : Anisha Vulli.
 * Date : 29th Aug 2018.
 */
import java.util.Scanner;
/**
 * Sum of n natural numbers.
 */
public final class SumofNnumbers {
    /**
     * Constructs the object.
     */
    private SumofNnumbers() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int n;
        int i = 1, sum = 0;
        System.out.println("Enter number of numbers");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        while (i <= n) {
            sum = sum + i;
            i = i + 1;
        }

        System.out.println("Sum of " + n + " Natural Numbers is : " + sum);
    }
}
