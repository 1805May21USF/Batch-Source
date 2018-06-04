package com.revature.driver;

import revature.com.daoimpl.SuperHeroDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
		try {
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getSuperHeroList().toString());
		} catch (Exception e) {
			
		}	
	}
}
