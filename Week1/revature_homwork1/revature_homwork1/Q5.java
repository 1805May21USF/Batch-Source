package revature_homwork1;

import java.util.Arrays;

public class Q5 {
	public static String substr(String input, int start, int end){
		return new String(Arrays.copyOfRange(input.toCharArray(),start, end));
	}
	public static String substr(String input, int end) {
		return substr(input, end);
	}
	
}	
