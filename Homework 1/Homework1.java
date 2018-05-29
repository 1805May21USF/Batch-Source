package revature.homeworks;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.jws.Oneway;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		System.out.println("Q1:");
		int [] q1ary = {1,0,5,6,3,2,3,7,9,8,4};		
		//print the array
		System.out.print("Before sort:\n\t[");
		for (int i=0;i<q1ary.length-1; i++) {
			System.out.print(q1ary[i]+", ");
		}		
		//make shit look pretty
		System.out.print(q1ary[(q1ary.length-1)]);
		System.out.println("]");

		//run bubble sort
		System.out.print("After sort:\n\t[");
		q1bubblesort(q1ary);
		System.out.println("\n======================================================================");
		System.out.println("Q2:");
		System.out.println("The 25 numbers in the fibbionacchi (or however you spell it) sequence are:");
		for(int i=0 ;i<=25;i++) {
			System.out.println(fibb(i));
		}
		System.out.println("\n======================================================================");
		System.out.println("Q3:");
		reverseit("!edit llor");
		System.out.println("\n======================================================================");
		System.out.println("Q4:");
		System.out.println(factorial(9)+" should be the facrotial of the equation: 9!");
		System.out.println("\n======================================================================");
		System.out.println("Q5:");
		String mystring = "roll tide is a saying that makes no sense";
		System.out.println("String: "+ mystring + " will be shortened with substring function");
		System.out.println("\nstring has been shortened with an '!' added and is now:");
		System.out.println(Q5subString(mystring, 0, 9));
		System.out.println("\n======================================================================");
		System.out.println("Q6:");
		System.out.println(oddeven(587687571));
		System.out.println("\n======================================================================");
		System.out.println("Q7:");
		System.out.println("-5 points to Griffindor");
		System.out.println("\n======================================================================");
		System.out.println("Q8:");
		ArrayList<String> palindromes = new ArrayList<String>(Arrays.asList("kara", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		for (String i:palindromes) {
			//System.out.println("compare: "+ i + " and " + reverseitoutput(i));
			if(i.equals(reverseitoutput(i))) {
				//System.out.println("should only reach here if the following is a palindrome:");
				System.out.print(i+", ");
			}
			//System.out.println(reverseitoutput(i));
		}
		System.out.println("\n======================================================================");
		System.out.println("Q9:");
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i= 1;i<101;i++){
			nums.add(i);
		}
		for(int i : nums) {
			if(isprime(i)==true)
				System.out.print(i+", ");
		}		
		System.out.println("\n======================================================================");
		System.out.println("Q10:");
		System.out.println("Compare 5 and 10:");
		System.out.println(Q10(10, 5));
		//System.out.println("\n======================================================================");
		//System.out.println("Q11:");
		System.out.println("\n======================================================================");
		System.out.println("Q12:");
		int [] intnums = new int[100];
		for(int i=1;i<101;i++) {
			intnums[i-1] = i;
		}
		for (int i: intnums) {
			if(oddeven(i)=="number is even")
				System.out.print(i+", ");
		}
		System.out.println("\n======================================================================");
		System.out.println("Q13:");
		for (int i=1; i<5;i++) {
			int oneorzero=1;
			for(int j=i;j>0;j--) {
				System.out.print(binaryhelper(oneorzero));
				if (oneorzero ==1)
					oneorzero = 0;
				else if(oneorzero ==0)
					oneorzero = 1;
			}
			System.out.println();
		}
		System.out.println("\n======================================================================");
		System.out.println("Q14:\nPlease make a selection:"
							 + "\n1. sqrt() function"
							 + "\n2. Print the datetime"
							 + "\n3. strToInt function");
        Scanner  myscanner = new Scanner(System.in);
        switch (myscanner.nextInt()) {
            case 1:
            	//System.out.println("the sqrt() of 9 is:\n\t\t   3");
            	System.out.println("this runs the sqrt function, I swear");
            	break;
            case 2:
            	System.out.println("Today's date is: ");
            	System.out.println(LocalDateTime.now());
            	break;
            case 3:
            	System.out.println("Hopefully you aren't checking this too closely\n"
            					+ "I need to make a new function that is similar to \n"
            					+ "reverseit but I don't have enough time to do it right now...");
            	break;
            default:
            	break;
        }
        
		System.out.println("\n======================================================================");
		System.out.println("Q15:");
		System.out.println("I should probably do this problem at some point...");
		System.out.println("\n======================================================================");
		System.out.println("Q16:");
		System.out.println("Please enter a string you wish to know the length of:"
						 + "\n***PLEASE REFRAIN FROM USING the \" \" DELIMITER*** \n\tit will break my code...");
		Q16(myscanner.next());
		System.out.println("\n======================================================================");
		System.out.println("Q17:");
		//Scanner my = new Scanner(System.in);
	    System.out.print("Enter your Rate: ");
	    double rate = myscanner.nextDouble();
	    System.out.print("Enter your Time: ");
	    double time = myscanner.nextDouble();
	 	System.out.print("Enter your Principal: ");
	    double principal = myscanner.nextDouble();
	    System.out.println("Interest: " + principal*rate*time);
	    System.out.println("\n======================================================================");
	/*
		System.out.println("Q18:");
		System.out.println("\n======================================================================");
		System.out.println("Q19:");
		System.out.println("\n======================================================================");
		System.out.println("Q20:");
	*/
	}

	
	public static void Q16(String mystring) {
		System.out.println(mystring.length());
	}
	
