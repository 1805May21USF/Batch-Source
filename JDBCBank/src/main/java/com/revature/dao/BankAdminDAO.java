package com.revature.dao;

import java.util.ArrayList;

public interface BankAdminDAO {

	public abstract ArrayList<String> ListOfOpenApplications();
	
	public abstract ArrayList<String> ListOfAllAccounts();

	public abstract void BankAdminApproveApplication(String account);

	public abstract void BankAdminDenyApplication(String account);

	public abstract ArrayList<String> BankAdminViewAndEditAccountInfo();
	
	public abstract void BankAdminWithdraw(String username, String account, String amount);
	
	public abstract void BankAdminDeposit(String username, String account, String amount);
	
	public abstract void BankAdminTransfer(String username, String account, String amount);
	
	public abstract void BankAdminCancelAccount(String username);

}
