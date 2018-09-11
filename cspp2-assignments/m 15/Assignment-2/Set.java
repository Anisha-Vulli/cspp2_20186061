import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class Set {
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
    public Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public Set(final int capacity) {
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
     * Adding a element in a particular index.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
     if (index < 0) {
         System.out.println("Negative Index Exception");
     } else {
         for (int i = size; i > index; i--) {
             set[i] = set[i - 1];
         }
         set[index] = item;
         size++;
     }
    }
    /**
     * Getting the element in the index.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
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
     * Checking if the element is present in the set or not.
     *
     * @param      item  The item
     *
     * @return     { boolean based on the checking }
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { value of the particular index }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Intersection of two sets.
     *
     * @param      set1  The set 1
     *
     * @return     { intersected set }
     */
    public Set intersection(final Set set1) {
        Set s1 = new Set();
        for (int  i = 0; i < this.size(); i++) {
            if (set1.contains(this.get(i))) {
                s1.add(this.get(i));
            }
        }
       return s1;
    }

   /**
    * Retainsall function.
    *
    * @param      intArray  The int array
    *
    * @return     { Set }
    */
    public Set retainAll(final int[] intArray) {
        Set set = new Set();
        for (int each : intArray) {
            set.add(each);
        }
        return intersection(set);
    }
    
    /**
     * Cartesian product of two sets.
     *
     * @param      set1  The set 1
     *
     * @return     { Cartesian product array }
     */
    public int[][] cartesianProduct(final Set set1) {
        if (this.size() == 0 || set1.size() == 0) {
            return null;
        }

        int[][] cartesianprod = new int[this.size() * set1.size()][2];
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < set1.size(); j++) {
                cartesianprod[count][0] = this.get(i);
                cartesianprod[count++][1] = set1.get(j);
            }
        }
        return cartesianprod;
    }

}