/**
 * Author: Anisha Vulli.
 * Date: 29th Aug 2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Main function.
	 *
	 * @param      args  The arguments
	 */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
        	int num = i;
        	while(num != 0) {
        		if (num % 10 == 7) {
        			count = count + 1;
        		}
        		num = num / 10;
        	}
        }
        System.out.println(count);
       
        
    }
}
