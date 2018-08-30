/**
 * Author: Anisha Vulli.
 * Date: 30th Aug 2018.
 */

import java.util.Scanner;
/**
 * Concatinate strings program.
 */

public final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        String finalstr = in.nextLine();
        String firststr = "Hello".concat(" " + finalstr);
        String laststr = firststr.concat("!");
        System.out.println(laststr);
    }
}
