package com.revature.solutions;

public class Fib {
	public static String fib(String s) {
		int x = 0;
		int y = 1;
		int z;
		s = "1. 0\n2. 1";
		for(int i = 0;i<23;i++) {
			z = x+y;
			int temp = i+3;
			s = s+"\n"+ temp + ". "+z;
			x=y;
			y=z;
		}
		return s;
	}

}
