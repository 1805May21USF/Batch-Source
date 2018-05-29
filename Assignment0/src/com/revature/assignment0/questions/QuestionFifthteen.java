package com.revature.assignment0.questions;

import com.revature.assignment0.interfaces.QuestionFifthteenInterface;
import com.revature.assignment0.objects.DiceMan;

public class QuestionFifthteen implements QuestionFifthteenInterface {
	public void Question_Fifthteen(DiceMan obj) {
		
		System.out.println("\r------Question FifthTeen-------");
		System.out.println("15.) Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.\r");
		
		//Dice that is randomly generated that will be used in addition/subtraction/multiplication/division
		float dice_a = DiceMan.getQuestionFifthteenNumberA();
		float dice_b = DiceMan.getQuestionFifthteenNumberB();
		
		//The methods that were created in the abstract class being called in the derived class
		addition(dice_a, dice_b);
		subtraction(dice_a,dice_b);
		Multiplication(dice_a,dice_b);
		Division(dice_a,dice_b);
	}
	
	//Adding two numbers together
	public void addition(float x, float y) {
		float output = x + y;
		System.out.println("\"" + x + " + " + y + "\" = " + output);
	}
	
	//Subtracting two numbers together
	public void subtraction(float x, float y) {
		float output = x - y;
		System.out.println("\"" + x + " - " + y + "\" = " + output);
	}

	//Multiplying two numbers together
	public void Multiplication(float x, float y) {
		float output = x * y;
		System.out.println("\"" + x + " + " + y + "\" = " + output);
	}

	//Dividing two numbers together
	public void Division(float x, float y) {
		float output = x / y;
		System.out.println("\"" + x + " + " + y + "\" = " + output);
	}
}
