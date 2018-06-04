package com.revature.exceptions;

public class UserExistsException extends Exception{
	// Allows for UserExistsException to be serialized
	private static final long serialVersionUID = -1273607527350037455L;

	public UserExistsException(String msg) {
		if(!msg.equals(">"))
			System.out.println("User " + msg + " already exists!");
	}
}
