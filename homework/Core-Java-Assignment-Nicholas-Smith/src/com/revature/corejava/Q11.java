/**
 * Write a program that would access two float-variables from a class that 
 * exists in another package. Note, you will need to create two packages 
 * to demonstrate the solution.
 * 
 * Completed: Yes
 */
package com.revature.corejava;

//import the Question11 class from the question11 package
import com.revature.corejava.question11.Question11;

/**
 * @author Nicholas Smith
 *
 */
public class Q11
{
	//create a new Question11 object named quest11
	Question11 quest11 = new Question11();
	
	//create a method that prints the solution to the problem
	public void printSolution() 
	{
		//get the float values from the Question11 class
		float f1 = quest11.getF1();
		float f2 = quest11.getF2();
		
		System.out.println("Q11: First float: " + f1);
		System.out.println("Q11: Second float: " + f2);
	}
}
