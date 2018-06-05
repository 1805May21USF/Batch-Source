/**
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * 
 * Completed: Yes
 */
package com.revature.corejava;

//import the Arrays Class
import java.util.Arrays;

/**
 * @author Nicholas Smith
 *
 *I used recursion to solve this problem.
 */
public class Q02
{
	//create a method to compute the Fibonacci number at the nth position
	public int fibonacci(int n)
	{
	    if (n <= 1) 
	    {
	    	return n;
	    }
	    else
	    {
	    	return fibonacci(n-1) + fibonacci(n-2);
	    }  
	}
	
	//create a method to populate an int array with the first 25 Fibonacci numbers
	public int [] fibonacciArray() 
	{
		//create an int Array to store the Fibonacci numbers
		int[] fibonacciArray = new int[25];
		
		//call the Fibonacci method
		//Start with 0
		//End with 24
		
		//create a for loop
		for (int i = 0; i < 25; i++)
		{
			fibonacciArray[i] = fibonacci(i);
		}
		
		return fibonacciArray;
	}
	
	//create a method to print the solution to the question 
	public void printSolution() 
	{
		System.out.println("Q2: " + Arrays.toString(fibonacciArray()));
	}
}
