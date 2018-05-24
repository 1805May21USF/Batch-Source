package com.revature.utility;

import java.util.Scanner;

public class VowelException extends Exception {
	private String message;
	private static final long serialVersionUID = 1L;
	
	public VowelException()
	{
		super("No Vowel Exception");
	}
	
	public VowelException(String message) {
		super(message + " has no vowels!");
	}
	

	
}
