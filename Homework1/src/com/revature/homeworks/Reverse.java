package com.revature.homeworks;

public class Reverse {
	
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	
	//Reverse method to reverse the string
	public String reverseString()
	{
		String name = "Adegboyega";
		String reverse = "";
		
		//starts at the end of the name and decrements
		for(int i = name.length() - 1; i >= 0; i--)
		{
			//takes char at i and appends it to reverse
			String o = name.charAt(i)+"";
			reverse += o;
		}
		
		return reverse;
	}
	
	
	//run method that is called by the main
	public void run()
	{
		System.out.println("Question Three: " + newLine + "-----------------------------");
		System.out.println("Printing The Reverse of 'Adegboyega': ");
		System.out.println(reverseString());
		System.out.println("-----------------------------");
		System.out.println();
	}

}
