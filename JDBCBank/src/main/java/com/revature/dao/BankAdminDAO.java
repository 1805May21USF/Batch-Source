package com.revature.dao;

import java.util.ArrayList;

public interface BankAdminDAO {
	/*
	 * A future implementation is to change the methods that are void to return a
	 * boolean value. This could help simplify if the process was successful or not.
	 */
	public abstract ArrayList<String> ListOfOpenApplications();

	public abstract ArrayList<String> ListOfAllAccounts();

	public abstract void BankAdminApproveApplication(String account);

	public abstract void BankAdminDenyApplication(String account);

	public abstract boolean BankAdminViewAndEditAccountInfo(String account, String newInfo,  int editPosition);

	public abstract void BankAdminWithdraw(String account, String amount);

	public abstract void BankAdminDeposit(String account, String amount);

	public abstract void BankAdminTransfer(String username, String account, String amount);

	public abstract void BankAdminCancelAccount(String username);

}
