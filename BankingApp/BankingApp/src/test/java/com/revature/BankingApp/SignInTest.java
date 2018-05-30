package com.revature.BankingApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.*;

import com.revature.storage.Account;
import com.revature.storage.Customer;
import com.revature.storage.Employee;

/**
 * Unit test for simple BankingApp.
 */
public class SignInTest {
	
	private Customer cus = null;
	private Employee emp = null;
	
	@Test
	@DisplayName("Customer login test")
	public void customerLoginTest() {
		Vector<Account> accounts = new Vector<>();
		Account a = new Account("checking", "Personal Checking", 200.00, "none");
		accounts.add(a);
		
		cus = new Customer("Well", "this", "was", 'a', "triumph", 13, "cake", accounts);
		
		App.serialize(cus);
		
		SignIn si = new SignIn();
		
		assertTrue(si.customerLogin(cus.getUsername(), cus.getPassword()));
		assertFalse(si.customerLogin(cus.getUsername(), "error"));
		assertFalse(si.customerLogin("error", cus.getPassword()));
		
		App.deleteCustomer(cus);
		
		cus = null;
	}
	
	@Test
	@DisplayName("Employee login test")
	public void employeeLoginTest() {
		emp = new Employee("Well", "this", "was", 'a', "triumph", 13, "cake", "huge success", 23.43);
		
		App.serialize(emp);
		
		SignIn si = new SignIn();
		
		assertTrue(si.employeeLogin(emp.getUsername(), emp.getPassword()));
		assertFalse(si.employeeLogin(emp.getUsername(), "error"));
		assertFalse(si.employeeLogin("error", emp.getPassword()));
		
		App.deleteEmployee(emp);
		
		emp = null;
	}
}
