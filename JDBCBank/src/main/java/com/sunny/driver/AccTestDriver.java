package com.sunny.driver;

import java.sql.SQLException;

import com.sunny.daoimpl.*;;

public class AccTestDriver {
	public static void main(String[] args) {
		AccountDAOImpl adi = new AccountDAOImpl();
		try {
			//adi.createAccount(1, (float) 200.00);
			System.out.println(adi.getAccountList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
