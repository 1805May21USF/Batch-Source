package com.revature;

/**
 * @author Nicholas Smith
 *
 */
public class Reimbursement
{	
	/*
	 * For @param coverageType 
	 * 
	 * 1: University Courses: 80%
	 * 2: Seminar: 60%
	 * 3: Certification Preparation: 75%
	 * 4: Certification: 100%
	 * 5: Technical Training: 90%
	 * 6: Other: 30%
	 * 
	 * */
	
	/**
	 * Returns the reimbursement amount based on cost and selected 
	 * coverage type. 
	 * 
	 * @param cost          the cost of tuition
	 * @param coverageType	the type of reimbursement coverage
	 * 				
	 * @return				the reimbursement amount 	
	 */
	public double getReimbursement(double cost, int coverageType) 
	{
		//Create a local variable called reimbursement.
		double reimbursement = 0;
		
		//University Courses
		if(coverageType == 1) 
		{
			reimbursement = cost * 0.80;
		}
		//Seminar
		else if(coverageType == 2) 
		{
			reimbursement = cost * 0.60;
		}
		//Certification Preparation 
		else if(coverageType == 3) 
		{
			reimbursement = cost * 0.75;
		}
		//Certification
		else if(coverageType == 4) 
		{
			reimbursement = cost * 1;
		}
		//Technical Training
		else if(coverageType == 5) 
		{
			reimbursement = cost * 0.90;
		}
		//Other
		else if(coverageType == 6) 
		{
			reimbursement = cost * 0.30;
		}
		
		return reimbursement; 
	}
	
}
