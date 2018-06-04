package com.revature.driver;

import com.revature.daoimpl.SuperHeroDAOImpl;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();

		try {
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getSuperHeroList());
		} catch (Exception ex) {
			System.out.println("Error in main method: " + ex.getMessage());
		}
	}

}
