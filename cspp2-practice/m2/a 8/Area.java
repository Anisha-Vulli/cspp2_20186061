/**.

    * Author: Anisha Vulli.
    * Date: 27th Aug

*/
import java.util.Scanner;
/**
 * Area of circle calcualtion.
 */
public final class Area {
    /**
     * Constructs the object.
     */

    private Area() {
    // Empty constructor
    }
    /**
     * Function for defining pi value.
     *
     * @return     pi value
     */

    static double pi() {
        final double pi = 3.14;
        return pi;
    }

    /**
     * Area calcualting function.
     *
     * @param      r     Radius of circle
     *
     * @return     Area of circle returns
     */

    static double areaofcircle(final double r) {
        final double area;
        area = pi() * r * r;
        return area;
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /*Main function*/
        final double r;
        Scanner in = new Scanner(System.in);
        r = in .nextDouble();
        Area obj = new Area();
        System.out.println(obj.areaofcircle(r));
    }
}
