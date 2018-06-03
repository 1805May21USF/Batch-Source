package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createUser(String userName, String firstName,
			String lastName, String password, int status) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USER_ID";
		String sql = 
				"INSERT INTO USER_ACCOUNT VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
			ps.setString(1, userName);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setInt(5, status);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User retrieveUser(String userName) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM USER_ACCOUNT WHERE user_account.USERNAME = '" + userName + "'");
		User user = null;

		if (rs.next()) {
			System.out.println("This user exists");
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
			return user;
		} else {
			System.out.println("User not found");
		}
		return null;
	}

	@Override
	public void updateUser() {

	}

	@Override
	public void deleteUser() {

	}

}
