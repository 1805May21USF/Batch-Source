package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AccountDAOimpl;
import com.revature.daoimpl.Bank_CustomerDAOimpl;
import com.revature.model.Account;



public class Driver {
	public static void main(String[] args) throws SQLException {
		AccountDAOimpl a = new AccountDAOimpl();
		Bank_CustomerDAOimpl bc = new Bank_CustomerDAOimpl();
		
		
		bc.createcustomerID("luis");
		System.out.println(bc.getCustomerList());
		
	}

}
