package com.revature.exceptions;

public class InvalidInputException extends Exception{
	// Allows for InvalidInputException to be serialized
	private static final long serialVersionUID = -4346322581772139027L;

	// Executes when the exception is declared
	public InvalidInputException() {
		System.out.println("Input wasn't valid! Please enter input as it's requested!");
	}
}
