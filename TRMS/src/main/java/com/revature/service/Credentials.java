package com.revature.service;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.*;

public class Credentials {
	
	private String[] arr;
	private UserDAOImpl udi;
	
	public Credentials(String[] arr)
	{
		this.arr = arr;
		udi = new UserDAOImpl(arr);

	}
	
	public boolean register(String firstname, String lastname, String email, String password)
	{
		
		try {
			udi.createUser(firstname, lastname, email, password, 1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	public boolean loginVerification(String email, String password) throws SQLException
	{
		if(!udi.userExist(email)) {
			return false;
		}
		
		try {
			User user = udi.retrieveUser(email);
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			if (user.getEmail().equals(email) && user.getPassword().equals(password))
			{
				return true;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}
