
import java.util.Scanner;

public class Solution
{/*
    Fill this main function to print maximum of given array
    */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxval = 0;
        for (int j = 0; j <= n; j++) {
           if (arr[j] > arr[j + 1]) {
             maxval = arr[j];
           }
        }
        System.out.println(maxval);
    }
}
