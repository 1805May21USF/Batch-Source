import java.util.Scanner;

public class Q3 {
	/*
	 * Reversing a string without using a temporary variable by using the substring
	 * method from the String class.
	 */
	public static void main(String[] args) {
		System.out.println("Q3. Reverse a string without using a temporary variable. "
				+ " Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.");
		System.out.print("Please enter a String: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();

		System.out.println("\tResult: " + reverseString(s));
		input.close();

	}

	/*
	 * The reverseString method takes a String as an input. The String saves over
	 * itself using the substring method while iterating the number of times based
	 * on the length of the String.
	 */
	static String reverseString(String str) {
		for (int i = 0; i < str.length(); i++) {
			str = str.substring(1, str.length() - i) + str.substring(0, 1)
					+ str.substring(str.length() - i, str.length());
		}
		return str;
	}

}