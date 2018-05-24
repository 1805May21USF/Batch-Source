package com.revature.utility;

public class VowelException extends Exception {
	VowelException(String s){
		super(s);
		if(s.contains("a")) {
			System.out.println("Exception");
		}
	}

}
