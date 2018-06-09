
public  class Account implements AccountManager {
	
	
	private double balance;
	private Account account;
	
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account getAccountType() {
		return account;
	}
	public void setAccountType(Account account) {
		this.account = account;
	}
	
	
	
	
	public void deposit(double d) {
		
		account.setBalance(account.getBalance() + d);
	}
	
	public void withdraw(double w) {
		
		account.setBalance(account.getBalance()+w);
	}
	
	
	
}