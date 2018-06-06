package com.revature.people;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.util.ConnFactory;

public class Employee extends Person{

	public Employee(String first_name, String last_name, String address, String city, String state, String zipcode, String phone, String username, String password, String ssn, String status, String account_level) {
		super(first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn);
	}
	
	public Employee(String user_id, String first_name, String last_name, String address, String city, String state,
			String zipcode, String username, String password,  String phone, String ssn, String account_level, String banking_account_id) {
		super(user_id, first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn, account_level, banking_account_id);
	}

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void logged_in() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) Look up an account\r2) Approve or Deny accounts\r3) View accounts\r4) Logout\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				//Look up an account
				break;
			case "2":
				approve_and_deny_accounts();
				break;
			case "3":
				view_account();
			case "4":
				repeat = false;
				break;
			}	
		}
	}
	
	protected void view_account() {
		Scanner input = new Scanner(System.in);
		String view_another_string = null;
		boolean repeat = true;
		boolean view_another = true;
		while(repeat) {
			
			System.out.println("Do you want to view applications, or accounts? \"Press One, Two, Three\"\r");
			System.out.println("1) Application");
			System.out.println("2) Accounts");
			System.out.println("3) Go back");
			
			String output = input.nextLine();
			switch(output) {
				case "1":
					boolean repeat_view_app = true;
					while (repeat_view_app) {
						System.out.println("Enter the user id you want to view");
						String username = input.nextLine();
						System.out.println(view_account(username));
						while(view_another) {
							System.out.println("Do you wish to view another application? \"Type Yes or No\"\r");
							view_another_string = input.nextLine();
							if (view_another_string.toLowerCase().contains("yes")) {
								view_another = false;
							} else if (view_another_string.toLowerCase().contains("no")) {
								view_another = false;
								repeat_view_app = false;
							}
						}
					}
					break;
				case "2":
					boolean repeat_view_acc = true;
					while (repeat_view_acc) {
						view_another = true;
						System.out.println("Enter the user username you want to view");
						String username = input.nextLine();
						Person account = Application.find_existing_account(username);
						System.out.println(
										"User ID: " + account.getUser_id() + "\r" + 
										"First Name: " + account.getFirst_name() + "\r" + 
										"Last Name: " + account.getLast_name() + "\r" + 
										"Address: " + account.getAddress() + "\r" + 
										"City: " + account.getCity() + "\r" + 
										"State: " + account.getState()+ "\r" + 
										"Zipcode: " + account.getZipcode() + "\r" + 
										"Username: " + account.getUsername() + "\r" + 
										"Password: " + account.getPassword() + "\r" + 
										"Phone: " + account.getPhone() + "\r" + 
										"SSN: " + account.getSSN() + "\r" + 
										"Account Level: " + account.getAccount_level() + "\r" + 
										"Banking ID: " + account.getBanking_account_id() + "\r"); 
						while(view_another) {
							System.out.println("Do you wish to view another account? \"Type Yes or No\"\r");
							view_another_string = input.nextLine();
							if (view_another_string.toLowerCase().contains("yes")) {
								view_another = false;
							} else if (view_another_string.toLowerCase().contains("no")) {
								view_another = false;
								repeat_view_acc = false;
							}
						}
					}
					break;
				case "3":
					repeat = false;
			}
		}
	}
	
	protected boolean create_account_customer(String application_id) {
		try {		
			Application applicant = null;
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_APPLICATIONS WHERE APPLICATION_ID = " + application_id);
			
			while(rs.next()) {
				applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
			}
			
			if (!(applicant == null)) {
				
				boolean account_create = create_account_customer_call(applicant);
				
				if (account_create) {
					
					System.out.println("Account was created! Attempting to delete old record....\r");
					boolean deleted_application = delete_application(application_id);
					
					if (deleted_application) {
						System.out.println("Application was deleted!\r");
						return true;
					} else {
						System.out.println("Application was not deleted! Please try again!");
						return false;
					}
				} else {
					System.out.println("Account was not created! Please try again!");
					return false;
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println("There seems to be an error in the database. Please try again!");
			return false;
		}
	}
	
	protected boolean delete_application(String Application_id) {		
		try {
			
			Connection conn = cf.getConnection();
			String sql = "{call delete_account (?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setString(1, Application_id);
			call.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected boolean create_account_customer_call(Application applicant) {
		try {
		     Person account = Application.find_existing_account(applicant.getUsername());
		     boolean created_checking =  false;
		     
			if(account == null) {
				
			     Scanner input = new Scanner(System.in);
			     boolean account_type = false;
			     String output = null;
			     
			     while (!(account_type)) {
			    	 System.out.println("Is this person an Employee or a Customer? \"Type Employee or Customer\" \r1) Employee\r2) Customer\r");
				     output = input.nextLine();
				     
				     switch(output) {
				     	 case "1":
				     		 output = "Employee";
				     		 account_type = true;
				     	 case "2":
				     		 output = "Customer";
				     		account_type = true;
				     }	 
			     }
			  
				Connection conn = cf.getConnection();
				String sql = "{call create_account (?,?,?,?,?,?,?,?,?,?,?)}";
				
				CallableStatement call = conn.prepareCall(sql);
				
				call.setString(1, applicant.getFirst_name());
				call.setString(2, applicant.getLast_name());
				call.setString(3, applicant.getAddress());
				call.setString(4, applicant.getCity());
				call.setString(5, applicant.getState());
				call.setString(6, applicant.getZipcode());
				call.setString(7, applicant.getUsername());
				call.setString(8, applicant.getPassword());
				call.setString(9, applicant.getPhone());
				call.setString(10, applicant.getSSN());
				call.setString(11, output);

				call.execute();

				account = Application.find_existing_account(applicant.getUsername());
				return created_checking = passing_account_types(account, applicant.getAccount_type());

			} else {
				return created_checking = passing_account_types(account, applicant.getAccount_type());
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	protected boolean passing_account_types(Person account, String account_type) {
		boolean created_checking = false;
		switch(account_type) {
		case "Checking":
			created_checking = create_money_account(account, account_type);
			return (created_checking) ? true : false;
		case "Savings":
			created_checking = create_money_account(account, account_type);
			return (created_checking) ? true : false;
		case "Joint":
			created_checking = create_money_account(account, account_type);
			return (created_checking) ? true : false;
		default:
			return false;
		}
	}
	
	protected boolean create_money_account(Person account, String account_type) {
		Connection conn = cf.getConnection();
		
		Scanner input = new Scanner(System.in);
		
		switch(account_type) {
			case "Checking":
				try {
					System.out.println("How much would the " + account.getFirst_name() + " " + account.getLast_name() + " like to deposit into your checking account?\r");
					
					int balance = input.nextInt();
					
					String sql = "{call create_checking_account (?,?)}";
					
					CallableStatement call = conn.prepareCall(sql);
					
					call.setInt(1, Integer.parseInt(account.getBanking_account_id()));
					call.setInt(2, balance);

					call.execute();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
					return false;
				}
			case "Savings":
				try {
					System.out.println("How much would the " + account.getFirst_name() + " " + account.getLast_name() + " like to deposit into your savings account?\r");
					
					int balance = input.nextInt();
					
					String sql = "{call create_savings_account (?,?)}";
					
					CallableStatement call = conn.prepareCall(sql);
					
					call.setInt(1, Integer.parseInt(account.getBanking_account_id()));
					call.setInt(2, balance);

					call.execute();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
					return false;
				}
			case "Joint":
				try {
					System.out.println("How much would " + account.getFirst_name() + " " + account.getLast_name() + " like to deposit into your savings account?\r");
					
					String balance = input.nextLine();
					boolean name_is_found = false;
					Person found_account = null;
					
					while (!(name_is_found)) {
						System.out.println("What account would " + account.getFirst_name() + " " + account.getLast_name() + " like to joint with? \"Enter the username of the account\"\r");
						
						String username = input.nextLine();
						
						found_account = Application.find_existing_account(username);
						
						if (!(found_account == null)) {
							int banking_account_id = Integer.parseInt(found_account.getBanking_account_id());
							
							String sql = "{call create_joint_account (?,?,?)}";
							
							CallableStatement call = conn.prepareCall(sql);
							
							call.setInt(1, Integer.parseInt(account.getBanking_account_id()));
							call.setInt(2, Integer.parseInt(balance));
							call.setInt(3, Integer.parseInt(found_account.getBanking_account_id()));
							
							call.execute();
							return true;
						} else {
							System.out.println("Account is not found... please try again!\r");
						}
					}				
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
					return false;
				}
		}
		return false;
	}
	
	protected void approve_and_deny_accounts() {
		Scanner input = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat) {
        	
        	try {
				Application applicant = null;
				
				List<Application> see_applications = new ArrayList<Application>();
				
				ResultSet rs = get_all_banking_applications();
				
				while(rs.next()) {
					applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
					see_applications.add(applicant);
				}
		        int i = 1;
		        
		        if (see_applications.size() == 0) {
		        	repeat = false;
		        	System.out.println("There is no accounts currently to approve/deny, please try again later!\r");
		        } else {
					System.out.println("\rHere are the usernames applications awaiting approval!");
					
		        	for (Application single_applicant : see_applications) {
				        	
				        System.out.println(i + ") " + single_applicant.getFirst_name() + " " + single_applicant.getLast_name() + ". Applicant ID: " + single_applicant.getApplication_id());
				        i++;
					}				
					
					 System.out.println("\rWhich account do you want to look at? *Please type in the Applicant ID*\r");
					 
					 String account_to_approve = input.nextLine();
		             
		             String account_info = view_account(account_to_approve);
		             
		             System.out.println(account_info);
		             
		             if(!(account_info.contains("Error"))) {
		            	 System.out.println("\rDo you wish to approve this account? \"Yes/No\"");
		            	 
		            	 String output = input.nextLine();
		            	 
		            	 if (output.toLowerCase().equals("yes")) {
		            		 boolean result = create_account_customer(account_to_approve);
		            		 
		            		 if (result) {
		            			 System.out.println("Everything was created and deleted perfectly! Would you want to approve/deny another account? \"Yes/No\"");
		            			 String yes_no = input.nextLine();
		            			 
		            			 	if(yes_no.toLowerCase().equals("no")) {
		            			 		List<Application> get_all_applications = new ArrayList<Application>();
		            			 		rs = get_all_banking_applications();
		         				
		            			 		while(rs.next()) {
		            			 			applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
		            			 			get_all_applications.add(applicant);
		            			 		}
	         				     
		            			 		if (get_all_applications.size() > 0) {
		            			 			repeat = false; 
		            			 		}		
		            			   }
		            		 }
		            	 } else if (output.toLowerCase().equals("no")) {
		            		 
		            		 boolean result = delete_application(account_to_approve);
		            		 
		            		 if (result) {
		            			 System.out.println("Everything was deleted perfectly! Would you want to approve/deny another account? \"Yes/No\"");
		            			 String yes_no = input.nextLine();
		            			 
		            			 if(yes_no.toLowerCase().equals("no")) {
		            			 
		            			 	List<Application> get_all_applications = new ArrayList<Application>();
	            				    rs = get_all_banking_applications();
		         				
	            				    while(rs.next()) {
	            				    	applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
	            				    	get_all_applications.add(applicant);
	            				    }
	            				     
	            				     if (get_all_applications.size() > 0) {
	    	            				 repeat = false; 
	            				     }	
		            		   }
		            	  }
		              }
		           }
		        }
			} catch (SQLException e){
				System.out.println("Error collecting all information, please try again!");
			} 
        }
	}
	
	protected ResultSet get_all_banking_applications() {
		ResultSet rs = null;
		try {
		Connection conn = cf.getConnection();
		Statement stmt;
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM BANKING_APPLICATIONS");
		return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
	}
	
	protected String view_account(String user_id_temp) {
		try {	
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_APPLICATIONS WHERE APPLICATION_ID = " + user_id_temp);
			while(rs.next()) {
				Application applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
				
				return "Applicant ID: " + applicant.getApplication_id() + "\r" + 
				"First Name: " + applicant.getFirst_name() + "\r" + 
				"Last Name: " + applicant.getLast_name() + "\r" + 
				"Address: " + applicant.getAddress() + "\r" + 
				"City: " + applicant.getCity() + "\r" + 
				"State: " + applicant.getState()+ "\r" + 
				"Zipcode: " + applicant.getZipcode() + "\r" + 
				"Username: " + applicant.getUsername() + "\r" + 
				"Password: " + applicant.getPassword() + "\r" + 
				"Phone: " + applicant.getPhone() + "\r" + 
				"SSN: " + applicant.getSSN() + "\r" + 
				"Claim Number: " + applicant.getClaim_number() + "\r" + 
				"Account Type: " + applicant.getAccount_type() + "\r"; 
			}     
		} catch (SQLException e){
			return "Error collecting all information, please try again!";
		}
		return "Error collecting all information, please try again!";
	}

}
