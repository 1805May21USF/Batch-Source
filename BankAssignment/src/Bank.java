
public class Bank {

	private Account [] accounts = new Account[30];
	private int accountCounter=0;
	
	public long createAccount(double openingBalance) {
		if(openingBalance >= 50) {
			if(accountCounter < accounts.length) {
				accounts[accountCounter]=new Account();
				accounts[accountCounter].setBalance(openingBalance);
				accountCounter++;
				return accounts[accountCounter].getAccountNumber();
			}
			
		}
		return 0;
	}

public int deposit (long accountNumber, double amount) {
	int status=0;
	if(amount > 0) {
	for (int i=0;i<accountCounter;i++) {
		
		if(accountNumber == accounts[i].getAccountNumber()){
			
			accounts[i].setBalance(accounts[i].getBalance()+amount);
			status = 1;
		}
	}
	}
	return status;
}

public int withdraw(long accountNumber, double amount) {
	int status=0;
	if(amount > 0) {
	
		for (int i=0;i<accountCounter;i++) {
		
		if(accountNumber == accounts[i].getAccountNumber()){
			
			if(accounts[i].getBalance()>=amount) {
			accounts[i].setBalance(accounts[i].getBalance()-amount);
			status = 1;
		}
	}
	
	
}
}
	return status;
}


public double getBalance(long accountNumber) {
for (int i=0;i<accountCounter;i++) {
		
		if(accountNumber == accounts[i].getAccountNumber()){
			
			return accounts[i].getBalance();
		}
}
return -1;
}
}