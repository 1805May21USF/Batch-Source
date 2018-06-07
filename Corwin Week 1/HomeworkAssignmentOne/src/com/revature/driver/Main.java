/*----------------------------------------------------------------------------------
 * Name:Corwin Lester
 * 
 * Project: Homework Assignment 1
 * 
 * Desc: The main body of homework assignment one. No key inputs were coded
 * except when explicitly specified. This project was run with "fiver" as an argument
 * to the main function via ecplipse run configurations.
 * 
 * All question solution comments are in their respective question classes. 
 * 
 -----------------------------------------------------------------------------------*/

package com.revature.driver;

import java.util.ArrayList;
import java.util.Arrays;

import com.revature.questions.QuestionEight;
import com.revature.questions.QuestionEighteen;
import com.revature.questions.QuestionEleven;
import com.revature.questions.QuestionFifteen;
import com.revature.questions.QuestionFive;
import com.revature.questions.QuestionFour;
import com.revature.questions.QuestionFourteen;
import com.revature.questions.QuestionNine;
import com.revature.questions.QuestionNineteen;
import com.revature.questions.QuestionOne;
import com.revature.questions.QuestionSeven;
import com.revature.questions.QuestionSeventeen;
import com.revature.questions.QuestionSix;
import com.revature.questions.QuestionSixteen;
import com.revature.questions.QuestionTen;
import com.revature.questions.QuestionThirteen;
import com.revature.questions.QuestionThree;
import com.revature.questions.QuestionTwelve;
import com.revature.questions.QuestionTwenty;
import com.revature.questions.QuestionTwo;
import com.revature.util.Employee;

public class Main {
	
	public static String linebreak = "===================================================================================================================================";
	public static void main(String[] args) {
		
		//Question one, change variables to suit
		System.out.println(linebreak);
		QuestionOne q1 = new QuestionOne();
		System.out.println("Question One:");
		int[] toSort = {1,4,7,34,6,8,4,6};
		System.out.println(Arrays.toString(toSort));
		q1.run(toSort);
		System.out.println(Arrays.toString(toSort));
		System.out.println(linebreak);
		
		//Question two
		QuestionTwo q2 = new QuestionTwo();
		System.out.println("Question Two:");
		q2.run(25);
		System.out.println(linebreak);
		
		//Question three
		QuestionThree q3 = new QuestionThree();
		System.out.println("Question Three:");
		String s = "I know you wont read this Matt! Unless you do...";
		System.out.println(s);
		System.out.println(q3.run(s));
		System.out.println(linebreak);
		
		//Question four
		QuestionFour q4 = new QuestionFour();
		System.out.println("Question Four:");
		q4.run(4);
		System.out.println(linebreak);
		
		//Question Five
		QuestionFive q5 = new QuestionFive();
		System.out.println("Question Five:");
		System.out.println(q5.run("Wowedawg", 3));
		System.out.println(linebreak);
		
		//Question Six
		QuestionSix q6 = new QuestionSix();
		System.out.println("Question Six:");
		System.out.println(q6.run(6));
		System.out.println(linebreak);
		
		//Question Seven
		QuestionSeven q7 = new QuestionSeven();
		System.out.println("Question Seven: ");
		Employee[] employees = { 
							   new Employee("Jim Halpert","Sales", 28),
							   new Employee("Dwight Schrute","Public Relations",31),
							   new Employee("Claudia Reynolds","Human Resources",54)
							 };
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.addAll(Arrays.asList(employees));
		q7.run(emp);
		System.out.println(linebreak);
		
		//Question Eight
		QuestionEight q8 = new QuestionEight();
		System.out.println("Question Eight: ");
		String[] ar = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> words = new ArrayList<String>();
		words.addAll(Arrays.asList(ar));
		q8.run(words);
		System.out.println(linebreak);
		
		//Question Nine
		QuestionNine q9 = new QuestionNine();
		System.out.println("Question Nine: ");
		q9.run();
		System.out.println(linebreak);
		
		//Question Ten
		QuestionTen q10 = new QuestionTen();
		System.out.println("Question Ten: ");
		System.out.println(q10.run(11, 10));
		System.out.println(linebreak);
		
		//Question Eleven
		QuestionEleven q11 = new QuestionEleven();
		System.out.println("Question Eleven: ");
		q11.run();
		System.out.println(linebreak);
		
		//Question Twelve
		QuestionTwelve q12 = new QuestionTwelve();
		System.out.println("Question Twelve: ");
		q12.run();
		System.out.println(linebreak);
		
		
		//Question Thirteen
		QuestionThirteen q13 = new QuestionThirteen();
		System.out.println("Question Thirteen: ");
		q13.run();
		System.out.println(linebreak);
		
		//Question Fourteen
		QuestionFourteen q14 = new QuestionFourteen();
		System.out.println("Question Fourteen: ");
		q14.run();
		System.out.println(linebreak);
		
		//Question Fifteen
		QuestionFifteen q15 = new QuestionFifteen();
		System.out.println("Question Fifteen: ");
		q15.run();
		System.out.println(linebreak);
		
		//Question Sixteen
		QuestionSixteen q16 = new QuestionSixteen();
		System.out.println("Question Sixteen: ");
		try {
				q16.run(args[0]);
		}
		catch(Exception e) {
			System.out.println("You didn't provide a string argument to main!");
		}	
		System.out.println(linebreak);
		
		//Question Seventeen
		QuestionSeventeen q17 = new QuestionSeventeen();
		System.out.println("Question Seventeen: ");
		System.out.println(q17.run());
		System.out.println(linebreak);
		
		//Question Eighteen
		QuestionEighteen q18 = new QuestionEighteen();
		System.out.println("Question Eighteen: ");
		q18.run();
		System.out.println(linebreak);
		
		//Question Nineteen
		QuestionNineteen q19 = new QuestionNineteen();
		System.out.println("Question Nineteen: ");
		q19.run();
		System.out.println(linebreak);
		
		//Question Twenty
		QuestionTwenty q20 = new QuestionTwenty();
		System.out.println("Question Twenty: ");
		q20.run();
		System.out.println(linebreak);
	}

}
