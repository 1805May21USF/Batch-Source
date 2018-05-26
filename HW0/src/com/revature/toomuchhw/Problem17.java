package com.revature.toomuchhw;
/*	Q17. Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
*/
public class Problem17 {
	
	private int principal;
	private double interest;
	private int years;
	
	public Problem17(int principal, double interest, int years) {
		super();
		this.principal = principal;
		this.interest = interest;
		this.years = years;
	}

	public double calcInterest() {
		return principal*interest*years;
	}
}
