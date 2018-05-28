/**
 * Write a program to compute N factorial.
 * 
 * Completed: Yes
 */
package com.revature.corejava;

/**
 * @author Nicholas Smith
 *
 */
public class Q04
{
	//returns an int
	//takes in an int		
	//what is N factorial? It is 5! (5 * 4 * 3 * 2 * 1)
	
	//create global variables
	private int factorial = 0;
	
	//create a method to compute N factorial
	public void factorial(int n) 
	{
		//assign factorial to 1
		factorial = 1;
		
		//loop over n times
		for (int i = 1; i < n + 1; i++)
		{
			//factorial is equal to (1 * 2 * 3 * 4 ....)
			factorial = factorial * i;
		}
	}
	
	//print the solution to the problem
	public void printSolution() 
	{
		System.out.println("Q4: " + factorial);
	}
}
