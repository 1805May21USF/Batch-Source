package com.revature.assignments;

public class Q17 {
		
	private static float interest;
	private static float rate;
	private static int time;
	private static float principal;

	
	public Q17() {
	}
	
	//calculate the interest rate.
	public void CalculateInterest(float rate, float principal, int time ) {
		
		
		interest = ((rate * time) * principal)/100;
		//change to variable
	
	}
	
	//print the interestRate.
	public void printInterest() {
		System.out.println(interest);
	}
		
	
	
}
