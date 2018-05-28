package com.revature.homeworks;
abstract class Members
{
	abstract boolean uppercase(String str);
	abstract String convertToUp(String str);
	abstract int convertToInt(String str);
}
public class Stringy extends Members  
{

	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	
	//implement the abstract method to check if string has uppercase 
	@Override
	boolean uppercase(String str) {
		
		
		boolean hasUppercase = !str.equals(str.toLowerCase());
		if (!hasUppercase)
		{
			return false;
		}
		return true;
		
	}

	//implement the abstract method to convert string to uppercase
	@Override
	String convertToUp(String str) 
	{
			String result = str.toUpperCase();
		return result;
		
	}

	//implement the abstract method to convert string to int
	@Override
	int convertToInt(String str) {
		
		
		int num = Integer.parseInt(str);
		
		return num + 10;
			
		
	}
	
	//run method that is called by the main
	
	 public void run()
		{
				System.out.println("Question Eighteen: " + newLine + "-----------------------------");
				System.out.println("Checking for uppercase...");
				System.out.println(uppercase("Adegboyega") + newLine);
				System.out.println("Converting to Uppercase...");
				System.out.println(convertToUp("Adegboyega") + newLine);
				System.out.println("Converting String '10' to int...");
				System.out.println(convertToInt("10"));
				System.out.println("-----------------------------");
				System.out.println();
		}





}
