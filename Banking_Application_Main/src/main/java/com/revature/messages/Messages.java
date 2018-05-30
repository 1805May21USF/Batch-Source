package com.revature.messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.people.Application;
import com.revature.people.Customer;
import com.revature.people.Employee;

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
					    login();
				  		repeat = false;
				  		break;
				  	case 2:
				  		//Apply for a new application
				  		take_information();
				  		System.out.println("\rYou are now being sent to the home screen.........\r");
				  		break;
				  	case 3:
				  		boolean claim_number_boolean = false;
				  		while (claim_number_boolean == false) {
				  			System.out.println("Please enter your Username to search our database");
				  			String username = input.nextLine();
					  		String result = check_on_application(username);
					  		System.out.println(result);
					  		
					  		if(!result.contains("Oops"))
					  			claim_number_boolean = true;
				  		}
				  		System.out.println("\rYou are now being sent to the home screen.........\r");
				  		break;
				  	default:
				  		System.out.println("\"" + i + "\" is out of range, please try again!\r");	
				  }
			} else {
				System.out.println("\"" + i + "\" is not valid, please try again!\r");
			}
		}
	}
	
	private void login() {
		Employee employee = null;
		Customer customer = null;
		
		Scanner input = new Scanner(System.in);
		System.out.println("----Login in---\r");
		System.out.println("1) Employee");
		System.out.println("2) Customers");
		String employee_customer = input.nextLine();
		
		boolean repeat = true;
		
		while(repeat == true) {
			System.out.println("\rEnter in your username");
			String username = input.nextLine();
			
			System.out.println("\rEnter in your password");
			String password = input.nextLine();
			
			switch(employee_customer) {
				case "1":
					employee = login_employee(username, password);
					if (employee != null) {
						repeat = false;
					} else {
						login();
					}
					break;
				case "2":
					customer = login_customer(username, password);
					if (customer != null) {
						repeat = false;
					} else {
						login();
					}
				default :
					System.out.println("Invalid entry, only type ONE or TWO.");
			}
		}
		
		if (employee instanceof Employee) {
			employee.logged_in();
		} else {
			customer.logged_in();
		}
	}
	public Employee login_employee(String temp_username, String temp_password) {
		
		try {
		    String first_name = null, last_name = null, address = null, phone = null, username = null, password = null, ssn = null, account_level = null;
					
			//Accessing the file
			Scanner output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\accounts\\employees\\" + temp_username + ".txt"));
			
			//While there is a next line
			while (output.hasNext())
			{
				first_name = output.nextLine();
				last_name = output.nextLine();
				address = output.nextLine();
				phone = output.nextLine();
				username = output.nextLine();
				password = output.nextLine();
				ssn = output.nextLine();
				account_level = output.nextLine();
			}
				output.close();
			
			Employee employee = new Employee(first_name, last_name, address, phone, username, password, ssn, account_level);
			
			return employee;

		} catch (Exception e) {
			return null;
		}
	}
	
	private Customer login_customer(String temp_username, String temp_password) {
		
		try {
		    String first_name = null, last_name = null, address = null, phone = null, username = null, password = null, ssn = null;
		    String account_type, status, claim_number;
					
			//Accessing the file
			Scanner output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\accounts\\customers\\" + temp_username + ".txt"));
			
			//While there is a next line
			while (output.hasNext())
			{
				first_name = output.nextLine();
				last_name = output.nextLine();
				address = output.nextLine();
				phone = output.nextLine();
				username = output.nextLine();
				password = output.nextLine();
				account_type = output.nextLine();
				ssn = output.nextLine();
			}
				output.close();
			
				Customer customer = new Customer(first_name, last_name, address, phone, username, password, ssn);
				
				return customer;
				
		} catch (Exception e) {
			return null;
		}
	}
	
	private String check_on_application(String term_username) {
		try {
		    String claim_number = "";
		    String status = "";
		    
		    String first_name, last_name, address, phone, username, password, ssn, account_type;
					
			//Accessing the file
			Scanner output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + term_username + ".txt"));
			
			//While there is a next line
			while (output.hasNext())
			{
				first_name = output.nextLine();
				last_name = output.nextLine();
				address = output.nextLine();
				phone = output.nextLine();
				username = output.nextLine();
				password = output.nextLine();
				account_type = output.nextLine();
				ssn = output.nextLine();
				status = output.nextLine();
				claim_number = output.nextLine();
			}
				output.close();
					
			return "Your claim # is: " + claim_number + " and your application status is: " + status + ". If you have any question please call us!";
		} catch (Exception e) {
			return "Oops, looks like we could not access your file with you username. Try enetering it again, or contact our bank during normal business hours to talk to someone";
		}
	}
	
	private void take_information() {
		System.out.println("You want to apply to have an account with us, awesome!\r");
		System.out.println("We are going to need some information from you!");
		
		String first_name, last_name, address, username, password, phone, SSN, account_Type;
		
		first_name = get_appplication_info_string("\rWhat is your first name?", "First name", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		last_name = get_appplication_info_string("\rWhat is your last name?", "Last name", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		address = get_appplication_info_string("\rWhat is your address?", "Address", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		username = get_appplication_info_string("\rWhat do you want your username to be?","Username", "Please enter in ONLY characters A-Z and 0-9", "[^a-zA-Z0-9]+"); // Have to do a file check
		password = get_appplication_info_string("\rWhat do you want your password to be?", "Password", "Please enter in ONLY characters A-Z, 0-9", "[^a-zA-Z0-9]+"); 
		phone = get_appplication_info_string("\rWhat is your phone number?", "Phone", "Please enter TEN numbers 0-9", "[^0-9]+"); 
		account_Type = get_appplication_info_string("\rWhat type of account are you applying for today?\r" +
		"1) Checking\r" +
		"2) Savings\r" +
		"3) Joint", "Account_Type", "Please one number only!", "[^1-3]");
		SSN = get_appplication_info_string("\rWhat is your Social Secuirty Number?", "SSN", "Please enter NINE numbers ONlY 0-9", "[^0-9]+");
		
		try {
			Application app = new Application(first_name.trim(), last_name.trim(), address.trim(), phone.trim(), username.trim(), password.trim(), account_Type.trim(), SSN.trim());
			String message = app.create_application();
			System.out.println(message);
		}
		catch (Exception e) {
			System.out.println("Oops, looks like we could not create your file! Please contact our bank during normal business hours to talk to someone");
		}
	}
	
	private String get_appplication_info_string(String message_info, String action, String error_info, String regex_patten) {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		String output = null;
		
		while(repeat == true) {
			
			System.out.println(message_info);
			output = input.nextLine();
			
			Pattern pattern = Pattern.compile(regex_patten);
		    Matcher matcher = pattern.matcher(output);
			
			if (matcher.matches()) {
				System.out.println("The wrong character(s) were inputed. " + error_info);
			} else {
				repeat = false;
				
				switch(action) {
					case "Username":
						String username = check_for_username(output);
						if (username.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(username);
							repeat = true;
						}
						break;
					case "First name":
						String first_name = check_for_length(output, action, 15, 2);
						if (first_name.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(first_name);
							repeat = true;
						}
						break;
					case "Last name":
						String Last_name = check_for_length(output, action, 25, 2);
						if (Last_name.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(Last_name);
							repeat = true;
						}
						break;
					case "Address":
						String address = check_for_length(output, action, 50, 4);
						if (address.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(address);
							repeat = true;
						}
						break;
					case "Phone":
						String phone = check_for_length(output, action, 10, 10);
						if (phone.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(phone);
							repeat = true;
						}
						break;
					case "SSN":
						String SSN = check_for_length(output, action, 9, 9);
						if (SSN.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(SSN);
							repeat = true;
						}
						break;
					case "Password":
						String password = check_for_length(output, action, 15, 4);
						if (password.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(password);
							repeat = true;
						}
						break;
					case "Account_Type":
						repeat = false;
						break;
					default:
						System.out.println("Error in action past! Pleast try again!");
				}
			}
		}
		return output;
	}
	
	private String check_for_length(String data, String action, int max, int min) {
		
		if (data.length() <= max && data.length() >= min) {
			if(action.contains("Password")) {
				check_password(data);
			}
			return "";
		} else if (data.length() > max) {
			return action + " is too long!";
		} else {
			return action + " is too short!";
		}
	}
	
    private static boolean isContain(String source, String subItem){
        String pattern = "\\b"+subItem+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(source);
        return m.find();
   }
	
	private void check_password(String data) {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("Type in the password again");
			
			String repeat_password = input.nextLine();
			
			if (!isContain(data, repeat_password)) {
				System.out.println("Passwords do not match! Try again!\r You entered \"" + data + "\" previously.");
			} else {
				repeat = false;
			}
		}
	}
	
	private String check_for_username(String username_parm) {
		
		try {

			List<String> usernames = new ArrayList<String>();
					
			//Accessing the file
			Scanner  output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\Username\\usernames"));
			
			//While there is a next line
			while (output.hasNext())
			{
				usernames.add(output.next());
			}

			output.close();
			
			for(String username : usernames) {
				if (username.contains(username_parm))
					return "Username is Taken";
			}

			if (username_parm.length() < 15 && username_parm.length() > 3) {
				return "";
			} else if (username_parm.length() > 15) {
				return "Username is too long!";
			} else {
				return "Username is too short!";
			}
			//Close the scanner
		} catch (FileNotFoundException e) {
			return "File is not found. Please see an administrator!";
		}
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
