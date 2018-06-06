package com.revature.people;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.revature.accounts.Account;
import com.revature.util.ConnFactory;

public class Application extends Person{
	private String status;
	private String account_type;
	private String application_id;
	private String claim_number;
	
	public Application(String first_name, String last_name, String address, String city, String state, String zipcode, String username, String password, String phone, String ssn, String status, String account_type) {
		super(first_name, last_name, address, city, state, zipcode, username, password, phone, ssn);
		this.status = status;
		this.account_type = account_type;
	}

	public Application(String application_id, String first_name, String last_name, String address, String city, String state, String zipcode,
			String username, String password, String phone, String ssn, String claim_number, String status, String account_type) {
		super(first_name, last_name, address, city,  state, zipcode, username, password, phone, ssn);
		this.status = status;
		this.account_type = account_type;
		this.application_id = application_id;
		this.claim_number = claim_number;
	}

	public static ConnFactory cf = ConnFactory.getInstance();

	public String create_application () throws SQLException {
			boolean duplicate = false;
			
			switch(this.getAccount_type()){
			case "1":
				this.setAccount_type("Checking");
				break;
			case "2":
				this.setAccount_type("Savings");
				break;
			case "3":
				this.setAccount_type("Joint");
				break;
			}
			List<Application> application_list = new ArrayList<Application>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM Banking_Applications");
			Application app = null;
			
			while(rs.next()) {
				app = new Application(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
				application_list.add(app);
			}
			
			if (!application_list.isEmpty()) {
				for(Application single_application : application_list) {
					if (single_application.getUsername().contains(this.getUsername())) {
						duplicate = true;
						break;
					}
				}
				if (!duplicate) {
						boolean money_account = check_to_see_if_money_account_exists(this.getUsername(), this.getAccount_type());
						if (!(money_account)) {
							return insert_application();
						} else {
							return "The application you are trying to make already has the account type created, if this is an error please contact the bank!";
						}
				} else {
					return "You already have an application pending. Enter your claim number at the home screen to view the status, or call during business hours";  
				}	
			} else {			
				boolean money_account = check_to_see_if_money_account_exists(this.getUsername(), this.getAccount_type());
				if (!(money_account)) {
					return insert_application();
				} else {
					return "The application you are trying to make already has the account type created, if this is an error please contact the bank!";
				}
			}
		} 
	
	protected boolean check_to_see_if_money_account_exists(String username, String account_type) {
		try {
			String temp_account_type = null;
			switch(account_type) {
				case "Checking":
					temp_account_type = "CHECKING_ACCOUNTS";
					break;
				case "Savings":
					temp_account_type = "SAVINGS_ACCOUNTS";
					break;
				case "Joint":
					temp_account_type = "JOINT_ACCOUNTS";
					break;
				default:
			}
			String banking_id = find_existing_account_baking_id(username);
			if(!(banking_id == null)) {
				List<Account> acc_list = new ArrayList<Account>();
				Account acc = null;
				Connection conn = cf.getConnection();
				Statement stmt;
				stmt = conn.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("SELECT BANKING_ACCOUNT_ID, BALANCE, PREVIOUS_TRANSACTION FROM " + temp_account_type + " WHERE BANKING_ACCOUNT_ID = " + banking_id);
				while(rs.next()) {
					acc = new Account(Integer.toString(rs.getInt(1)), rs.getInt(2), rs.getInt(3));
					acc_list.add(acc);
				}
				if (!(acc_list.size() == 0))
					return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected static String find_existing_account_baking_id(String username) {
		try {
			List<Customer> customer_list = new ArrayList<Customer>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE USERNAME = '" + username + "'");
			Customer app = null;
			while(rs.next()) {
				app = new Customer(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),  Integer.toString(rs.getInt(13)));
				customer_list.add(app);
			}
			if(!(customer_list.size() == 0)) {
				for(Customer cust : customer_list) {
					if(cust.getUsername().contains(username)) {
						return cust.getBanking_account_id();
					} else {
						return null;
					}
				}
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
		return username;
	}
	
	protected static Person find_existing_account(String username) {
		try {
			
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE USERNAME = '" + username + "'");
			Person app = null;
			
			while(rs.next()) {
				app = new Person(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),  Integer.toString(rs.getInt(13)));
			}
			
			return app;
			
		} catch(SQLException e) {
			return null;
		}
	}

	public static String check_on_application(String temp_claim_number) {
		try {
			
			List<Application> application_list = new ArrayList<Application>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM Banking_Applications");
			Application app = null;
			
			while(rs.next()) {
				app = new Application(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.toString(rs.getInt(12)), rs.getString(13), rs.getString(14));
				application_list.add(app);
			}
			
			if (!(application_list.isEmpty())) {
				for (Application single_app : application_list) {
					if (single_app.claim_number.contains(temp_claim_number)) {
						app = single_app;
						break;
					}
				}
				
				if (!(app == null)) {
					return "Your status on your application is :\"" + app.getStatus() + "\", if you have any questions feel free to call during normal banking hours";
				} else {
					return "You do not have an application on file, if you have any questions feel free to call during normal banking hours";
				}
				
			} else {
				return "There is no applications currently pending, if you think this was a mistake please call the business during normal banking hours with your claim #";
			}
		}
		catch(Exception e) {
			return "Error: Having issues with the database. Please try again later!";
		}	
	}
	
	protected String insert_application() {
		try {
			Connection conn = cf.getConnection();
			String sql = "{call create_applications (?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setString(1, this.getFirst_name());
			call.setString(2, this.getLast_name());
			call.setString(3, this.getAddress());
			call.setString(4, this.getCity());
			call.setString(5, this.getState());
			call.setString(6, this.getZipcode());
			call.setString(7, this.getUsername());
			call.setString(8, this.getPassword());
			call.setString(9, this.getPhone());
			call.setString(10, this.getSSN());
			call.setString(11, this.getStatus());
			call.setString(12, this.getAccount_type());

			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error: Having issues with the database. Please try again later!";
		}

		return "Your application has been recieved! Thank you for applying, have a great day!";
	}
	
	public String getClaim_number() {
		return claim_number;
	}

	public String getApplication_id() {
		return application_id;
	}
	
	public String getAccount_type() {
		return account_type;
	}

	protected void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}

}