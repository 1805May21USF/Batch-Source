package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

public class EmployeeSerializer  implements EmployeeDAO{


	private ArrayList<Employee> employees;
	
	public EmployeeSerializer() {
		this.employees = new ArrayList<Employee>();
	}
	
	@Override
	public ArrayList<Employee> getAllEmployee() {
		loadFromFile();
		return this.employees;
	}

	@Override
	public Employee getEmployee(int ID) {
		loadFromFile();
		for(Employee employee: this.employees) {
			if(ID == employee.getID()) {
				return employee;
			}
		}
		return null;
	}
	
	public Employee getEmployeeByUsername(String username) {
		loadFromFile();
		for(Employee employee: this.employees) {
			if(username.equals(employee.getUserName())) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		loadFromFile();
		System.out.println(getEmployeeByUsername(employee.getUserName()));
		if(getEmployeeByUsername(employee.getUserName())!=null) {
			deleteEmployee(employee);
		}
		this.employees.add(employee);
		saveToFile();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		loadFromFile();
		for(Employee e:this.employees) {
			if(e.getUserName().equals(employee.getUserName())){
				this.employees.remove(e);
			}
		}
		saveToFile();
		
	}
	
	public void loadFromFile() {
		try {
			
			ObjectInputStream objectInputStream =
				    new ObjectInputStream(new FileInputStream("EmployeesTable.txt"));
			
			this.employees = (ArrayList<Employee>) objectInputStream.readObject();
			//for(Employee i:this.employees) {
			//	System.out.println(i);
			//}

			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
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
			        new ObjectOutputStream(new FileOutputStream("EmployeesTable.txt"));
			
			objectOutputStream.writeObject(employees);
	        objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Couldn't write to file!");
		}
	}
}
