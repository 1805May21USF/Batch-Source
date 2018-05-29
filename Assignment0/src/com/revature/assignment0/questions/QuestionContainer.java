package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;
import com.revature.assignment0.objects.QuestionSevenEmployees;
import com.revature.assignment0.sorting.Question_Seven_SortByName;

public class QuestionContainer {
	public static void main(String[] args) {
		//Everything below uses that static methods to call the problem and complete it
		
		QuestionOne.Question_One();
		QuestionTwo.Question_Two();
		QuestionThree.Question_Three();
		QuestionFour.Question_Four();
		
		QuestionFive question_5 = new QuestionFive();
		question_5.Question_Five();
		
		QuestionSix.Question_Six();
		
		List<QuestionSevenEmployees> employees = new ArrayList<QuestionSevenEmployees>();
		employees.add(new QuestionSevenEmployees("Robert","Accounting",(byte)30));
		employees.add(new QuestionSevenEmployees("Jake","IT",(byte)40));
		employees.add(new QuestionSevenEmployees("Avail","Sales",(byte)60));
		QuestionSeven.Question_Seven(employees);
		
		QuestionEight.Question_Eight();
		QuestionNine.Question_Nine();
		QuestionTen.Question_Ten();
		QuestionEleven.Question_Eleven();
		QuestionTwelve.Question_Twelve();
		QuestionThirteen.Question_Thirteen();
		QuestionFourteen.Question_Fourteen();
		
		QuestionFifthteen question_15 = new QuestionFifthteen();
		question_15.Question_Fifthteen(new DiceMan());

		QuestionSixteen.Question_Sixteen(args);
		QuestionSeventeen.Question_Seventeen();
		
		QuestionEighteen question_18 = new QuestionEighteen();
		question_18.Question_Eighteen();
		
		QuestionNineteen.Question_Nineteen();
		QuestionTwenty.Question_Twenty();
	}
}
