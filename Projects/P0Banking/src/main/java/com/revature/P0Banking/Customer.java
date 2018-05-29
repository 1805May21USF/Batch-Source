package com.revature.P0Banking;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customer extends Partner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] queueJointUserInfo;
	private boolean appliedForJoint;
	private static DecimalFormat dFormat = new DecimalFormat(".##");

	public Customer(String name, int age, String username, String password) {
		super(username, password,name, age);
		this.accounts.add(new Account("Primary"));
		this.appliedForJoint = false;
	}
	public Customer(String name, String username, String password) {
		super(username, password,name);
		this.accounts.add(new Account("Primary"));
		this.appliedForJoint = false;
	}

	public boolean applyJoint() {
		App.sc.nextLine();
		System.out.print("Username of joint member? ");
		String user = App.sc.nextLine();
		System.out.print("Password of joint member? ");
		String pass = App.sc.nextLine();
		//Check if username and password match in database
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(App.file));
			ArrayList<?> accts = (ArrayList<?>)in.readObject();
			if(User.returnUserNameMatch(user,accts) != null) {
				this.queueJointUserInfo = new String[]{user,pass};
				this.appliedForJoint = true;
				in.close();
				return true;
			}
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}
	
	public void viewPersonalInfo(Customer user) {
		System.out.println("Name: "+user.getName());
		System.out.println("Username: "+user.getUsername());
		System.out.println("Balance accounts: ");
		int i = 1;
		for(Account acct: user.getAccounts()) {
			System.out.println(i+") "+acct.getName()+acct.getId()+": $"+String.format("%.2f", acct.getBalance()));
			i++;
		}
	}
	
	public ArrayList<Partner> accessAccounts(ArrayList<Partner> newAccts) {
		System.out.println("Select an account to access: ");
		printListOfAccounts(accounts);
		int pick = App.sc.nextInt();
		if(pick > accounts.size() || pick < 0) {
			System.out.println("Please pick a valid account.");
		}
		else {
			Account account = accounts.get(pick-1);
			newAccts = account.prompt(this.getUsername(),newAccts);
		}
		return newAccts;
	}
	
	private ArrayList<Partner> customerActions(ArrayList<Partner> newAccts, int pick) throws BadInputException{
		switch(pick) {
			case 1:
				viewPersonalInfo(this);
				break;
			case 2:
				newAccts = this.accessAccounts(newAccts);
				break;
			case 3:
				if(this.applyJoint()) {System.out.println("\nYou have applied for a joint account "+this.getName()+". An employee will approve or deny the application soon.");}
				else {System.out.println("\nThere is no account with those credentials or you have already applied. Please try again.");}
				break;
		}
		return newAccts;
	}
	
	private ArrayList<Partner> bankAdminActions(ArrayList<Partner> newAccts, int pick) throws BadInputException{
		switch(pick) {
			case 1:
				viewPersonalInfo(this);
				break;
			case 2:
				newAccts = this.accessAccounts(newAccts);
				break;
			case 3:
				if(this.appliedForJoint) {
					int choice = jointAccountActions();
					switch(choice) {
						case 1:
							//make new account object
							Account jointAccount = new Account("Joint");
							//place it into Customer and Joint Member ,remove old current user and joint from arraylist
							Partner jointMember = User.returnLoginMatch(this.getQueueJointUserInfo()[0], this.getQueueJointUserInfo()[1], newAccts);
							newAccts.remove(this);
							newAccts.remove(jointMember);
							this.getAccounts().add(jointAccount);
							jointMember.getAccounts().add(jointAccount);
							//set flags back to normal
							this.setAppliedForJoint(false);
							this.setQueueJointUserInfo(new String[2]);
							//add objects back to arraylist
							newAccts.add(jointMember);
							newAccts.add(this);
							break;
						case 2:
							//Deny just resets flags and info.
							this.setAppliedForJoint(false);
							this.setQueueJointUserInfo(new String[2]);
							break;
					}
				}else {
					System.out.println("There is no request for a joint account.");
				}
				break;
		}
		return newAccts;
	}
	
	private ArrayList<Partner> employeeActions(ArrayList<Partner> newAccts, int pick) throws BadInputException{
		switch(pick) {
			case 1:
				viewPersonalInfo(this);
				break;
			/*case 2:
				newAccts = this.accessAccounts(newAccts);
				break;*/
			case 2:
				if(this.appliedForJoint) {
					int choice = jointAccountActions();
					switch(choice) {
						case 1:
							//make new account object
							Account jointAccount = new Account("Joint");
							//place it into Customer and Joint Member ,remove old current user and joint from arraylist
							this.getAccounts().add(jointAccount);
							Partner jointMember = User.returnLoginMatch(this.getQueueJointUserInfo()[0], this.getQueueJointUserInfo()[1], newAccts);
							newAccts.remove(this);
							newAccts.remove(jointMember);
							jointMember.getAccounts().add(jointAccount);
							//set flags back to normal
							this.setAppliedForJoint(false);
							this.setQueueJointUserInfo(new String[2]);
							//add objects back to arraylist
							newAccts.add(jointMember);
							newAccts.add(this);
							break;
						case 2:
							//Deny just resets flags and info.
							this.setAppliedForJoint(false);
							this.setQueueJointUserInfo(new String[2]);
							break;
					}
				}else {
					System.out.println("There is no request for a joint account.");
				}
				break;
		}
		return newAccts;
	}
	
	public ArrayList<Partner> receiveCustomerAction(ArrayList<Partner> newAccts, Partner user) throws BadInputException {
		int pick = -1;
		while(pick != 4) {
			if(user instanceof Customer) {
				System.out.print("What would you like to do?\n1)View personal info\n2)Access your accounts\n3)Apply for a joint account\n4)Log Out\n");
				pick = App.sc.nextInt();
				if(pick>4 || pick<1) {
					throw new BadInputException();
				}
				newAccts = customerActions(newAccts, pick);
			}
			else if(user instanceof Employee) {
				System.out.print("What would you like to do?\n1)View personal info\n2)Check request for joint account\n3)Log Out\n");
				pick = App.sc.nextInt();
				if(pick>3 || pick<1) {
					throw new BadInputException();
				}else if(pick == 3) {
					break;
				}
				newAccts = employeeActions(newAccts, pick);
			}
			else if(user instanceof BankAdmin) {
				System.out.print("What would you like to do?\n1)View personal info\n2)Access user accounts\n3)Check request for joint account\n4)Log Out\n");
				pick = App.sc.nextInt();
				if(pick>4 || pick<1) {
					throw new BadInputException();
				}
				newAccts = bankAdminActions(newAccts, pick);
			}
		}
		App.sc.nextLine();
		return newAccts;
	}



	public boolean isAppliedForJoint() {
		return appliedForJoint;
	}


	public void setAppliedForJoint(boolean appliedForJoint) {
		this.appliedForJoint = appliedForJoint;
	}

	public String[] getQueueJointUserInfo() {
		return queueJointUserInfo;
	}

	public void setQueueJointUserInfo(String[] queueJointUserInfo) {
		this.queueJointUserInfo = queueJointUserInfo;
	}
}
