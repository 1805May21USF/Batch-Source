package com.revature.beans;
/*Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class. Interest = Principal* Rate* Time
*/
public class Problem17 {
	private double interest;
	private double principal;
	private double rate;
	private double timeInYears;
	
	public Problem17(double rate, double principal, double timeInYears){
		this.rate = rate;
		this.principal = principal;
		this.timeInYears = timeInYears;
		this.interest = this.rate * this.principal * this.timeInYears;
	}
	
	public double getIntrest(){
		return this.interest;
	}

}
