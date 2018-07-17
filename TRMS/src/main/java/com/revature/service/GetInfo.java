package com.revature.service;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.beans.User;
import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.daoimpl.UserDAOImpl;

public class GetInfo {

	private String[] arr;
	private UserDAOImpl udi;
	private ReimbursementsDAOimpl rdi;

	public GetInfo(String[] arr) {
		this.arr = arr;
		udi = new UserDAOImpl(arr);
		rdi = new ReimbursementsDAOimpl(arr);
	}

	public User getUser(String email) {
		try {
			User user = udi.retrieveUser(email);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public boolean submitForm(String loc, String email, double amount, Timestamp eventStartDate, String desc, String type,
			String justy) {
		
		int cId = getCID(type);
		int userId = getUserId(email);
		int superUserId = getSuperUserId(2);
		try {
			rdi.createReimbursement(loc, amount, eventStartDate, desc, justy, cId, userId, superUserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public int getCID(String type)
	{
		
		try {
			
			return rdi.retrieveCoverageId(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	public int getUserId(String email)
	{
		
		try {
			
			return rdi.retrieveUserId(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
	public int getSuperUserId(int titleId)
	{
		
		try {
			
			return rdi.retrieveSuperUserId(titleId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	

}