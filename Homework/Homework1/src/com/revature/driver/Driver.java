package com.revature.driver;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.floats.floats;
import com.revature.solutions.Bubble;
import com.revature.solutions.DisplayArray;
import com.revature.solutions.Employee;
import com.revature.solutions.EvenInteger;
import com.revature.solutions.PrimePrint;
import com.revature.solutions.StringCharacters;
import com.revature.solutions.EvenPrinting;
import com.revature.solutions.Fib;
import com.revature.solutions.FileIO;
import com.revature.solutions.Interest;
import com.revature.solutions.NFactorial;
import com.revature.solutions.Palindromes;
import com.revature.solutions.EvenPrinting;
import com.revature.solutions.Switch;
import com.revature.solutions.Ternary;
import com.revature.solutions.Triangles;
import com.revature.solutions.number;
import com.revature.solutions.reverseString;
import com.revature.solutions.substring;
public class Driver {
	public static void main(String[] args) {
		String str = FileIO.readInput();
		str = FileIO.formatInput(str);
		System.out.println("Question 20:Answer in FileIO.java\n" + str);
		
		System.out.println("\nQuestion 19:Answer in DisplayArray.java \n");
		DisplayArray.init();
		DisplayArray.printArrayList();
		DisplayArray.addEvenOdd();
		DisplayArray.removePrime();
		System.out.println("\nQuestion 18: abstract class is stringCheck.java, methods implemented in Abstract Extension \n");
		System.out.println("\nQuestion 17:Answer in Interest.java \n");
			Interest.calculateInterest();
		System.out.println("\nQuestion 16:Answer in StringCharacters.java \n");
		
	
			StringCharacters.charCount(args);
		
		System.out.println("\nQuestion 15: \n");
		
			number x = new number(17);
			System.out.println(x.addition(4, 5));
			System.out.println(x.subtraction(4, 5));
			System.out.println(x.multiplication(4, 5));
			System.out.println(x.division(4, 5));
		
		System.out.println("\nQuestion 14:Answer in Switch.java \n");
		
			Switch.switching(2);
			Switch.switching(1);
		
		System.out.println("\nQuestion 13:Answer in Triangles.java \n");
		
			Triangles.printTriangle(4);
		
		System.out.println("\nQuestion 12:Answer in EvenPrinting.java \n");
		
			EvenPrinting.evenPrint();
		
		System.out.println("\nQuestion 11:answer in floats.java and below \n");
		
			floats num = new floats(9,8);
			num.setLength(66);
			System.out.println(num.getLength());
			
		
		System.out.println("\nQuestion 10:Answer in Ternary.java \n");
		
			System.out.println("whats smaller 7 or 90? " + Ternary.ternary(7, 90));
		
		System.out.println("\nQuestion 9:Answer in PrimePrint.java \n");
		
			System.out.println("Prime numbers: ");
			PrimePrint.evenPrint();
		
		System.out.println("\nQuestion 8:Answer in Palindromes.java \n");
		
			Palindromes.palindrome("");
		
		System.out.println("\nQuestion 7:Answer in Employee.java \n");
		
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(new Employee("john", "HR", 35));
			employeeList.add(new Employee("christine","sales",27));
			for(Employee e:employeeList) {
				System.out.println(e);
			}
			System.out.println("\nSort by age");
			Collections.sort(employeeList,Employee.ageComparator);
			for(Employee e:employeeList) {
				System.out.println(e + "\n");
			}
			System.out.println("\nSort by department");
			Collections.sort(employeeList,Employee.departmentComparator);
			for(Employee e:employeeList) {
				System.out.println(e + "\n");
			}
				System.out.println("\nSort by name");
			Collections.sort(employeeList,Employee.nameComparator);
			for(Employee e:employeeList) {
				System.out.println(e  + "\n");
			}
			
		System.out.println("\nQuestion 6:Answer in EvenInteger.java \n");
		
			System.out.println("12 is even? " + EvenInteger.evenInt(12));
		
		System.out.println("\nQuestion 5:Answer in substring.java \n");
		
			System.out.println(substring.sub("I am a string", 6));
		
		System.out.println("\nQuestion 4:Answer in NFactorial.java \n");
		
			System.out.println("5! = " + NFactorial.factorial(5));
		
		System.out.println("\nQuestion 3:Answer in reverseString.java \n");
		
			String temp = "reverse me";
			reverseString.reverse(temp);
		
		System.out.println("\nQuestion 2:Answer in Fib.java \n");
			String s ="";
			s = Fib.fib(s);
			System.out.println(s);
		
		System.out.println("\nQuestion 1:Answer in Bubble.java \n");
			int[] i = {1,0,5,6,3,2,3,7,9,8,4};
			Bubble.bubble(i);
		
	}
}
