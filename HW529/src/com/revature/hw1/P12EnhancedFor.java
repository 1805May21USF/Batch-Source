package com.revature.hw1;

public class P12EnhancedFor {
	public static void foreachForReal() {
		int[] arr = new int[100];
		for (int i =0; i <100; i++) arr[i] = i;
		
		for(int i : arr) if(i%2==0) System.out.print(i+" ");
		System.out.println("");
	}
}
