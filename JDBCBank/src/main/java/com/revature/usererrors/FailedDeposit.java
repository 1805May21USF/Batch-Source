package com.revature.usererrors;

public class FailedDeposit extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FailedDeposit(String message)
	{
		super(message);
	}

}
