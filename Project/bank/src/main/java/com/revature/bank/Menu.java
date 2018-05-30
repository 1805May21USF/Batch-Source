package com.revature.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static HashMap<String,Customer> log = new HashMap<String,Customer>();
	public static Bank ba = new Bank(log);
	public static void main(String[] args) {
	//	HashMap<String,Customer> log = new HashMap<String,Customer>();
		//Bank ba = new Bank(log);
		Menu.menu1();
	}
	public static void init() {
		account acc = new account("checking",9,7);
		ArrayList<account> fake1 = new ArrayList<account>();
		fake1.add(acc);
		Customer a = new Customer("john","cg",fake1);
		ba.addC("john", a);
	}
	
	public static void menu1() {
		System.out.println("Select your menu item\n1.New account\n2.New joint account\n3.Login\n4.Employee login");
		switch(sc.nextInt()) {
		case 1:
			Menu.menu2();
			break;
		case 2:
			Menu.menuJoint();
			break;
		case 3:
			Menu.menuLogin();
			break;
		case 4:
			Menu.menuEmployee();
			break;
		default:
			System.out.println("Please enter a valid number");
			Menu.menu1();
			break;
		}
	}
	public static void menu2() {
		String usr,pas,acc;
		System.out.println("Please enter your username and then password then account name");
		usr = sc.next();
		pas = sc.next();
		acc = sc.next();
		if(ba.checkAv(usr)==true) {//todo validate username
			System.out.println("username is taken");
			Menu.menu1();
		}else {
			//todo add to approval list
			ArrayList<account> accounts = new ArrayList<account>();
			account x = new account(acc,0,0);
			accounts.add(x);
			Customer c = new Customer(usr,pas,accounts);
			ba.addPend(usr, c);
			ba.addC(usr, c);
			System.out.println("Your account has been added to the approval list");
			Menu.menu1();
		}
		
	}
	public static void menuJoint() {
		String usr1,usr2,pas;
		System.out.println("please enter your two usernames and then the password");
		usr1 = sc.next();
		usr2 = sc.next();
		pas = sc.next();
		if(usr1=="0") {//todo validate both usernames
			Menu.menu1();
		}else {
			System.out.println("your account has been added to the approval list");
			Menu.menu1();
		}
	}
	public static void menuLogin() {
		System.out.println("enter your username then password");
		String usr,pas;
		usr = sc.next();
		pas = sc.next();
		if(ba.checkUsr(usr,pas)==true) {//todo validate username
			System.out.println("login successful");
			Customer c = ba.getCustomer(usr);
			Menu.menuCustomer(c);
		}
		//todo validate user
	}
	
	
	public static void menuCustomer(Customer c) {
		ArrayList<account> ac = c.getAccounts();
		account inUse = ac.get(0);
		account inUse2 = ac.get(0);
		System.out.println("please select account name");
		for(account x:ac) {
			System.out.println(x.getName());
		}
		String temp = sc.next();
		for(account x:ac) {
			if(x.getName().equals(temp)) {
				inUse = x;
			}
		}
		System.out.println("select your menu item\n1.withdraw\n2.deposit\n3.transfer");
		switch(sc.nextInt()) {
		case 1:
			System.out.println("enter amount to withdraw");
			if(inUse.withdraw(sc.nextDouble())==false) {
				System.out.println("insufficient funds");
				Menu.menuCustomer(c);
			}else {
				System.out.println("funds withdrawn");
				Menu.menu1();
			}
			break;
		case 2:
			System.out.println("enter amount to deposit");
			inUse.deposit(sc.nextDouble());
			System.out.println("funds deposited");
			Menu.menu1();
			//todo deposit
			break;
		case 3:
			System.out.println("please select account name to transfer from, then transfer to");
			for(account x:ac) {
				System.out.println(x.getName());
			}
			String trans1 = sc.next();
			String trans2 = sc.next();
			account with=inUse,to=inUse;
			for(account x:ac){
				if(x.getName().equals(trans1)) {
					with = x;
				}else {with = inUse;}
				if(x.getName().equals(trans1)) {
					to = x;
				}else {to=inUse;}
			}
			System.out.println("enter amount to transfer");
			double cash = sc.nextDouble();
			if(with.withdraw(cash)==true) {
				to.deposit(cash);
				System.out.println("successfully transfered money");
			}else {System.out.println("insufficient funds");}
			//todo transfer
			break;
		default:
			System.out.println("please enter a valid menu item");
			Menu.menuCustomer(c);
			break;
		}
	}
	
	public static void menuEmployee() {
		System.out.println("please enter user name and password");
		String usr = sc.next();
		String pas = sc.next();
		System.out.println("select your menu item\n1.show accounts\n2.show approval list");
		switch(sc.nextInt()) {
		case 1:
			//todo
			break;
		case 2:
			//todo
			break;
		default:
			System.out.println("please enter a valid menu item");
			Menu.menuEmployee();
			break;
		}
	}
	
	public static void menuAdmin() {
		System.out.println("select your menu item\n1.Approval list\n2.account list");
	}
}
