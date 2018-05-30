package com.revature.banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
    	Customer currentUser = new Customer();
    	boolean logged = false;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Log in? or Register?");
    	String lOR = sc.nextLine(); 
    	//System.out.println(lOR);
		while(!logged) {
    	if(lOR.toLowerCase().equals("log in")) {
    			System.out.println("Username?");
    			String username = sc.next();
    			System.out.println("Password?");
    			String password = sc.next();
    			for (Customer e : TechnicalDB.translateTextToArrayCu()) {
    				//System.out.println(e.getUsername());
    				if (username.equals(e.getUsername())){
    					if(password.equals(e.getPasswd())) {
    						currentUser = e;
    						logged = true;
    						User.getLoggedInUsers().add(e.getId());
    						break;
    					}
    					else {
    						System.out.println("Wrong Password, please try again");
    					}
    				} else {
    					System.out.println("Username not found. Please register");
    					break;
    				}
    			}
    	}  else if (lOR.toLowerCase().equals("register")) {
    		System.out.println("Username?");
    		String username = sc.next();
    		String password = null;
    		boolean pass = false;
    		while(pass != true) {
    			System.out.println("Password?");
    			password = sc.next();
    			System.out.println("Confirm Password?");
    			String password2 = sc.next();
    			if (password.equals(password2)) {
    				pass = true;
    			} else {
    				System.out.println("Passwords don't match. Try again!");
    			}	
    		}
    		System.out.println("What's your name?");
    		String name = sc.next();
    		System.out.println("Phone number?");
    		String phonenumber = sc.next();
    		
    		Customer newCustomer = new Customer(name, username, password, phonenumber);
    		TechnicalDB.addToDB(newCustomer);
    		User.getLoggedUsers().add(newCustomer.getId());
    		User.getLoggedInUsers().add(newCustomer.getId());
    		
    		TechnicalDB.addToDB(newCustomer);
    		logged = true;
    	}	
    	while(logged) {
    		System.out.println("What action would you like to perform?");
    		String act = sc.nextLine();
    		if (act.equals("open account")){
    			System.out.println("How much money would you like to deposit to start?");
    			String res = sc.nextLine();
    			System.out.println("Are there any other signatories to your account? If so, please type there IDs below");
    			String sigs = sc.nextLine();
    			if (sigs == null) {
    				
    			}
    			System.out.println("Thank you! Your account now awaits approval by one of our representatives.");
    			HashSet<String> h = new HashSet<String>(Arrays.asList(currentUser.getId()));
    			Account newacct = new Account(Float.valueOf(res) , h);
    			//TODO on approval by employee this should happen
    			currentUser.getAccounts().add(newacct.getAccountId());
    			TechnicalDB.addToDB(newacct);
    			
    		}
    		else if (act.equals("deposit")){
    			//TODO make a legality checker here
    			if(currentUser.getAccounts().size() > 1) {
        			System.out.println("Please cite the id number of the account you'd like to access.");
    			} else {
    				System.out.println("How much money would you like to deposit?");
    				float num = sc.nextFloat();
    				for(Account a : TechnicalDB.translateTextToArrayAc()) {
    					if (a.getSignerIDs().contains(currentUser.getId())) {
    						Account current = a;
    						current.deposit(num);
    					} else {
    						System.out.println("account not found");
    					}
    				}
    			}

    		}
    		else if (act.equals("withdraw")){
    			//TODO make a legality checker here
    			if(currentUser.getAccounts().size() > 1) {
        			System.out.println("Please cite the id number of the account you'd like to access.");
    			} else {
    				System.out.println("How much money would you like to withdraw?");
    				float num = sc.nextFloat();
    				for(Account a : TechnicalDB.translateTextToArrayAc()) {
    					if (a.getSignerIDs().contains(currentUser.getId())) {
    						Account current = a;
    						current.withdraw(num);
    					} else {
    						System.out.println("account not found");
    					}
    				}
    			}

    		}
    		else if (act.equals("transfer")){
    			//TODO make a legality checker here
    			if(currentUser.getAccounts().size() > 1) {
        			System.out.println("Please cite the id number of the account you'd like to access.");
    			} else {
    				System.out.println("How much money would you like to transfer?");
    				float num = sc.nextFloat();
    				System.out.println("Please type in the id number of the account you are sending it to.");
    				String acctt = sc.nextLine();
    				for(Account a : TechnicalDB.translateTextToArrayAc()) {
    					if (a.getSignerIDs().contains(currentUser.getId())) {
    						Account current = a;
    						current.transfer(acctt, num);
    					} else {
    						System.out.println("account not found");
    					}
    				}
    			}

    		}
    		else if (act.equals("log off")) {
    			logged = false;
    			currentUser = null;
    		}
    		
    	}
		}
    	
/*    		if (act.equals("deposit")) {
    			
    		}*/
    	/*HashSet<Account> test = TechnicalDB.translateTextToArrayAc();
    	for(Account a : test) {
    		System.out.println(a.getAccountId());
    	}
    	HashSet<String> dupe = new HashSet<String>();
    	dupe.add("lame");
    	dupe.add("woah");
    	Account jk = new Account(15.0f, dupe);
    	TechnicalDB.addToDB(jk);
    }*/
       	/*Iterator<Account> itr = test.iterator();
    	while (itr.hasNext()) {
    		System.out.println(Arrays.toString(itr.next());
    	}
    	}*/
    	/*}
    	
    	if (currentUser instanceof Customer) {
    		System.out.println("What would you like to do? (transfer, withdraw, deposit, create account)");
    		String option = sc.next();
    		
    	}
    	*/
    	//HashSet<Account> test = TechnicalDB.translateTextToArrayAc("/banking/data/Customers.txt");
    	ArrayList<Customer> fakes = new ArrayList<Customer>();
    	fakes.add(new Customer("nameun6", "usernameun", "passwordun", "phoneun"));
    	fakes.add(new Customer("nameun7", "usernameun", "passwordun", "phoneun"));
    	fakes.add(new Customer("nameun8", "usernameun", "passwordun", "phoneun"));
    	//Customer fake = new Customer("nameun6", "usernameun", "passwordun", "phoneun");
/*    	for(Customer fack : fakes) {
    	TechnicalDB.addToDB(fack);
    	}*/

    	//System.out.println()
    }   	
    	
}
