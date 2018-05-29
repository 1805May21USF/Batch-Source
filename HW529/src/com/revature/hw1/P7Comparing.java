package com.revature.hw1;

import java.util.ArrayList;
import java.util.Collections;

public class P7Comparing {
	public static void myCompare() {
		ArrayList<Employee> al =new ArrayList<Employee>();  
		al.add(new Employee("Donatello", "Staff", 4));  
		al.add(new Employee("Michelangelo", "Nunchuks", 27));  
		al.add(new Employee ("Leonardo","Swords", 21));  
		al.add(new Employee ("Leonardo","Swords", 19)); 
		
		Collections.sort(al, new P7Comparator2());
		Collections.sort(al, new P7Comparator3());
		Collections.sort(al, new P7Comparator());
		
		for (Employee e : al) {
			System.out.print("[" +e.getName()+", "+e.getDept()+", "+e.getAge()+"] ");
		}
		System.out.println("");
	}
}
