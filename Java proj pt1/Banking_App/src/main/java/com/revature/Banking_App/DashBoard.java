package com.revature.Banking_App;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.*;
import com.revature.Banking_App.BankAccount.accountStatus;
import com.revature.Banking_App.BankAccount.accountType;
import com.revature.Banking_App.BankAccount.pendingJointOwnerAcceptance;
import com.revature.Banking_App.User.LevelOfAccess;

public class DashBoard 
{
	private ArrayList<BankAccount> mainBankAccounts;
	private ArrayList<User> mainUsers;
	private User currentUser;
	
	public static Scanner input = new Scanner(System.in);
	public static Logger logger = LogManager.getLogger("TRANSACTIONS");
	
	public DashBoard()
	{
		this.mainBankAccounts = new ArrayList<BankAccount>();
		this.mainUsers = new ArrayList<User>();
		this.mainBankAccounts = ReadBankAccountsFromFile.deserializeBankAccount();
		this.mainUsers = ReadUsersFromFile.deserializeUsers();
		this.currentUser = null; 	
	}
	
	//Method to handle the initial menu to Login, Register new user, or exit
	public void Login()
	{
		
		String selection = "";
		boolean finished = false;
		while(!finished)
		{
			System.out.println("1> Login");
			System.out.println("2> Register New User");
			System.out.println("3> Exit");
			selection = input.nextLine();
			
			if(selection.equals("1"))
			{
				if(!authenticate())
				{
					System.out.println("Invalid Login Name or password");
				}
				
				if(this.currentUser != null && this.currentUser.permissions == LevelOfAccess.Customer)
				{
					customerCommands();
					this.currentUser = null;
				}
				if(this.currentUser != null && this.currentUser.permissions == LevelOfAccess.Employee)
				{
					employeeCommands();
					this.currentUser = null;
				}
				if(this.currentUser != null && this.currentUser.permissions == LevelOfAccess.Admin)
				{
					adminCommands();
					this.currentUser = null;
				}
								
			}
			if(selection.equals("2"))
			{
				if(registerNewUser())
				{
					WriteUsersToFile.serializeUsers(this.mainUsers);
				}
			}
			if (selection.equals("3"))
			{
				break;
			}
		}
	}
	
