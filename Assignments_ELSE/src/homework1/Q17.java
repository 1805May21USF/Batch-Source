package homework1;

import java.util.Scanner;

public class Q17
{
	//Write a program that calculates the simple interest on the principal, 
	//rate of interest and number of years provided by the user. Enter principal, 
	//rate and time through the console using the Scanner class.
	//Interest = Principal* Rate* Time
	
	private static double interest;
	
	
	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		
		// prompt user, process input
		System.out.println("Enter the principal: ");
		double principal = scan.nextDouble();
		
		System.out.println("Enter the rate: ");
		final float rate = scan.nextFloat();
		
		System.out.println("Enter time (in years): ");
		float time = scan.nextFloat();
		
		
		scan.close();        
		
		
		interest = principal * rate * time;
		
		
		
		System.out.printf("simple interest on the principal is: %.2f", interest);
		
	}

}