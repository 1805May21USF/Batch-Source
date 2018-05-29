/**
 *  Write a program to store numbers from 1 to 100 in an array.
 *  Print out all the even numbers from the array. Use the 
 *  enhanced FOR loop for printing out the numbers.
 *  
 *  Completed: No
 */
package com.revature.corejava;

/**
 * @author Nicholas Smith
 *
 */
public class Q12
{
	//create global variables
	int [] intArray;
	int [] evenIntArray;
	
	//create a method to make an array of ints
	//it returns an int array
	public int[] makeIntArray() 
	{
		//initialize the intArray
		//it can hold 100 elements
		intArray = new int[100];
		
		//populate the array with 1-100
		int index = 0;
		for(int i = 1; i <= 100; i ++) 
		{
			//add i to the current index of the array
			intArray[index] = i; 
	
			//increment index
			index ++;
		}
		
		return intArray;
	}
	
	//make a method to create an array that holds even numbers
	//takes in an int Array
	//returns an int Array
	public int[] makeEvenIntArray(int[] array) 
	{
		
		//initialize evenIntArray
		//it holds 50 elements
		evenIntArray = new int[50];
		
		int evenIndex = 0;
		//populate evenIntArray with the even elements from intArray
		for(int i = 0; i <= 99; i++) 
		{
			//element is equal to the element at the ith index position in intArray
			int element = intArray[i];
			
			//if element is even, add it to evenIntArray
			if (element % 2 == 0)
			{
				evenIntArray[evenIndex] = element;
				
				//increment evenIndex
				evenIndex ++;
			}
		}
		
		return evenIntArray;
	}
	
	//make a method to print the even array using an enhanced for loop
	public void printSolution() 
	{
		
		//use an enhanced for loop to print the elements from evenIntArray
		for (int currentElement: evenIntArray) 
		{
			System.out.println("Q12: " + currentElement);
		}
		
	}
	
}
