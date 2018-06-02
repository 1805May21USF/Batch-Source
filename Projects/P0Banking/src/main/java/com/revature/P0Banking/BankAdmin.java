package com.revature.P0Banking;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class BankAdmin extends Partner{
	private static final long serialVersionUID = 1L;
	
	public BankAdmin(String name,String username, String password) {
		super(username, password,name);
	}
	
	/*
	 * Name: receiveBankAdminActions
	 * Input:ArrayList<Partner> accounts
	 * Output:ArrayList<Partner>
	 * Description: Provides interface for admin access to users - bank admins
	 */
	public ArrayList<Partner> receiveBankAdminActions(ArrayList<Partner> accounts) throws IOException{
		int pick = -1;
		while(pick != 3) {
			//System.out.print("What would you like to do admin?\n1)Access an account\n2)Create an account\n3)Log Out\n");
			System.out.print("What would you like to do admin?\n1)Access an account\n2)Delete an account\n3)Log Out\n");
			pick =  App.sc.nextInt();
			try {
				if(pick>3 || pick<1) {
					throw new BadInputException();
				}
				switch(pick) {
					case 1:
						pickPartnerAccount(accounts);
						break;
					case 2:
						deletePartnerAccount(accounts);
						break;
					/*case 2:
						accts = bankAdminAccountCreation(accts);
						break;*/
				}
			}catch(BadInputException e) {e.getMessage();}
		}
		return accounts;
	}
	
	/*
	 * Name: pickPartnerAccount
	 * Input:ArrayList<Partner> accounts
	 * Output:None
	 * Description: Class only access that allows BankAdmin object to pick a partner account to access
	 */
	private void pickPartnerAccount(ArrayList<Partner> accounts) throws BadInputException {
		App.sc.nextLine();
		System.out.print("Username of partner account to access: ");
		String user = App.sc.nextLine();
		try {
			Partner select = User.returnUserNameMatch(user, accounts);
			((Customer) select).receiveCustomerAction(accounts,this);
		}catch(NullPointerException e) {
			System.out.println("That account does not exist.");
			throw new BadInputException();
		}
	}
	
	/*
	 * Name: deletePartnerAccount
	 * Input:ArrayList<Partner> accounts
	 * Output:None
	 * Description: Class only access that allows BankAdmin to delete an account
	 * Note: May need to remove Account objects, not sure what floating Account objects that aren't referenced do
	 */
	private void deletePartnerAccount(ArrayList<Partner> accounts) throws BadInputException, IOException {
		App.sc.nextLine();
		System.out.print("Username of partner account to delete: ");
		String user = App.sc.nextLine();
		Partner select = User.returnUserNameMatch(user, accounts);
		accounts.remove(((Customer) select));
		User.saveToFile(accounts);
	}
	
	/*
	 * Name: bankAdminAccountCreation
	 * Input:ArrayList<Partner> accounts
	 * Output:ArrayList<Partner>
	 * Description: Class only access that allows bankadmin to create any account
	 * Notes: WIP
	 */
	/*private ArrayList<Partner> bankAdminAccountCreation(ArrayList<Partner> acct) throws BadInputException, IOException{
		User.saveToFile(acct);
		System.out.println("What type of account would you like to create:\n1)Customer\n2)Employee\n3)BankAdmin");
		int pick1 = App.sc.nextInt();
		App.sc.nextLine();
		if(pick1>3||pick1<1) {
			throw new BadInputException();
		}
		switch(pick1) {
			case 1:
				acct = User.registerAcct("Customer",this.getUsername());
				break;
			case 2:
				acct =  User.registerAcct("Employee", this.getUsername());
				break;
			case 3:
				acct = User.registerAcct("BankAdmin");
				break;
		}
		return acct;
	}*/
	
	
	
}
