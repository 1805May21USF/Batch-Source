import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14 {
	/*
	 * Write a program that demonstrates the switch case. Implement the following
	 * functionalities in the cases:java Case 1: Find the square root of a number
	 * using the Math class method. Case 2: Display today’s date. Case 3: Split the
	 * following string and store it in a string array. “I am learning Core Java”
	 */
	public static void main(String[] args) {
		System.out.println("Q14. Write a program that demonstrates the switch case. " + "Enter either 1, 2 or 3: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		switch (n) {
		case 1:
			System.out.println("Case 1 - Find the square root of a number "
					+ "using the Math class method. Please enter a number: ");
			double t = input.nextDouble();
			System.out.println("The square root of " + t + " is " + findSquareRoot(t));
			break;
		case 2:
			System.out.print("Case 2 - Display today's date: ");
			printDate();
			break;
		case 3:
			System.out.println(
					"Case 3 - Split the following string and store it in a string array. “I am learning Core Java”");
			storeString();
			break;
		default:
			System.out.println("You did not select good case number.");

		}
		input.close();
	}

	/*
	 * This method uses the sqrt function from the Math class to find the square
	 * root of a double.
	 */
	static double findSquareRoot(double n) {
		return Math.sqrt(n);
	}

	/*
	 * This method creates a Date object. Then the method prints the Date object
	 * using the toString() function. The date is printed in the form of Day Month
	 * Date HH:MM:SS TimeZone Year
	 */
	static void printDate() {
		Date t = new Date();
		System.out.println(t.toString());
	}

	/*
	 * This method takes the String "I am learning Core Java" and stores each
	 * character into a String array. The method prints the array using
	 * Arrays.toString(String[] a) function to convert the array into a String.
	 */
	static void storeString() {
		String stArr = "I am learning Core Java";
		String[] r = new String[stArr.length()];
		for (int i = 0; i < stArr.length(); i++) {
			r[i] = "" + stArr.charAt(i);
		}
		System.out.println(Arrays.toString(r));
	}
}
