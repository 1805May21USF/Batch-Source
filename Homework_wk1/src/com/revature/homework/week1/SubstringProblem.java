package com.revature.homework.week1;

public class SubstringProblem {
	//program that prints out substring
	//by passing a substring and an integer
	
	private String str;
	private int idx;
	
	public SubstringProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void printSubstring(String str, int idx) {
		//this method accepts a string and an integer
		//and return the substring between 0 and int-1
		char[] ch = str.toCharArray();
		
		for(int i = 0; i < idx - 1; i++) {
			
			System.out.print(ch[i]);
		}
		
		System.out.println();
	}

	
	
}
