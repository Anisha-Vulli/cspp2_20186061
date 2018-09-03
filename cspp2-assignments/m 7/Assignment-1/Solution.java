import java.util.*;
class InputValidator
{
	private String s;
	InputValidator(String strng) {
		this.s = strng;
	}

	boolean validateData() {
		int len = s.length();
		if (len >= 6) {
			return true;
		} else {
			return false;
		}
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
