/**
 * Author : Anisha Vulli.
 * Date : 28th Aug 2018.
 */
import java.util.Scanner;
/**
 * Class for biggerequalsmaller.
 */

public final class Biggerequalsmaller {
    /**
     * Constructs the object.
     */
    private Biggerequalsmaller() {
    // Empty constructor
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int a, b, c;
        System.out.println("Enter 3 values");
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        if ((a > b) && (a > c)) {
            System.out.println("A is bigger");
        } else if (b > c) {
            System.out.println("B is bigger");
        } else {
            System.out.println("C is bigger");
        }
    }
}