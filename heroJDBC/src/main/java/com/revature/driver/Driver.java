package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDAOimpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperHeroDAOimpl shdi = new SuperHeroDAOimpl();
		
		try {
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
