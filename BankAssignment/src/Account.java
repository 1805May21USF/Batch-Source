
public class Account {

	private long accountNumber;
	private double balance;
	static private long accountNumberGenerator=1000;
	
	
	
	public Account() {
		
		accountNumber = ++accountNumberGenerator;
	}
	
	public  long getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}



