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
     * Gets the set.
     *
     * @return     The set.
     */
    int[] getSet() {
        return set;
    }
    /**
     * Sets the set.
     *
     * @param      sets  The sets
     */
    void setSet(final int[] sets) {
        this.set = sets;
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
     * Adding array of values function.
     *
     * @param      values  The values
     */

    public  void add(final int[] values) {
        for (int each : values) {
            add(each);
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
     *
     * @return     { intersected set. }
     */
    public Set intersection(final Set set1) {
        if (this.size() == 0 || set1.size() == 0) {
            return new Set();
        }

        Set s1 = new Set();
        for (int  i = 0; i < this.size(); i++) {
            if (set1.contains(this.set[i])) {
                s1.add(this.set[i]);
            }
        }
       //System.out.println(s1.toString());
       return s1;
    }

   /**
    * Retain all function.
    *
    * @param      intArray  The int array
    *
    * @return     { intersected set. }
    */
    public Set retainAll(final int[] intArray) {
        Set set2 = new Set();
        set2.add(intArray);
        return this.intersection(set2);
    }
    /**
     * Cartesian product of two sets.
     *
     * @param      set1  The set 1
     *
     * @return     { cartesian product array }
     */

    public int[][] cartesianProduct(final Set set1) {
        if (this.size() == 0 || set1.size() == 0) {
            return null;
        }

        int[][] cartesianprod = new int[this.size() * set1.size()][2];
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < set1.size(); j++) {
                cartesianprod[count][0] = this.set[i];
                cartesianprod[count++][1] = set1.set[j];
            }
        }
        return cartesianprod;
    }

}

/**
 * Class for sortedset.
 */
class Sortedset extends Set {
    /**
     * Constructs the object.
     */
    Sortedset() {
        super();
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        Arrays.sort(getSet(), 0, size());
        return super.toString();
    }

    /**
     * Subset of the given set.
     *
     * @param      startelement  The startelement
     * @param      endelement    The endelement
     *
     * @return     { subset }
     */
    public Set subSet(final int startelement, final int endelement) {
        int start = startelement;
        int end = endelement;
        if (end < start) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        }

        Set subset = new Set();
        while (start < end) {
            if (contains(start)) {
                subset.add(start);
            }
            start++;
        }

        return subset;
    }

    /**
     * Headset of the given set.
     *
     * @param      element  The element
     *
     * @return     { head value }
     */

    public Set headSet(final int element) {
        Set head = new Set();
        for (int i = 0; i < size(); i++) {
            if (getSet()[i] < element) {
                head.add(getSet()[i]);
            }
        }
        return head;
    }


    /**
     * last value.
     *
     * @return     { value }
     */
    public int last() {
        if (size() <= 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        Arrays.sort(getSet(), 0, size());
        int s = size() - 1;
        return getSet()[s];
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
        Sortedset s = new Sortedset();
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
                case "addAll":
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "subSet":
                String[] strArray = tokens[1].split(",");
                intArray = new int[2];
                intArray[0] = Integer.parseInt(strArray[0]);
                intArray[1] = Integer.parseInt(strArray[1]);
                Set sub = s.subSet(intArray[0], intArray[1]);
                if (sub != null) {
                    System.out.println(sub);
                }
                break;
                case "headSet":
                String[] strArray1 = tokens[1].split(",");
                intArray = new int[1];
                intArray[0] = Integer.parseInt(strArray1[0]);
                System.out.println(s.headSet(intArray[0]));
                break;
                case "last":
                System.out.println(s.last());
                break;
                // case "intersection":
                // s = new Set();
                // Set t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(s.intersection(t));
                // break;
                // case "retainAll":
                // s = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // System.out.println(s.retainAll(intArray));
                // break;
                // case "cartesianProduct":
                // s = new Set();
                // t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(
                // Arrays.deepToString(s.cartesianProduct(t)));
                // break;
                default:
                break;
            }
        }
    }
}





