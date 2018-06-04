package com.revature.exceptions;

public class NoUserExistsException extends Exception{
	// Allows for NoUserExistsException to be serialized
	private static final long serialVersionUID = 1475495648818115650L;
	
	public NoUserExistsException(String msg) {
		System.out.println("User " + msg + " doesn't exist!");
	}
}
