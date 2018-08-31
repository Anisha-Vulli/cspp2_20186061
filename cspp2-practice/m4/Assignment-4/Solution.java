
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
    Do not modify the main function 
    */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String reverse=reverseString(s);    
        System.out.println(reverse);
        
    }
    
    public static String reverseString(String s) {
        int len = s.length();
        String temp = "";
        for (int i = len; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }

        return temp;
    }

}
