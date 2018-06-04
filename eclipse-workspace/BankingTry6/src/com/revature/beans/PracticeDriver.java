package com.revature.beans;

import java.sql.SQLException;


import com.revature.daoimpl.CustomerDAOImpl;

public class Driver {

	public static void main(String[] args) {
		
		
		CustomerDAOImpl shdi = new CustomerDAOImpl();
		
	try {
		shdi.createCustomer("One Punch Man");
		System.out.println(shdi.getCustomerList());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		// TODO Auto-generated method stub

	}

}
