package com.revature.BankingApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SignUp {
	public static void signUp() {
		Scanner scan = new Scanner(System.in);
		
		String input = "";
		
		while(!input.equals("exit")) {
			// Requests a username for the account
			System.out.println("Please enter a username (type c to cancel): ");
		
			String username = scan.nextLine();
			
			// Executes if c is entered
			if(username.equalsIgnoreCase("c")) {
				input = "exit";
				break;
			}
			
			// Executes if the username doesn't exist
			if(!exists(username)) {
				// Executes if the username contains an illegal character
				if(username.contains("/") || username.contains("\\") || username.contains("?") || username.contains("%") ||
				   username.contains("*") || username.contains(":") || username.contains("|") || username.contains("\"") ||
				   username.contains("<") || username.contains(">") || username.contains(".") || username.contains(" ")) {
					System.out.println("Username cannot contain the /, \\, ?, %, *, :, |, \", <, >, ., or space characters!");
					break;
				}
				while(!input.equals("back") && !input.equals("exit")) {
					// Requests a password from the user
					System.out.println("Please enter a password (type b to go back, c to cancel): ");
				
					String password = scan.nextLine();
					
					// Executes if the back command is provided
					if(password.equalsIgnoreCase("b")) {
						input = "back";
						break;
					}
					// Executes if the cancel command is provided
					else if(password.equalsIgnoreCase("c")){
						input = "exit";
						break;
					}
					
					// Creates variables for a first and last name, middle initial, and age
					String firstName = null;
					String middleInitial = null;
					String lastName = null;
					int age = 0;
					
					// Executes while a first name isn't provided
					while(firstName == null) {
						// Requests the user's first name
						System.out.println("Please enter your first name: ");
						// Assigns the input to the firstName variable
						firstName = scan.nextLine();
						// Executes if no input was provided
						if(firstName.length() == 0) {
							System.out.println("Please enter a value!");
							firstName = null;
						}
						// Executes if a special character was included
						else if(firstName.contains("1") || firstName.contains("2") || firstName.contains("3") ||
								firstName.contains("4") || firstName.contains("5") || firstName.contains("6") ||
								firstName.contains("7") || firstName.contains("8") || firstName.contains("9") ||
								firstName.contains("0") || firstName.contains("!") || firstName.contains("@") ||
								firstName.contains("#") || firstName.contains("$") || firstName.contains("%") ||
								firstName.contains("^") || firstName.contains("&") || firstName.contains("*") ||
								firstName.contains("(") || firstName.contains(")") || firstName.contains("-") ||
								firstName.contains("_") || firstName.contains("+") || firstName.contains("=") ||
								firstName.contains(",") || firstName.contains("<") || firstName.contains(">") ||
								firstName.contains(".") || firstName.contains("?")|| firstName.contains("/") ||
								firstName.contains("\"") || firstName.contains("\'") || firstName.contains("\\") ||
								firstName.contains(";") || firstName.contains(":") || firstName.contains("|") ||
								firstName.contains("{") || firstName.contains("}") || firstName.contains("[") ||
								firstName.contains("]")) {
							System.out.println("No special characters allowed!");
							firstName = null;
						}
					}
					// Executes while a middle initial isn't provided
					while(middleInitial == null) {
						// Requests the user's middle initial
						System.out.println("Please enter your middle initial: ");
						middleInitial = scan.nextLine();
						// Executes if more than 1 character was entered
						if(middleInitial.length() > 1) {
							System.out.println("Please enter only one letter!");
							middleInitial = null;
						}
						// Executes if no input was provided
						else if(middleInitial.length() == 0) {
							System.out.println("Please enter a value!");
							middleInitial = null;
						}
						// Executes if a special character was entered
						else if(middleInitial.charAt(0) == '1' || middleInitial.charAt(0) == '2' || middleInitial.charAt(0) == '3' ||
								middleInitial.charAt(0) == '4' || middleInitial.charAt(0) == '5' || middleInitial.charAt(0) == '6' ||
								middleInitial.charAt(0) == '7' || middleInitial.charAt(0) == '8' || middleInitial.charAt(0) == '9' ||
								middleInitial.charAt(0) == '0' || middleInitial.charAt(0) == '!' || middleInitial.charAt(0) == '@' ||
								middleInitial.charAt(0) == '#' || middleInitial.charAt(0) == '$' || middleInitial.charAt(0) == '%' ||
								middleInitial.charAt(0) == '^' || middleInitial.charAt(0) == '&' || middleInitial.charAt(0) == '*' ||
								middleInitial.charAt(0) == '(' || middleInitial.charAt(0) == ')' || middleInitial.charAt(0) == '-' ||
								middleInitial.charAt(0) == '_' || middleInitial.charAt(0) == '+' || middleInitial.charAt(0) == '=' ||
								middleInitial.charAt(0) == ',' || middleInitial.charAt(0) == '<' || middleInitial.charAt(0) == '>' ||
								middleInitial.charAt(0) == '.' || middleInitial.charAt(0) == '?' || middleInitial.charAt(0) == '/' ||
								middleInitial.charAt(0) == '\"' || middleInitial.charAt(0) == '\'' || middleInitial.charAt(0) == '\\' ||
								middleInitial.charAt(0) == ';' || middleInitial.charAt(0) == ':' || middleInitial.charAt(0) == '|' ||
								middleInitial.charAt(0) == '{' || middleInitial.charAt(0) == '}' || middleInitial.charAt(0) == '[' ||
								middleInitial.charAt(0) == ']') {
							System.out.println("No special characters allowed!");
							middleInitial = null;
						}
					}
					// Executes while a last name isn't provided
					while(lastName == null) {
						// Requests the user's last name
						System.out.println("Please enter your last name: ");
						lastName = scan.nextLine();
						// Executes if no input was provided
						if(lastName.length() == 0) {
							System.out.println("Please enter a value!");
							lastName = null;
						}
						// Executes if a special character was entered
						else if(lastName.contains("1") || lastName.contains("2") || lastName.contains("3") ||
								lastName.contains("4") || lastName.contains("5") || lastName.contains("6") ||
								lastName.contains("7") || lastName.contains("8") || lastName.contains("9") ||
								lastName.contains("0") || lastName.contains("!") || lastName.contains("@") ||
								lastName.contains("#") || lastName.contains("$") || lastName.contains("%") ||
								lastName.contains("^") || lastName.contains("&") || lastName.contains("*") ||
								lastName.contains("(") || lastName.contains(")") || lastName.contains("-") ||
								lastName.contains("_") || lastName.contains("+") || lastName.contains("=") ||
								lastName.contains(",") || lastName.contains("<") || lastName.contains(">") ||
								lastName.contains(".") || lastName.contains("?")|| lastName.contains("/") ||
								lastName.contains("\"") || lastName.contains("\'") || lastName.contains("\\") ||
								lastName.contains(";") || lastName.contains(":") || lastName.contains("|") ||
								lastName.contains("{") || lastName.contains("}") || lastName.contains("[") ||
								lastName.contains("]")) {
							System.out.println("No special characters allowed!");
							lastName = null;
						}
					}
					// Executes while an age isn't provided
					while(age == 0) {
						// Requests an age
						System.out.println("Please enter your age: ");
						try {
							age = Integer.parseInt(scan.nextLine());
							
							// Executes if the age entered is negative
							if(age <= 0) {
								System.out.println("Please enter a positive number greater than 0");
								age = 0;
							}
							// Executes if the entered age is less than 16
							else if(age < 16) {
								System.out.println("You must be at least 16 years old to open an account with us!");
								System.out.println("The account creation process will now close!");
								// Exits the method
								return;
							}
						// Executes if the input wasn't numerical
						}catch(NumberFormatException e) {
							System.out.println("Please enter a valid number!");
							age = 0;
						}
					}
					
					// Writes the password to the profile file, saves the personal information in an info file, and completes signup
					try{
						// Creates the necessary file objects
						File file = new File("data/login/" + username + ".txt");
						File info = new File("data/info/" + username + ".txt");
						File account = new File("data/accounts/" + username + ".txt");
						
						// Creates the necessary files
						file.createNewFile();
						info.createNewFile();
						account.createNewFile();
						
						// Creates FIleWriters to write the files
						FileWriter fw = new FileWriter(file);
						FileWriter iw = new FileWriter(info);
						FileWriter aw = new FileWriter(account);
						
						// Writes the password to the login file
						fw.write(password);
						// Writes the info file in a specified format
						iw.write(firstName + ":" + middleInitial + ":" + lastName + ":" + age);
						// Writes the account information to the account file
						aw.write("Personal Checking:0:none");
						
						// Lets the user know the account was created successfully
						System.out.println("Signup successfully complete for " + username + "!");
						
						// Closes the FileWriters and exits the loop
						fw.close();
						iw.close();
						aw.close();
						input = "exit";
					// Executes if signup fails
					} catch (IOException e) {
						System.out.println("Couldn't create user profile!");
						input = "exit";
					}
				}
			}
			else
				System.out.println("Username already in use");
		}
		return;
	}
	
	static boolean exists(String username) {
		// Tests if the file exists
		File file = new File("data/login/" + username + ".txt");
		// Returns true if the file exists false if it doesn't
		if(file.exists())
			return true;
		else
			return false;
	}
}
