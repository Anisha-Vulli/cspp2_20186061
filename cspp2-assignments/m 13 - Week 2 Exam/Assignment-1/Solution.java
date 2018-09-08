import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Anisha Vulli
 * Date : 08th Sept 2018.
 */

/**
 * Class for set.
 */
class Set {
    /**
     * Size variable declaration.
     */
    private int size;
    /**
     * Set declaration.
     */
    private int[] set;

    /**
     * Constructs the object.
     */
    protected Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    protected Set(final int capacity) {
        size = 0;
        set = new int[capacity];
    }

    /**
     * Adding elements into a set.
     *
     * @param      val   The value
     */
    public void add(final int val) {
        try {
            if (!contains(val)) {
               set[size++] = val;

            }

        } catch (Exception e) {
            resize();
        }
    }


    /**
     * Resizing an set.
     */
    public void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }

    /**
     * Size of a set.
     *
     * @return     { size of the set value }
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the element is present in the set.
     *
     * @param      val   The value
     *
     * @return     { boolean based on the condition }
     */
    public boolean contains(final int val) {
        for (int i = 0; i < size; i++) {
            if (val == set[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + "," + " ";
        }
        str = str + set[i] + "}";
        return str;
    }

    /**
     * Intersection of two sets.
     *
     * @param      set1  The set 1
     * @param      set2  The set 2
     *
     * @return     { intersected set }
     */
    public Set intersection(final Set set1, final Set set2) {
        Set s1 = new Set();
        int a = 0;
        int b = 0;
        if (set1.size() > set2.size()) {
            a = set1.size();
            //System.out.println(a);
            b = set2.size();
        } else {
            a = set2.size();
            b = set1.size();

        }
        for (int  i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (set1.set[i] == set2.set[j]) {
                    s1.add(set2.set[j]);
                }
            }
        }
       //System.out.println(s1.toString());
       return s1;
    }

    /**
     * Retainall Method.
     *
     * @param      set1  The set 1
     * @param      set2  The set 2
     *
     * @return     { set }
     */
    public Set retainAll(final Set set1, final Set set2) {
        Set s1 = new Set();
        int a = 0;
        int b = 0;
        if (set1.size() > set2.size()) {
            a = set1.size();
            //System.out.println(a);
            b = set2.size();
        } else {
            a = set2.size();
            b = set1.size();

        }
        for (int  i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (set1.set[i] == set2.set[j]) {
                    s1.add(set2.set[j]);
                }
            }
        }
       //System.out.println(s1.toString());
       return s1;
    }

    /**
     * Cartesian product method.
     *
     * @param      set1  The set 1
     * @param      set2  The set 2
     *
     * @return     { null }
     */

    public int[] cartesianProduct(final Set set1, final Set set2) {
        int a = 0;
        int b = 0;
        if (set1.size() > set2.size()) {
            a = set1.size();
            //System.out.println(a);
            b = set2.size();
        } else {
            a = set2.size();
            b = set1.size();

        }
        int[][] finalprod = new int[a * b][2];
        // Set finalprod = new Set(a * b);
        for (int  i = 0; i < a; i++) {
            //int[] temparray = new int[2];
            for (int j = 0; j < b; j++) {
                finalprod[i][0] = i;
                finalprod[i][1] = j;
            }
            //Arrays.stream(temparray).toArray();
            // //System.out.println();
            // for (int p = 0; i < finalprod.size(); p++) {
            //     finalprod.add(Arrays.stream(temparray).toArray());
            // }
        }
        // for (int p = 0; p < finalprod.length; p++) {
        //     System.out.println(finalprod[p]);
        // }
        
        System.out.println(finalprod.toString());
        return null;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
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
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        s.add(intArray[i]);
                    }
                }
                break;
                case "intersection":
                Set p = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                for (int i = 0; i < intArray.length; i++) {
                        p.add(intArray[i]);
                        //System.out.println(intArray[i]);
                }
                intArray = intArray(tokens[2]);
                for (int i = 0; i < intArray.length; i++) {
                     t.add(intArray[i]);
                }
                System.out.println(p.intersection(p, t));
                break;
                case "retainAll":
                s = new Set();
                Set k = new Set();
                intArray = intArray(tokens[1]);
                for (int i = 0; i < intArray.length; i++) {
                    s.add(intArray[i]);
                }
                intArray = intArray(tokens[2]);
                for (int i = 0; i < intArray.length; i++) {
                     k.add(intArray[i]);
                }
                System.out.println(s.retainAll(s, k));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                for (int i = 0; i < intArray.length; i++) {
                    s.add(intArray[i]);
                }
                intArray = intArray(tokens[2]);
                for (int i = 0; i < intArray.length; i++) {
                     t.add(intArray[i]);
                }
                s.cartesianProduct(s, t);
                //System.out.println(Arrays.deepToString());
                break;
                default:
                break;
            }
        }
    }
}



