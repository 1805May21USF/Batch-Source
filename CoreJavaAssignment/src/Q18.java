public class Q18 extends superClass {
	/*
	 * Q18. Write a program having a concrete ;subclass that inherits three abstract
	 * methods from a superclass. Provide the following three implementations in the
	 * subclass corresponding to the abstract methods in the superclass:
	 * 
	 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’
	 * depending if any are found. 2. Convert all of the lower case characters to
	 * uppercase in the input string, and return the result. 3. Convert the input
	 * string to integer and add 10, output the result to the console.
	 * 
	 * Create an appropriate class having a main method to test the above setup.
	 */
	public static void main(String[] args) {
		Q18 t = new Q18();
		System.out.println("Is \"Hello\" uppercase? " + t.checkUppercase("Hello"));
		System.out.println("Convert \"roll ride\" to uppercase: " + t.toUppercase("roll tide"));
		System.out.println("Add 10 to a string value of \"5\": " + t.addTen("5"));

	}

}

abstract class superClass {
	superClass() {

	}

	/*
	 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’
	 * depending if any are found.
	 */
	public static boolean checkUppercase(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * 2. Convert all of the lower case characters to uppercase in the input string,
	 * and return the result.
	 */
	public static String toUppercase(String str) {
		return str.toUpperCase();
	}

	/*
	 * 3. Convert the input string to integer and add 10, output the result to the
	 * console.
	 */
	public int addTen(String str) {
		return Integer.parseInt(str) + 10;
	}

}
