/**
 * Author: Anisha Vulli.
 * Date: 31st Aug 2018.
 */

import java.util.Scanner;

public class Solution {
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
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            long res = binaryToDecimal(s);//Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * BCD to decimal conversion.
     *
     * @param      s     String.
     *
     * @return     { returns decimal value }.
     */

    public static long binaryToDecimal(String s) {
        int len = s.length();
        int sumval = 0;
        int j = 0;
        for (int i = len - 1; i > 0; i--) {
            sumval += Character.getNumericValue(s.charAt(i)) * (Math.pow(2, j));
            j++;
        }

        return sumval;

    }


}