	//Find a user based on the loginName and return that User object
	private User findUser(String loginName)
	{
		User user = null;
		
		for(int i=0; i< this.mainUsers.size(); i++)
		{
			if(this.mainUsers.get(i).getLoginName().equals(loginName))
			{
				
				return this.mainUsers.get(i);
			}
		}
		return user;
	}
	//If the user exists and the correct password is submitted, user is Authenticated into the system.
	private boolean authenticate()
	{
		String loginName = "";
		String password = "";
		System.out.println("Enter Login Name");
		
		loginName = input.nextLine();
		System.out.println("Enter password");
		password = input.nextLine();
		
		User user = findUser(loginName);
		if(user != null && user.getPassword().equals(password))
		{
			this.currentUser = user;
			return true;
		}
				
		return false;
	}
	//Method to handle the creation of a new User.
	private boolean registerNewUser()
	{
		String loginName = "";
		String password = "";
		String fullName = "";
		System.out.println("Register a Login Name");
		loginName = input.nextLine();
		
		if(findUser(loginName) != null)
		{
			System.out.println("User already exists.");
			return false;
		}
		System.out.println("Enter a password");
		password = input.nextLine();
		System.out.println("Enter your Full Name");
		fullName = input.nextLine();
		User registered = new User(loginName, password, fullName, LevelOfAccess.Customer);
		this.mainUsers.add(registered);
		
		return true;
	}
	//Method to handle transfers. Two For-each loops. Outer loop finds the destination account and the inner finds the originating account for funds transfer.  
	private boolean transferFunds(String command[])
	{
		boolean transferSuccessful = false;
		double amount = Double.parseDouble(command[1]);
		int initialAccount = Integer.parseInt(command[3]);
		int endAccount = Integer.parseInt(command[5]);
		if(amount <= 0)
		{
			System.out.println("Transfer amount is 0 or negative");
			return false;
		}
		for(BankAccount iter1 : this.mainBankAccounts)
		{
			if(iter1.getAccountNumber() == endAccount && iter1.isAnOwner(this.currentUser.getLoginName()) && iter1.status == accountStatus.Approved && iter1.pendingAcceptance != pendingJointOwnerAcceptance.Pending
					||	iter1.getAccountNumber() == endAccount && this.currentUser.permissions == LevelOfAccess.Admin && iter1.status == accountStatus.Approved && iter1.pendingAcceptance != pendingJointOwnerAcceptance.Pending)
			{
				for(BankAccount iter2: this.mainBankAccounts)
				{
					if(iter2.getAccountNumber() == initialAccount && iter2.isAnOwner(this.currentUser.getLoginName()) && iter2.status == accountStatus.Approved && iter2.getBalance() >= amount && iter2.pendingAcceptance != pendingJointOwnerAcceptance.Pending
							||	iter2.getAccountNumber() == initialAccount && this.currentUser.permissions == LevelOfAccess.Admin && iter2.status == accountStatus.Approved && iter2.getBalance() >= amount && iter2.pendingAcceptance != pendingJointOwnerAcceptance.Pending)
					{
						iter2.withdraw(amount);
						logger.info(this.currentUser.getLoginName()+" Transfered $"+amount +" From account:"+initialAccount +" to account:"+endAccount);
						transferSuccessful = true;
						break;
					}					
				}
				if(transferSuccessful)
				{
					iter1.deposit(amount);
					WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
					return transferSuccessful;
				}
			}
		}
		System.out.println("Transfer of funds failed");
		return transferSuccessful;
	}
	//Method to perform a withdraw of funds
	private boolean withdrawFunds(String command[])
	{
		double amount = Double.parseDouble(command[1]);
		int account = Integer.parseInt(command[3]);
		for(BankAccount iter: this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == account && iter.isAnOwner(this.currentUser.getLoginName()) && amount > 0 && amount <= iter.getBalance() 
					||	iter.getAccountNumber() == account && this.currentUser.permissions == LevelOfAccess.Admin && amount > 0 && amount <= iter.getBalance())
			{
				iter.withdraw(amount);
				logger.info(this.currentUser.getLoginName()+" Withdrew $" + amount +" from account:" + account);
				WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
				return true;
			}
		}
		System.out.println("Unable to withdraw. Insufficient funds, incorrect account number, or input.");
		return false;
	}
	//Method to perform a deposit of funds
	private boolean depositFunds(String[] command)
	{
		double amount = Double.parseDouble(command[1]);
		int account = Integer.parseInt(command[3]);
		for(BankAccount iter: this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == account && amount > 0 && iter.isAnOwner(this.currentUser.getLoginName()) && iter.status == accountStatus.Approved && iter.pendingAcceptance != pendingJointOwnerAcceptance.Pending
					||	iter.getAccountNumber() == account && this.currentUser.permissions == LevelOfAccess.Admin && amount > 0 && iter.status == accountStatus.Approved && iter.pendingAcceptance != pendingJointOwnerAcceptance.Pending)
			{
				iter.deposit(amount);
				logger.info(this.currentUser.getLoginName()+" Deposited $" + amount +" to account:" + account);
				WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
				return true;
			}
		}
		System.out.println("Unable to desposit funds. Incorrect account number, account is in a pending state, or input.");
		return false;
	}
	//Method to handle the Customer menu and commands.
	private void customerCommands()
	{
		String customerInput = "";
		while(!customerInput.equals("logout"))
		{
			for(BankAccount account : this.mainBankAccounts)
			{
				if(account.isAnOwner(currentUser.getLoginName()))
				{
					System.out.println(account.displayAccount());
				}
			}
			
			System.out.println("Enter commands: deposit | withdraw | transfer | open account | accept | decline | logout");
			customerInput = input.nextLine();
			String[] cInputSep = customerInput.split(" ");
			
			if(cInputSep[0].equals("deposit"))
			{
				depositFunds(cInputSep);
			}
			if(cInputSep[0].equals("withdraw"))
			{
				withdrawFunds(cInputSep);
			}
			if(cInputSep[0].equals("transfer"))
			{
				transferFunds(cInputSep);
			}
			if(cInputSep[0].equals("open"))
			{
				openNewAccount();
			}
			if(cInputSep[0].equals("accept") || cInputSep[0].equals("decline"))
			{
				jointAccountAcceptOrDecline(cInputSep);
			}
		}
	}
	//Method to handle the opening of new accounts. Customer chooses if the account is a single or joint account. Joint needing a loginName of the other owner.
	private boolean openNewAccount() 
	{
		String customerInput = ""; 
		System.out.println("Enter account type: single or joint");
		customerInput = input.nextLine();
		
		int accountNumber = generateAccountNumber();
		
		if(customerInput.equals("single"))
		{
			BankAccount newBankAccount = new BankAccount(accountNumber, this.currentUser.getLoginName(), this.currentUser.getFullName(), accountType.Single, accountStatus.Pending, pendingJointOwnerAcceptance.None);
			this.mainBankAccounts.add(newBankAccount);
			WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
			return true;
		}
		if(customerInput.equals("joint"))
		{
			
			System.out.println("Enter Login Name of the other owner");
			customerInput = input.nextLine();
			BankAccount newBankAccount = null;
			if(findUser(customerInput).getLoginName().equals(customerInput))
			{
				
				newBankAccount = new BankAccount(accountNumber, this.currentUser.getLoginName(), this.currentUser.getFullName(), accountType.Joint, accountStatus.Pending, pendingJointOwnerAcceptance.Pending);
				newBankAccount.addJointOwner(customerInput, findUser(customerInput).getFullName());
				this.mainBankAccounts.add(newBankAccount);
				WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
			}
			
			
			System.out.println("Joint owner does not exist");
			return false;
		}
		
		System.out.println("Failed to create a new account");
		return false;
	}
	//After a joint account is approved by Admin or Employee, the joint owner has a choice to accept or decline the joint account.
	private boolean jointAccountAcceptOrDecline(String[] command )
	{
		int accountNumber = Integer.parseInt(command[3]);
		if(command[0].equals("accept"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				if(iter.getAccountNumber() == accountNumber && iter.isAJointOwner(this.currentUser.getLoginName()) && iter.status == accountStatus.Approved && iter.pendingAcceptance == pendingJointOwnerAcceptance.Pending)
				{
					iter.pendingAcceptance = pendingJointOwnerAcceptance.Accepted;
					WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
					return true;
				}
			}
		}
		
		if(command[0].equals("decline"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				if(iter.getAccountNumber() == accountNumber && iter.isAJointOwner(this.currentUser.getLoginName()) && iter.status == accountStatus.Approved && iter.pendingAcceptance == pendingJointOwnerAcceptance.Pending)
				{
					iter.status = accountStatus.Canceled;
					WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
					return true;
				}
			}
		}
		return false;
	}
	//Method to generate a random number when accounts are created. Finds a number between 1000 and 1999 and checks to make sure the number chosen is not in use
	private int generateAccountNumber()
	{
		
		int accountNumber = 0;
		Random rand = new Random();
		while(accountNumber == 0)
		{
			accountNumber = rand.nextInt(999) + 1000;
			for(BankAccount iter : this.mainBankAccounts)
			{
				if(iter.getAccountNumber() == accountNumber)
				{
					accountNumber = 0;
				}
			}
		}
		return accountNumber;
	}
	//Method to approve an account. Employee can only approve if the account is in a pending state. Admin can enable closed accounts
	private void approveAccount(int accountNumber)
	{
		for(BankAccount iter : this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == accountNumber && iter.status == accountStatus.Pending || iter.getAccountNumber() == accountNumber && currentUser.permissions == LevelOfAccess.Admin)
			{
				iter.status = accountStatus.Approved;
				WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
			}
		}
	}
	//Method to deny an account. Employee can only deny accounts in a pending state. Admin can cancel accounts.
	private void denyAccount(int accountNumber)
	{
		for(BankAccount iter : this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == accountNumber && iter.status == accountStatus.Pending || iter.getAccountNumber() == accountNumber && currentUser.permissions == LevelOfAccess.Admin)
			{
				iter.status = accountStatus.Canceled;
				WriteBankAccountsToFile.serializeBankAccount(this.mainBankAccounts);
			}
		}
	}
	//Method for Employee menu and commands.
	private void employeeCommands()
	{
		String employeeInput = "";
		while(!employeeInput.equals("logout"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				System.out.println(iter.displayAccount());
			}
			System.out.println("Employee commands: approve | deny | logout");
			employeeInput = input.nextLine();
						
			String[] seperatedEmployeeInput = employeeInput.split(" ");
						
			if(seperatedEmployeeInput[0].equals("approve"))
			{
				int accountNumber = Integer.parseInt(seperatedEmployeeInput[1]);
				approveAccount(accountNumber);				
			}
			
			if(seperatedEmployeeInput[0].equals("deny"))
			{
				int accountNumber = Integer.parseInt(seperatedEmployeeInput[1]);
				denyAccount(accountNumber);	
			}
		}
	}
	//Method for Admin menu and commands
	private void adminCommands()
	{
		String adminInput ="";
		while(!adminInput.equals("logout"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				System.out.println(iter.displayAccount());
			}
			System.out.println("Admin commands: approve | deny | cancel | transfer | deposit | withdraw | logout");
			adminInput = input.nextLine();
			
			String[] seperatedAdminInput = adminInput.split(" ");
			
			if(seperatedAdminInput[0].equals("deposit"))
			{
				depositFunds(seperatedAdminInput);
			}
			if(seperatedAdminInput[0].equals("withdraw"))
			{
				withdrawFunds(seperatedAdminInput);
			}
			if(seperatedAdminInput[0].equals("transfer"))
			{
				transferFunds(seperatedAdminInput);
			}
			if(seperatedAdminInput[0].equals("approve"))
			{
				int accountNumber = Integer.parseInt(seperatedAdminInput[1]);
				approveAccount(accountNumber);				
			}
			
			if(seperatedAdminInput[0].equals("deny") || seperatedAdminInput[0].equals("cancel"))
			{
				int accountNumber = Integer.parseInt(seperatedAdminInput[1]);
				denyAccount(accountNumber);	
			}
		}
	}
}