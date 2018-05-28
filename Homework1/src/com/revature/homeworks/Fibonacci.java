package com.revature.homeworks;

import java.util.ArrayList;

public class Fibonacci 
{
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	//method that returns the array list of fibonacci numbers
	public ArrayList<Integer> fib()
	{
		//create a ArrayList which is a dynamic collection
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		//Add the first two numbers of the Fibonacci sequence
		integerList.add(0);
		integerList.add(1);
		
		//for loop that adds the sum of the previous two numbers to the ArrayList
		for(int i = 0; i < 23; i++)
		{
			int firstNum = integerList.get(i);
			int secondNum = integerList.get(i + 1);
			
			int sum = firstNum + secondNum;
			integerList.add(sum);
		}
		return integerList;
	}
	
	//run method that is called by the main
	 public void run()
	{
			System.out.println("Question  Two: " + newLine + "-----------------------------");
			System.out.println("Printing first 25 Fibonacci numbers: ");
			System.out.println(fib());
			System.out.println("-----------------------------");
			System.out.println();
	}
		
	

}
