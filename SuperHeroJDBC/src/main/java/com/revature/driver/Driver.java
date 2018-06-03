package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoImpl.PowersDAOImpl;
import com.revature.daoImpl.SuperHeroDAOImpl;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDAOImpl sdao = new SuperHeroDAOImpl();
		PowersDAOImpl pdao = new PowersDAOImpl();
		
		try {
			sdao.createSuperHero("One Punch Man");
			System.out.println(sdao.getSuperHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
