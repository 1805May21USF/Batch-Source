/**
 *  Write a program that calculates the simple interest on the principal,
 *  rate of interest, and number of years provided by the user. 
 *  
 *  Enter principal, rate and time through the console using the Scanner class.
 *  Interest = Principal * Rate * Time
 *  
 *  Completed: Yes
 */
package com.revature.corejava;

import java.util.Scanner;

/**
 * @author Nicholas Smith
 *
 */
public class Q17
{
	//create global variables
	private double interest = 0;
	private double principal = 0;
	private double rate = 0;
	private double time = 0;
	
	//create a method that computes interest
	public void computeInterest() 
	{		
		//call the getUserInput() method
		getUserInput();
		
		interest = principal * rate * time;
		
		System.out.println("Interest is: " + interest);
	}
	
	//create a method to get user input
	public void getUserInput() 
	{
		//use this method to assign the global variables
		Scanner input = new Scanner(System.in);
		
		//prompt the user to enter the principal
		System.out.println("Please enter the principal: " );
		
		//assign principal to what the user enters
		principal = input.nextDouble(); 
		
		//prompt the user to enter the rate
		System.out.println("Please enter the rate: " );
		
		//rate is assigned to what the user enters
		rate = input.nextDouble();
		
		//prompt the user to enter the time
		System.out.println("Please enter the time: ");
		
		//assign time to what the user enters
		time = input.nextDouble();
		
		//close the scanner
		input.close();
	}
}
