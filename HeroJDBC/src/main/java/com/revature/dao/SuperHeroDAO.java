package com.revature.dao;

import java.util.List;
import java.sql.SQLException;

import com.revature.beans.SuperHero;

public interface SuperHeroDAO
{
//CRUD operations
	public abstract void createSuperHero(String heroName) throws SQLException;
	public abstract List<SuperHero> getSuperHeroList() throws SQLException;
	
}
