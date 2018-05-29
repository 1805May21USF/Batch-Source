package com.revature.beans;

public class Question13 {

	public void printTriangle() {
		String triString = "";
		for(int i=1; i<=4; i++) {
			if(i%2 == 0) {
				triString = "1 " + triString;
				System.out.println(triString);
			} else {
				triString = "0 " + triString;
				System.out.println(triString);
			}
		}
	}
	
}
