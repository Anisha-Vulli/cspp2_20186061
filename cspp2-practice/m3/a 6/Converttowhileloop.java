/**
 * Author : Anisha Vulli.
 * Date : 29th Aug 2018.
 */

public final class Converttowhileloop {
    /**
     * Constructs the object.
     */
    private Converttowhileloop() {
        //Empty constructor.
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        final int range = 10;
        while (i <= range) {
            System.out.println(i);
            i = i + 2;
        }

        System.out.println("GoodBye!!");
    }
}
