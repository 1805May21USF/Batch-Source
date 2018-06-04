package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.SuperHero;
import com.revature.dao.SuperHeroDAO;
import com.revature.util.ConnFactory;

public class SuperHeroDAOImpl implements SuperHeroDAO {
	private static PreparedStatement statement, check;
	private static ConnFactory cf = ConnFactory.getInstance();

	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTSUPERHERO(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();

	}

	public List<SuperHero> getSuperHeroList() throws SQLException {
		Connection conn = cf.getConnection();
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		SuperHero s = null;
		try {
			check = conn.prepareStatement("Select * from superhero");

			ResultSet result = check.executeQuery();

			while (result.next()) {
				s = new SuperHero(result.getInt(1), result.getString(2));
				superHeroList.add(s);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return superHeroList;
	}

}
