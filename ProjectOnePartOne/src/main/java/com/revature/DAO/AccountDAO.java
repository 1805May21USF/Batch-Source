package com.revature.DAO;

import java.util.ArrayList;

import com.revature.beans.Account;

public interface AccountDAO {
	   
	   public ArrayList<Account> getAllAccount();
	   public Account getAccount(int ID);
	   public void updateAccount(Account account);
	   public void deleteAccount(Account account);

}
