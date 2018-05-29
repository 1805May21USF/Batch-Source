package com.revature.solutions;

public class Bubble {
	
	public static void bubble(int x[]) {
		boolean switched;
		do {
			switched = false;
			for(int i = 0;i<x.length-1;i++) {
				if(x[i]>x[i+1]) {
					int temp = x[i];
					x[i] = x[i+1];
					x[i+1]=temp;
					switched = true;
				}
			}
		}while(switched == true);
		for(int i = 0;i<x.length;i++) {
			System.out.print(x[i] +",");
		}
	}

}
