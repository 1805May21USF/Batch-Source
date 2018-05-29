import java.text.DecimalFormat;
import java.util.Scanner;

public class Q17 {
	/*
	 * Q17. Write a program that calculates the simple interest on the principal,
	 * rate of interest and number of years provided by the user. Enter principal,
	 * rate and time through the console using the Scanner class. Interest =
	 * Principal* Rate* Time
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner is used to read user input
		System.out.println("Q17. Write a program that calculates the simple interest on the"
				+ " principal, rate of interest and number of years provided by the user. "
				+ "Enter principal, rate and time through the console using the Scanner class."
				+ "Interest = Principal* Rate* Time");
		// User must enter the principal.
		System.out.print("Enter the principal: ");
		double principal = input.nextDouble();
		// User must enter the rate of interest.
		System.out.print("Enter the rate of interest: ");
		double rateOfInterest = input.nextDouble();
		// User must enter the number of years.
		System.out.print("Enter the number of years: ");
		double numberOfYears = input.nextDouble();
		// The principal, rate of interest, and number of years are multiplied together
		// to find the interest.
		double interest = principal * rateOfInterest * numberOfYears;
		// To make the output look nicer, we will use DecimalFormat to create the format
		// that contains the symbols $ , and . at the appropriate places.
		DecimalFormat df = new DecimalFormat("$###,###,###.00");
		System.out.println("The interest on the principal (" + df.format(principal) + "), rate of interest ("
				+ rateOfInterest + "), and number of years (" + numberOfYears + ") is: " + df.format(interest));

		input.close();

	}

}
