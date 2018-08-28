/**
 * Author : Anisha Vulli.
 * Date : 28th Aug 2018.
 */

import java.util.Scanner;
import java.lang.Math;
/**
 * Class for solution.
 */

public class Solution {
    static double rootsOfQuadraticEquation(final int a, final int b, final int c) {
        final double r1, r2;
        final int mul = 4;
        r1 = (-b + (Math.sqrt((b * b) - (mul * a * c)))) / (2 * a);
        r2 = (-b - (Math.sqrt((b * b) - (mul * a * c)))) / (2 * a);
        System.out.println(r1 + " " + r2);
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        Solution obj = new Solution();
        obj.rootsOfQuadraticEquation(a, b, c);
    }
    
}
