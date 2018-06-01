package BankingApp;

import java.util.*;

public class bankAccount {
public String userName;
public String password;
public Float balance;
{
	
if(balance < 0) {
	System.out.println("Warning: Negative balance");
}}

bankAccount(String userName, String password, Float balance)
{
	this.userName = userName;
	this.password = password;
	this.balance = balance;
}

public void setUserName(String userName) {
	this.userName = userName;
}
public void setPassword(String password) {
	this.password = password;
}
public void setBalance(Float balance) {
	this.balance = balance;
}
}

