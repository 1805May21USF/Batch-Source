package com.revature.bs.api.exceptions;

public class OverdraftException extends RuntimeException {
   
    	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public OverdraftException (String message) {
    		super(message);
}
}