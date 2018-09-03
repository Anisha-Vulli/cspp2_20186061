/**
 * Author: Anisha Vulli.
 * Date : 03rd Sept 2018.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * Input validation class.
     */
    private String s;
    /**
     * Constructs the object.
     *
     * @param      strng  The strng
     */
    InputValidator(final String strng) {
        this.s = strng;
    }

    /**
     * Input validation.
     *
     * @return    boolean { True or false }
     */
    boolean validateData() {
        int len = s.length();
        final int six = 6;
        return (len >= six);

    }
}

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
    public static void main(final String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);       
        System.out.println(i.validateData());

    }

}
