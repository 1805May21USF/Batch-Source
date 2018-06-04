package com.sunny.util;

public class OverDraftException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OverDraftException() {
		super("Not enough Money");
	}
}
