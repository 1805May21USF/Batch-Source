/**
 * Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 * 
	0 * * *
	1 0 * *
	1 0 1 *
	0 1 0 1
 *
 * Completed: Yes
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
		//loop over the 2D array
		//outer array has indexes 0-3
		
		//outer for loop
		for(int i = 0; i <= 3; i++) 
		{
			//inner for loop
			//inner arrays have indexes 0-3
			for(int j = 0; j <= 3; j++) 
			{
				//print the element 
				String element = array[i][j];
				
				//print on the same line
				System.out.print(" " + element);
			}
			
			//print on the next line after printing the elements in the inner array
			System.out.println("");
		}
	}
	
}
