import java.io.File;
import java.util.Scanner;

public class Q20 {
	/*
	 * Q20. Create a notepad file called Data.txt and enter the following:
	 * Mickey:Mouse:35:Arizona Hulk:Hogan:50:Virginia Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 * 
	 * Write a program that would read from the file and print it out to the screen
	 * in the following format:
	 * 
	 * Name: Mickey Mouse Age: 35 years State: Arizona State
	 */

	public static void main(String[] args) {
		try {
			// The text file is located within the package
			File file = new File("src\\Data.txt");
			Scanner input = new Scanner(file);
			// The while loop traverses through the file
			while (input.hasNext()) {
				// Read each line as a String and replace all : with a space
				// Then the String is split at each space into an array of words
				String t = input.next();
				t = t.replace(':', ' ');
				String[] words = t.split("\\s+");
				// The array of words are printed in the desired format
				System.out.printf("Name: %s %s\nAge: %s\nState: %s State\n\n", words[0], words[1], words[2], words[3]);
			}
			input.close();
		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}

	}
}
