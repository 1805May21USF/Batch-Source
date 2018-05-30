package com.revature.project_zero.BankingApp;

import java.util.ArrayList;

import com.revature.project_zero.beans.User;

public class Login {
	
	public Login() {
		
	}
	
	public int validateLogin(String username, String password) {
		boolean check = false;
		int level = 0;
		ArrayList<User> userList = new ArrayList<User>();
		
		for(int i = 0; i < userList.size(); i++) {
			
			if(userList.get(i).getUsername().equals(username)
				&& userList.get(i).getPassword().equals(password)){
					level = 1;
				}
				if(userList.get(i).getAdmin() == 1) {
					level = 2;
				}
				break;
		}
	
	return level;
}
    
    public void Signup(String customerName, String username, String password) {
    	ArrayList<User> userList = new ArrayList<User>();
    	
    	User user = new User();
    	user.setName(customerName);
    	user.setUsername(username);
    	user.setPassword(password);
    	userList.add(user);
    }
}
