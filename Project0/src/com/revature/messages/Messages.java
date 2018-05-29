package com.revature.messages;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.people.Application;

public class Messages {
	public void welcome_message() {
		System.out.println("Thank you for visiting \"Big Corp Inc\", how can we help you?\r");
		
		boolean repeat = true;
		Scanner input = new Scanner(System.in);
		
		while(repeat == true) {
			System.out.println("1) Login\r2) Apply for account\r3) Check on existing account application");
			String i = input.nextLine();
			
			if (tryParseInt(i)) {  
				  int input_integer = Integer.parseInt(i);
				   
				  switch(input_integer) {
				  	case 1:
					    //Goes to a login
				  		repeat = false;
				  		input.close();
				  		break;
				  	case 2:
				  		//Apply for a new application
				  		take_information();
				  		repeat = false;
				  		input.close();
				  		break;
				  	case 3:
				  		//Check on existing application
				  		repeat = false;
				  		input.close();
				  		break;
				  	default:
				  		System.out.println("\"" + i + "\" is out of range, please try again!\r");	
				  }
			} else {
				System.out.println("\"" + i + "\" is not valid, please try again!\r");
			}
		}
	}
	
	private void take_information() {
		System.out.println("You want to apply to have an account with us, awesome!\r");
		System.out.println("We are going to need some information from you!");
		
		String first_name, last_name, address, username, password;
		int phone, SSN;
		
		first_name = get_appplication_info("first name");
		last_name = get_appplication_info("last name");
		
	}
	
	private String get_appplication_info(String message_info) {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		String output = "";
		
		while(repeat == true) {
			
			System.out.println("What is your " + message_info+ " ?");
			output = input.nextLine();
			
			Pattern pattern_check = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern_check.matcher(output);
			boolean regex_checker = match.find();
			
			if (regex_checker) {
				System.out.println("The wrong character(s) \"" + match.group() + "\" was inputed. Please enter in ONLY characters A-Z.");
			} else {
				repeat = false;
			}
		}
		input.close();
		return output;
	}
	
	static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}
