package com.revature.driver;

import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.impl.register.RegisterNewAccount;
import com.revature.impl.register.RegisterNewAccountJoint;
import com.revature.impl.register.RegisterReturningAccount;

public class Register {
	public Register() {
		Scanner input = new Scanner(System.in);
		while (true) {
			getRegisterWelcome();
			getPleaseEnterANumberPrompt();
			switch (input.next()) {
			case "1":
				new RegisterNewAccount();
				break;
			case "2":
				new RegisterNewAccountJoint();
				break;
			case "3":
				new RegisterReturningAccount();
				break;
			case "4":
				return;
			default:
				getError();
			}
		}
	}

	private static void getRegisterWelcome() {
		System.out.print(new Messages().getRegisterWelcome());
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}

	private static void getPleaseEnterANumberPrompt() {
		System.out.print(new Messages().getPleaseEnterANumberPrompt());
	}
}
