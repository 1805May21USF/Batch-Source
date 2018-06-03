package com.revature.beans;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.JDBCBank.App;
import com.revature.exceptions.BadInputException;
import com.revature.implementdao.ImpUserDAO;
import com.revature.util.AppUtil;

public class SuperUser {
	private String username;
	private String password;
	private String name;
	
	/****Constructors************/
	public SuperUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuperUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.name = "Superman";
	}
	
	/****Methods*****************/
	/*
	 * Name: receiveSuperUserActions()
	 * Input:None
	 * Output:None
	 * Description: Prompts superuser on what they want to do
	 */
	public void receiveSuperUserActions() throws IOException, SQLException{
		int pick = -1;
		while(pick != 4) {
			System.out.print("What would you like to do "+this.name+"?\n"
					+ "1)Access a user account\n"
					+ "2)Delete a user account\n"
					+ "3)Create a user account\n"
					+ "4)Log Out\n");
			pick =  Integer.parseInt(App.sc.nextLine());
			try {
				switch(pick) {
					case 1:
						pickUserAccount().promptUser();
						break;
					case 2:
						deleteUserAccount();
						break;
					case 3:
						createUserAccount();
						break;
					default:
						throw new BadInputException();
				}
			}catch(BadInputException e) {e.getMessage();}
		}
		//return accounts;
	}
	
	/*
	 * Name: createUserAccount()
	 * Input:None
	 * Output:None
	 * Description: Creates a new user account
	 */
	public void createUserAccount() throws SQLException {
		AppUtil.register();
	}
	
	/*
	 * Name: deleteUserAccount()
	 * Input:None
	 * Output:None
	 * Description: Deletes a user account
	 */
	public void deleteUserAccount() throws SQLException {
		System.out.println("Username: ");
		String username = App.sc.nextLine();
		ImpUserDAO iud = new ImpUserDAO();
		iud.deleteUser(username);
		System.out.println("User has been deleted.");
	}
	
	/*
	 * Name: pickUserAccount()
	 * Input:None
	 * Output:User
	 * Description: Selects a user account
	 */
	public User pickUserAccount() throws SQLException {
		System.out.print("Username: ");
		String username = App.sc.nextLine();
		ImpUserDAO iud = new ImpUserDAO();
		return iud.getUserByUsername(username);
	}
	
	/****Getters+Setters***************************/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
