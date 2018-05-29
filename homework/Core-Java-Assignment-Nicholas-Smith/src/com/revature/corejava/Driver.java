/**
 * Test the classes. 
 */
package com.revature.corejava;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Nicholas Smith
 *
 */
public class Driver
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create objects for Classes Q1-Q20
		Q01 q01 = new Q01();
		Q02 q02 = new Q02();
		Q03 q03 = new Q03();
		Q04 q04 = new Q04();
		Q05 q05 = new Q05();
		Q06 q06 = new Q06();
		Q07 q07 = new Q07();
		Q08 q08 = new Q08();
		Q09 q09 = new Q09();
		Q10 q10 = new Q10();
		Q11 q11 = new Q11();
		Q12 q12 = new Q12();
		Q13 q13 = new Q13();
		Q14 q14 = new Q14();
		Q15 q15 = new Q15();
		Q16 q16 = new Q16();
		Q17 q17 = new Q17();
		Q18 q18 = new Q18();
		Q19 q19 = new Q19();
		Q20 q20 = new Q20();
		
		//sort q01
		q01.bubbleSort();
		//print the solution to the console
		q01.printSolution();
		
		//line break
		System.out.println("");
		
		//compute the first 25 Fibonacci numbers
		q02.fibonacciArray();
		//print the solution to the console
		q02.printSolution();
		
		//line break
		System.out.println("");
		
		//reverse the string
		String reversedString = q03.reverse("This String is being reversed.");
		//print the solution to the console
		q03.printSolution(reversedString);
		
		//line break
		System.out.println("");
		
		q04.factorial(5);
		q04.printSolution();
		
		//line break
		System.out.println("");
		
		String q05String = q05.subString("Trevor", 4);
		q05.printSolution(q05String);
		
		//line break
		System.out.println("");
		
		boolean isEven = q06.isEven(28);
		q06.printSolution(isEven);
		
		//line break
		System.out.println("");
		
		Employee e1 = new Employee();
		e1.setName("Smith");
		e1.setAge(28);
		e1.setDepartment("Finance");
		
		Employee e2 = new Employee();
		e1.setName("Turner");
		e1.setAge(31);
		e1.setDepartment("IT");
		
		//create an employee arrrayList that holds e1 and e2 
		ArrayList <Employee> empArr = new ArrayList<Employee>();
		
		empArr.add(e1);
		empArr.add(e2);
		
		System.out.println("Q7: unsorted" + empArr.toString());
		System.out.println("Q7: Sort by name:");
		System.out.println("Q7: unsorted");
		System.out.println("Q7: unsorted");
		
		//line break
		System.out.println("");
				
		System.out.println("Q8: Original array: " + q08.makeArray().toString());
		ArrayList<String> q08PalindromeArray = q08.makePalindromeArray();
		System.out.println("Q8: Palindrome array: " + q08PalindromeArray.toString());
		
		//line break
		System.out.println("");
		
		ArrayList<Integer> q09List = q09.makeArrayList();
		boolean prime = q09.isPrime(50);
		ArrayList<Integer> q09PrimeList = q09.makePrimeArrayList();
		System.out.println("Q9: Prime Array List: " + q09PrimeList.toString());
		
		//line break
		System.out.println("");
		
		int min = q10.findMin(85, 41);
		System.out.println("Q10: " + min);
		
		//line break
		System.out.println("");
		
		q11.printSolution();
		
		//line break
		System.out.println("");
		
		int[] intArray = q12.makeIntArray();
		int[] evenIntArray = q12.makeEvenIntArray(intArray);
		q12.printSolution();
		
		//line break
		System.out.println("");
		
		
	}
}
