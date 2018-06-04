package com.revature.beans;

import java.sql.SQLException;

import com.revature.JDBCBank.App;
import com.revature.exceptions.BadInputException;
import com.revature.implementdao.ImpBankAccountDAO;
import com.revature.implementdao.ImpTransactionsDAO;

public class BankAccount {
	private int accountid;
	private float balance;
	private int userid;
	private static final ImpBankAccountDAO ibad = new ImpBankAccountDAO();
	private static final ImpTransactionsDAO itd = new ImpTransactionsDAO();

	/******Constructors************************/
	public BankAccount(int accountid, float balance, int userid) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.userid = userid;
	}
	
	/*********Methods*************************/
	/*
	 * Name: promptBankAccountActions()
	 * Input:None
	 * Output:None
	 * Description: Provides actions a user can do inside their bank account.
	 */
	public void promptBankAccountActions() {
		int pick = -1;
		while(pick != 4){
			try {
					System.out.println("What action would you like to take:\n1)View Balance\n2)Withdraw\n3)Deposit\n4)Go back");
					pick = Integer.parseInt(App.sc.nextLine());
					switch(pick) {
						case 1:
							this.viewBalance();
							break;
						case 2:
							System.out.print("Withdraw amount: ");
							float amountWithdraw = Float.parseFloat(App.sc.nextLine());
							this.withdraw(amountWithdraw);
							break;
						case 3:
							System.out.print("Deposit amount: ");
							float amountDeposit = Float.parseFloat(App.sc.nextLine());
							this.deposit(amountDeposit);
							break;
						case 4:
							break;
						default:
							throw new BadInputException();
					}
				}catch(BadInputException | SQLException d) {
					System.out.println("Please try again.");
				}
		}
	}
	
	/*
	 * Name: viewBalance()
	 * Input:None
	 * Output:None
	 * Description: Account method that allows user to see balance
	 */
	public void viewBalance() {
		System.out.print("Account-"+this.getAccountid()+" has: $");
		System.out.printf("%.2f\n",this.getBalance());
	}
	
	/*
	 * Name: withdraw
	 * Input:float amount
	 * Output:None
	 * Description: Public account method that allows user to withdraw money from account instance
	 */
	public void withdraw(float amount) throws BadInputException, SQLException{
		if(amount>this.getBalance()) {
			System.out.println("\nThe amount exceeded what you have.");
			throw new BadInputException();
		}
		else if(amount < 0) {
			throw new BadInputException();
		}
		else {
			this.setBalance(this.getBalance()-amount);
			ibad.updateBankAccount(this);
			itd.addTransaction("Withdrew",amount, this.getUserid(),this.getAccountid());
			String money = String.format("%.2f", amount);
			System.out.println("You withdrew $"+money+" from the account.");
			App.log.info("Account-"+this.getAccountid()+" withdrew: $"+money);
		}
	}
	
	/*
	 * Name: deposit
	 * Input:double amount
	 * Output:None
	 * Description: Public account method that allows user to deposit money to account instance
	 */
	public void deposit(float amount) throws SQLException{
		//deposit yo money
		this.setBalance(this.getBalance()+amount);
		ibad.updateBankAccount(this);
		itd.addTransaction("Deposited",amount, this.getUserid(),this.getAccountid());
		String money = String.format("%.2f", amount);
		System.out.println("You have deposited $"+money+" into the account.");
		App.log.info("Account-"+this.getAccountid()+" deposited: $"+money);
	}
	
	/*******Getters and Setter********************/
	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}