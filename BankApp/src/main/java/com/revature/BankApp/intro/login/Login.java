package com.revature.BankApp.intro.login;

import java.util.Scanner;

import com.revature.BankApp.intro.login.bankadmin.BankAdmin;
import com.revature.BankApp.intro.login.customer.Customer;
import com.revature.BankApp.intro.login.employee.Employee;

public class Login {
	public Login() {
		Scanner input = new Scanner(System.in);

		CheckUser cu = new CheckUser();
		/*
		 * Check if the user name and password exists in the Person.txt If it doesn't
		 * exist, the person is allowed to re-enter their user name and password or
		 * leave to the main menu.
		 */
		Loop1: while (true) {
			System.out.println("LOGIN:");
			System.out.print("Please enter your username: ");
			String username = input.next();
			System.out.print("Please enter your password: ");
			String password = input.next();
			if (cu.CheckIfUserValid(username, password)) {
				/*
				 * After successful login, check the user status. There are varying privileges
				 * per status Status -1: Application has been denied Status 0: Application under
				 * review Status 1: Customer Status 2: Employee Status 3: Bank Administrator
				 */
				switch (cu.CheckUserStatus(username, password)) {
				case -2:
					System.out.println(
							"Your account has been deactivated. Please contact an employee about your account status.");
					break;
				case -1:
					System.out.println("We have reviewed your application and it has been denied. Please speak "
							+ "to an employee about your application if you have any questions or concerns.");
					break;
				case 0:
					System.out.println("Your account application is currently being reviewed. Please try again later.");
					break;
				case 1:
					new Customer(username);
					break;
				case 2:
					new Employee(username);
					break;
				case 3:
					new BankAdmin(username);
					break;
				default:
					System.out.println("Error during login phase");
				}
				break Loop1;
			} else {
				System.out.println(
						"The username or password you've entered doesn't match any account. Please try again.");
			}

		}

	}
}
