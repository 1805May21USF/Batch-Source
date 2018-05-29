/**
 * Create an ArrayList which stores numbers from 1 to 100 and prints
 * out all the prime numbers to the console.
 *  
 *  Completed: Yes
 */
package com.revature.corejava;

import java.util.ArrayList;

/**
 * @author Nicholas Smith
 *
 */
public class Q09
{
	//create global variables
	ArrayList<Integer> numList;
	ArrayList<Integer> primeList;
	
	//create a method that creates the arraylist
	public ArrayList<Integer> makeArrayList()
	{
		//initialize numList
		numList = new ArrayList<Integer>();
		
		//create a loop and populate the ArrayList
		for(int i = 1; i <= 100; i ++) 
		{			
			//add i to numList
			numList.add(i);
			
		}
		
		return numList;
	}
	
	//create a method that determines if the number is prime
	//takes an int
	//returns a boolean
	public boolean isPrime(int num) 
	{
		//a number is prime if it is only divisible by 1 and itself		
		//divide num by every number leading up to in
		for (int i = 2; i < num; i ++) 
		{
			//if num divides evenly by i
			if(num % i == 0) 
			{
				//num is not prime
				return false;
			}	
		}
		//num only divides evenly by 1 and itself
		return true;
	}
	
	//create a method that creates an arraylist that contains primes
	public ArrayList<Integer> makePrimeArrayList()
	{
		//initialize primeList
		primeList = new ArrayList<Integer>();
		
		//populate primeList with prime nums from numList
		int i = 0;
		while (i < 100) 
		{			
			//assign number to the current element in numList at index i
			int number = numList.get(i);
			
			//test to see if number is prime
			boolean prime = isPrime(number);
			
			if(prime == true) 
			{
				//add number to primeList
				primeList.add(number);
			}
			
			//increment i
			i++;
		}
		
		//temp
		return primeList;
	}
}
