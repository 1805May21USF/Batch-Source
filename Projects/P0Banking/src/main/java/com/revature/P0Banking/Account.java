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
	private final long id;

	public Account(String name) {
		this.balance = 0.00;
		this.name = name;
		this.id = uniqueId.getLeastSignificantBits();
	}
	
	public ArrayList<Partner> prompt(String currentUser, ArrayList<Partner> newAccts){
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
							this.view();
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
	
	public void view() {
		System.out.print(this.getName()+this.getId()+" has: $");
		System.out.printf("%.2f\n",this.getBalance());
	}
	
	public void withdraw(double amount) throws BadInputException{
		if(amount>this.getBalance()) {
			System.out.println("\nThe amount exceeded what you have.");
			throw new BadInputException();
		}
		else if(amount < 0) {throw new BadInputException();}
		else {this.setBalance(this.getBalance()-amount);}
	}
	
	public void deposit(double amount) throws BadInputException{
		//deposit yo money
		this.setBalance(this.getBalance()+amount);
	}
	
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
			System.out.print("Transfer amount: ");
			double amountTransfer = App.sc.nextDouble();
			this.withdraw(amountTransfer);
			((Customer) transferAcct).getAccounts().get(pick-1).deposit(amountTransfer);
			accts.add(transferAcct);
		}
		return accts;
	}

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

	public long getId() {
		return id;
	}



	
	
	
}
