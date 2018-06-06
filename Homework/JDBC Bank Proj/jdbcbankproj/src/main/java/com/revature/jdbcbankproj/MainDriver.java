package com.revature.jdbcbankproj;

import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;
import java.sql.SQLException;

import java.text.SimpleDateFormat;


import org.apache.log4j.Logger;

/**
 * ADD EXIT TO DEPOSIT AND WITHDRAW
 *
 */
public class MainDriver {
	// Add log4j
	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}

	static Logger log = Logger.getLogger(MainDriver.class.getName());

	public static ConnFactory cf = ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();

	public static void main(String[] args) {
		// Configure log4j to print to console.
		// Comment out to not print to console.
		// BasicConfigurator.configure();

		log.info("In main(): \n");

		/*
		 * try { Statement stm = conn.createStatement(); ResultSet result =
		 * stm.executeQuery("SELECT * FROM USERS");
		 * 
		 * while(result.next()) { System.out.println("USER_ID: " +
		 * result.getString("USER_ID")); } result.close(); stm.close(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		int topMenuScan;

		boolean topMenuControl;
		boolean topMenuControl1;
		boolean topMenuControl2;

		// TOP MENU
		topMenuControl = true;

		while (topMenuControl == true) {
			log.info("Inside TOP Menu while loop");
			System.out.println("BANK MENU");
			System.out.println("\n1 Register\n2 Login\n\n0 Exit\n");
			System.out.println("Enter number to continue: ");
			Scanner scan = new Scanner(System.in);
			topMenuScan = 0;
			topMenuScan = scan.nextInt();
			log.info("topMenuScan == " + topMenuScan);

			// EXIT PROGRAM
			if (topMenuScan == 0) {
				log.info("Inside topMenuScan == 0");
				System.out.println("Thank You. Goodbye. EXITING PROGRAM.");
				topMenuControl = false;
			}
			// REGISTRATION
			else if (topMenuScan == 1) {
				log.info("Inside topMenuScan == 1");
				topMenuControl1 = true;
				while (topMenuControl1 == true) {
					log.info("Inside topMenuControl1");
					System.out.println("REGISTER PAGE");
					System.out.println("Enter EXIT to go back.");
					// REGISTRATION PROCESS
					Users u = new Users();

					System.out.println("Username: ");
					String userNam = scan.next();

					// Check if exit

					if (userNam.equalsIgnoreCase("exit")) {
						break;
					}

					// Check username
					boolean userNameExists;
					userNameExists = u.CheckUsername(userNam);

					// If username exists, ask for new username. Go back to topMenuControl1.
					if (userNameExists == true) {
						System.out.println("Username " + userNam + " exists. Please enter a new username.");
						continue;
					}
					// If username doesn't exist, Registration Process Continues.
					else {
						System.out.println("Username " + userNam + " is avaialable. ");

						// Continue User Registration
						u.CreateUsers(userNam);
						// Exit while loop topMenuControl1
						topMenuControl1 = false;
					}

				}
				// After Registration Process, go to TOP MENU
				System.out.println("Registration Complete. Returning to BANK MENU.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			// LOGIN
			else if (topMenuScan == 2) {
				log.info("Inside topMenuScan == 2");
				System.out.println("LOGIN PAGE");
				topMenuControl2 = true;
				while (topMenuControl2 == true) {
					log.info("Inside topMenuControl2");

					// LOGIN PROCESS
					Users u = new Users();
					System.out.println("Enter EXIT to return");

					// CHECK USERNAME AND PASSWORD
					System.out.println("Username: ");
					String userNL = scan.next();

					// Check if EXIT
					if (userNL.equalsIgnoreCase("exit")) {
						break;
					}

					System.out.println("Username: " + userNL);

					System.out.println("Password: ");
					String userPL = scan.next();

					// Check if EXIT
					if (userPL.equalsIgnoreCase("exit")) {
						break;
					}
					System.out.println("Password: " + userPL);

					boolean userNamePassExists;
					userNamePassExists = u.CheckUsernameAndPass(userNL, userPL);

					// If username and doesn't exist, re-enter info.
					if (userNamePassExists == false) {
						continue;
					}
					// If username and pass exists, show LOGIN_TRUE MENU
					// LOGIN_TRUE MENU:
					else {
						int userid_BOP;
						// System.out.println("userNl: " + userNL + "\nuserPL: " + userPL);
						userid_BOP = u.GetUserID(userNL, userPL);

						// Set fields of User u.
						u.SetUser(userid_BOP);

						// Check if User status is open or closed
						// System.out.println("USER STATUS: " + u.userstatusid);
						if (u.userstatusid == 2) {
							// If USER is closed, exit
							System.out.println("USER is not active.");
							break;
						}
						
						// IF CUSTOMER
						if(u.usertypeid == 2) {
							// View Customer Menu
							
							// 1. CREATE ACCOUNT
							// 2. VIEW ACCOUNT
							// 3. DELETE ACCOUNT
							// 4. DEPOSIT
							// 5. WITHDRAW
							// 6. TRANSFER
							// 7. LOGOUT
							boolean bankOptions = true;
							
							while (bankOptions == true) {
								// System.out.println("User ID: " + userid_BOP );

								System.out.println("\n\n\nWelcome, " + u.fname + " " + u.lname);

								System.out.println("BANK OPTIONS PAGE:");
								System.out.println("1. CREATE ACCOUNT");
								System.out.println("2. VIEW ACCOUNT");
								System.out.println("3. DELETE ACCOUNT");
								System.out.println("4. DEPOSIT");
								System.out.println("5. WITHDRAW");
								System.out.println("6. LOGOUT");
								System.out.println("Enter number: ");
								int options = scan.nextInt();
								System.out.println("Selected: " + options);

								Accounts a = new Accounts();

								// 1. CREATE ACCOUNT
								if (options == 1) {
									// System.out.println("u.userid: " + u.userid);
									a.CreateAccount(u.userid);
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								// 2. VIEW ACCOUNT
								else if (options == 2) {
									boolean accountCont = true;
									a.SetAccount(u.userid);

									a.ViewAccount();

									while (accountCont == true) {

										System.out.println("Enter 0 to return to BANK OPTIONS MENU");
										System.out.print("Enter number: ");
										Scanner scanAccountCont = new Scanner(System.in);
										int scanAccountInt = scanAccountCont.nextInt();

										if (scanAccountInt == 0) {
											try {
												System.out.println("Returning to BANK OPTIONS MENU.");
												Thread.sleep(2000);
												accountCont = false;

											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										} else {
											System.out.println("Enter 0 to return to BANK OPTIONS MENU");
										}
									}

								}
								// 3. DELETE ACCOUNT
								else if (options == 3) {

									boolean delAccBool = true;

									while (delAccBool == true) {
										a.SetAccount(u.userid);

										a.ViewAccount();

										int accountNumDel = 1234;
										System.out.println("Enter 0 to exit.");
										System.out.print("Enter account number to delete:");

										Scanner scanAccDel = new Scanner(System.in);

										accountNumDel = scanAccDel.nextInt();

										System.out.println("Account Number to delete: " + accountNumDel);

										if (accountNumDel == 0) {
											System.out.println("Exiting.");
											delAccBool = false;
										} else {
											// Check if account exists and balance is 0 and then delete.
											a.SetAccount(u.userid);

											boolean accNumExists = false;
											int accNumExistsAt = -1;

											for (int i = 0; i < a.accountid.size(); i++) {
												if (a.accountid.get(i).equals(accountNumDel)) {
													accNumExists = true;
													accNumExistsAt = i;
												}
											}

											// If account number exists and has a balance of 0, delete.
											if (accNumExists == true && a.accountbalance.get(accNumExistsAt).equals(0.0)) {
												a.DeleteAccount(accountNumDel, u.userid);
												a.SetAccount(u.userid);
												a.ViewAccount();
												delAccBool = false;
											} else {
												System.out.println("Account must have a 0 balance to delete.");
												try {
													Thread.sleep(3000);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
										}
									}

									try {
										System.out.println("Returning to BANK OPTIONS MENU.");
										Thread.sleep(3000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								// 4. DEPOSIT
								else if (options == 4) {

									boolean depControl = true;

									while (depControl == true) {

										a.SetAccount(u.userid);
										a.ViewAccount();
										System.out.println("Enter amount to deposit: ");
										Scanner scanDep = new Scanner(System.in);
										double dep = 0.00;
										// To Do: Will include check to make sure input does not include non numbers.
										dep = scanDep.nextDouble();
										System.out.println("Deposit Amount Entered: " + dep);

										if (dep <= 0 || dep > 5000) {
											System.out.println(
													"Deposit must be greater than 0 and must be less than or equal to 5000.");

											try {
												Thread.sleep(3000);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											continue;
										}
										System.out.println("Enter account number to deposit to.");

										int accountNum = 0;
										Scanner scanAcc = new Scanner(System.in);
										accountNum = scanAcc.nextInt();
										System.out.println("Account Number Entered: " + accountNum);

										boolean accNumExists = false;

										a.SetAccount(u.userid);

										for (int i = 0; i < a.accountid.size(); i++) {
											if (a.accountid.get(i).equals(accountNum)) {
												accNumExists = true;
												System.out.println("Account number exists.");
											}
										}

										// If account number exists, deposit
										if (accNumExists == true) {
											System.out.println("Begin deposit.");
											a.Deposit(accountNum, u.userid, dep);
											a.SetAccount(u.userid);
											a.ViewAccount();
											depControl = false;
										} else {
											System.out.println("Account doesn't exist.");

											try {
												Thread.sleep(3000);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}

									try {
										System.out.println("Returning to BANK OPTIONS MENU.");
										Thread.sleep(3000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								// 5. WITHDRAW

								else if (options == 5) {

									boolean withControl = true;

									while (withControl == true) {
										a.SetAccount(u.userid);
										a.ViewAccount();
										System.out.println("Enter amount to withdraw: ");
										Scanner scanWith = new Scanner(System.in);
										double with = 0.00;
										with = scanWith.nextDouble();
										System.out.println("Withdrawal Amount Entered: " + with);

										if (with <= 0 || with > 500) {
											System.out.println(
													"Withdrawal must be greater than 0 and must be less than equal to 500.");

											try {
												Thread.sleep(3000);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											continue;
										}
										System.out.println("Enter account number to withdraw from.");

										int accountNum = 0;
										Scanner scanAcc = new Scanner(System.in);
										accountNum = scanAcc.nextInt();
										System.out.println("Account Number Entered: " + accountNum);

										boolean accNumExists = false;

										a.SetAccount(u.userid);

										for (int i = 0; i < a.accountid.size(); i++) {
											if (a.accountid.get(i).equals(accountNum)) {
												accNumExists = true;
												System.out.println("Account number exists.");
											}
										}

										// If account number exists, withdraw
										if (accNumExists == true) {
											System.out.println("Begin withdrawal.");
											a.Withdraw(accountNum, u.userid, with);
											a.SetAccount(u.userid);
											a.ViewAccount();
											withControl = false;
										} else {
											System.out.println("Account doesn't exist.");

											try {
												Thread.sleep(3000);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}

									try {
										System.out.println("Returning to BANK OPTIONS MENU.");
										Thread.sleep(3000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else if (options == 6) {
									// 6. LOGOUT
									System.out.println("Thank You. Goodbye. EXITING BANK OPTIONS PAGE.");
									bankOptions = false;
								} else {
									// INVALID CHOICE
									// If user does not choose any
									System.out.println("Please enter a valid number. Returning to BANK OPTIONS PAGE.");

									// Wait 3 seconds before going back to BANK OPTIONS PAGE
									try {
										Thread.sleep(2000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						} // end if of USER
						// IF SUPERUSER
						else if(u.usertypeid == 1){
							
							
							boolean superUserCont = true;
							
							while(superUserCont == true) {
								// View Superuser Menu
								System.out.println("SUPERUSER: " + u.username + " " + u.fname);
								
								// 1 View Account
								// 2 Create Account
								// 3 Update Account
								// 4 Delete Account
								// 5 Delete User
								// 0 Exit
								
								System.out.println("1 View Account\n2 Create Account\n3 Update Account\n4 Delete Account\n5 Delete User\n\n0 Logout");
								
								int superUserInt = 0;
								
								Scanner scanSuperUserOption = new Scanner(System.in);
								System.out.print("Enter number: ");
								superUserInt = scanSuperUserOption.nextInt();
								
								// 0 Exit
								if(superUserInt == 0) {
									// Logout
									System.out.println("Logging out. Goodbye. Thank you.");

									// Wait 2 seconds before going back to BANK OPTIONS PAGE
									try {
										Thread.sleep(1000);
										superUserCont = false;
										
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								// 1 View Account
								else if(superUserInt == 1) {
									Scanner scanSU1 = new Scanner(System.in);
									
									// View All Users Using First Name and Last Name
									System.out.println("Enter User Information.");
									
									String sUFName;
									String sULName;
									
									System.out.print("First Name: ");
									sUFName = scanSU1.next();
									System.out.println("First Name: " + sUFName);
									
									System.out.println("Last Name: ");
									sULName = scanSU1.next();
									System.out.println("Last Name: " + sULName);
									
									// Find user using first name and last name
									u.FindUser(sUFName, sULName);
									
									try {
										Thread.sleep(2000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									
									// After finding User ID, enter userID to view accounts of user
									
									// Enter UserID
									System.out.print("Enter User ID: ");
									
									int scanIntSU1 = scanSU1.nextInt();
									
									// New Account
									Accounts superUserAcc = new Accounts();
									// Set User
									superUserAcc.SetAccount(scanIntSU1);
									// View Accounts of User
									superUserAcc.ViewAccount();
									
									
								}
								// 2 Create Account
								else if(superUserInt == 2) {
									Users uSuper = new Users();
									
									Scanner scanSCU = new Scanner(System.in);
									
									System.out.println("Create User.");
									System.out.println("Enter Username: ");
									String usernSCU = scanSCU.next();
									System.out.println("Username entered: " + usernSCU);
									
									
									// Check username
									boolean userNameExists;
									userNameExists = uSuper.CheckUsername(usernSCU);

									// If username exists, ask for new username. Go back to topMenuControl1.
									if (userNameExists == true) {
										System.out.println("Username " + usernSCU + " exists. Please enter a new username.");
										continue;
									}
									// If username doesn't exist, Registration Process Continues.
									else {
										System.out.println("Username " + usernSCU + " is avaialable. ");

										// Continue User Registration
										uSuper.CreateUsers(usernSCU);
										// Exit while loop topMenuControl1
										topMenuControl1 = false;
									}
									
									
									System.out.println("User created.");
									
								}
								// 3 Update Account
								else if(superUserInt == 3) {
									System.out.println("This will feature will be implented soon.");
								}
								// 4 Delete Account
								else if(superUserInt == 4) {
									Users uSuper3 = new Users();
									Accounts accSuper3 = new Accounts();
									int accountNumber;
									int userID;
									Scanner scanSU3 = new Scanner(System.in);
									
									
									System.out.println("Enter Account Number and UserID to Delete.");
									System.out.println("Account Number: ");
									accountNumber = scanSU3.nextInt();
									System.out.println("Account Number Entered: " + accountNumber);
									
									
									System.out.println("User ID: ");
									userID = scanSU3.nextInt();
									System.out.println("User ID Entered: " + userID);
									
									
									accSuper3.DeleteAccount(accountNumber, userID);
								}
								// 5 Delete User
								else if(superUserInt == 5) {
									Users sU5 = new Users();
									Scanner scanSU5 = new Scanner(System.in);
									int userIDSU5;
									
									System.out.println("Enter User ID to delete.");
									userIDSU5 = scanSU5.nextInt();
									System.out.println("User ID entered: " + userIDSU5);
									
									sU5.DeleteUser(userIDSU5);
									
								}
								else {
									System.out.println("Number entered is invalid.");
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
								
								// End, return to menu
								try {
									System.out.println("Returning to Menu.");
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}
							
							
							
							
							
							
							
							System.out.println();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} // end else of superuser
						// IF NOT USER AND NOT SUPERUSER, USER TYPE IS UNKNOWN
						else {
							System.out.println("User Type Unknown.");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						// Exit while loop TopMenuControl2
						topMenuControl2 = false;
					}

				}

				// After Login Process, go to TOP MENU
				System.out.println("Returning to BANK MENU.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			// INVALID CHOICE
			else {
				log.info("Inside topMenuScan == invalid option");
				System.out.println("Please enter a valid number. Returning to BANK MENU.");

				// Wait 5 seconds before going back to TOP MENU
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

		log.info("Outside the TOP MENU");

		/* Close Connection conn */
		try {
			log.info("Closing Connection conn");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
