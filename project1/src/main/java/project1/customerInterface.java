package project1;

import java.util.ArrayList;

public class customerInterface {
	Account account;
	DoSerialization DS = new DoSerialization();
	ArrayList<Customer> arrList = new ArrayList();;
	Customer customer;
	
	public customerInterface(Customer customer) {
		// TODO Auto-generated constructor stub
		this.account = new Account();
		this.arrList = account.accountList;
		this.customer = customer;
	}
	
	public void createJointAccount(String userName){
		
	}
	
	public int withdraw(String userName, int amount){
		int number = customer.getAccountBalance() - amount;
		return number;
	}
	
	public int deposit(String accountNumber, int amount){
		int number = customer.getAccountBalance() + amount;
		return number;
	}
	
	public int transfer(Customer c2, int amount){
		//Account newAccount = new Account(accountNumber);
		int newCustomerBalance = c2.getAccountBalance() + amount;
		return newCustomerBalance;
	}
}