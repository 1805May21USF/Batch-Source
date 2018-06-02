package com.revature.exceptions;

public class BadInputException extends Exception{
	private static final long serialVersionUID = 1L;

	public BadInputException() {
		super("Bad input received not caught by IllegalInputException");
	}
}