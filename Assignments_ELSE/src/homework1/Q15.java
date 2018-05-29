package homework1;


	import java.util.Scanner;
	 
	public abstract class Q15 implements UserInterface
	{
		
		//Write a program that defines an interface having the following methods: addition, subtraction, multiplication, 
		//and division. Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
		//Hard code two operands in a test class having a main method that calls the implementing class.
	    //public static void main(String args[])
	    {
	       int a, b, res;
	       Scanner scan = new Scanner(System.in);
		   
	       System.out.print("Enter Two Numbers : ");
	       a = scan.nextInt();
	       b = scan.nextInt();
		   
	       res = a + b;
	       System.out.println("Addition = " +res);
		   
	       res = a - b;
	       System.out.println("Subtraction = " +res);
		   
	       res = a * b;
	       System.out.println("Multiplication = " +res);
		   
	       res = a / b;
	       System.out.println("Division = " +res); 
	    	
	    /*	I use implement another interface. Help rewritten the same code and to cut time
	    	   */
	    
	}
}