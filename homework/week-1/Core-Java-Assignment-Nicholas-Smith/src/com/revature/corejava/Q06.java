/**
 * Write a program to determine if an integer is even without using the modulus operator (%)
 * 
 * Completed: Yes
 */
package com.revature.corejava;

/**
 * @author Nicholas Smith
 *
 */
public class Q06
{
	//create a method to print the solution to the problem
	public void printSolution(boolean b) 
	{
		System.out.println("Q6: " + b);
	}
	
	//create a method to determine is an integer is even
	public boolean isEven(int number) 
	{
		//NOTE: when an odd int is divided by 2, the remainder is cut off.
		//This means that if the result is doubled, it will be exactly 
		//1 less than orginal odd int.
				
		int dividedBy2 = number/2;
		
		int newNumber = dividedBy2 * 2;
		
		//compare the number that was passed in to
		//when it was divided by 2 then doubled again
		if(number != newNumber) 
		{
			return false;
		}
		
		return true;
	}
}
