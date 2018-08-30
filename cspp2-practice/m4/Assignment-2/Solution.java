/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows1 = sc.nextInt();
        int coloumn1 = sc.nextInt();
        int[][] mat1 = new int[rows1][coloumn1];
        for(int i = 0; i < rows1; i++) {
         for(int j = 0; j < coloumn1; j++ ) {
              mat1[i][j] = sc.nextInt();
            }
        }

        int rows2 = sc.nextInt();
        int coloumn2 = sc.nextInt();
        int[][] mat2 = new int[rows2][coloumn2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < coloumn2; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }

        if ((rows1 == rows2) && (coloumn1 == coloumn2)) {
            int[][] result = new int[rows1][coloumn1];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < coloumn1; j++) {
                    result[i][j] = mat1[i][j] + mat2[i][j];
                }
            }

            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < coloumn1; j++) {
                    System.out.print(result[i][j]);
                    if (j < (coloumn1 - 1)) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
             System.out.println("not possible");
        }


    }
}
