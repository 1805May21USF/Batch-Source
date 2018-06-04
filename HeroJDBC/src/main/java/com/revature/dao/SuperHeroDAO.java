package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;

public interface SuperHeroDAO {
//CRUD Operations
	public abstract void createSuperHero(String heroname)throws SQLException;
	public abstract List<SuperHero> getSuperHeroList() throws SQLException;
	
}
