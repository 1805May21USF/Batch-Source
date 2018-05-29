/**
 * Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 * 
	0 * * *
	1 0 * *
	1 0 1 *
	0 1 0 1
 *
 * Completed: No
 */
package com.revature.corejava;

/**
 * @author Nicholas Smith
 *
 */
public class Q13
{
	//use an array of arrays?
	//create an array of arrays
	//String[][] array;
	
	//create a method to create the array of arrays (2D array)
	//return 2D array
	public String[][] makeArray()
	{
		System.out.println("I am in the makeArray method");
		
		//initialize the array
		//it is 4 X 4
		String[][]array = 
				  {	
					{"0", "", "", ""},
					{"1", "0", "", ""},
					{"1", "0", "1", ""},
					{"0", "1", "0", "1"}
				  };
		
		return array;
	}
	
	//create a method to print the 2D array
	//takes in a 2D String array
	public void printArray(String[][] array) 
	{
		System.out.println("I am in the printArray method");
	}
	
}
