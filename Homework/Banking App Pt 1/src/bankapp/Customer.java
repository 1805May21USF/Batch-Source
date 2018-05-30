package bankapp;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Customer implements Serializable {
	public String firstName;
	public String lastName;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String phoneNumber;
	public String email;
	public String username;
	//public boolean accountActive;
	public String accessLevel;
	//bankEmployee
	//bankAdmin
	//customer
	
	public boolean jointAcc;
	public String secondJointAccUsername;
	
	public void CreateCustomer(String user) {
		BankAppDriver.log.info("Begin Customer Creation: ");
		
		username = user;
		
		// Will replace and ask for accessLevelCode, which will replace accessLevel to either bankAdmin or bankEmployee for special account
		accessLevel = "customer";
		
		// Ask user to enter information
		Scanner scan = new Scanner(System.in);
		System.out.println("Registration. Please enter information.");
		System.out.print("First Name: ");
		firstName = scan.next();
		System.out.print("Last Name: ");
		lastName = scan.next();
		System.out.print("Address 1: ");
		address1 = scan.next();
		System.out.print("Address 2: ");
		address2 = scan.next();
		scan.nextLine();
		System.out.print("City: ");
		city = scan.nextLine();
		System.out.print("State: ");
		state = scan.nextLine();
		System.out.print("Phone Number: ");
		phoneNumber = scan.nextLine();
		System.out.print("E-mail: ");
		email = scan.next();
		
		
		
		
		BankAppDriver.log.info("CreateCustomer(): ");
		BankAppDriver.log.info("username: " + username);
		BankAppDriver.log.info("firstName: " + firstName);
		BankAppDriver.log.info("lastName: " + lastName);
		BankAppDriver.log.info("address1: " + address1 ); 
		BankAppDriver.log.info("address2: " + address2);
		BankAppDriver.log.info("city: " + city);
		BankAppDriver.log.info("state: " + state);
		BankAppDriver.log.info("phoneNumber: " + phoneNumber);
		BankAppDriver.log.info("email: " + email);
		BankAppDriver.log.info("accessLve: " + accessLevel);
		BankAppDriver.log.info("End Customer Creation \n");
		
	}
	
	
	// Move serialization method from BankAppDriver to here
	public void CustSerialization() {
		
	}
	
	
	public void CustDeserialization(){
		// Replace this with customer deserialization from BankAppDriver class
	}

	
}
