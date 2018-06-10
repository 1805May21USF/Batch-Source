package com.revature.usererrors;

public class FailedWithdraw extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FailedWithdraw(String message)
	{
		super(message);
	}
	
}
