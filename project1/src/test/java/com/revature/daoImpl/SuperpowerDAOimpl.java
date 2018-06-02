package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Superhero;
import com.revature.dao.SuperheroDAO;
import com.revature.dao.SuperpowerDAO;
import com.revature.util.ConnFactory;

public class SuperpowerDAOimpl implements SuperpowerDAO {
	public static ConnFactory cf =ConnFactory.getInstance();

	@Override
	public void createSuperpower(String powerName) throws SQLException {
		//prepared statement
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "PowersId";
		String sql = "Insert into powers values(powseq.nextval,?)";
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, powerName);
		ps.executeUpdate();
		
	}


}
