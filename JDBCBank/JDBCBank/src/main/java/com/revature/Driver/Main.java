package com.revature.Driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.Client;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.daoimp.UserDaoImp;

public class Main {

	public static void main(String[] args) {
		
		boolean success = false;
		Scanner sc = new Scanner(System.in);
		
		
		User u1 = new User();
		UserDaoImp userDao = new UserDaoImp();
		Client c1 = new Client();
		Employee e1 = new Employee();
		Admin a1 = new Admin();
		
		while(success == false) {
			System.out.println("Welcome to the banking app login. Please choose an option below: ");
			System.out.println("1) Existing Customer Login");
			System.out.println("2) New Customer Login (Create An Account)");
			System.out.println("3) Employee Login");
			System.out.println("4) Administrator Login");
			System.out.println("5) Close Application");
			System.out.print(">");
		
			int startOption = sc.nextInt();
		
			switch (startOption) {
		
			case 1: try {
					userDao.login(1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2: try {
					userDao.newUserLogin();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3: try {
					userDao.login(2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4: try {
					userDao.login(2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				success = true;
				break;
			default: System.out.println("Invalid option! Please choose a valid option from the menu.");
				break;
			
			}
		}
		
		System.out.println("Thanks for using the banking app! Application closing...");
	}
}
