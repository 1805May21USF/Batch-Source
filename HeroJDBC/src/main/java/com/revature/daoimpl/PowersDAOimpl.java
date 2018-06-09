package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;
import com.revature.dao.PowersDAO;
import com.revature.dao.SuperHeroeDAO;
import com.revature.util.ConnFactory;

public class PowersDAOimpl implements PowersDAO {
 //preparedStatement
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createSuperHero(String powerName) throws SQLException {
		// TODO Auto-generated method stub

	}

	

	public void createPower(String powerName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0]="PowerId";
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, powerName); // the 1 refers to the question mark  in the insert into
		ps.executeUpdate();
		}
	catch 
		(SQLException e){
			e.printStackTrace();
		
	}
	}
}
	
	

