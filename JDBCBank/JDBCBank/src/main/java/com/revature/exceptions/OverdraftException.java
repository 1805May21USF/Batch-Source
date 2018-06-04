package com.revature.exceptions;

public class OverdraftException extends Exception{
	// allows for the OverdraftException to be serialized
	private static final long serialVersionUID = 1698729540637268034L;
	
	// Executes when the exception is declared
	public OverdraftException(String msg) {
		System.out.println("There aren't enough funds in account " + msg + " to cover that withdrawal!");
	}
}
