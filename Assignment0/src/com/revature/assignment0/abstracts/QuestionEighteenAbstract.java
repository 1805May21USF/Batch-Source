package com.revature.assignment0.abstracts;

public abstract class QuestionEighteenAbstract {
	
	/*
	 * These abstract methods will be used once a class implements them
	 * They are labeled as protected so they can only be taken if implemented
	 */

	protected abstract boolean checkForUppercase(String name);
	
	protected abstract String convertToLowerCase(String name);
	
	protected abstract int convertAndAddTen(String number);
}
