import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int balance;
	
	public ArrayList<BankPerson> owners = new ArrayList<BankPerson>();

	public boolean approved;
	
	private long accountNumber;
	
	public Account(int balance, int number) {
		balance = 0;
		accountNumber = number;
	}
	
	public Account(BankPerson c, int number) {
		owners.add(c);
		balance = 0;
		approved = false;
		accountNumber = number;

	}
	
	public void addOwner(Customer c) {
		owners.add(c);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(approved)
		balance-=money;
		else {
			System.out.println("Wait until an employee approves an account.");
		}
	}
	
	public void deposit(int money) {
		if(approved)
		balance += money;
		else {
			System.out.println("Wait until an employee approves an account");		}
	}
	
	
	public void approving() {
		approved = true;
	}
	
	public String toString() {
		if(approved) return "This account has " + balance + " dollars, whith an ID of " + accountNumber
				+  "\nand is approved.";
		else 		return "This account has " + balance + " dollars, whith an ID of " + accountNumber 
				+ "\nand is not approved.";

	}
	
	
}
