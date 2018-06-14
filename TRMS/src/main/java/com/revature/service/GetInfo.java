                      package com.revature.service;

import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.UserDAOImpl;

public class GetInfo {
	
	private String[] arr;
	private UserDAOImpl udi;
	
	public GetInfo(String[] arr)
	{
		this.arr = arr;
		udi = new UserDAOImpl(arr);

	}
	
	public User getUser(String email)
	{
		try {
			User user = udi.retrieveUser(email);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


}
