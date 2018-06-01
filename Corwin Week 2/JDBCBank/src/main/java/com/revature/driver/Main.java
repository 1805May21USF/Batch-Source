package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Bank;
import com.revature.beans.Customer;
import com.revature.daoimpl.CustomerDAOImpl;

public class Main {
	
	public static void main(String[] args) {
		CustomerDAOImpl c = new CustomerDAOImpl();
		Customer customer = new Customer("test","test","Test","Test");
		try {
			c.createCustomer(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Bank b = new Bank();
		b.start();
		*/
	}

}
