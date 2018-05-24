package com.revature.random;

import java.util.Scanner;

public class ControlMe {
	private int count;

	public ControlMe() {
		count = 0;
	}
	
	public void start() {
		Scanner s = new Scanner(System.in);
		System.out.println("What's your name? (type exit to leave)");
		String input = s.nextLine();
		do {
			count++;
			while(!input.equals("exit")) {
				boolean name = specialName(input);
				if(!name) {
					System.out.println("Your name is special");
				} else {
					System.out.println("Your name is not special");
				}
				input = s.nextLine();
			}
		} while (!input.equals("exit"));
		
	
	}

	public boolean specialName(String name) {

		switch (name.length()) { 
		case 0 :
			return false;
		case 1 :
			return false;
		case 2 :
			return false;
		case 3 :
		case 4 :
		case 5 :
		case 6 :
		default :
			break;
		}


		for(int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i' ||
					name.charAt(i) == 'o' || name.charAt(i) == 'u' || name.charAt(i) == 'y')
				return false;
			else 
				break;
		}
		return true;
	}
	
	public String toString () {
		return "You've entered " + count + " names";
	}

}
