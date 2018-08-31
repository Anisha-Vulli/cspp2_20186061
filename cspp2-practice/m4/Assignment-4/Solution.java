/**
 * Author : Anisha Vulli.
 * Date: 31st Aug 2018.
 */

import java.util.Scanner;
/**
 * Class for solution.
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
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);    
        System.out.println(reverse);
        
    }
    /**
     * Reverse of a string function.
     *
     * @param      s     { String }
     *
     * @return     { A string }
     */
    public static String reverseString(String s) {
        int len = s.length();
        String temp = "";
        for (int i = len - 1; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }

        return temp;
    }

}
