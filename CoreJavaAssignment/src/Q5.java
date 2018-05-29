import java.util.InputMismatchException;
import java.util.Scanner;

public class Q5 {
	/*Rol
	 * Write a substring method that accepts a string str and an integer idx and
	 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
	 * of the existing substring methods in the String, StringBuilder, or
	 * StringBuffer APIs.
	 */
	public static void main(String[] args) {
		System.out.println("Q5. Write a substring method that accepts a string str "
				+ "and an integer idx and returns the substring contained "
				+ "between 0 and idx-1 inclusive.  Do NOT use any of the existing"
				+ " substring methods in the String, StringBuilder, or StringBuffer APIs.");
		// A try-catch function is used to catch possible exceptions due to the user
		// input
		try {
			// A scanner is used to read the user's input for a string and integer
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter a string: ");
			String t = input.nextLine();
			System.out.print("Please enter an integer: ");
			int i = input.nextInt();
			// A substring method will accept the user's input and return a string that is
			// between 0 and the user specified index.
			System.out.println(substring(t, i));
			input.close();
			// We use InputMismatchException in case the user attempts to enter a character
			// where an integer is required
		} catch (InputMismatchException ex) {
			System.out.println("You have entered the incorrect input format. Please try again.");
		} catch (StringIndexOutOfBoundsException ex) {
			System.out.println("Your integer is too large for your string. Please try again.");
		}

	}

	static String substring(String str, int idx) {
		String result = "";
		for (int i = 0; i < idx; i++) {
			result += str.charAt(i);
		}
		return result;
	}

}
