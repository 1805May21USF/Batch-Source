package com.revature.banking_app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.revature.DAOImp.BankAccountDAOImp;
import com.revature.DAOImp.UserDAOImp;
import com.revature.banking_app.BankAccount.AccountStatus;
import com.revature.banking_app.BankAccount.AccountType;
import com.revature.banking_app.BankAccount.JointOwner;
import com.revature.banking_app.User.LevelOfAccess;
import com.revature.usererrors.FailedLoginAttempt;

public class DashBoard 
{
	private ArrayList<BankAccount> mainBankAccounts;
	private ArrayList<User> mainUsers;
	private User currentUser;
	
	public static Scanner input = new Scanner(System.in);
	
	
	
	public DashBoard()
	{
		this.mainBankAccounts = new ArrayList<BankAccount>();
		this.mainUsers = new ArrayList<User>();
		
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		UserDAOImp usersDAOImp = new UserDAOImp();
		try {
			
			this.mainBankAccounts = bankAccountDAOImp.getBankAccounts();
			this.mainUsers = usersDAOImp.getUsers();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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
					throw new FailedLoginAttempt("Invalid Login Name or password");
				
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
				registerNewUser();
				
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
		UserDAOImp usersDAOImp = new UserDAOImp();
		try {
			usersDAOImp.createUser(registered);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		this.mainUsers.add(registered);
		
		return true;
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
			
			System.out.println("Enter commands: deposit | withdraw | transfer | open account | accept joint account | decline joint account | delete account |logout");
			customerInput = input.nextLine();
			String[] cInputSep = customerInput.split(" ");
			
			if(cInputSep[0].equals("deposit"))
			{
				//depositFunds(cInputSep);
				this.mainBankAccounts = Transactions.deposit(cInputSep, this.mainBankAccounts, this.currentUser);
			}
			if(cInputSep[0].equals("withdraw"))
			{
				//withdrawFunds(cInputSep);
				this.mainBankAccounts = Transactions.withdraw(cInputSep, this.mainBankAccounts, this.currentUser);
			}
			if(cInputSep[0].equals("transfer"))
			{
				//transferFunds(cInputSep);
				this.mainBankAccounts = Transactions.transfer(cInputSep, this.mainBankAccounts, this.currentUser);
			}
			if(cInputSep[0].equals("open"))
			{
				openNewAccount();
			}
			if(cInputSep[0].equals("accept") || cInputSep[0].equals("decline"))
			{
				jointAccountAcceptOrDecline(cInputSep);
			}
			if(cInputSep[0].equals("delete"))
			{
				if(DeleteBankAccount.deleteBankAccount(cInputSep, this.mainBankAccounts, this.currentUser))
				{
					BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
					try {
						this.mainBankAccounts = bankAccountDAOImp.getBankAccounts();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	}
	//Method to handle the opening of new accounts. Customer chooses if the account is a single or joint account. Joint needing a loginName of the other owner.
	private boolean openNewAccount() 
	{
		String customerInput = ""; 
		System.out.println("Enter account type: single or joint");
		customerInput = input.nextLine();
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		//int accountNumber = generateAccountNumber();
		
		if(customerInput.equals("single"))
		{
			BankAccount newBankAccount = new BankAccount(0, 0D, this.currentUser.getLoginName(), this.currentUser.getFullName(), AccountType.Single, AccountStatus.Pending, JointOwner.None);
			this.mainBankAccounts.add(newBankAccount);
			try {
				bankAccountDAOImp.createBankAccount(newBankAccount);
				this.mainBankAccounts = bankAccountDAOImp.getBankAccounts();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return true;
		}
		if(customerInput.equals("joint"))
		{
			
			System.out.println("Enter Login Name of the other owner");
			customerInput = input.nextLine();
			BankAccount newBankAccount = null;
			if(findUser(customerInput).getLoginName().equals(customerInput))
			{
				
				newBankAccount = new BankAccount(0, 0D, this.currentUser.getLoginName(), this.currentUser.getFullName(), AccountType.Joint, AccountStatus.Pending, JointOwner.Pending);
				newBankAccount.addJointOwner(customerInput, findUser(customerInput).getFullName());
				this.mainBankAccounts.add(newBankAccount);
				try {
					bankAccountDAOImp.createBankAccount(newBankAccount);
					this.mainBankAccounts = bankAccountDAOImp.getBankAccounts();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
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
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		int accountNumber = Integer.parseInt(command[3]);
		if(command[0].equals("accept"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				if(iter.getAccountNumber() == accountNumber && iter.isAJointOwner(this.currentUser.getLoginName()) && iter.status == AccountStatus.Approved && iter.pendingAcceptance == JointOwner.Pending)
				{
					iter.pendingAcceptance = JointOwner.Accepted;
					try {
						bankAccountDAOImp.updateBankAccount(iter);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					System.out.println("JOINT ACCOUNT ACCEPTED");
					return true;
				}
			}
		}
		
		if(command[0].equals("decline"))
		{
			for(BankAccount iter : this.mainBankAccounts)
			{
				if(iter.getAccountNumber() == accountNumber && iter.isAJointOwner(this.currentUser.getLoginName()) && iter.status == AccountStatus.Approved && iter.pendingAcceptance == JointOwner.Pending)
				{
					iter.status = AccountStatus.Canceled;
					try {
						bankAccountDAOImp.updateBankAccount(iter);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					System.out.println("JOINT ACCOUNT DECLINED");
					return true;
				}
			}
		}
		return false;
	}
	
	
	//Method to approve an account. Employee can only approve if the account is in a pending state. Admin can enable closed accounts
	private void approveAccount(int accountNumber)
	{
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		for(BankAccount iter : this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == accountNumber && iter.status == AccountStatus.Pending || iter.getAccountNumber() == accountNumber && currentUser.permissions == LevelOfAccess.Admin)
			{
				iter.status = AccountStatus.Approved;
				try {
					bankAccountDAOImp.updateBankAccount(iter);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				System.out.println("ACCOUNT: "+accountNumber+" HAS BEEN APPROVED");
				
			}
		}
	}
	//Method to deny an account. Employee can only deny accounts in a pending state. Admin can cancel accounts.
	private void denyAccount(int accountNumber)
	{
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		for(BankAccount iter : this.mainBankAccounts)
		{
			if(iter.getAccountNumber() == accountNumber && iter.status == AccountStatus.Pending || iter.getAccountNumber() == accountNumber && currentUser.permissions == LevelOfAccess.Admin)
			{
				iter.status = AccountStatus.Canceled;
				try {
					bankAccountDAOImp.updateBankAccount(iter);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				System.out.println("ACCOUNT: "+accountNumber+" HAS BEEN DENIED");
				
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
				this.mainBankAccounts = Transactions.deposit(seperatedAdminInput, this.mainBankAccounts, this.currentUser);
			}
			if(seperatedAdminInput[0].equals("withdraw"))
			{
				//withdrawFunds(seperatedAdminInput);
				this.mainBankAccounts = Transactions.withdraw(seperatedAdminInput, this.mainBankAccounts, this.currentUser);
			}
			if(seperatedAdminInput[0].equals("transfer"))
			{
				//transferFunds(seperatedAdminInput);
				this.mainBankAccounts = Transactions.transfer(seperatedAdminInput, this.mainBankAccounts, this.currentUser);
			}
			if(seperatedAdminInput[0].equals("approve"))
			{
				int accountNumber = Integer.parseInt(seperatedAdminInput[1]);
				approveAccount(accountNumber);				
			}
			
			if(seperatedAdminInput[0].equals("deny"))
			{
				int accountNumber = Integer.parseInt(seperatedAdminInput[1]);
				denyAccount(accountNumber);	
			}
			if(seperatedAdminInput[0].equals("cancel"))
			{
				if(DeleteBankAccount.deleteBankAccount(seperatedAdminInput, this.mainBankAccounts, this.currentUser))
				{
					BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
					try {
						this.mainBankAccounts = bankAccountDAOImp.getBankAccounts();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
			}
		}
	}
}