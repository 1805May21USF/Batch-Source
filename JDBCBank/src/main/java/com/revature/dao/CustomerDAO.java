package com.revature.dao;

public interface CustomerDAO {
	public abstract void CustomerWithdraw(String username, String account, String amount);

	public abstract void CustomerDeposit(String username, String account, String amount);

	public abstract void CustomerTransfer(String username);

	public abstract void CustomerCancelAccount(String account);
}