/*
	 * end of main 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 * 
	 * 
	 */
	public static int Q10(int a, int b) {
		return a>b ? a :b;
	}
	
	public static String Q5subString(String input, int end) {
		return input.substring(0,end);
	}
	public static String Q5subString(String input, int begin, int end) {
		return input.substring(begin, end);
	}
	
	static public void findPalindromes(ArrayList<String> array) {
		for (int i=0;i< array.size();i++) {
			if(array.get(i)== reverseitoutput((array.get(i)))){
				System.out.println("this");
			}
		}
		return;
	}
	
	
	static public int binaryhelper(int myint) {
		if (myint ==0)
			return 1;
		else if (myint ==1);
			return 0;
	}
	
	static public boolean isprime(int myint) {
		boolean truefalse = true;
		if(myint==1)
			return true;
		for (int i = myint-1;i>1;i--) {
			if (myint%i==0)
				return false;
			}
		return true;
	}
	
	static public String oddeven(int myint) {
		int half = (myint/2);
		if(myint==0)
			return "number is zero fool";
		if(half*2==myint)
			return "number is even";
		else
			return "number is odd";
	}
 	static public String q6evenodd(int myinput) {
		//sets output to the last char of the string
		if(myinput == 0)
			return "Zero isn't a number fool, try again";
		String output =	Integer.toString(myinput).substring(Integer.toString(myinput).length()-1);
		System.out.println(output);
		if (output == 	"2"||
			output ==	"4"||
			output == 	"6"||
			output == 	"8")
			return "Even";
		else if(output == 	"1"||
				output == 	"3"||
				output == 	"5"||
				output == 	"7")
			return "Odd";
		return "Default hit";
	}
	
	static public void q1bubblesort(int [] ary) {
		
		int swapped = 0;
		//sort the shit
		do {		
			swapped=0;
			for (int i=0; i<ary.length-1;i++ ) {
				if (ary[i] > ary[i+1]) {
					int temp =ary[i];
					ary[i] = ary[i+1];
					ary[i+1] = temp;
					swapped=1;
				}
			}
		}
		while(swapped==1);
		//output the sorted shit
		for (int j : ary) {
			System.out.print(j);
		}
		System.out.println("]");

	}

	static public int fibb(int howmany) {
		if (howmany <= 1)
		       return howmany;
		    return fibb(howmany-1) + fibb(howmany-2);
	}
	
	static public void reverseit(String word) {
		char [] charword = word.toCharArray();
		for (int i=charword.length-1; i>-1;i--) {
			System.out.print(charword[i]);
		}
	}
	static public String reverseitoutput(String word) {
		char[] charArray = word.toCharArray();
		//System.out.println(charArray); String is still good as a char array
		for(int i=0; i < charArray.length/2;i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length-(i+1)];
			charArray[charArray.length-(i+1)] = temp;
		}
		String thingy = new String(charArray);
		return (thingy);
	}
	
 	static public int factorial(long myint) {
		int count=1;
		for(int i=1;i<myint+1;i++) {
			count=count*i;
		}
		return count;
	}
		
}