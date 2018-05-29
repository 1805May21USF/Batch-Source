package com.revature.utility;

public class VowelException extends Exception {
	VowelException(String s){
		super(s);
		if(s.contains("a")) {
			System.out.println("Exception");
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		try {
		
		
		}
		finally{
			
		}
	}

}
