/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
 */
import java.util.Scanner;
/**
 * Class for sixpresent.
 */
public final class Sixpresent {
    /**
     * Constructs the object.
     */
    private Sixpresent() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        final int comp = 6;
        if ((arr[0] == comp) || (arr[n - 1] == comp)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
