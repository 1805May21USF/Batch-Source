package com.revature.same;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees {
	ArrayList<Employees> listOfEmployees;
	
	public SortEmployees() {
		// TODO Auto-generated constructor stub
		Employees E1 = new Employees("John", "Customer Service", 20);
		Employees E2 = new Employees("Sarah", "Staff", 31);
		Employees E3 = new Employees("Obi", "Manager", 19);
		Employees E5 = new Employees("Akpan", "CFO", 21);
		
		listOfEmployees = new ArrayList<Employees>();
        listOfEmployees.add(E1);
        listOfEmployees.add(E2);
        listOfEmployees.add(E3);
        listOfEmployees.add(E5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        
	}

}
