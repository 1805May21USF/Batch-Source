package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createPower(String powerName) {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "PowersID";
		String sql = "Insert into powers values (powseq.nextval,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql, primaryKeys);
			pstmt.setString(1, powerName);
		} catch (SQLException e) {
			System.out.println("Error in inserting powers: " + e.getMessage());
		}

	}

}
