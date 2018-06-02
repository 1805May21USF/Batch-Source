package com.revature.beans;

import java.sql.SQLException;

import com.revature.daoImpl.SuperheroDAOimpl;

public class driver {
	public static void main(String[] args) {
		SuperheroDAOimpl s=new SuperheroDAOimpl();
		try {
			s.createSuperhero("El Hombre de UniPega");
			System.out.println(s.getSuperHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
