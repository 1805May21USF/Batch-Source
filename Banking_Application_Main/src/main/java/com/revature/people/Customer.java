package com.revature.people;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.accounts.Checking;
import com.revature.accounts.Joint;
import com.revature.accounts.Savings;
import com.revature.messages.Messages;
import com.revature.util.ConnFactory;

public class Customer extends Person {

	private String claim_number;
	private Savings savings_account;
	private Checking checking_account;
	private Joint joint_account;
	private String account_level;
	private String user_id;
	private String bank_account_id;
	
	public Customer(String first_name, String last_name, String address, String city, String state, String zipcode, String username, String password, String ssn, String phone, String account_level) {
		super(first_name, last_name, address, city, zipcode, state, username, password,  phone, ssn);
		
	}
	
	public Customer(String user_id, String first_name, String last_name, String address, String city, String state,
			String zipcode, String username, String password,  String phone, String ssn, String account_level, String banking_account_id) {
		super(user_id, first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn, account_level, banking_account_id);
	}

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void logged_in() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) Look up an account\r2) Apply for an account\r3) View personal information\r4) Go back\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				//Look up an account
			case "2":
				try {
					Messages.take_information();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
				}
			case "3":
				//view_account();
			case "4":
				repeat = false;
			}	
		}
	}
	
	protected void look_up_personal_information(String username, String password) {
		try {	
			
		    List<Person> person_list = new ArrayList<Person>(); 
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");
			Person app = null;
			
			while(rs.next()) {
				app = new Person(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),  Integer.toString(rs.getInt(13)));
				person_list.add(app);
			}
			
			if (person_list.size() > 0) {
				System.out.println(
						"User ID: " + app.getUser_id() + "\r" + 
						"First Name: " + app.getFirst_name() + "\r" + 
						"Last Name: " + app.getLast_name() + "\r" + 
						"Address: " + app.getAddress() + "\r" + 
						"City: " + app.getCity() + "\r" + 
						"State: " + app.getState()+ "\r" + 
						"Zipcode: " + app.getZipcode() + "\r" + 
						"Username: " + app.getUsername() + "\r" + 
						"Password: " + app.getPassword() + "\r" + 
						"Phone: " + app.getPhone() + "\r" + 
						"SSN: " + app.getSSN() + "\r" + 
						"Account Level: " + app.getAccount_level() + "\r" + 
						"Banking ID: " + app.getBanking_account_id() + "\r"); 
			} else {
				System.out.println("Sorry, we could not pull up your account...");
			}
			
			
		} catch(SQLException e) {
			System.out.println("Error conecting with the database, please try again later!");
		}
	}
	
	protected int apply_for_application() {
		return 0;
	}

	protected void view_personal_info() {
		
	}
	
	protected void check_application(String claim_number) {
		
	}
	
	protected void check_banking_account(Account account) {
		
	}
	
	public String getClaim_number() {
		return claim_number;
	}

	public Savings getSavings_account() {
		return savings_account;
	}

	public Checking getChecking_account() {
		return checking_account;
	}

	public Joint getJoint_account() {
		return joint_account;
	}
}
