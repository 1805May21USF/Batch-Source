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
	
	private String account_level;
	private String user_id;
	private String bank_account_id;

	public Employee(String first_name, String last_name, String address, String city, String state, String zipcode, String phone, String username, String password, String ssn, String status, String account_level) {
		super(first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn);
		
		this.account_level = account_level;
	}
	
	public Employee(String user_id, String first_name, String last_name, String address, String city, String state,
			String zipcode, String username, String password,  String phone, String ssn, String account_level, String bank_account_id) {
		super(first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn);
		this.account_level = account_level;
		this.user_id = user_id;
		this.bank_account_id = bank_account_id;
	}

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void logged_in() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) Look up an account\r2) Approve or Deny accounts\r3) View accounts\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				//Look up an account
			case "2":
				approve_and_deny_accounts();
			case "3":
				//view_account("", "");
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
		     Customer account = Application.find_existing_account(applicant.getUsername());
			
			if(account == null) {
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
				call.setString(11, "Customer");

				call.execute();
				
				switch(applicant.getAccount_type()) {
				case "Checking":
					boolean created_checking = create_money_account(account, applicant.getAccount_type());
					return true;
				case "Savings":
					return true;
				case "Joint":
					return true;
				}
			} else {
				switch(applicant.getAccount_type()) {
				case "Checking":
					boolean created_checking = create_money_account(account, applicant.getAccount_type());
					return true;
				case "Savings":
					return true;
				case "Joint":
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}
	
	protected boolean create_money_account(Customer account, String account_type) {
		String temp_account_variable = null;
		Connection conn = cf.getConnection();
		
		Scanner input = new Scanner(System.in);
		
		switch(account_type) {
			case "Checking":
				try {
					System.out.println("How much would you like to deposit into your checking account?\r");
					
					int balance = input.nextInt();
					
					String sql = "{call create_checking_account (?,?)}";
					
					CallableStatement call = conn.prepareCall(sql);
					
					call.setInt(1, Integer.parseInt(account.getBank_account_id()));
					call.setInt(2, balance);

					call.execute();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
					return false;
				}
			case "Savings":
				break;
			case "Joint":
				break;
		}
		return false;
	}
	
	protected void approve_and_deny_accounts() {
		Scanner input = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat == true) {
        	
        	try {
				Application applicant = null;
				
				List<Application> see_applications = new ArrayList<Application>();
				Connection conn = cf.getConnection();
				Statement stmt;
				stmt = conn.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("SELECT * FROM BANKING_APPLICATIONS");
				
				while(rs.next()) {
					applicant = new Application( Integer.toString(rs.getInt(1)), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
					see_applications.add(applicant);
				}
		        int i = 1;
		        
				for (Application single_applicant : see_applications) {
					System.out.println("\rHere are the usernames applications awaiting approval!");
			        	
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
	            			 
	            			 if(output.toLowerCase().equals("no"))
	            				 repeat = false;	
	            		 }
	            	 } else {
	            		 
	            		 boolean result = delete_application(account_to_approve);
	            		 
	            		 if (result) {
	            			 System.out.println("Everything was deleted perfectly! Would you want to approve/deny another account?");
	            			 String yes_no = input.nextLine();
	            			 
	            			 if(output.toLowerCase().equals("no"))
	            				 repeat = false;	
	            		 }
	            	 }
	             }
			} catch (SQLException e){
				System.out.println("Error collecting all information, please try again!");
			} 
        }
	}
	
	protected <T> void search_for_account(T account) {
		
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
	
	public String getUser_id() {
		return user_id;
	}

	public String getBank_account_id() {
		return bank_account_id;
	}

	
	public String getAccount_level() {
		return account_level;
	}

}
