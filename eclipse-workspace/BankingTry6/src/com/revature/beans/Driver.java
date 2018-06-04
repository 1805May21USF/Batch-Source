package com.revature.beans;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CustomerDAOImpl;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Big Money Bank!");
		
		System.out.println("Are you a customer: 1, or Employee: 2");
		Scanner enterRole = new Scanner(System.in);
		int role = enterRole.nextInt();
		
		//Customer Start
				if(role == 1) {
					System.out.println("Welcome valued customer!");
					System.out.println("Please log in with your username");
					Scanner enterUsernameOption = new Scanner(System.in);
					String usernameOption = enterUsernameOption.nextLine();
					System.out.println("And your Password");
					int passwordOption = enterUsernameOption.nextInt();
		
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
