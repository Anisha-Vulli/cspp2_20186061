/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
 */
import java.util.Scanner;
/**
 * Caluculating max value in the array.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxval = 0;
        for (int j = 0; j < n; j++) {
           if (maxval < arr[j]) {
             maxval = arr[j];
           }
        }
        System.out.println(maxval);
    }
}
