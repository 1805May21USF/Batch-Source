package bankapp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.*;

public class BankAppDriver {
	
	// Add log4j
	
	static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
	
	static Logger log = Logger.getLogger(BankAppDriver.class.getName());
	
	public static void main(String[] args){
		// Configure log4j to print to console.
		// Comment out to not print to console.
		//BasicConfigurator.configure();
		
		String usernameM = "";
		
		
		// Initialize bools
		boolean accountExists = false;
		boolean jointAccount = false;
		
		
		
		// Create objects
		Customer c = new Customer();
		Customer d = new Customer();
		Account a = new Account();
		BankAdmin ba = new BankAdmin();
		BankEmployee be = new BankEmployee();
		
		
		// Will replace with Scanner 
		// Option to login or register
		
		// Customer 1: Replace and ask for username with Scanner.
		
		
		// Ask for username
		// Check if account exists.
				//File f = new File(filePathString);
				//if(f.exists() && !f.isDirectory()) { 
				//    // do something
				//}
		// If account exists, set accountExists to true.
		// If account does not exist, set accountExists to false.
		
		Scanner scanMain = new Scanner(System.in);
		
		System.out.println("Select option.\n1. Register\n2. Login");
		
		int topMenu = scanMain.nextInt();
		
		if(topMenu == 1) {
			// Register User
		
			int controlTopMenu = 1;
			
			while(controlTopMenu == 1) {
				// Ask for you username
				System.out.print("Create a username.\nUsername: ");
				usernameM = scanMain.next();
				
				// Check if username exists. If exists: go back to menu. If not exists, create user.
				File f = new File("bankcust/customer/cust" + usernameM + ".ser");
				// If file exists, 
				if(f.exists() && !f.isDirectory()) {
					accountExists = true;
					System.out.println("Username exists. Please enter a enter a new username.");
				}
				else {
					// If file does not exist, create user.
					
					// Create Customer
					c.CreateCustomer(usernameM);
					SerializeCustomer(c);
					log.info("c.username created: " + c.username + "\n");
					
					// Create Account
					a.WriteAccount(c.username);
					// View Customer Info by Logging In With Username
					c = DeserializeCustomer(c, c.username);
					a.ViewBalance(a, c.username);
					
					
					// Does customer want to apply for a joint checking?
					// If true, set jointAccount = true. 
					// If false, set jointAccount = false.
					// Then, create another customer 
					// Need to add joint variable that connects both accounts
					log.info("jointAccount = " + jointAccount);
					
					System.out.println("Would you like to apply for a joint account? Enter 1 for yes. Enter 2 for no.");
					Scanner scanJA = new Scanner(System.in);
					int choiceJointAcc = scanJA.nextInt();
					
					// Set joint account
					if(choiceJointAcc == 1) {
						jointAccount = true;
					}
					else {
						jointAccount = false;
					}
					
					
					if(jointAccount == true) {
						// Ask for Customer 2's username
						
						int controlJointAccount = 1;
						while(controlJointAccount == 1) {
							System.out.println("Create username.\nUsername:");
							usernameM = scanMain.next();
							
							File g = new File("bankcust/customer/cust" + usernameM + ".ser");
							// If file exists, 
							if(g.exists() && !g.isDirectory()) {
								accountExists = true;
								System.out.println("Username exists. Please enter a enter a new username.");
							}
							else {
								d.CreateCustomer(usernameM);
								
								// Set Customer's bool jointAcc = true and set Customer 2's username into Customer 1's info and write to file.
								c.jointAcc = true;
								c.secondJointAccUsername = usernameM;
								SerializeCustomer(c);
								
								// Set Customer's bool jointAcc to true and set Customer 1's username into Customer 2's info and write to file.
								d.jointAcc = true;
								d.secondJointAccUsername = c.username;
								SerializeCustomer(d);
								
								log.info("d.username created: " + d.username);
								
								// Create Account
								a.WriteAccount(d.username);	
								d = DeserializeCustomer(d, d.username);
								
								a.ViewBalance(a, d.username);
								
								// Exit creating user
								controlJointAccount = 0;
								
								
							} // end else						
						} // end while control	
						
					} // end if joint account == true
					else {
						c.jointAcc = false;
						break;
					}
					
					// Registration complete. Exit registration.
					controlTopMenu = 0;
				} // end else, if file does not exist, else -> create user
				
			}// end while controlTopMenu create username
			
		} // end top Menu register or login
		else if(topMenu == 2) {
			// Login User
			
			// Ask for you username
			// Check if username exists. If exists: view menu options to view balance, deposit, withdraw, transfer if (joint)
			
			// If Customer is Registered, View Customer Information By Login Username
			
			
			
			int controlTopMenu = 1;
			
			while(controlTopMenu == 1) {
				// Ask for you username
				System.out.print("Enter Username: ");
				usernameM = scanMain.next();
				System.out.print("Username: " + usernameM);
				// Check if username exists. If exists, show login menu.
				File f = new File("bankcust/customer/cust" + usernameM + ".ser");
				// If file exists, view menu option
				if(f.exists() && !f.isDirectory()) {
					accountExists = true;
					System.out.println("Username exists. ");
					
					
					// View Menu Option for user logging in that exists
					
					log.info("Username: " + usernameM);
					log.info("access level: " + c.accessLevel);
					
					
					c = DeserializeCustomer(c, usernameM);

					// If customer, view customer options	
					if(c.accessLevel.equals("customer")) {
						
						// Ask customer what action they would like to take:
						// 1. View Balance
						// 2. Deposit 
						// 3. Withdraw
						// 4. Exit
						

						int controlMenuCustExists = 1;
						
						while(controlMenuCustExists == 1) {
							
							int custMenu = 0;
							
							
							Scanner scanMenuCustExists = new Scanner(System.in);
							System.out.println("\n\nWhat would you like to do?"); 
							System.out.println("1. View Balance");
							System.out.println("\n2. Deposit");
							System.out.println("\n3. Withdraw");
							if(c.jointAcc == true) {
								System.out.println("\n4. Transfer");
							}
							System.out.println("\n9. Exit");
							System.out.println("Please enter a number: ");
							
							
							custMenu = scanMenuCustExists.nextInt();
							
							if(custMenu == 1) {
								// View Customer's Account Info
								a.ViewBalance(a, usernameM);
								
								System.out.println("Enter 1 to view menu. Enter 2 to exit.");
								custMenu = scanMenuCustExists.nextInt();
								if(custMenu == 1) {
									continue;
								}
								else {
									System.out.println("Exiting.");
									
									break;
								}
								
							}
							else if(custMenu == 2) {
								
								System.out.println("Enter amount to deposit. Use 00.00 format.\n");
								double dep = scanMenuCustExists.nextDouble();
										
								a.Deposit(dep, usernameM);
								a.ViewBalance(a, usernameM);
								System.out.println("Enter 1 to view menu. Enter 2 to exit.");
								
								custMenu = scanMenuCustExists.nextInt();
								if(custMenu == 1) {
									continue;
								}
								else {
									System.out.println("Exiting.");
									
									break;
								}
							}
							// Withdraw Money From Account
							else if(custMenu == 3) {
								
								System.out.println("Enter amount to withdraw. Use 00.00 format.\n");
								double with = scanMenuCustExists.nextDouble();
								a.Withdraw(with, usernameM);
								a.ViewBalance(a, usernameM);
								
								System.out.println("Enter 1 to view menu. Enter 2 to exit.");
								custMenu = scanMenuCustExists.nextInt();
								if(custMenu == 1) {
									
									continue;
								}
								else {
									System.out.println("Exiting.");
									
									break;
								}
							}
							else if(custMenu == 4) {
								// Transfer Money Into Joint Account if joint account exists
								
								
								
								int scanJointControl = 1;
								while(scanJointControl == 1) {
									
									System.out.println("Enter 1 to transfer into account from joint account.");
									System.out.println("Enter 2 to transfer into joint account from current account.");
									Scanner scanJoint = new Scanner(System.in);
									int scanJointInt = scanJoint.nextInt();
									
									if(scanJointInt == 1) {
										a.transferIntoAcc = true; 
										scanJointControl = 0;
										break;
									}
									else if(scanJointInt == 2){
										a.transferIntoAcc = false;
										scanJointControl = 0;
										
										break;
									}
									else {
										System.out.println("Please reenter option.");
									}
								}
								
								System.out.println("Enter amount to transfer. Use 00.00 format.\n");
								double transf = scanMenuCustExists.nextDouble();
								a.Transfer(transf, c);
								a.ViewBalance(a, usernameM); //usernameM ex: jtumma1
								//a.ViewBalance(a, "ktumma1"); Example of second account for joint users
								
								System.out.println("Enter 1 to view menu. Enter 2 to exit.");
								custMenu = scanMenuCustExists.nextInt();
								if(custMenu == 1) {
									continue;
								}
								else {
									System.out.println("Exiting.");
									break;
								}
								
							}
							else if(custMenu == 9) {
								System.out.println("Exiting program");
								break;
								
							}
							else {
								System.out.println("Please select an option.");
								System.out.println("Enter 1 to view menu. Enter 2 to exit.");
								custMenu = scanMenuCustExists.nextInt();
								if(custMenu == 1) {
									continue;
								}
								else {
									System.out.println("Exiting.");
									break;
								}
								
							}
							
						} // end while controlMenuCustExists
						

						
						
						
					}
					// If Bank Employee, view bank employee options
					else if(c.accessLevel.equals("bankEmployee")) {
						
					}
					// If Bank Admin, view bank admin options
					else if(c.accessLevel.equals("bankAdmin")) {
						
					}
					// access level is not customer, banke employee or bank admin
					else {
						System.out.println("Access Level required.");
					}
					controlTopMenu = 0;
				} // end top if file with username exists while
				else {
					// If file does not exist, go back to top menu
					System.out.println("Username does not exist.");
				} // end  else
			}// end control  
		} // end top else if register or (login)
		scanMain.close();
		
	} // end main
		
		
		
			
			
			
			
		
	
	
	// Move this to Customer class
	public static void SerializeCustomer(Customer cParamS) {
		// Serialize
		log.info("Begin Serialization - SerializeCustomer(): ");
		
		try{
			// Make accounts directory if doesn't exist.
			File directory = new File("bankcust/customer/");
			directory.mkdir();
			
			// Create customer.ser file and serialize
			FileOutputStream fileOut = new FileOutputStream("bankcust/customer/cust" + cParamS.username + ".ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			
			outStream.writeObject(cParamS);
			
			
			log.info("Check Object Written To .ser File - cParamS: ");
			log.info("username: " + cParamS.username);
			log.info("firstName: " + cParamS.firstName);
			log.info("lastName: " + cParamS.lastName);
			log.info("address1: " + cParamS.address1 ); 
			log.info("address2: " + cParamS.address2);
			log.info("city: " + cParamS.city);
			log.info("state: " + cParamS.state);
			log.info("phoneNumber: " + cParamS.phoneNumber);
			log.info("email: " + cParamS.email);
			log.info("accessLevel: " + cParamS.accessLevel);
		if(cParamS.secondJointAccUsername != null) {
				log.info("secondJointAccUsername: " + cParamS.secondJointAccUsername);
			}
			
			
			
			
			outStream.close();
			fileOut.close();
			
			
			log.info("End Serialization - SerializeCustomer() \n");
			
			System.out.println("\nSerialized data is saved in bankcust/customer/cust" + cParamS.username + ".ser\n");
		} catch(IOException i){
			BankAppDriver.log.info("IOException i: " + i.toString());
		}
		
	}
	
	// Move this to Customer Class
	public static Customer DeserializeCustomer(Customer cParamD, String userNam) {

		//Deserialize
		
		log.info("Begin Deserialization - DeserializeCustomer(): ");
		
		// Makes c reference null to load data from file into c.
		log.info("Customer reference is set to null. c = (cParamD = null)");
		cParamD = null;
		
		try {
			
			FileInputStream fileIn = new FileInputStream("bankcust/customer/cust" + userNam + ".ser");
			
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			cParamD = (Customer) inStream.readObject();
			
			
			log.info("Check Object Read From .ser File - cParamD: ");
			log.info("username: " + cParamD.username);
			log.info("firstName: " + cParamD.firstName);
			log.info("lastName: " + cParamD.lastName);
			log.info("address1: " + cParamD.address1 ); 
			log.info("address2: " + cParamD.address2);
			log.info("city: " + cParamD.city);
			log.info("state: " + cParamD.state);
			log.info("phoneNumber: " + cParamD.phoneNumber);
			log.info("email: " + cParamD.email);
			log.info("accessLevel: " + cParamD.accessLevel);
			if(cParamD.secondJointAccUsername != null) {
				log.info("secondJointAccUsername: " + cParamD.secondJointAccUsername);
			}
			
			
			inStream.close();
			fileIn.close();
			
			log.info("End Deserialization - DeserializeCustomer() \n");
			
			
			
		} catch(IOException i) {
			i.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Print Customer Information to Console
		System.out.println("Check Object Read From .ser File - cParamD: ");
		System.out.println("username: " + cParamD.username);
		System.out.println("firstName: " + cParamD.firstName);
		System.out.println("lastName: " + cParamD.lastName);
		System.out.println("address1: " + cParamD.address1 ); 
		System.out.println("address2: " + cParamD.address2);
		System.out.println("city: " + cParamD.city);
		System.out.println("state: " + cParamD.state);
		System.out.println("phoneNumber: " + cParamD.phoneNumber);
		System.out.println("email: " + cParamD.email);
		log.info("accessLvel: " + cParamD.accessLevel);
		if(cParamD.secondJointAccUsername != null) {
			System.out.println("secondJointAccUsername: " + cParamD.secondJointAccUsername + "\n");
		}
		
		
		
		
		return cParamD;
		
		/*
		log.info("Deserialized Customer: ");
		log.info("Name: " + cParamD.firstName + " " + cParamD.lastName);
		log.info("Address: " + cParamD.address1 + ", " + cParamD.city + ", " + cParamD.state);
		log.info("Phone Number: " + cParamD.phoneNumber);
		log.info("Email: " + cParamD.email);
		log.info("Username: " + cParamD.username);
		*/
	}

}
