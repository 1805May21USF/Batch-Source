package com.revature.exceptions;

public class IncorrectPasswordException extends Exception{
	// Allows for the IncorrectPAsswordException to be serialized
	private static final long serialVersionUID = -5815002540314877203L;

	// Executes when the exception is declared
	public IncorrectPasswordException() {
		System.out.println("Username and password don't match!");
	}
}
