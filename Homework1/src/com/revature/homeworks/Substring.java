package com.revature.homeworks;

public class Substring 
{
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	//method to grab substring of string from the start to the index
	public String subStringM(String str, Integer idx)
	{
		String subString = "";
		
		//for loop iterates through String 
		for(int i = 0; i <= idx-1; i++)
		{
			String o = str.charAt(i)+"";
			subString += o;
		}
		
		
		return subString;
				
	}
	
	//run method that is called by the main
	 public void run()
		{
				System.out.println("Question Five: " + newLine + "-----------------------------");
				System.out.println("Printing subString of 'Adegboyega' with index at 5: ");
				System.out.println(subStringM("Adegboyega", 5));
				System.out.println("-----------------------------");
				System.out.println();
		}
}
