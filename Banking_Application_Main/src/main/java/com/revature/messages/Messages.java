package com.revature.messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.accounts.Account;
import com.revature.people.Application;
import com.revature.people.Customer;
import com.revature.people.Employee;
import com.revature.people.Person;
import com.revature.util.ConnFactory;

public class Messages {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
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
				  		break;
				  	case 2:
				  		//Apply for a new application
					try {
						take_information();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  		System.out.println("\rYou are now being sent to the home screen.........\r");
				  		break;
				  	case 3:
				  		boolean claim_number_boolean = false;
				  		while (claim_number_boolean == false) {
				  			System.out.println("Please enter your claim # to search our database");
				  			String username = input.nextLine();
					  		String result = Application.check_on_application(username);
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
		boolean repeat = true;
		while (repeat) {
			try {			
				Scanner input = new Scanner(System.in);
				
				System.out.println("----Login in---\r");
				
				System.out.println("Enter in a username");
				
				String username = input.nextLine();
				
				System.out.println("\rEnter your password");
				
				String password = input.nextLine();
				
				List<Person> login_account = new ArrayList<Person>();
				Connection conn = cf.getConnection();
				Statement stmt;
				stmt = conn.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("SELECT USERNAME, PASSWORD, ACCOUNT_LEVEL FROM BANKING_ACCOUNTS");
				Person person = null;
				Person matched_person = null;

				while(rs.next()) {
					person = new Person( rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("ACCOUNT_LEVEL"));
					login_account.add(person);
				}
				
				if (!(login_account.isEmpty())) {
					for (Person single_person : login_account) {
						if (single_person.getUsername().contains(username) && single_person.getPassword().contains(password)) {
							matched_person = single_person;
							break;
						}
					}
						
					if (!(matched_person == null)) {
						if(matched_person.getAccount_level().contains("Employee - Regular")) {
							try {
								Employee employee = null;
								
								rs = stmt.executeQuery("SELECT * FROM Banking_Accounts");
								
								List<Employee> employee_login = new ArrayList<Employee>();
								
								while(rs.next()) {
									employee = new Employee( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Integer.toString(rs.getInt(13)));
									employee_login.add(employee);
								}
								
								for (Employee single_employee : employee_login) {
									if (single_employee.getUsername().contains(username) && single_employee.getPassword().contains(password)) {
										single_employee.logged_in();
										repeat = false;
										break;
									}
								}							
							} catch (SQLException e){
								System.out.println("Error collecting all information, please try again!");
								repeat = false;
							}
						} else if (person.getAccount_level().contains("Customer")) {
							try {
								Customer customer = null;
								rs = stmt.executeQuery("SELECT * FROM Banking_Accounts");
								
								List<Customer> customer_login = new ArrayList<Customer>();
								
								while(rs.next()) {
									customer = new Customer( Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Integer.toString(rs.getInt(13)));
									customer_login.add(customer);
								}
								
								for (Customer single_customer : customer_login) {

									if (single_customer.getUsername().contains(username) && single_customer.getPassword().contains(password)) {
										single_customer.logged_in();
										repeat = false;
										break;
									}
								}
							} catch (SQLException e){
								System.out.println("Error collecting all information, please try again! d");
								repeat = false;
							}
						}
					} else {
						System.out.println("The account can not be found, if you think this was a mistake please call the business during normal banking hours with your claim #");
						repeat = false;
					}
					
				} else {
					System.out.println( "There is no accounts in the database, if you think this was a mistake please call the business during normal banking hours with your claim #");
					repeat = false;
				}
			} catch(SQLException e) {
				System.out.println("Error: Having issues with the database. Please try again later!");
				repeat = false;
			}
	    }
	}
	
	public static void take_information() throws SQLException {
		System.out.println("You want to apply to have an account with us, awesome!\r");
		System.out.println("We are going to need some information from you!");
		
		String first_name, last_name, address, city, state, zipcode, phone, username, password, account_Type, SSN;
		
		first_name = get_appplication_info_string("\rWhat is your first name?", "First name", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		last_name = get_appplication_info_string("\rWhat is your last name?", "Last name", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		address = get_appplication_info_string("\rWhat is your address?", "Address", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		city = get_appplication_info_string("\rWhat is your city?", "City", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		state = get_appplication_info_string("\rWhat is your state?", "State", "Please enter in ONLY characters A-Z", "[^a-zA-Z]+");
		zipcode = get_appplication_info_string("\rWhat is your zipcode?", "Zipcode", "Please enter in ONLY 5 numbers 0-9", "[^0-9]+");
		phone = get_appplication_info_string("\rWhat is your phone number?", "Phone", "Please enter TEN numbers 0-9", "[^0-9]+"); 
		username = get_appplication_info_string("\rWhat do you want your username to be?","Username", "Please enter in ONLY characters A-Z and 0-9", "[^a-zA-Z0-9]+"); // Have to do a file check
		password = get_appplication_info_string("\rWhat do you want your password to be?", "Password", "Please enter in ONLY characters A-Z, 0-9", "[^a-zA-Z0-9]+"); 
		account_Type = get_appplication_info_string("\rWhat type of account are you applying for today?\r" +
		"1) Checking\r" +
		"2) Savings\r" +
		"3) Joint", "Account_Type", "Please one number only!", "[^1-3]");
		SSN = get_appplication_info_string("\rWhat is your Social Secuirty Number?", "SSN", "Please enter NINE numbers ONlY 0-9", "[^0-9]+");
		
		try {
			Application app = new Application(first_name.trim().toLowerCase(), last_name.trim().toLowerCase(), address.trim().toLowerCase(), city.trim().toLowerCase(), state.trim().toLowerCase(), zipcode.trim(), username.trim().toLowerCase(), password.trim(), phone.trim(), SSN.trim(), "Pending", account_Type.trim());
			String message = app.create_application();
			System.out.println(message);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error: Having issues with the database. Please try again later!");
		}
	}
	
	private static String get_appplication_info_string(String message_info, String action, String error_info, String regex_patten) {
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
					case "City":
						String city = check_for_length(output, action, 25, 2);
						if (city.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(city);
							repeat = true;
						}
						break;
					case "State":
						String state = check_for_length(output, action, 30, 4);
						if (state.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(state);
							repeat = true;
						}
						break;
					case "Zipcode":
						String zipcode = check_for_length(output, action, 5, 5);
						if (zipcode.isEmpty() ) {
							repeat = false;
						} else {
							System.out.println(zipcode);
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
	
	private static String check_for_length(String data, String action, int max, int min) {
		
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
	
	private static void check_password(String data) {
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
	
	private static String check_for_username(String username_parm) {
		
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
