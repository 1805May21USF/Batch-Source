package com.sunny.driver;

import java.sql.SQLException;

import com.sunny.daoimpl.*;;

public class CustTestDriver {
	public static void main(String[] args) {
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		try {
			//cdi.createCustomer("Sunny", "Purama", "sunny", "themage");
			System.out.println(cdi.getCustomerList().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
