/**
 * Author: Anisha Vulli.
 * Date: 04th Sept 2018.
 */

/**
 * Buffered input stream method.
 */
import java.io.BufferedInputStream;
/**
 * Scanner method from util class.
 */
import java.util.Scanner;
/**
 * Array method.
 */
import java.util.Arrays;

/**
 * List of .
 */
public class List {

    //Implement all the methods mentioned to build a ListADT

    /**
     * Array declaration.
     */
    private int[] arr;

    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor



    /**
     * Size declaration.
     */
    private int size;

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /**
     * Constructs the object.
     */
    public List() {
        /**
         * Array declaration.
         */
        final int ten = 10;
        arr = new int[ten];
        size = 0;
    }

    /**
     * Add function described.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.

        arr[size] = item;
        size += 1;
    }

    /**
     * Size function.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /**
     * Remove function.
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        final int nine = 9;
        final int ten = 10;
        if (index <= nine) {
            int[] temparr = new int[ten];
            for (int i = 0, j = 0; i < ten; i++, j++) {
                    if (i == index - 1) {
                        temparr[j] = arr[i];
                        i += 1;
                    } else {
                        temparr[j] = arr[i];
                    }
            }

            arr = temparr.clone();
            size -= 1;

        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    /**
     * Get function.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (arr[index] != 0) {
            System.out.println(arr[index]);
        }
        return -1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        int[] emptyarr = new int[size];
        System.arraycopy(arr, 0, emptyarr, 0, size);
        return (Arrays.toString(emptyarr)).replace(" ", "");
    }

    /**
     * Function to check if contains.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        final int ten = 10;
        for (int i = 0; i < ten; i++) {
            if (arr[i] == item) {
                return true;
            }
        }

        return false;
    }

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below
        final int ten = 10;
        for (int i = 0; i < ten; i++) {
            if (arr[i] == item) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Count function.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */

    public int count(final int item) {
        int countval = 0;
        for (int i = 0; i < size; i++) {
            if (item == arr[i]) {
                countval = countval + 1;
            }
        }

        return countval;
    }

    /**
     * Adds all.
     *
     * @param      array  The array
     */

    public void addAll(final int[] array) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * Adds a 1.
     *
     * @param      index  The index
     * @param      item   The item
     */

    public void add1(final int index, final int item) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;

    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                l.get(Integer.parseInt(tokens[1]));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;

                case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;

                case "addAll":
                int[] array1 = new int[tokens.length - 1];
                for (int i = 0; i < tokens.length - 1; i++) {
                    array1[i] = Integer.parseInt(tokens[i + 1]);
                }
                l.addAll(array1);
                break;

                case "addindex":
                l.add1(Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
                break;

                default:
            }
        }
    }
}


