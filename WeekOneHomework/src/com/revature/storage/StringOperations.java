/****************************************************
 * 		Name: StringOperations						*
 * 		Purpose: Abstract class to provide abstract *
 * 				 methods for StringOps				*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

public abstract class StringOperations {
	// Abstract methods that perform operations on provided Strings
	public abstract boolean anyUppercase(String s);
	public abstract String toUppercase(String s);
	public abstract void addTen(String s);
}
