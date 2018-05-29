package com.revature.driver;
import java.util.ArrayList;
import java.util.Collections;

import com.revature.beans.*;

public class Main {

	//int array for Question 01
	public static int [] q1Arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	public static void main(String[] args) {
		//Question 01
		Question01 q1 = new Question01();
		q1.bubbleSort(q1Arr);
		q1.printSortedArray(q1Arr);
		System.out.println();
		
		//Question 02
		Question02 q2 = new Question02();
		System.out.println("Fibonacci Numbers: ");
		q2.fib(25);
		System.out.println();
		System.out.println();
		
		//Question 03
		String s = "PleaseReverseMe";
		Question03 q3 = new Question03();
		q3.reverse(s);
		System.out.println();
		
		//Question 04
		int n = 7;
		Question04 q4 = new Question04();
		q4.factorial(n);
		System.out.println();
		
		//Question 05
		
		
		//Question 06
		Question06 q6 = new Question06();
		q6.checkEvenOrOdd(n);
		System.out.println();
		
		//Question 07
		Employee e1 = new Employee("Bob", "Sales", 37);
		Employee e2 = new Employee("John", "Recruiting", 49);
		Employee e3 = new Employee("Dave", "Sales", 29);
		
		ArrayList<Employee> empArr = new ArrayList<Employee>();
		empArr.add(e1);
		empArr.add(e2);
		empArr.add(e3);
		
		System.out.println("Unsorted Employee List: ");
		for(int i=0; i<empArr.size(); i++) {
			System.out.println(empArr.get(i));
		}
		
		Collections.sort(empArr, new CompareName());
		System.out.println("\nSorted by Name: ");
		for(int i=0; i<empArr.size(); i++) {
			System.out.println(empArr.get(i));
		}
		
		Collections.sort(empArr, new CompareDepartment());
		System.out.println("\nSorted by Department: ");
		for(int i=0; i<empArr.size(); i++) {
			System.out.println(empArr.get(i));
		}
		
		Collections.sort(empArr,  new CompareAge());
		System.out.println("\nSorted by Age: ");
		for(int i=0; i<empArr.size(); i++) {
			System.out.println(empArr.get(i));
		}
		
		//Question 08
		System.out.println();
		String [] str = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		Question08 q8 = new Question08();
		q8.findPalindromes(str);
		
		//Question 09
		System.out.println();
		Question09 q9 = new Question09();
		q9.addInts();
		
		//Question 10
		System.out.println();
		int a=17, b=11;
		Question10 q10 = new Question10();
		q10.findMin(a, b);
		System.out.println();
		
		//Question 11
		Question11 q11 = new Question11();
		float f1 = q11.getFloatOne();
		float f2 = q11.getFloatTwo();
		System.out.println("Float #1 from class Question11 is " + f1);
		System.out.println("Float #2 from class Question11 is " + f2);
		System.out.println();
		
		//Question 12
		Question12 q12 = new Question12();
		q12.storeNums();
		q12.printEvenNums(q12.nums);
		System.out.println();
		
		//Question 13
		Question13 q13 = new Question13();
		q13.printTriangle();
		System.out.println();
		
		//Question 14
		Question14 q14 = new Question14();
		//call the runSwitch() method with valid case numbers
		//q14.runSwitch(1);
		q14.runSwitch(2);
		//q14.runSwitch(3);
		System.out.println();
		
		//Question 15
		Question15 q15 = new Question15();
		q15.addition(5, 2);
		q15.subtraction(5, 2);
		q15.multiplication(5, 2);
		q15.division(10, 2);
		System.out.println();
		
		//Question 16
		
		
		//Question 17
		Question17 q17 = new Question17();
		//q17.calculateInterest();
		
		//Question 18
		System.out.println();
		Question18 q18 = new Question18();
		String str2 = "uppersAreHere";
		q18.checkUpperCase(str2);
		q18.convertLowerCase(str2);
		String numberString = "150";
		q18.convertToInteger(numberString);
		
		
		//Question 19
		System.out.println();
		Question19 q19 = new Question19();
		System.out.println("Integers in array list: ");
		q19.addAndDisplay();
		q19.addEvenOddIntegers();

	}

}
