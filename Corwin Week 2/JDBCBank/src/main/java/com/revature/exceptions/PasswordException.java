package com.revature.exceptions;

import org.apache.log4j.spi.ErrorCode;

public class PasswordException extends Exception{

		private ErrorCode code;

		public PasswordException() {
			System.out.println("Invalid Password!");
		}
}
