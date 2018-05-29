package com.revature.P0Banking;

import java.io.IOException;
import java.util.ArrayList;

public class BankAdmin extends Partner {
	private static final long serialVersionUID = 1L;
	
	public BankAdmin(String name,String username, String password) {
		super(username, password,name);
	}
	
	public ArrayList<Partner> receiveBankAdminActions(ArrayList<Partner> accts) throws IOException{
		int pick = -1;
		while(pick != 2) {
			//System.out.print("What would you like to do admin?\n1)Access an account\n2)Create an account\n3)Log Out\n");
			System.out.print("What would you like to do admin?\n1)Access an account\n2)Delete an account\n3)Log Out\n");
			pick =  App.sc.nextInt();
			try {
				if(pick>3 || pick<1) {
					throw new BadInputException();
				}
				switch(pick) {
					case 1:
						pickPartnerAccount(accts);
						break;
					case 2:
						deletePartnerAccount(accts);
						break;
					/*case 2:
						accts = bankAdminAccountCreation(accts);
						break;*/
				}
			}catch(BadInputException e) {e.getMessage();}
		}
		return accts;
	}
	
	private void pickPartnerAccount(ArrayList<Partner> accounts) throws BadInputException {
		App.sc.nextLine();
		System.out.print("Username of partner account to access: ");
		String user = App.sc.nextLine();
		Partner select = User.returnUserNameMatch(user, accounts);
		((Customer) select).receiveCustomerAction(accounts,this);
	}
	
	private void deletePartnerAccount(ArrayList<Partner> accounts) throws BadInputException {
		App.sc.nextLine();
		System.out.print("Username of partner account to delete: ");
		String user = App.sc.nextLine();
		Partner select = User.returnUserNameMatch(user, accounts);
		accounts.remove(((Customer) select));
	}
	
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
