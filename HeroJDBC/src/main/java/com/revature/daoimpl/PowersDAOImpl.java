package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createPower(String powerName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1]; //column number
		primaryKeys[0] = "PowersID";
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, powerName);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
