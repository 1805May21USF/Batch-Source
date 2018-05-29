package com.revature.P0Banking;

//Self explanatory custom exception class element for bad inputs
public class BadInputException extends Exception{
		private static final long serialVersionUID = 1L;
		public BadInputException() {
			System.out.println("Please try again.");
		}
}
