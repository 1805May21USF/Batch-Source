package bank;

import java.text.NumberFormat;

import bank.Account;

public class Account {
    public static double balance = 500;
    private String name;
    protected String accountId;
    private long acctNum;
    private static int numAccounts;
  
    	int balance1;
    	static double previousTransaction;
    	String customerName;
    	String customerId;
    	
    	
    	
    	
    	
    	 public Account(String balance, String name){
    		this.customerName = balance;
    		this. customerId = name;
    		this.acctNum = acctNum;
    		numAccounts++;
    	}
    	
    	static void deposit(int amount)
    	{
    		balance += amount;
    		
    		/*if(amount !=0)
    		{
    			balance = balance + amount;
    			previousTransaction = amount;
    		}*/
    	}
    	public String getName()
    	{
    		return name;
    	}
    	
    	static void withdraw(int amount1) {
    		 
    		if (balance >= amount1)
    			balance -= amount1;
    		else
    			System.out.println("Insufficient funds");
    		
    	
    		//if(amount !=0) {
    			//balance = balance - amount;
    			//previousTransaction = -amount;
    			//}
    					
    		}
    	public double getBalance()
    	{
    		return balance;
    	}
    	public long getAcctNumber()
    	{
    		return acctNum;
    	}
    	public String toString()
    	{
    		// write your code here

    		NumberFormat usMoney = NumberFormat.getCurrencyInstance();

    		return "Account Owner: " + name 
    				+ "\nAccount Number: " + acctNum 
    				+ "\nBalance: " + usMoney.format(balance); 

    		/*String str = "Account Owner: %s%nAccount Number: %d%nBalance: $%.2f", name, Long.parsetoInt(acctNum), balance;
    	  return str; */
    	}
    	public void changeName(String newName)
    	{
    		// Write your code here
    		name = newName;
    	}
    	
    	
    	public void close()
    	{
    		this.name += " - CLOSED";
    		this.balance = 0;
    		numAccounts--;
    	}	
    	// Transfers money from one bank account to another bank account
    	public void transfer(Account acct, double amount)
    	{
    		NumberFormat usMoney = NumberFormat.getCurrencyInstance();
    		if (amount < 0)
    		{
    			System.out.println("Invalid amount to transfer from account #" 
    					+ this.acctNum + ".");
    		}
    		
    		else
    		{
    			System.out.println("Insufficient funds to transfer from account #" 
    					+ this.acctNum + ".");
    		}
    	}

    	// Creates a new account that is the sum of the balance of two accounts and closes the two original accounts
    	public static Account consolidate(Account acct1, Account acct2)
    	{
    		acct1.balance = 5000;
    		acct2.balance = 5000;
    		if (acct1.name.equals(acct2.name) && acct1.acctNum != acct2.acctNum)
    		{
    			long newAcctNum;
    			if (acct1.acctNum > acct2.acctNum)
    			{
    				newAcctNum = acct1.acctNum + 1;
    			}
    			else
    			{
    				newAcctNum = acct2.acctNum + 1;
    			}

    			Account newAcct = new Account(acct1.balance + acct2.balance, acct1.name);
    			acct1.close();
    			acct2.close();

    			return newAcct;
    		}
    		else
    		{
    			System.out.println("Accounts cannot be consolidated.");
    			return null;
    		}
    	}

    	// Transfers money from acct1 to acct2
    	public static void transfer(Account acct1, Account acct2, double amount)
    	{
    		acct1.transfer(acct2, amount);
    	}
    
	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	static void getPreviousTransaction() {
    			if(previousTransaction > 0)
    			{
    				System.out.println("Deposited:"+ previousTransaction );
    			}
    			else if(previousTransaction < 0)
    			{
    				System.out.println("withdrawn:" + Math.abs(previousTransaction));
    			}
    			else {
    				System.out.println("No transaction occurred");
    			}
    		}
    
 
    

   public Account() {}  

   public Account(double bal, String id) {   
       if (balance >= 0) {
           balance = bal;
       }
       else {
           balance = 0;
       }
       accountId = id;
   }

  // public abstract void deposit(double amount); 

  // public abstract void withdraw(double amount);

   //public abstract double getBalance();

  // public abstract String getAccountId();

  // public abstract void transfer(double amount, Account account);

public static String getNumAccounts() {
	// TODO Auto-generated method stub
	return null;
}

public void transfer(double amount, Account account) {
	// TODO Auto-generated method stub
	
}

public void deposit(double amount) {
	// TODO Auto-generated method stub
	
}

public void withdraw(double amount) {
	// TODO Auto-generated method stub
	
}

public String getAccountId() {
	// TODO Auto-generated method stub
	return null;
}
}
