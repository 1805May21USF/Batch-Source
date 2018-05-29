package homework1;

import java.util.Scanner;




public class Q18 
{
	
	//Write a program having a concrete ;subclass that inherits three abstract methods from a superclass. 
	//Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
		//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
		//2. Convert all of the lower case characters to uppercase in the input string, and return the result.
		//3. Convert the input string to integer and add 10, output the result to the console. Create an appropriate 
		//class having a main method to test the above setup.
	
	
	
	
	
	
	protected static String name;
	protected static String age;

	
	/*public boolean hasUpperCase() 
	{
		for(int i = 0; i < name.length(); i++)
		{
			if( Character.isUpperCase( name.charAt(i) ) )
				return true;
		}
		
		return false;
	}

	
	public void toUpperCase() 
	{
		name = name.toUpperCase();	
	}

	
	public int addTen() 
	{
		return Integer.parseInt(age) + 10;	
	}
	*/
	public static void main(String[] args)
	{
		Q4 q4 = new Q4();
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Enter your name: ");
		name = scan.nextLine();
		
		
		System.out.println("Enter your age: ");
		age = scan.nextLine();
		
		//1
		System.out.println("Any capital letters: "  + q4.hasUpperCase() + " --> " + name );
		
		// 2
		 q4.toUpperCase();
		System.out.println("All Caps: " + name );
		
		// 3
		System.out.println("Your age plus 10: " + q4.addTen() );
		
		
		
		
		scan.close();
		
		
		
		
	}
	
			
	
		
		
		
		
	
}
