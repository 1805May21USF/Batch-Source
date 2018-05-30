package com.revature.bank;
import java.util.*;
public class Bank {
	private HashMap<String,Customer> login = new HashMap<String,Customer>();
	private HashMap<String,Customer> pending = new HashMap<String,Customer>();
	public HashMap<String, Customer> getLogin() {
		return login;
	}

	public void addC(String str,Customer c) {
		login.put(str, c);
	}
	public void addPend(String str,Customer c) {
		pending.put(str, c);
	}
	public boolean checkUsr(String str,String pas) {
		if(login.containsKey(str)) {
			System.out.println("contains user");
			if(login.get(str).getPassword().equals(pas)) {
				return true;
			}
		}
		return false;
	}
	public Customer getCustomer(String str) {
		return login.get(str);
	}
	/*check if username is taken*/
	public boolean checkAv(String str) {
		if(login.containsValue(str)||pending.containsKey(str)) {
			return true;
		}else {
			return false;
		}
	}
	public void setLogin(HashMap<String, Customer> login) {
		this.login = login;
	}

	public Bank(HashMap<String, Customer> login) {
		super();
		this.login = login;
	}
	
	

}
