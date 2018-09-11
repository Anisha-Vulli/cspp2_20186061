/**.
 * Creates a input stream
 */
import java.io.BufferedInputStream;
/**.
 * Scanner class for taking the input
 */
import java.util.Scanner;
/**.
 * for array operations
 */
import java.util.Arrays;
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
	/**
	 * Constructs the object.
	 *
	 * @param      s     { parameter_description }
	 */
	SetEmptyException(final String s) {
		super(s);
	}
}

/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
	/**
	 * Constructs the object.
	 *
	 * @param      s     { parameter_description }
	 */
	InvalidSubsetSelectionException(final String s) {
		super(s);
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

    /**.
     * Add function to add the elements into the set
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }

    /**
     * Subset of the given set.
     *
     * @param      startelement                     The startelement
     * @param      endelement                       The endelement
     *
     * @return     { array of subset }
     *
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] SubSet(final int startelement, final int endelement)
    throws InvalidSubsetSelectionException {
    	//System.out.println("hello");
    	int start = getIndex(startelement);
        int end = getIndex(endelement);
    	if (start > end) {
    		throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");
    	} else {
            int[] subset = new int[start - end];
            int k = 0;
            for (int i = start; i < end; i++) {
            	subset[k++] = this.get(i);
            }
            return subset;
    	}
    }

    /**
     * Headset function
     *
     * @param      element         The element
     *
     * @return     { array of headset }
     *
     * @throws     SetEmptyException                { exception_description }
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] headSet(final int element) throws SetEmptyException,
    InvalidSubsetSelectionException {
        if (element <= this.get(0)) {
        	throw new SetEmptyException("Set Empty Exception");
        } else {
        	return SubSet(get(0), element);
        }
    }

    /**
     * Last element in the set.
     *
     * @return     { last element in the set }
     *
     * @throws     SetEmptyException  { Empty set exception }
     */
    public int last() throws SetEmptyException {
        if (size() == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
        	return get(size() - 1);
        }
    }

    /**
     * Gets the index.
     *
     * @param      item  The item
     *
     * @return     The index.
     */
    public int getIndex(final int item) {
    	for (int i = 0; i < size(); i++) {
    		if (item == this.get(i)) {
    			return i;
    		}
    	}
    	return size();
    }
}

public class Solution {
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
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "SubSet":
                try {
                    String[] arrstring = tokens[1].split(",");
                    int[] subarray = s.SubSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.add(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                } catch (InvalidSubsetSelectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "headSet":
                try {
                    int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                    Set headset = new Set();
                    headset.add(headarray);
                    if (headset != null) {
                        System.out.println(headset);
                    }
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidSubsetSelectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "intersection":
                s = new Sortedset();
                Sortedset t = new Sortedset();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
            break;
            case "retainAll":
                s = new Sortedset();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
            break;
            case "cartesianProduct":
                s = new Sortedset();
                t = new Sortedset();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
            break;
            default:
                break;
            }
        }
    }
}