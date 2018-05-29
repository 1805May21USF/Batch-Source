package com.revature.hw1;

public class P2Fibonacci {
	public static void fibonacci() {
		int[] fib = new int[25];
		fib[0]= 0;
		fib[1]= 1;
		
		//f[n] = f[n-1] +f[n-2]
		for (int i = 2; i < 25; i++) {
			fib[i]=fib[i-2]+fib[i-1];
		}
		//System.out.println(fib.toString());
		for (int i : fib) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}
