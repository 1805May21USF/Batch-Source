package bankapp;

public class BankEmployee {
	
	Customer c = new Customer();
	Account a = new Account();
	
	String userNam;
	
	// View (Only, Not Edit) Customer Information and Balance
	public void ViewCustomer() {
		// Set username. Replace with Scanner.
		userNam = "wake";
		
		// Deserialize customer
		BankAppDriver.DeserializeCustomer(c, userNam);
		
		// Deserialize account
		a.ViewBalance(a, userNam);
	}

	// Approve or Deny Account Application
		public void DecideAccountApplication() {
			// Set account to approve or deny
			
		}
}
