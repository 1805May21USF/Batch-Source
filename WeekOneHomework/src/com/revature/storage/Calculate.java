/****************************************************
 * 		Name: Calculate						*
 * 		Purpose: Can interface that provides methods*
 * 				 for performing basic arithmetic	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

public interface Calculate {
	// Abstract methods that take two integers and return an integer
	public abstract int addition(int value1, int value2);
	public abstract int subtraction(int value1, int value2);
	public abstract int multiplication(int value1, int value2);
	public abstract double division(double value1, double value2);
}
