package com.revature.database;

import java.util.ArrayList;
import java.util.Vector;

import com.revature.DAO.AccountSerializer;
import com.revature.DAO.ApplicationSerializer;
import com.revature.DAO.CustomerSerializer;
import com.revature.DAO.EmployeeSerializer;
import com.revature.DAO.TransactionSerializer;
import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;
import com.revature.beans.User;

public class Database {
	
	private CustomerSerializer customerSerializer;
	private EmployeeSerializer employeeSerializer;
	private ApplicationSerializer applicationSerializer;
	private AccountSerializer accountSerializer;
	private TransactionSerializer transactionSerializer;
	
	public Database() {
		customerSerializer = new CustomerSerializer();
		employeeSerializer = new EmployeeSerializer();
		applicationSerializer = new ApplicationSerializer();
		accountSerializer = new AccountSerializer();
		transactionSerializer = new TransactionSerializer();
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
	
	public void updateApplication(Application a) {
		applicationSerializer.updateApplication(a);
	}
	public void deleteApplication(Application a) {
		applicationSerializer.deleteApplication(a);
	}
	public void getApplication(Application a) {
		applicationSerializer.getApplication(a.getID());
	}
	public ArrayList<Application> getAllApplications() {
		return applicationSerializer.getAllApplication();
	}
	
	public void updateAccount(Account a) {
		accountSerializer.updateAccount(a);
	}
	
	public void deleteAccount(Account a) {
		accountSerializer.deleteAccount(a);
	}
	
	public void getAccount(Account a) {
		accountSerializer.getAccount(a.getID());
	}
	
	public ArrayList<Account> getAllAccounts() {
		return accountSerializer.getAllAccount();
	}
	
	public void updateTransaction(Transaction t) {
		transactionSerializer.updateTransaction(t);
	}
	
	public void deleteTransaction(Transaction t) {
		transactionSerializer.deleteTransaction(t);
	}
	
	public void getTransaction(Transaction t) {
		transactionSerializer.getTransaction(t.getID());
	}
	
	public ArrayList<Transaction> getAllTransactions() {
		return transactionSerializer.getAllTransaction();
	}
	

}
