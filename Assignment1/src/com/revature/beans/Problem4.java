package com.revature.beans;
/*Q4. Write a program to compute N factorial.*/
public class Problem4 {
	private int factorial;
	private int n;
	
	public Problem4(int n){
		setAnumber(n);
		setFactorial(n);
	}
	
	private void setFactorial(int n){
		int factorial = 1;
		for(int i = 1; i <= n; i++){
			factorial *= i;
		}
		this.factorial = factorial;	
	}
	
	public void setAnumber(int n){
		this.n = n;
	}
	
	public int getFactorial(){
		return this.factorial;
	}
}
