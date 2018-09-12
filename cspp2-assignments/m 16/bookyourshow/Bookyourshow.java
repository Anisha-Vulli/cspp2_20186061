/**
 * BufferedInputStream.
 */
import java.io.BufferedInputStream;
/**
 * Scanner class.
 */
import java.util.Scanner;
/**
 * Arrays.
 */
import java.util.Arrays;

public class Bookyourshow {
    public int size;
    public String[] mve;
    public void add(final String[] details) {
        mve[size++] = details;
        System.out.println(Arrays.toString(mve));
    }
}