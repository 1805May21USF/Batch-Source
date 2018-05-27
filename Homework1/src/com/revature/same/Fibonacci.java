package com.revature.same;

import java.util.*;
public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
		fibonacci();
	}
	
	public static ArrayList<Integer> fibonacci() {
		ArrayList<Integer> fib = new ArrayList<>();
		fib.add(0); fib.add(1);
		for(int i = 0; i < 23; i++) {
			int first = fib.get(i);
			int second = fib.get(i+1);
			fib.add(first + second);
		}
		return fib;
	}

}
