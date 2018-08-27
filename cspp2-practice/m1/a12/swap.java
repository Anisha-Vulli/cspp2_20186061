/**

    * Author: Anisha Vulli.
    * Date: 27th Aug

*/
import java.util.*;

public final class swap {

    /*Public class*/
    /**
       * Constructor.
    */
    private swap() {
    // Empty constructor
    }

    /**
    *
    * @param args of type String
    */
    public static void main(final String[] args) {
        /*Main function*/
        int a,b,temp;
        System.out.println("Enter numbers");
        Scanner j = new Scanner(System.in);
        a = j.nextInt();
        b = j.nextInt();
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + " " +  "b = " + b);
    }
}
