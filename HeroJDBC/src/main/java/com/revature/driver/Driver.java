package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDAOimpl;

public class Driver {
	public static void main(String[] args) {
		
		SuperHeroDAOimpl shdi = new SuperHeroDAOimpl();
		
		try {
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getSuperHeroList());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
