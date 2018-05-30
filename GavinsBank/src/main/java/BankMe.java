import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankMe implements Serializable{

	static Scanner input = new Scanner(System.in);
	static Logger logger =LogManager.getLogger(BankMe.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int rank;
	private static String user;
	private static BankMe instance;
	
	
	ArrayList<Account> Accounts;
	ArrayList<BankPerson> Persons;
	BankPerson current;
	Account currentAccount;
	
	private BankMe() {
		rank = 0;
		user = null;
	}
	
	public void showAccounts() {
		if(current.accountList == null) current.accountList = new ArrayList<Account>();
		System.out.println(current.accountList);
		int temp =1;
		while(temp !=0) {
			System.out.println("Pick an account to view further, or 0 to go back to the main menu");
			temp = input.nextInt();
			if(temp == 0) break;
			System.out.println(current.accountList.size());
			System.out.println(temp);
			if(current.accountList.size() <temp-1) {
				System.out.println("That bank account doesn't exist.");
				continue;
			}
			currentAccount = current.accountList.get(temp-1);
			break;
		}
		
		while(temp !=0 ) {
			if(temp!=0) {
				System.out.println(currentAccount);
				System.out.println("Would you like to deposit or withdraw from this account?");
				System.out.println("1. Depost \n2. Withdraw");
				temp = input.nextInt();
				System.out.println("How much?");
				if(temp ==1) currentAccount.deposit(input.nextInt());
				if(temp ==2) currentAccount.withdraw(input.nextInt());
				if(temp !=1 && temp!=2) {
					System.out.println("Niether of those were options");
					temp = 0;
				}
				
			
			}
		}
	}
	
	public void changeUser() {		
		System.out.println("Please enter your username: ");
		String possibleUser = input.next();
		System.out.println(possibleUser);
		
		System.out.println("And your password: ");
		String possiblePass = input.next();
		
		for(BankPerson BP: Persons) {
			if(!((BP.getUser() .equals(possibleUser))&&BP.checkPass(possiblePass))) {
				System.out.println("These userword and password do not match.");
				
			} else {
				this.rank = BP.loggingIn();
				this.user = BP.getUser();
				current = BP;
				break;
			}
		}
		System.out.println("These userword and password do not match.");
		
	}
	
	public void logOut() {
		rank = 0;
		user = null;
	}
	
	public static BankMe startBank() {
		  
		if(instance == null)
			instance = new BankMe();
		
		return instance;
	}
	
	public void newCustomer() {
		
		String first;
		String last;
		String user =null;
		String pass = null;
		boolean token1 = false;
		boolean token2 = true;
		
		System.out.println("Please enter information as it appears.");
		System.out.println("Enter you first name");
		first = input.next();
		System.out.println("Enter your last name");
		last = input.next();
		System.out.println("Enter your username");
		
		
		while(token2) {
			if(token1) System.out.println("That username has already been taken, please enter a username.");
			user = input.next();
			token2 = false;
			for(BankPerson BP: Persons) {
				if(user == BP.userName) {
					token2 = true;
					token1 = true;
				}
			}
		
		
		}
		System.out.println("Enter your password");
		pass = input.next();
		
		Persons.add(new Customer(user,  pass, first, last));
	
	}
	
	public void createCustomerAccount() {
		if(rank == 3) {
			Accounts.add(new Account(0,Accounts.size()+1));
		} else if (rank == 1) {
			currentAccount = new Account(current,Accounts.size()+1);
			Accounts.add(currentAccount);
			if(current.accountList == null) current.accountList = new ArrayList<Account>();
			current.accountList.add(currentAccount);
			
		}
		
	}
	
	public void approveAccount(Account a) {
		if(rank == 2||rank ==3) {
			a.approving();
		} else {
			System.out.println("How'd you get here.");
		}
	}
	
	public void approve() {
		if(rank == 2 || rank == 3) {
			//TODO
		}
	}
	
	public void resetBank() {
		Persons = new ArrayList<BankPerson>();
		Accounts = new ArrayList<Account>();
		Persons.add(new Admin("admin","pass"));
		Persons.add(new Employee("employee","pass"));

		quit();
	}
	
	public void quit() {
		try{
	         
	         FileOutputStream fosAccounts = new FileOutputStream("myAccounts");
	         FileOutputStream fosPersons = new FileOutputStream("myPersons");


	         
	         ObjectOutputStream oosAccounts = new ObjectOutputStream(fosAccounts);
	         ObjectOutputStream oosPersons = new ObjectOutputStream(fosPersons);


	       
	         oosAccounts.writeObject(Accounts);	         
	         oosPersons.writeObject(Persons);


	        
	         oosAccounts.close();
	         fosAccounts.close();
	         oosPersons.close();
	         fosPersons.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	
	public void initialize() {
		 
         try {
        	
        	 FileInputStream fisAccounts = new FileInputStream("myAccounts");
        	 FileInputStream fisPersons = new FileInputStream("myPersons");
            
             ObjectInputStream oisAccounts = new ObjectInputStream(fisAccounts);
             ObjectInputStream oisPersons = new ObjectInputStream(fisPersons);


	
			Accounts  = (ArrayList) oisAccounts.readObject();
			Persons  = (ArrayList<BankPerson>) oisPersons.readObject();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void screenMe() {
		System.out.println("===========================================================\n\n");
		if(rank ==0) System.out.println("Hello! Would you like to log in or create an account?");
		else {
			System.out.println("Hello User " + user +"!");
			System.out.print("Pick an option: ");
			System.out.println();

		}
		
	}
	
	private void approveAccounts() {
	
		screenMe();
		int temp = 0;
		int count = 1;
		boolean approveTime = false;
		while(temp!=9) {
			screenMe();
			if(approveTime) {
				count = 1;
				while(true) {
					if(temp == 9) break;
					for(Account account:Accounts) {
						if(!(account.approved)) {
							if(count == temp) {
								for(BankPerson cust: account.owners) {
									System.out.println(cust);

								}
								
								System.out.println("These are the owners, would you like to approve the bank account?");
								System.out.println("1 for yes, any other number for no.");
								if(input.nextInt() == 1) {
									account.approving();
									System.out.println("Thanks!");
									temp = 9;
									break;
								} else {
									System.out.println("Maybe next time!");
									temp =9;
									break;
								}
							} else {
								count++;
							}
						}
					}
				}
			}
			
			for(Account account:Accounts) {
				if(!(account.approved)) {
					System.out.println(count + " "+ account);
				}
			}
			
			System.out.println("Pick an account to look at the owers of, or enter 9 to go to the main menu.");
			temp = input.nextInt();
			approveTime = true;
		
		
		}
	
	}
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to my banking app. Please quit on screen to save and of the account or users you've made.");
		System.out.println(" Enter 0 at anytime to quit. Press any key to continue. Thanks!");
		input.nextLine();
		int temp = 1;
		int mode = 0;
		BankMe Bank = BankMe.startBank();
//		Bank.resetBank();
		Bank.initialize();


		
		while(temp!=0) {
			screenMe();
			
			
			if(Bank.rank == 0) {
				System.out.println("1: Log in.");
				System.out.println("2: Create new account.");
				temp = input.nextInt();
			} else {
				System.out.println("Choose your option.");
				//TODO
				if(Bank.rank > 0) 
					System.out.println("1: Change User ");
				if(Bank.rank == 0) System.out.println("2: Create a new account");
				if(Bank.rank == 3) System.out.println("2: Add a customer account");
				if(Bank.rank == 1) System.out.println("3. Access one of your accounts.");
				if(Bank.rank == 2) System.out.println("4. Approve accounts. ");
				if(Bank.rank == 1) System.out.println("5. Make a new Bank Acount");
				temp = input.nextInt();
	
			}
			
			if(temp == 1) {
				Bank.changeUser();	
			} else if(temp == 2) {
				Bank.newCustomer();
			} else if(temp == 3) {
				Bank.showAccounts();
			} else if(temp == 4) {
				Bank.approveAccounts();
			} else if(temp == 5) {
				Bank.createCustomerAccount();
			}
			
			
		}
		
	
		
		
		System.out.println("Goodbye!");
		
		Bank.quit();
	}


	


	



}
