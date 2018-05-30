package project1;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
	private int accountBalance;
	private String accountNumber;
	ArrayList<Customer> accountList;
	
	public Account() {
		// TODO Auto-generated constructor stub
		this.accountList = new ArrayList<>();
	}

	public Account(String accountNumber) {
		// TODO Auto-generated constructor stub
		this.accountList = new ArrayList<>();
	}
	
//	public Account(String userName) {
//		// TODO Auto-generated constructor stub
//		this.accountList = new ArrayList<>();
//	}
	
	public void createCustomerAccount(Customer customer) {
		accountList.add(customer);
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public boolean isEmpty(){
		if(this.accountNumber.isEmpty())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Account [accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + ", accounts="
				+ accountList + "]";
	}
}
