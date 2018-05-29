package com.revature.homework.week1;

public class StringReverseProblem {
	//reverse a string

	private String str;

	public StringReverseProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StringReverseProblem(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void printReverse(String s) {
		//this method takes in a string
		//and reverses it character by character
		char[] c = s.toLowerCase().toCharArray();
		
		for(int i = c.length - 1 ; i>=0; i--) {
			System.out.print(c[i]);
		}
	}
}
