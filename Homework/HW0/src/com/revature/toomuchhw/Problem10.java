package com.revature.toomuchhw;
//Q10. Find the minimum of two numbers using ternary operators.
public class Problem10 {
	private int n1;
	private int n2;
	
	public Problem10(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int findMin() {
		return (n1 < n2) ? n1 : n2;
	}
}
