package com.revature.corejava;

import java.util.Arrays;

public class driverHomeWork {
	
	public static void main(String[] args)
	{
		System.out.println("Question 1");
		Q1 myQ1 = new Q1();
		System.out.println(Arrays.toString(myQ1.getArray()));
		myQ1.bubbleSortArray();
		System.out.println(Arrays.toString(myQ1.getArray()));
		
		System.out.println(" ");
		System.out.println("Question 2");
		Q2 myQ2 = new Q2();
		myQ2.calcFirst25FibNumbers();
		System.out.println(Arrays.toString(myQ2.getArray()));
		
		System.out.println(" ");
		System.out.println("Question 3");
		Q3 myQ3 = new Q3();
		System.out.println(myQ3.getString());
		myQ3.reverseTheString();
		
		System.out.println(" ");
		System.out.println("\nQuestion 4");
		Q4 myQ4 = new Q4(5);
		myQ4.calcFactorialNumber();
		System.out.println(myQ4.getFactorialNumber());
		
		System.out.println(" ");
		System.out.println("Question 5");
		Q5 myQ5 = new Q5();
		System.out.println(myQ5.subString("Roll Tide", 4));
		
		System.out.println(" ");
		System.out.println("Question 6");
		Q6 myQ6 = new Q6();
		System.out.println(myQ6.EvenOrOdd(6));
		
		System.out.println(" ");
		System.out.println("Question 7");
		Q7 myQ7 = new Q7();
		System.out.println("Sort on Name");
		myQ7.sortOnName();
		myQ7.displayListOfEmployees();
		System.out.println("Sort on Department");
		myQ7.sortOnDepartment();
		myQ7.displayListOfEmployees();
		System.out.println("Sort on Age");
		myQ7.sortOnAge();
		myQ7.displayListOfEmployees();
		
		System.out.println(" ");
		System.out.println("Question 8");
		Q8 myQ8 = new Q8();
		myQ8.displayPalindromes();
		
		System.out.println(" ");
		System.out.println("Question 9");
		Q9 myQ9 = new Q9();
		myQ9.displayPrimeNumbers();
		
		System.out.println(" ");
		System.out.println("Question 10");
		Q10 myQ10 = new Q10();
		System.out.println(myQ10.minValue(8, 6));
		
		System.out.println(" ");
		System.out.println("Question 11");
		Q11 myQ11 = new Q11();
		myQ11.displayOtherPackageFloatNumbers();
		
		System.out.println(" ");
		System.out.println("Question 12");
		Q12 myQ12 = new Q12();
		myQ12.displayEvenNumbers();
		
		System.out.println(" ");
		System.out.println("Question 13");
		Q13 myQ13 = new Q13();
		myQ13.displayTheTriangle();
		
		System.out.println(" ");
		System.out.println("Question 14");
		Q14 myQ14 = new Q14();
		myQ14.displayThreeRequestedItems(1);
		myQ14.displayThreeRequestedItems(2);
		myQ14.displayThreeRequestedItems(3);
		
		System.out.println(" ");
		System.out.println("Question 15");
		Q15 myQ15 = new Q15();
		System.out.println(myQ15.addition(20, 10));
		System.out.println(myQ15.multiplication(4, 6));
		
		System.out.println(" ");
		System.out.println("Question 16");
		System.out.println(args[0]);
		Q16 myQ16 = new Q16();
		System.out.println(myQ16.countOfCharsInString(args[0]));
		
		System.out.println(" ");
		System.out.println("Question 17");
		Q17 myQ17 = new Q17();
		myQ17.calcIntrest();
		
		System.out.println(" ");
		System.out.println("Question 18");
		Q18 myQ18 = new Q18();
		if(myQ18.checkForUpperCaseChars("this is The string"))
			System.out.println("Found at least one uppercase");
		System.out.println(myQ18.convertCaseLowerToUpper("this string should be in all uppercase"));
		System.out.println(myQ18.convertStringToInteger("1500"));
		
		System.out.println(" ");
		System.out.println("Question 19");
		Q19 myQ19 = new Q19();
		myQ19.displayInitialArrayList();
		System.out.println(myQ19.addAllEvensInArrayList());
		System.out.println(myQ19.addAllOddsInArrayList());
		System.out.println(myQ19.removeAllPrimesInArrayList());
		
		System.out.println(" ");
		System.out.println("Question 20");
		Q20 myQ20 = new Q20();
		myQ20.formatedDisplayOfItemsFromFile();
		
	}

}
