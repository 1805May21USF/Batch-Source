package com.revature.usererrors;

public class FailedLoginAttempt extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FailedLoginAttempt(String message)
	{
		super(message);
	}
}
