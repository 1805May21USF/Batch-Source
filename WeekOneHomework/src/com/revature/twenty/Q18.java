/****************************************************
 * 		Name: Q18									*
 * 		Purpose: Performs operations on each        *
 * 				 argument in the args array         *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import com.revature.storage.StringOp;

public class Q18 {
	public static void main(String[] args) {
		// Instantiates a new StringOp object
		StringOp so = new StringOp();
		
		// Goes through every argument in the args array and runs them through StringOp methods
		for(String s : args) {
			if(so.anyUppercase(s))
				System.out.println(s + " has uppercase characters!");
			else
				System.out.println(s + " doesn't have any uppercase characters!");
			System.out.println(s + " in uppercase is " + so.toUppercase(s));
			try {
				so.addTen(s);
			}catch(NumberFormatException e) {
				System.out.println(s + " is not a number!");
			}
		}
	}
}
