package com.revature.P0Banking;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Partner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] queueJointUserInfo;
	private boolean appliedForJoint;
	
	//Constructor Chaining Woo!
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

	/*
	 * Name: applyJoint
	 * Input:None
	 * Output:boolean
	 * Description: Customer access that just allows Customer objects to apply for a joint account
	 */
	private boolean applyJoint() {
		App.sc.nextLine();
		System.out.print("Username of joint member? ");
		String user = App.sc.nextLine();
		System.out.print("Password of joint member? ");
		String pass = App.sc.nextLine();
		//Check if username and password match in database
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(App.file));
			ArrayList<?> accts = (ArrayList<?>)in.readObject();
			if(User.returnUserNameMatch(user,accts) != null && !this.getUsername().equals(user) && this.appliedForJoint == false) {
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
	
	/*
	 * Name: viewPersonalInfo
	 * Input:Customer user
	 * Output:None
	 * Description: Public access method that allows Bank Partners to view personal Info
	 */
	public void viewPersonalInfo(Customer user) {
		System.out.println("Name: "+user.getName());
		System.out.println("Username: "+user.getUsername());
		System.out.println("Accounts: ");
		int i = 1;
		for(Account acct: user.getAccounts()) {
			System.out.println(i+") "+acct.getName()+acct.getId()+": $"+String.format("%.2f", acct.getBalance()));
			i++;
		}
	}
	
	/*
	 * Name: customerActions
	 * Input:ArrayList<Partner> newAccts, int pick
	 * Output:ArrayList<Partner>
	 * Description: "Customer" access method that provides actions a customer can take in his/her account.
	 */
	private ArrayList<Partner> customerActions(ArrayList<Partner> newAccts, int pick) throws BadInputException{
		switch(pick) {
			case 1:
				viewPersonalInfo(this);
				break;
			case 2:
				newAccts = this.accessAccounts(newAccts);
				break;
			case 3:
				if(this.applyJoint()) {System.out.println("You have applied for a joint account "+this.getName()+". An employee will approve or deny the application soon.\n");}
				else {System.out.println("\nThat is not a viable account or you have already applied. Please try again.");}
				break;
		}
		return newAccts;
	}
	
	/*
	 * Name: bankAdminActions
	 * Input:ArrayList<Partner> newAccts, int pick
	 * Output:ArrayList<Partner>
	 * Description: "Customer" access method that provides actions a bank admin can take in a customer's account.
	 */
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
					newAccts = approveDenyJoints(choice, newAccts);
				}else {
					System.out.println("There is no request for a joint account.");
				}
		}
		return newAccts;
	}

	/*
	 * Name: employeeActions
	 * Input:ArrayList<Partner> newAccts, int pick
	 * Output:ArrayList<Partner>
	 * Description: "Customer" access method that provides actions a employee can take in a customer's account.
	 */
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
							Partner jointMember = User.returnLoginMatch(this.getQueueJointUserInfo()[0], this.getQueueJointUserInfo()[1], newAccts);
							newAccts.remove(this);
							newAccts.remove(jointMember);
							jointMember.getAccounts().add(jointAccount);
							this.getAccounts().add(jointAccount);
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
	
	/*
	 * Name: approveDenyJoints
	 * Input:ArrayList<Partner> newAccts, int choice
	 * Output:ArrayList<Partner>
	 * Description: "Customer" access method that provides ability to bank admin and employee to approve
	 * or deny requests for joints to bank admin and employee.
	 */
	private ArrayList<Partner> approveDenyJoints(int choice, ArrayList<Partner> newAccts) {
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
			System.out.println("Joint account has been approved!");
			break;
		case 2:
			//Deny just resets flags and info.
			this.setAppliedForJoint(false);
			this.setQueueJointUserInfo(new String[2]);
			System.out.println("Joint account has been denied!");
			break;
		}
		return newAccts;
	
	}
	
	/*
	 * Name: receiveCustomerAction
	 * Input:ArrayList<Partner> newAccts, Partner user
	 * Output:ArrayList<Partner>
	 * Description: Public access method that provides actions to customer accounts based on who is accessing the Customer account.
	 */
	public ArrayList<Partner> receiveCustomerAction(ArrayList<Partner> newAccts, Partner user) {
		int pick = -1;
		while(pick != 4) {
			try {
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
			}catch(BadInputException e) {
				e.getMessage();
			}
		}
		App.sc.nextLine();
		return newAccts;
	}


	/*
	 * Getters and Setters
	 */
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
