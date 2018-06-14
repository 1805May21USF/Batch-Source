package com.revature;

public class Driver
{

	public static void main(String[] args)
	{
		Reimbursement ri = new Reimbursement();
		double reimbursement = ri.getReimbursement(100, 8);
		
		System.out.println(reimbursement);
	}

}
