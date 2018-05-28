package com.revature.homeworks;

public class EnhancedForEven {
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	
	public void efe()
	{
		//declaration of integer array which hold 100 values
		int[] arr = new int[101];
		
		//for loop to fill array up numbers from 1 - 100
		for(int i = 0; i <= 100; i++)
		{
			arr[i] = i;
		}
		
		
		//For each loop that grabs i, checks if its even, and prints it out 
		for(int i : arr)
		{
			if (i % 2 == 0)
			{
				System.out.print(i + ", ");
				
			}
		}
		
		System.out.println();

	}
	

	
	//run method that is called by the main
	 public void run()
		{
			System.out.println("Question Twelve: " + newLine + "-----------------------------");
			System.out.println("Printing out the even numbers from 1- 100. (Using For Each)");
			efe();
			System.out.println("-----------------------------");
			System.out.println();
		}

}
