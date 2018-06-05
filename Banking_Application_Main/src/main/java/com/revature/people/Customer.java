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
		
		while (repeat) {
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) Look up an account\r2) Apply for an account\r3) View personal information\r4) Go back\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				look_up_your_account();
				break;
			case "2":
				try {
					Messages.take_information();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error: Having issues with the database. Please try again later!");
				}
				break;
			case "3":
				look_up_personal_information();
				break;
			case "4":
				repeat = false;
			}	
		}
	}
	
	public static Person find_account_by_banking_id(String banking_id) {
		try {
			
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM BANKING_ACCOUNTS WHERE BANKING_ACCOUNT_ID = " + Integer.parseInt(banking_id));
			Person app = null;
			
			while(rs.next()) {
				app = new Person(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),  Integer.toString(rs.getInt(13)));
			}
			
			return app;
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	protected Checking current_checking() {
		try {
			List<Checking> checking_account = new ArrayList<Checking>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM CHECKING_ACCOUNTS WHERE BANKING_ACCOUNT_ID = " + this.getBanking_account_id());
			Checking app = null;
			
			while(rs.next()) {
				app = new Checking(Integer.toString(rs.getInt(1)), rs.getInt(2), rs.getInt(3));
				checking_account.add(app);
			}
			
			if (checking_account.size() > 0) {
				return app;
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	protected Savings current_savings() {
		try {
			List<Savings> savings_account = new ArrayList<Savings>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM SAVINGS_ACCOUNTS WHERE BANKING_ACCOUNT_ID = " + this.getBanking_account_id());
			Savings app = null;
			
			while(rs.next()) {
				app = new Savings(Integer.toString(rs.getInt(1)), rs.getInt(2), rs.getInt(3));
				savings_account.add(app);
			}
			
			if (savings_account.size() > 0) {
				return app;
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	protected List<Joint> current_joint_list() {
		try {
			List<Joint> joint_account = new ArrayList<Joint>();
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM JOINT_ACCOUNTS WHERE BANKING_ACCOUNT_ID_JOINT = " + Integer.parseInt(this.getBanking_account_id()));
			Joint app = null;
			
			while(rs.next()) {
				app = new Joint(Integer.toString(rs.getInt(1)), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				joint_account.add(app);
			}
			
			if (joint_account.size() > 0) {
				return joint_account;
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	protected Joint current_joint_single(String banking_account_id) {
		try {
			
			Connection conn = cf.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM JOINT_ACCOUNTS WHERE BANKING_ACCOUNT_ID = " + Integer.parseInt(banking_account_id));
			Joint app = null;
			
			while(rs.next()) {
				app = new Joint(Integer.toString(rs.getInt(1)), rs.getInt(2), rs.getInt(3), rs.getInt(4));
			}
			
			if (!(app == null)) {
				return app;
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	public void look_up_your_account() {
		boolean repeat = true;
		while(repeat) {
			Scanner input = new Scanner(System.in);
			System.out.println("What account do you want to check? \"Type in One, Two, Three or Four\"\r");
			System.out.println("1) Checking\r2) Savings\r3) Joint Account\r4) Go back");
			String account_chosen = input.nextLine();
			
			switch (account_chosen) {
				case "1":
					Checking acc = current_checking();
					if (!(acc == null)) {
						this.checking_account = acc;
						boolean account_choice = true;
						while (account_choice) {
							System.out.println("What would you like to do? \"Type in One, Two, Three or Four\"\r");
							
							System.out.println("1) Deposit\r2) Withdraw\r3) Delete Account\r4) Go back");
							
							String choice = input.nextLine();
							boolean deposit_repeat = true;
							boolean withdraw_repeat = true;
							boolean delete_account = true;
							
							switch(choice) {
							case "1":
								while(deposit_repeat) {
									acc = current_checking();
									this.checking_account = acc;
									System.out.println("Current Balance: $" + this.checking_account.getBalance() + "\r");
									System.out.println("How much would you like to deposit?\r");
									String new_balance_string = input.nextLine();
									boolean number = tryParseInt(new_balance_string);
									if (number) {
										int new_balance = checking_account.getBalance() + Integer.parseInt(new_balance_string);
										boolean successful_deposit = this.checking_account.deposit(this.getBanking_account_id(), new_balance, Integer.parseInt(new_balance_string));
										boolean continue_to_deposit = true;

										if (successful_deposit) {
											while(continue_to_deposit) {
												System.out.println("Deposit successful! Would you like to make another deposit? \"Yes or No\"");
											
												String deposit_continue = input.nextLine();
									
												switch (deposit_continue) {
													case "yes":
														continue_to_deposit = false;
														break;
													case "no":
														continue_to_deposit = false;
														deposit_repeat = false;
														break;
													default:
														System.out.println("Entered in incorrect data, please try again!\r");
												}
											}
										}
									} else {
										System.out.println("Entered in incorrect data, please try again!\r");
									}
								}
								break;
							case "2":
								while(withdraw_repeat) {
									acc = current_checking();
									this.checking_account = acc;
									System.out.println("Current Balance: $" + this.checking_account.getBalance() + "\r");
									System.out.println("How much would you like to withdraw?\r");
									String minus = input.nextLine();
									boolean number = tryParseInt(minus);
									if (number) {
										int new_balance = this.checking_account.getBalance() -  Integer.parseInt(minus);
										if (!(new_balance < 0)) {
											boolean successful_withdraw = checking_account.deposit(this.getBanking_account_id(), new_balance, Integer.parseInt(minus));
											boolean continue_to_withdraw = true;
											
											if (successful_withdraw) {
												while(continue_to_withdraw) {
													System.out.println("Withdraw successful! Would you like to make another withdraw? \"Yes or No\"");
												
													String deposit_continue = input.nextLine();
										
													switch (deposit_continue) {
														case "yes":
															continue_to_withdraw = false;
															break;
														case "no":
															continue_to_withdraw = false;
															withdraw_repeat = false;
															break;
														default:
															System.out.println("Entered in incorrect data, please try again!\r");
													}
												}
											}
										} else {
											System.out.println("You can not withdraw $" + minus + ", because you only have $" + this.checking_account.getBalance());
										}
									} else {
										System.out.println("Entered in incorrect data, please try again!\r");
									}
								}
								break;
							case "3":
								while(delete_account) {
									acc = current_checking();
									this.checking_account = acc;
									System.out.println("Current Balance: $" + this.checking_account.getBalance() + "\r");
									
									if (this.checking_account.getBalance() == 0) {
										System.out.println("Would you like to remove the checking account? \"Type Yes or No\"\r");
										String answer = input.nextLine();
										boolean number = tryParseInt(answer);
										if (!(number)) {
											boolean deleted_account = Account.delete_checking_account(this.getBanking_account_id());
											if (deleted_account) {
												System.out.println("Your account was deleted!\r");
												delete_account = false;
												account_choice = false;
											} else {
												System.out.println("There was issues deleteing the account, please try again later!\r");
											}
										}
									} else {
										System.out.println("You can not delete your account since it has $" + this.current_checking().getBalance() + " left in it\r" );
										delete_account = false;
									}
								}
								break;
							case "4":
								account_choice = false;
								break;
							default:
								System.out.println("Entered in incorrect data, please try again!\r");
							}
						}
					} else {
						System.out.println("Can not find your account! Please try again!\r");
					}
					break;
				case "2":
					Savings savings = current_savings();
					if (!(savings == null)) {
						this.savings_account = savings;
						boolean account_choice = true;
						while (account_choice) {
							System.out.println("What would you like to do? \"Type in One, Two, Three or Four\"\r");
							
							System.out.println("1) Deposit\r2) Withdraw\r3) Delete Account\r4) Go back");
							
							String choice = input.nextLine();
							boolean deposit_repeat = true;
							boolean withdraw_repeat = true;
							boolean delete_account = true;
							
							switch(choice) {
							case "1":
								while(deposit_repeat) {
									savings = current_savings();
									this.savings_account = savings;
									System.out.println("Current Balance: $" + this.savings_account.getBalance() + "\r");
									System.out.println("How much would you like to deposit?\r");
									String new_balance_string = input.nextLine();
									boolean number = tryParseInt(new_balance_string);
									if (number) {
										int new_balance = this.savings_account.getBalance() + Integer.parseInt(new_balance_string);
										boolean successful_deposit = savings_account.deposit(this.getBanking_account_id(), new_balance, Integer.parseInt(new_balance_string));
										boolean continue_to_deposit = true;

										if (successful_deposit) {
											while(continue_to_deposit) {
												System.out.println("Deposit successful! Would you like to make another deposit? \"Yes or No\"");
											
												String deposit_continue = input.nextLine();
									
												switch (deposit_continue) {
													case "yes":
														continue_to_deposit = false;
														break;
													case "no":
														continue_to_deposit = false;
														deposit_repeat = false;
														break;
													default:
														System.out.println("Entered in incorrect data, please try again!\r");
												}
											}
										}
									} else {
										System.out.println("Entered in incorrect data, please try again!\r");
									}
								}
								break;
							case "2":
								while(withdraw_repeat) {
									savings = current_savings();
									this.savings_account = savings;
									System.out.println("Current Balance: $" + this.savings_account.getBalance() + "\r");
									System.out.println("How much would you like to withdraw?\r");
									String minus = input.nextLine();
									boolean number = tryParseInt(minus);
									if (number) {
										int new_balance = this.savings_account.getBalance() -  Integer.parseInt(minus);
										if (!(new_balance < 0)) {
											boolean successful_withdraw = this.savings_account.deposit(this.getBanking_account_id(), new_balance, Integer.parseInt(minus));
											boolean continue_to_withdraw = true;
											
											if (successful_withdraw) {
												while(continue_to_withdraw) {
													System.out.println("Withdraw successful! Would you like to make another withdraw? \"Yes or No\"");
												
													String deposit_continue = input.nextLine();
										
													switch (deposit_continue) {
														case "yes":
															continue_to_withdraw = false;
															break;
														case "no":
															continue_to_withdraw = false;
															withdraw_repeat = false;
															break;
														default:
															System.out.println("Entered in incorrect data, please try again!\r");
													}
												}
											}
										} else {
											System.out.println("You can not withdraw $" + minus + ", because you only have $" + this.savings_account.getBalance());
										}
									} else {
										System.out.println("Entered in incorrect data, please try again!\r");
									}
								}
								break;
							case "3":
								while(delete_account) {
									savings = current_savings();
									this.savings_account = savings;
									System.out.println("Current Balance: $" + this.savings_account.getBalance() + "\r");
									
									if (this.getSavings_account().getBalance() == 0) {
										System.out.println("Would you like to remove the savings account? \"Type Yes or No\"\r");
										String answer = input.nextLine();
										boolean number = tryParseInt(answer);
										if (!(number)) {
											boolean deleted_account = Account.delete_savings_account(this.getBanking_account_id());
											if (deleted_account) {
												System.out.println("Your account was deleted!\r");
												delete_account = false;
												account_choice = false;
											} else {
												System.out.println("There was issues deleteing the account, please try again later!\r");
											}
										}
									} else {
										System.out.println("You can not delete your account since it has $" + this.current_checking().getBalance() + " left in it\r" );
										delete_account = false;
									}
								}
								break;
							case "4":
								account_choice = false;
								break;
							default:
								System.out.println("Entered in incorrect data, please try again!\r");
							}
						}
					} else {
						System.out.println("Can not find your account! Please try again!\r");
					}
					break;
				case "3":
					List<Joint> joint = current_joint_list();
					if (!(joint.size() == 0)) {
						int i = 1;
						boolean continue_if_non_number = true;
						boolean isNumber = false;
						String joint_account_picked = null;
						
						while(continue_if_non_number) {
							
							System.out.println("Which account would you like to work with? \"Type the banking account id to access the account\"");
							for(Joint single_joint : joint) {
								Person joint_partner = find_account_by_banking_id(single_joint.getBanking_account_id());
								System.out.println(i + ") " + joint_partner.getFirst_name() + " " + joint_partner.getLast_name() + ". Banking account id:  " + joint_partner.getBanking_account_id());
								i++;
							}
							
							joint_account_picked = input.nextLine();
							isNumber = tryParseInt(joint_account_picked);
							
							if (isNumber) {
								continue_if_non_number = false;
							} else {
								System.out.println("Values are not valid, please try again!");
							}
						}
						
						Joint single_account = current_joint_single(joint_account_picked);
						this.joint_account = single_account;
						boolean account_choice = true;
						while (account_choice) {
							System.out.println("What would you like to do? \"Type in One, Two, Three or Four\"\r");
							
							System.out.println("1) Deposit\r2) Withdraw\r3) Delete Account\r4) Go back");
								
							String choice = input.nextLine();
							boolean deposit_repeat = true;
							boolean withdraw_repeat = true;
							boolean delete_account = true;
								
							switch(choice) {
								case "1":
									while(deposit_repeat) {
										single_account = current_joint_single(joint_account_picked);
										this.joint_account = single_account;
										System.out.println("Current Balance: $" + this.joint_account.getBalance() + "\r");
										System.out.println("How much would you like to deposit?\r");
										String new_balance_string = input.nextLine();
										boolean number = tryParseInt(new_balance_string);
										if (number) {
											int new_balance = this.joint_account.getBalance() + Integer.parseInt(new_balance_string);
											boolean successful_deposit = this.joint_account.deposit(joint_account_picked, new_balance, Integer.parseInt(new_balance_string));
											boolean continue_to_deposit = true;

											if (successful_deposit) {
												while(continue_to_deposit) {
													System.out.println("Deposit successful! Would you like to make another deposit? \"Yes or No\"");
												
													String deposit_continue = input.nextLine();
										
													switch (deposit_continue) {
														case "yes":
															continue_to_deposit = false;
															break;
														case "no":
															continue_to_deposit = false;
															deposit_repeat = false;
															break;
														default:
															System.out.println("Entered in incorrect data, please try again!\r");
													}
												}
											}
										} else {
											System.out.println("Entered in incorrect data, please try again!\r");
										}
									}
									break;
								case "2":
									while(withdraw_repeat) {
										acc = current_checking();
										this.checking_account = acc;
										System.out.println("Current Balance: $" + this.checking_account.getBalance() + "\r");
										System.out.println("How much would you like to withdraw?\r");
										String minus = input.nextLine();
										boolean number = tryParseInt(minus);
										if (number) {
											int new_balance = this.checking_account.getBalance() -  Integer.parseInt(minus);
											if (!(new_balance < 0)) {
												boolean successful_withdraw = checking_account.deposit(this.getBanking_account_id(), new_balance, Integer.parseInt(minus));
												boolean continue_to_withdraw = true;
												
												if (successful_withdraw) {
													while(continue_to_withdraw) {
														System.out.println("Withdraw successful! Would you like to make another withdraw? \"Yes or No\"");
													
														String deposit_continue = input.nextLine();
											
														switch (deposit_continue) {
															case "yes":
																continue_to_withdraw = false;
																break;
															case "no":
																continue_to_withdraw = false;
																withdraw_repeat = false;
																break;
															default:
																System.out.println("Entered in incorrect data, please try again!\r");
														}
													}
												}
											} else {
												System.out.println("You can not withdraw $" + minus + ", because you only have $" + this.checking_account.getBalance());
											}
										} else {
											System.out.println("Entered in incorrect data, please try again!\r");
										}
									}
									break;
								case "3":
									while(delete_account) {
										acc = current_checking();
										this.checking_account = acc;
										System.out.println("Current Balance: $" + this.checking_account.getBalance() + "\r");
										
										if (this.checking_account.getBalance() == 0) {
											System.out.println("Would you like to remove the checking account? \"Type Yes or No\"\r");
											String answer = input.nextLine();
											boolean number = tryParseInt(answer);
											if (!(number)) {
												boolean deleted_account = Account.delete_checking_account(this.getBanking_account_id());
												if (deleted_account) {
													System.out.println("Your account was deleted!\r");
													delete_account = false;
													account_choice = false;
												} else {
													System.out.println("There was issues deleteing the account, please try again later!\r");
												}
											}
										} else {
											System.out.println("You can not delete your account since it has $" + this.current_checking().getBalance() + " left in it\r" );
											delete_account = false;
										}
									}
									break;
								case "4":
									account_choice = false;
									break;
								default:
									System.out.println("Entered in incorrect data, please try again!\r");
								}
							}
						} else {
							System.out.println("Can not find your account! Please try again!\r");
						}
					break;
				case "4":
					repeat = false;
					break;
				default:
					System.out.println("Entered in incorrect data, please try again!\r");
			}
		}
	}
		
	protected void look_up_personal_information() {
		try {	
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("----Secure account look up---\r");
			
			System.out.println("Enter in a username");
			
			String username = input.nextLine();
			
			System.out.println("\rEnter your password");
			
			String password = input.nextLine();
			
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
	
	static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}
