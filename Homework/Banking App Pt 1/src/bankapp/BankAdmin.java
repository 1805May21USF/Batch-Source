package bankapp;

import java.util.Scanner;

public class BankAdmin {
	
	Customer c = new Customer();
	Account a = new Account();
	
	String userNam;
	
	// View Customer Accounts
	public void ViewAccount() {
		
		// Set username. Replace with Scanner.
		userNam = "wake";
		
		// Deserialize customer
		BankAppDriver.DeserializeCustomer(c, userNam);
		
		// Deserialize account
		a.ViewBalance(a, userNam);
	}
	
	// Withdraw, Deposit, Transfer From All Accounts
	public void TransactAccount() {
		
		// Create Scanner to choose what type of transaction in while loop
		int transAccControl = 1;
		while(transAccControl == 1) {
			Scanner scan = new Scanner(System.in);
			int scanInt = 0;
			System.out.println("Enter number to select the option below.");
			System.out.println("1. Deposit\n2. Withdraw\n3. Transfer\n4. Exit");
			
			if(scanInt == 1) {
				// Option to Deposit. Replace with Scanner.
				double depAmount = 1.00;
				a.Deposit(depAmount, userNam);
				
			}
			else if(scanInt == 2) {
				// Option to Withdraw. Replace with Scanner.
				double drawAmount = 2.00;
				a.Withdraw(drawAmount, userNam);
				
			}
			else if(scanInt == 3) {
				// Option to Transfer. Replace with Scanner.
				double transAmount = 3.00;
				
			}
			else if(scanInt == 4) {
				System.out.println("Exiting.");
				
			}
			else {
				System.out.println("Please enter number.");
				
			}
			
			
			
			
		}
		
	}
	
	// Cancel Accounts
	public void CancelAccounts() {
		// Create field in customer that shows account cancelled is true or false.
		// Place a check when logging in if account is active to be able to login.
		
		//Uncomment to continue creating CancelAccounts() method. Also uncomment the variable in Customers.
		//c.accountActive = true;
	}
	
	// Approve or Deny Account Application
	public void DecideAccountApplication() {
		// Set account to approve or deny
		
	}
	
	
}
