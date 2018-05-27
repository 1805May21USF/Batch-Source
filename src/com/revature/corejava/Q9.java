package com.revature.corejava;

import java.util.ArrayList;

public class Q9 
{
	private ArrayList<Integer> numberList;
	
	//Creates the ArrayList of 1-00 Integer
	public Q9()
	{
		this.numberList = new ArrayList<Integer>();
		
		for(int i = 1; i<=100; i++)
		{
			this.numberList.add(i);
		}
	}
	//Checks to see if a single number is prime or not
	public boolean isPrime(Integer number)
	{
		for(int i=2;i<number;i++) {
	        if(number % i ==0)
	            return false;
	    }
	    return true;
		
	}
	//Prints out the prime numbers
	public void displayPrimeNumbers()
	{
		for(int i = 0; i<this.numberList.size(); i++)
		{
			if(isPrime(this.numberList.get(i)))
			{
				System.out.print(this.numberList.get(i).toString()+" ");
			}
		}
		System.out.print("\n");
	}
}
