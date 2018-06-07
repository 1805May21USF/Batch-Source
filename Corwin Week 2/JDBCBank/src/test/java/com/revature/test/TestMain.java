package com.revature.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.util.Datastore;

public class TestMain {
	public Datastore d;
	@Test
	void userTest() {
		d = d.getInstance();
		d.addCustomer(new Customer("test","test","test","test"));
		Customer v = d.getCustomerByUsername("test");
		assertTrue(v.getUserName().equals("test"));
		d.deleteCustomer(d.getCustomerByUsername("test"));
		assertNull(d.getCustomerByUsername("test"));
	}
	
	void employeeTest() {
		d = d.getInstance();
		d.addEmployee(new Employee("test","test","test","test","N"));
		Employee v = d.getEmployeeByUsername("test");
		assertTrue(v.getUserName().equals("test"));
		d.deleteEmployee(d.getEmployeeByUsername("test"));
		assertNull(d.getEmployeeByUsername("test"));
	}
}
