import java.util.Scanner;

public class Solution {

    static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        else {
            return base * power(base, exponent - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        Solution obj = new Solution();
        int result = obj.power(base,exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
}
