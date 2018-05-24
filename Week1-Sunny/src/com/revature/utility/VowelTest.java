package com.revature.utility;

import java.util.Scanner;

public class VowelTest {
	public static void main(String[] args) {
		String s;
		Scanner input = new Scanner(System.in);
		System.out.println("Type a word");
		s = input.nextLine();
		while(s.length() != 0) {
			try {
				if(s.toLowerCase().contains("a") || s.toLowerCase().contains("e")
						|| s.toLowerCase().contains("i") || s.toLowerCase().contains("o")
						|| s.toLowerCase().contains("u") || s.toLowerCase().contains("y")) { 
				} else {
					throw new VowelException(s);
				} 
			} catch(VowelException v) {
				v.printStackTrace();
				break;
			} 
			s = input.nextLine();
		}

	}

}