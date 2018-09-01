import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Anisha Vulli.
 * Date : 01st Sept 2018.
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        //System.out.println(n);
        for (int i = 2; i < n; i++) {
            //System.out.println(i);
            int c = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    c = c + 1;
                }
                //System.out.println(c);
            }

            if (c != 2) {
                if (i % 2 != 0) {
                   System.out.println(i);
                }
            }
        }

    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}


