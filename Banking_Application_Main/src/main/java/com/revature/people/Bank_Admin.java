package com.revature.people;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.util.ConnFactory;

public class Bank_Admin extends Person{
	
	protected Bank_Admin(String first_name, String last_name, String address, String city, String state, String zipcode, String phone, String username, String password, String ssn, String status) {
		super(first_name, last_name, address, city, zipcode, state, phone, username, password, ssn);
	}
	
	public Bank_Admin(String user_id, String first_name, String last_name, String address, String city, String state,
			String zipcode, String username, String password,  String phone, String ssn, String account_level, String banking_account_id) {
		super(user_id, first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn, account_level, banking_account_id);
	}
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void logged_in() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("The administrator has logged in....\r");
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) View Accounts\r2) Logout\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				view_account();
				break;
			case "2":
				repeat = false;
				break;
			}	
		}
	}
	
	protected void view_account() {
		Scanner input = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat) {
			Account applicant = null;
				
			List<Account> all_accounts = new ArrayList<Account>();
				
			List<Person> person_list = get_all_accounts();
				
	        int i = 1;
		        
		    if (person_list == null) {
		       	repeat = false;
		       	System.out.println("There is no accounts currently, please try again later!\r");
		    } else {
				System.out.println("\rHere are the all the accounts!");		        	
		        for (Person single_person : person_list) {
				    System.out.println(i + ") " + single_person.getFirst_name() + " " + single_person.getLast_name() + ". User ID: " + single_person.getUser_id());
				    i++;
				}
		        System.out.println(i +") Leave \"Press 0\"");
		        
		        boolean repeat_user_id = true;
				while (repeat_user_id) {
				
					System.out.println("\rWhich account do you want to look at? *Please type in the User ID*\r");
					 
					String account_to_look_at = input.nextLine();
					
					boolean is_number = tryParseInt(account_to_look_at);
					
					if (is_number) {
						String account_info = view_account(account_to_look_at);
				        
				        if (!(account_info.contains("Error"))) { 
					        System.out.println(account_info);
					        
					        boolean repeat_account_deletion = true;
					    	while (repeat_account_deletion) {
					    		System.out.println("What do you want to do?\r1) Delete Account\r2) Look at another account\r3) Leave");
					        
					    		String descion = input.nextLine();
					    		
					    		is_number = tryParseInt(descion);
								if (is_number) {
									switch (descion) {
										case "1":
											Person per = reterive_account_user_id(account_to_look_at);
											if (!(per == null)) {
												boolean deleted_accounts = delete_account(account_to_look_at);
												if (deleted_accounts) {
													System.out.println("Account has been deleted!\r");
													repeat_account_deletion = false;
													repeat_user_id = false;	
												} else {
													System.out.println("We are having issues deleteing the account. Please try again!\r");
												}
											} else {
												System.out.println("We are having issues grabbing the account. Please, try again!\r");
											}
											break;
										case "2":
											repeat_account_deletion = false;
											repeat_user_id = false;
											break;
										case "3":
											repeat_account_deletion = false;
											repeat_user_id = false;
											repeat = false;
											break;
										default:
											System.out.println(" That is the not a correct response, please try again!\r");
									}
								} else {
									System.out.println("That is not a number! Please try again!\r");
								}
					    	}
				        } else {
				        	System.out.println("Could not find account. Please try again!\r");
				        	repeat_user_id = false;
				        }
					} else {
						repeat_user_id = false;
						System.out.println("That is not a number! Please try again!\r");
					}
				}
		   }
        }
	}
	
	public static String view_account(String User_id) {
		try {
			List<Person> person_list = new ArrayList<Person>();
			Person single_person = null;
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE USER_ID = " + User_id);
			while(rs.next()) {
				single_person = new Person( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Integer.toString(rs.getInt(13)));
				person_list.add(single_person);
			}     
			
			if(!(person_list.size() == 0)) {
				for(Person single : person_list) {
					return "User ID: " + single_person.getUser_id() + "\r" + 
							"First Name: " + single_person.getFirst_name() + "\r" + 
							"Last Name: " + single_person.getLast_name() + "\r" + 
							"Address: " + single_person.getAddress() + "\r" + 
							"City: " + single_person.getCity() + "\r" + 
							"State: " + single_person.getState()+ "\r" + 
							"Zipcode: " + single_person.getZipcode() + "\r" + 
							"Username: " + single_person.getUsername() + "\r" + 
							"Password: " + single_person.getPassword() + "\r" + 
							"Phone: " + single_person.getPhone() + "\r" + 
							"SSN: " + single_person.getSSN() + "\r" + 
							"Account Level: " + single_person.getAccount_level() + "\r" + 
							"Banking Account ID: " + single_person.getBanking_account_id() + "\r"; 
				}
			} else {
				return "Error in finding the viewing information";
			}
		} catch (SQLException e){
			return "Error collecting all information, please try again!";
		}
		return "Error collecting all information, please try again!";
	}
	
	public static Person reterive_account_user_id(String User_id) {
		try {
			
			List<Person> person_list = new ArrayList<Person>();
			Person single_person = null;
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE USER_ID = " + User_id);
			while(rs.next()) {
				single_person = new Person( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Integer.toString(rs.getInt(13)));
				person_list.add(single_person);
			}     
			
			if(!(person_list.size() == 0)) {
				for(Person single : person_list) {
					return single;
				}
			} else {
				return null;
			}
		} catch (SQLException e){
			System.out.println("There seems to be a database error! Please, try again!");
			return null;
		}
		return null;
	}
	
	protected List<Person> get_all_accounts() {
		try {	
			
			List<Person> person_accounts = new ArrayList<Person>();
			Person accounts = null;
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE ACCOUNT_LEVEL = 'Employee - Regular' OR ACCOUNT_LEVEL = 'Customer'");
					
			while(rs.next()) {
				accounts = new Person( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Integer.toString(rs.getInt(13)));
				person_accounts.add(accounts);
			}
			
			if (!(person_accounts.size() == 0)) {
				return person_accounts;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("There seems to be a database error! Please, try again!");
			return null;
		}
	}
	
	protected boolean delete_account(String user_id) {		
		try {
			
			Connection conn = cf.getConnection();
			String sql = "{call delete_banking_account (?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setString(1, user_id);
			call.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
