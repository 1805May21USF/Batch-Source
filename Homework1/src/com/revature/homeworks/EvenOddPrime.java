package com.revature.homeworks;

import java.util.ArrayList;

public class EvenOddPrime {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	public void work()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		ArrayList<Integer> odd = new ArrayList<Integer>();
		
		
		//adds integers 1- 10 to arraylist
		for(int i = 1; i <= 10; i++)
		{
			ints.add(i);
			
		}
		System.out.println(ints);

		//For each loop that grabs i, checks if its even then adds it to even arrayList 
		for(int i : ints)
		{
			if (i % 2 == 0)
			{
				even.add(i);
						
			}
		}
		int sum = 0;
		
		//adds evens up
		for (int i = 0; i < even.size(); i++)
		{
			sum += even.get(i);
		}
		System.out.println(sum);
		
		
		//For each loop that grabs i, checks if its odd then adds it to odd arrayList
		for(int i : ints)
		{
			if (i % 2 != 0)
			{
				odd.add(i);
								
			}
		}		
		int sum2 = 0;
				
		//adds odds up
		for (int i = 0; i < odd.size(); i++)
		{
			sum2 += odd.get(i);
		}
		System.out.println(sum2);
		
		
		//for loop to validate if number is prime and removes it from List
		for (int j = 0; j <= ints.size() - 1; j++)
		{
			boolean prime = isPrime(ints.get(j));
			
			if (prime == true)
			{
				ints.remove(ints.get(j));
			}
		}
		
		System.out.println(ints);
		
		
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
					System.out.println("Question Nineteen: " + newLine + "-----------------------------");
					System.out.println("Printing out initial list, sum of evens, sum of odds and list without primes.");
					work();
					System.out.println("-----------------------------");
					System.out.println();
			}

}
