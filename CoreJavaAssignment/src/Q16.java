
public class Q16 {
	/*
	 * Q16. Write a program to display the number of characters for a string input.
	 * The string should be entered as a command line argument using (String []
	 * args).
	 */
	public static void main(String[] args) {
		System.out.println("Q16. Write a program to display the number of characters"
				+ " for a string input. The string should be entered as a command "
				+ "line argument using (String [ ] args).");
		try {
			// Check if there is exactly 1 argument
			if (args.length > 1 || args.length == 0) {
				System.out.print("ERROR: You entered: ");
				for (int i = 0; i < args.length; i++) {
					System.out.print(args[i] + " ");
				}
				System.out.println("There should be only one argument. Please try again. "
						+ "If your string has more than one word, please use double quotes. Ex. \"Example of some words\"");
				System.exit(0);
			} else {
				int count = 0;
				// Loops through the string and counts the number of characters
				for (int i = 0; i < args[0].length(); i++) {
					if (args[0].charAt(i) != ' ') {
						count++;
					}
				}
				System.out.println("The number of characters in the string \"" + args[0] + "\" is: " + count);
			}
		} catch (Exception ex) {
			System.out.println("Error.");
		}

	}

}
