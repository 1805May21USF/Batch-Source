package com.revature.homeworks;

public class Minimum {
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	
	//ternary method.determines is x is less than y, if it is, x is the minimum, else y.
	public int ternary(int x, int y)
	{
		int minimumValue = (x < y) ? x : y;
		return minimumValue;
	}
	
	
	//run method that is called by the main
	 public void run()
		{
			System.out.println("Question Ten: " + newLine + "-----------------------------");
			System.out.println("Printing out the Minimum of  158 and 236 using Ternary operators");
			System.out.println(ternary(158, 236));
			System.out.println("-----------------------------");
			System.out.println();
		}

}
