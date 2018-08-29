/**
 * Author : Anisha Vulli.
 * Date : 29th Aug 2019.
 */
import java.util.Scanner;
/**
 * Printing a pattren.
 */

public final class Pattren {
    /**
     * Constructs the object.
     */
    private Pattren() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int n;
        System.out.println("Enter n value");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
