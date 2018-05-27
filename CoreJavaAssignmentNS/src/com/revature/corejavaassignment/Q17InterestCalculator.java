package com.revature.corejavaassignment;

public class Q17InterestCalculator {

	private static double interestCalculator(double principal, double rate, double time) {
		return principal * rate * time;
	}

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

	public static void main(String[] args) {
		interestCalculatorDemo();
	}

}
