/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
 */
import java.util.*;
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
		Scanner sc = new Scanner(System.in);
        int rows1 = sc. nextInt();
        int coloumn1 = sc. nextInt();
        int[][] mat1 = new int[rows1][coloumn1];
        for (int i = 0; i < rows1; i++) {
       	 for (int j = 0; j < coloumn1; j++ ) {
       		  mat1[i][j] = sc.nextInt();
       	    }
        }
       
        int rows2 = sc. nextInt();
        int coloumn2 = sc. nextInt();
        int[][] mat2 = new int[rows2][coloumn2];
        for (int i = 0; i < rows2; i++) {
       	    for (int j = 0; j < coloumn2; j++ ) {
       		    mat2[i][j] = sc.nextInt();
       	    }
        }

        int[][] result = new int[rows1][coloumn1];
        for (int i = 0; i < rows1; i++) {
        	for (int j = 0; j < coloumn1; j++) {
        		result[i][j] = mat1[i][j] + mat2[i][j];
        	}
        }
		
		for (int i = 0; i < rows1; i++) {
        	for (int j = 0; j < coloumn1; j++) {
        		System.out.print(result[i][j] + " ");
        	}
        	System.out.println();
        }
	}
}