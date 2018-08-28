/**
 * Author : Anisha Vulli.
 * Date : 28th Aug 2018
 */
import java.util.Scanner;
/**
 * Factorial of a number using recursion.
 */

public final class Factorial {
    /**
     * Constructs the object.
     */

    private Biggerequalsmaller() {
    // Empty constructor
    }

    /**
     * Factorial function.
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int fact(final int a) {
        final int b = 1;
        if (a == 1) {
            return 1;
        } else {
            return a * fact(a - b);
        }
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int a;
        System.out.println("Enter a number");
        Scanner in  = new Scanner(System.in);
        a = in.nextInt();
        Factorial obj = new Factorial();
        System.out.println("Factorial of " + a + "is" + obj.fact(a));
    }
}