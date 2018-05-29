package com.revature.hw1;

public class P6EvenOrNah {
	public static void isItEven(int n) {
		//System.out.println(Integer.toBinaryString(n).toCharArray()[Integer.toBinaryString(n).toCharArray().length-1]);
		
		//converts number to binary, checks the last item in the binary string to see if it's 1. If it's one 
		//it will be odd if not it's even.
		if(Integer.toBinaryString(n).toCharArray()[Integer.toBinaryString(n).toCharArray().length-1] != '1') {
			System.out.println("It's even!");
		} else {
			System.out.println("It's odd!");
		}
			
	}
}
