/**
 * Find the minimum of two numbers using ternary operators.
 * 
 * Completed: Yes
 */
package com.revature.corejava;

/**
 * @author Nicholas Smith
 *
 */
public class Q10
{	
	//created a method to find the minimum of two numbers
	//takes 2 ints
	//returns the smaller int
	public int findMin(int a, int b) 
	{
		//assign min to smaller value
		int min = (a < b) ? a : b;
		
		//return min
		return min;
	}
}
