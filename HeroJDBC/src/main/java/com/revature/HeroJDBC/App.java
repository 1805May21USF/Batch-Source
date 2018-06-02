package com.revature.HeroJDBC;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
        try {
			shdi.createSuperHero("One Punch Man");
			System.out.println(shdi.getSuperHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
