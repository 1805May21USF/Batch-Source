package com.revature.homeworks;

public class Factorial 
{
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	
	//methods that uses recursion of itself to compute the factorial
	public int factorialN(int number)
	{
		
		if(number == 0)
		{
			return 1;
		}
		int answer;
		
		answer = factorialN(number - 1) * number;
		
		return answer;
		
	}
	
	
	//run method that is called by the main
		 public void run()
		{
				System.out.println("Question Four: " + newLine + "-----------------------------");
				System.out.println("Printing N factorial: ");
				System.out.println(factorialN(5));
				System.out.println("-----------------------------");
				System.out.println();
		}

}
