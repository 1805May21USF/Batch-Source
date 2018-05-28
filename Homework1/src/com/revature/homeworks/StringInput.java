package com.revature.homeworks;

public class StringInput {
	
	
	String word;
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	//run method that is called by the main
	public String run(String x)
	{	
		System.out.println();
		System.out.println(newLine + "Question Sixteen: " + newLine + "-----------------------------");
		word = x;
		System.out.println("This word contains " + word.length() + " characters");
		System.out.println("-----------------------------" + newLine);
		return x;
	}

}
