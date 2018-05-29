package com.revature.P0Banking;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Partner implements Serializable{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String name;
	//private int age;
	
	public Employee(String name,String username, String password) {
		super(username, password,name);
	}
	
	public ArrayList<Partner> receiveEmployeeActions(ArrayList<Partner> accts) throws IOException{
		int pick = -1;
		while(pick != 2) {
			//System.out.print("What would you like to do admin?\n1)Access an account\n2)Create an account\n3)Log Out\n");
			System.out.print("What would you like to do employee?\n1)Access an account\n2)Log Out\n");
			pick =  App.sc.nextInt();
			try {
				if(pick>2 || pick<1) {
					throw new BadInputException();
				}
				switch(pick) {
					case 1:
						pickPartnerAccount(accts);
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
}
