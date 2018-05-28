package com.revature.corejavaassignment;

/**
 * Calculates the interest after an amount of time.
 * @author Nathaniel Simpson
 *
 */
public class Q17InterestCalculator {

	/*
	 * Calculates the interest.
	 * @param principal - initial amount of money
	 * @param rate - interest rate
	 * @param time - time in years
	 */
	private static double interestCalculator(double principal, double rate, double time) {
		return principal * rate * time;
	}

	/*
	 * Demonstrates the interest calculator.
	 */
	public static void interestCalculatorDemo() {
		double principal = 0;
		double rate = 0;
		double time = 0;

		System.out.println("Q17. Interest Calculator");
		System.out.println("\tWelcome to the Roll Tide interest calculator!");

		try {
			System.out.print("\tPlease enter the principal: ");
			principal = AssignmentDemo.in.nextDouble();
			System.out.print("\tPlease enter the rate (percentage): ");
			rate = AssignmentDemo.in.nextDouble() / 100;
			System.out.print("\tPlease enter the time in years: ");
			time = AssignmentDemo.in.nextDouble();
		} catch(Exception e) {
			System.out.println("\tYour input is not Roll Tide (Invalid input. Must be doubles.)");
		}
		
		System.out.printf("\tThe interest is $%.2f. Have a Roll Tide day!\n", 
				interestCalculator(principal, rate, time));
		System.out.println();
		
	}

	/*
	 * For testing
	 */
	public static void main(String[] args) {
		interestCalculatorDemo();
	}

}
