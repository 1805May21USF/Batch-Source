package com.revature.beans;

public class Question04 {
	
	public void factorial(int n) {
		int i, j=1;
		for(i=1; i<=n; i++) {
			j = j * i;
		}
		System.out.println(n + " factorial equals " + j);
	}
}
