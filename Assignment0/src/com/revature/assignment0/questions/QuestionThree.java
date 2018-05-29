package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionThree {
	public static void Question_Three() {
		
		StringBuffer string_buffer = new StringBuffer();
		
		/*
		 * Starts removing the characters at the end of the array and then adds 
		 * it the the beginning of the stringbuffer. You then have the a reversed string
		 * without using the reverse() method
		 */
		for (int i = DiceMan.getName().length() - 1; i >= 0; i--) {
			string_buffer.append(DiceMan.getName().charAt(i));
		}
		
		System.out.println("\r------Question Three-------");
		System.out.println("3.)Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.\r");
		
		System.out.println("--------");
		System.out.println("Orignal");
		System.out.println("--------");
		System.out.println(DiceMan.getName());
		
		System.out.println("\r--------");
		System.out.println("Reversed");
		System.out.println("--------");
		System.out.println(string_buffer);
	}
}
