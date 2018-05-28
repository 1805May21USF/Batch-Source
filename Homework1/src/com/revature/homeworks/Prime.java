package com.revature.homeworks;

import java.util.ArrayList;

public class Prime {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	public ArrayList<Integer> primeNumbers()
	{
		//declare and array lists of Integers to store numbers
		ArrayList<Integer> intList = new ArrayList();
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		//for loop adds numbers from 0-100
		for(int i = 0; i <= 100; i++)
		{
			int currentNumber = i;
			intList.add(i);
			
		}
		
		
		//for loop to validate if number is prime and add to primeList
		for (int j = 0; j <= intList.size() - 1; j++)
		{
			boolean prime = isPrime(intList.get(j));
			
			if (prime == true)
			{
				primeList.add(intList.get(j));
			}
		}
		
		return primeList;
		
	}
	
	public boolean isPrime(int n)
	{
		//Check for 2
		if (n == 1 || n != 2 && n%2==0)
		{
			return false;
		}
		
		//formula loop to determine if number is prime checks only the odds sicne the number isnt a multiple of two
		for (int i = 3; i*i <n; i+=2)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	//run method that is called by the main
		 public void run()
			{
					System.out.println("Question Nine: " + newLine + "-----------------------------");
					System.out.println("Printing out the prime numbers from 1 - 100");
					System.out.println(primeNumbers());
					System.out.println("-----------------------------");
					System.out.println();
			}

}
