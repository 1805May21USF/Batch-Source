package com.revature.hw1;

import java.util.ArrayList;
import java.util.Collections;

public class P7Comparing {
	public static void myCompare() {
		ArrayList<Employee> al =new ArrayList<Employee>();  
		
		//two to compare
		al.add(new Employee ("Leonardo","Sword", 21));  
		al.add(new Employee ("Leonardo","Swords", 19)); 
		
		//sorts by dept, then age, then name.
		Collections.sort(al, new P7Comparator2());
		Collections.sort(al, new P7Comparator3());
		Collections.sort(al, new P7Comparator());
		
		for (Employee e : al) {
			System.out.print("[" +e.getName()+", "+e.getDept()+", "+e.getAge()+"] ");
		}
		System.out.println("");
	}
}
