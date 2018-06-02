package com.revature.beans.driver;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDAOImpl;

public class Driver
{
	public static void main(String[] args) 
	{
		SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
		
		try 
		{
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getSuperHeroList());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
