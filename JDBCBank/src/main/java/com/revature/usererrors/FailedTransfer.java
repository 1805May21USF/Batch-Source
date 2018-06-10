package com.revature.usererrors;

public class FailedTransfer extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FailedTransfer(String message)
	{
		super(message);
	}

}
