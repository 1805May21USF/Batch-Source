package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Bank;
import com.revature.beans.Customer;
import com.revature.daoimpl.CustomerDAOImpl;

public class Main {
	
	public static void main(String[] args) {
		
		Bank b = new Bank();
		b.start();
	}

}
