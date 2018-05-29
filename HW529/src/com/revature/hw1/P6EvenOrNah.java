package com.revature.hw1;

public class P6EvenOrNah {
	public static void isItEven(int n) {
		//System.out.println(Integer.toBinaryString(n).toCharArray()[Integer.toBinaryString(n).toCharArray().length-1]);
		if(Integer.toBinaryString(n).toCharArray()[Integer.toBinaryString(n).toCharArray().length-1] != '1') {
			System.out.println("It's even!");
		} else {
			System.out.println("It's odd!");
		}
			
	}
}
