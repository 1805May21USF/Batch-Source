package com.revature.P0Banking;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;


public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double balance;
	private String name;
	private UUID uniqueId = UUID.randomUUID();
	private final String id;

	public Account(String name) {
		this.balance = 0.00;
		this.name = name;
		//cool id and logger to see when a new account has been created!
		this.id = Long.toString(uniqueId.getLeastSignificantBits()).substring(0, 10);
		App.log.info(name+id+" has been created.");
		
	}
	
	/*
	 * Name: promptAccountActions
	 * Input:ArrayList<Partner> newAccts, String currentUser
	 * Output:ArrayList<Partner>
	 * Description: Public access method that gives a user options when accessing their bank account
	 */
	public ArrayList<Partner> promptAccountActions(String currentUser, ArrayList<Partner> newAccts) throws SecurityException, IOException{
		int pick = -1;
		while(pick != 5){
			try {
					System.out.println("What action would you like to take:\n1)View Balance\n2)Withdraw\n3)Deposit\n4)Transfer\n5)Go back");
					pick = App.sc.nextInt();
					App.sc.nextLine();
					if(pick > 5 || pick < 1) {
						throw new BadInputException();
					}
					switch(pick) {
						case 1:
							this.viewBalance();
							break;
						case 2:
							System.out.print("Withdraw amount: ");
							double amountWithdraw = App.sc.nextDouble();
							this.withdraw(amountWithdraw);
							break;
						case 3:
							System.out.print("Deposit amount: ");
							double amountDeposit = App.sc.nextDouble();
							this.deposit(amountDeposit);
							break;
						case 4:
							System.out.print("Username of account to transfer to: ");
							String user = App.sc.nextLine();
							if(user.equals(currentUser)) {
								System.out.print("Cannot transfer to own account. ");
								throw new BadInputException();
							}else {
								newAccts = this.transfer(user, newAccts);
							}
							break;
					}
				}catch(ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}catch(BadInputException d) {
					continue;
				}
		}
		//Breaks out of Customer
		return newAccts;
	}
	
	/*
	 * Name: viewBalance
	 * Input:None
	 * Output:None
	 * Description: Private access method that views balance on account only for specific account instance
	 */
	private void viewBalance() {
		System.out.print(this.getName()+this.getId()+" has: $");
		System.out.printf("%.2f\n",this.getBalance());
	}
	
	/*
	 * Name: withdraw
	 * Input:double amount
	 * Output:None
	 * Description: Public account method that allows user to withdraw money from account instance
	 */
	public void withdraw(double amount) throws BadInputException{
		if(amount>this.getBalance()) {
			System.out.println("\nThe amount exceeded what you have.");
			throw new BadInputException();
		}
		else if(amount < 0) {throw new BadInputException();}
		else {
			this.setBalance(this.getBalance()-amount);
			String money = String.format("%.2f", amount);
			App.log.info(this.name+this.id+" withdrew: $"+money);
		}
	}
	
	/*
	 * Name: deposit
	 * Input:double amount
	 * Output:None
	 * Description: Public account method that allows user to deposit money to account instance
	 */
	public void deposit(double amount) throws BadInputException{
		//deposit yo money
		this.setBalance(this.getBalance()+amount);
		String money = String.format("%.2f", amount);
		App.log.info(this.name+this.id+" deposited: $"+money);
	}
	
	/*
	 * Name: transfer
	 * Input:String user, ArrayList<Partner> accts
	 * Output:ArrayList<Partner>
	 * Description: Public account method that allows user to transfer money between accounts to another unique username.
	 */
	public ArrayList<Partner> transfer(String user, ArrayList<Partner> accts) throws BadInputException,IOException,ClassNotFoundException{
		ArrayList<?> getFileAccts = User.readFromFile();
		Partner transferAcct = User.returnUserNameMatch(user, getFileAccts);
		for(int i = 0; i < accts.size(); i++) {
			if(accts.get(i).getUsername().equals(user)) {accts.remove(i);}
		}
		if(transferAcct == null) {
			System.out.print("No account with those credentials. ");
			throw new BadInputException();
		}
		System.out.println("Select an account to transfer to: ");
		if(transferAcct instanceof Customer) {
			ArrayList<Account> listAccts = ((Customer) transferAcct).getAccounts();
			((Customer) transferAcct).printListOfAccounts(listAccts);
			int pick = App.sc.nextInt();
			if(pick-1 > listAccts.size() || pick < 0) {
				throw new BadInputException();
			}
			Account transferMoney = ((Customer) transferAcct).getAccounts().get(pick-1);
			if(transferMoney.getId().equals(this.id)) {
				System.out.println("Can't transfer to same account");
				throw new BadInputException();
			}
			System.out.print("Transfer amount: ");
			double amountTransfer = App.sc.nextDouble();
			this.withdraw(amountTransfer);
			((Customer) transferAcct).getAccounts().get(pick-1).deposit(amountTransfer);
			String money = String.format("%.2f", amountTransfer);
			App.log.info(this.name+this.id+" transferred: $"+money+" to "+transferAcct.getUsername());
			accts.add(transferAcct);
		}
		return accts;
	}

	/*
	 * Getters and Setters
	 */
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}




	
	
	
}
