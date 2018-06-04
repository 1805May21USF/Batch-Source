package com.revature.exceptions;

public class OverdraftException extends Exception{

	private static final long serialVersionUID = 1L;

	public OverdraftException() {
		super("Error: Not enough money.");
		// TODO Auto-generated constructor stub
	}

}
