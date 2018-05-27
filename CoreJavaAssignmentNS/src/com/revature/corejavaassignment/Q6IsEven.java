package com.revature.corejavaassignment;

public class Q6IsEven {
	
	private static boolean isEven(int input) {
		if((input & 1) == 0)
			return true;
		
		return false;
	}
	
	public static void isEvenDemo(int input) {
		String evenOrOdd = "";
		if (isEven(input))
			evenOrOdd = "even";
		else
			evenOrOdd = "odd";
		System.out.println("\t" + input + " is " + evenOrOdd);
	}
	
	public static void main(String[] args) {
		isEvenDemo(5);
		isEvenDemo(6);
	}

}
