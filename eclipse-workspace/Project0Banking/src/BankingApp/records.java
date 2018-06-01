package BankingApp;

import java.util.*;
import java.util.Scanner;

public class records {
	public String userName;
	public String password;
	public Float balance;

	
	public void makeANewAccount() {
		System.out.println("enter a new username");
		Scanner enterUserName = new Scanner(System.in);
		this.userName = enterUserName.nextLine();
		System.out.println("enter a new password");
		Scanner enterPassword = new Scanner(System.in);
		this.password = enterPassword.nextLine();
		System.out.println("enter a balance");
		Scanner enterBalance = new Scanner(System.in);
		this.balance = enterBalance.nextFloat();
		
	ArrayList<bankAccount> accounts = new ArrayList<bankAccount>();
	accounts.add(new bankAccount(this.userName, this.password, this.balance));
	System.out.println(this.userName +" "+ this.password +" "+ this.balance);
	}
}

