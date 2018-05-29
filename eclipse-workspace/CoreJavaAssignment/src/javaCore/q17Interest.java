package javaCore;

import java.util.Scanner;

public class q17Interest {
	{
	System.out.println("Enter the principal: ");
	Scanner inPrincipal = new Scanner(System.in);
	float principal = inPrincipal.nextFloat();
	
	System.out.println("Enter the rate: ");
	Scanner inRate = new Scanner(System.in);
	float rate = inRate.nextFloat();
	
	System.out.println("Enter the time: ");
	Scanner inTime = new Scanner(System.in);
	float time = inTime.nextFloat();	
	
	float interest = principal * rate * time;
	System.out.println("This is the Interest: " + interest);
	}
}