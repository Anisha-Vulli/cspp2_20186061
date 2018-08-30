/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
 */
import java.util.Scanner;
/**
 * Avarge of values in a array.
 */
public final class Avarage {
    /**
     * Constructs the object.
     */
    private Avarage() {
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
        int avg = 0;
        int sumval = 0;
        for (int j = 0; j < n; j++) {
            sumval = sumval + arr[j];
        }
        avg = sumval / n;
        System.out.println("Avarage is:" + avg);
    }
}
