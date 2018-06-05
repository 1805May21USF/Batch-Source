/**
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 * 
 * Completed: Yes 
 */
//use this package
package com.revature.corejava;

//import the Arrays Class
import java.util.Arrays;

/**
 * @author Nicholas Smith
 *
 *I used for loops and if statements to solve this problem.
 *I compared the first element of the array to the second element
 *of the array. If it was less than it, I swapped it.
 *Then I moved on to the next element. I used the same method.
 *I then looped over the array again, comparing adjacent elements.
 *The array becomes sorted after the outer loop finishes looping
 *11 times. 
 *
 */
public class Q01
{
	//create the int array
	private int[] intArray = new int[]{1,0,5,6,3,2,3,7,9,8,4};
	
	//create a method to perform a bubble sort on the int array.
	public void bubbleSort() 
	{
		//created an int to store the length of the array (11)
		int length = intArray.length;
		
		//loop 11 times
        for (int i = 0; i < length-1; i++)
        {
        	//loop 11 times
        	for (int j = 0; j < length-i-1; j++) 
            {
        		//if the preceding element in the array is less than the next element
            	if (intArray[j] > intArray[j+1])
                {
                    //create a temp variable to hold the value of the element
                    int temp = intArray[j];
                    //assign the element at the jth index to the next element 
                    intArray[j] = intArray[j+1];
                    //assign the next element to the previous element
                    intArray[j+1] = temp;
                    //the elements are now swapped
                }
            }
        }             	
	}
	//exit bubbleSort()
	
	//create a new method to print the solution to the question
	public void printSolution() 
	{
		//the array is currently an intArray. 
		//convert it using toString()
		System.out.println("Q1: " + Arrays.toString(intArray));
	}
	
}
