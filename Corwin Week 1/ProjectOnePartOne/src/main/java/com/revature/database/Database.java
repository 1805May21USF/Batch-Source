package com.revature.database;

import java.util.ArrayList;
import java.util.Vector;

import com.revature.DAO.CustomerSerializer;
import com.revature.DAO.EmployeeSerializer;
import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;
import com.revature.beans.User;

public class Database {
	
	private CustomerSerializer customerSerializer;
	private EmployeeSerializer employeeSerializer;
	
	public Database() {
		customerSerializer = new CustomerSerializer();
		employeeSerializer = new EmployeeSerializer();
	}
	
	public void updateCustomer(Customer c) {
		customerSerializer.updateCustomer(c);
	}
	public void deleteCustomer(Customer c) {
		customerSerializer.deleteCustomer(c);
	}
	public Customer getCustomer(Customer c) {
		return customerSerializer.getCustomer(c.getID());
	}
	
	public Customer getCustomer(String username) {
		return customerSerializer.getCustomerByUsername(username);
	}
	public Customer getCustomer(int ID) {
		return customerSerializer.getCustomer(ID);
	}
	public Customer getLoadedCustomer(int ID) {
		return customerSerializer.getLoadedCustomer(ID);
	}
	public ArrayList<Customer> getAllCustomers() {
		return customerSerializer.getAllCustomer();
	}
	
	public void updateEmployee(Employee e) {
		employeeSerializer.updateEmployee(e);
	}
	public void deleteEmployee(Employee e) {
		employeeSerializer.deleteEmployee(e);
	}
	public void getEmployee(Employee e) {
		employeeSerializer.getEmployee(e.getID());
	}
	public Employee getEmployee(String username) {
		return employeeSerializer.getEmployeeByUsername(username);
	}
	public ArrayList<Employee> getAllEmployees() {
		return employeeSerializer.getAllEmployee();
	}
	

}
