package com.sunny.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LinkTool {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void linkAccount(int cid, int aid) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "INSERT INTO BANKLINKS VALUES(?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ps.setInt(2, aid);
		ps.executeQuery();
		ps.close();
	}

	public void deleteLinkCid(int cid) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "DELETE FROM BANKLINKS WHERE CID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ps.executeQuery();
		ps.close();
		con.close();
	}

	public void deleteLinkAid(int aid) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "DELETE FROM BANKLINKS WHERE AID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, aid);
		ps.executeQuery();
		ps.close();
		con.close();
	}

	public ArrayList<Integer> getCustomerLinks(int aid) throws SQLException{
		Connection con = cf.getConnection();

		String sql = "SELECT CID FROM BANKLINKS WHERE AID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, aid);
		ResultSet rs = ps.executeQuery();

		ArrayList<Integer> clist = new ArrayList<Integer>();

		while(rs.next()) {
			clist.add(rs.getInt(1));
		}
		rs.close();
		ps.close();
		con.close();
		return clist;
	}

	public ArrayList<Integer> getAcountLinks(int cid) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "SELECT AID FROM BANKLINKS WHERE CID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet rs = ps.executeQuery();

		ArrayList<Integer> alist = new ArrayList<Integer>();

		while(rs.next()) {
			alist.add(rs.getInt(1));
		}
		rs.close();
		ps.close();
		con.close();
		return alist;

	}

	public String getAccountType(int accid) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "SELECT ACCTYPE FROM BANKACCOUNTTYPE WHERE ACCID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, accid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String accType = rs.getString(1);
		rs.close();
		ps.close();
		con.close();
		return accType;

	}
}
