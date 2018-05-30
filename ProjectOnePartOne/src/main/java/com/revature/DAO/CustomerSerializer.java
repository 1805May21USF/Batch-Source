package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.comparators.CustomerIdComparator;
import com.revature.comparators.UserUsernameComparator;

public class CustomerSerializer implements CustomerDAO {

	private ArrayList<Customer> customers;
	
	public CustomerSerializer() {
		this.customers = new ArrayList<Customer>();
	}
	
	@Override
	public ArrayList<Customer> getAllCustomer() {
		loadFromFile();
		return this.customers;
	}

	@Override
	public Customer getCustomer(int ID) {
		loadFromFile();
		for(Customer customer: this.customers) {
			if(ID == customer.getID()) {
				return customer;
			}
		}
		return null;
	}
	
	public Customer getLoadedCustomer(int ID) {
		for(Customer customer: this.customers) {
			if(ID == customer.getID()) {
				return customer;
			}
		}
		return null;
	}
	
	public Customer getCustomerByUsername(String username) {
		loadFromFile();
		for(Customer customer: this.customers) {
			//System.out.println("Searching :" +customer.getUserName() + username);
			if(username.equals(customer.getUserName())) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		loadFromFile();
		if(getCustomerByUsername(customer.getUserName())!=null) {
			deleteCustomer(customer);
		}
		this.customers.add(customer);
		saveToFile();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		loadFromFile();
		int remove = -1;
		for(int i = 0;i<this.customers.size();i++) {
			if(this.customers.get(i).getUserName().equals(customer.getUserName())){
				remove = i;
			}
		}
		if(remove>-1) {
			this.customers.remove(remove);
		}
		saveToFile();
		
	}
	
	public void loadFromFile() {
		try {
			
			ObjectInputStream objectInputStream =
				    new ObjectInputStream(new FileInputStream("CustomersTable.txt"));
			
			this.customers = (ArrayList<Customer>) objectInputStream.readObject();
			for(Customer i:this.customers) {
				//System.out.println(i);
			}

			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not read from file!");
		} catch (ClassNotFoundException e) {
			System.out.println("The data in the file was not the class provided!");
		} 
			catch (NullPointerException e) {
			System.out.println("There was no data!");
		}
	}
	
	public void saveToFile() {
		try {
			ObjectOutputStream objectOutputStream =
			        new ObjectOutputStream(new FileOutputStream("CustomersTable.txt"));
			
			objectOutputStream.writeObject(customers);
	        objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldn't write to file!");
		}
	}

}
