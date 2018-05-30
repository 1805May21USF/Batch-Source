package com.revature.project_zero.beans;

public class User {

	private int userId;
    private String username;
    private String password;
    private String name;
    private int admin;

    public User(){
        
    }
    
    public User(String name, String username, String password){
    	name = this.name;
        username = this.username;
        password = this.password;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
    
    public void setAdmin(int admin) {
    	this.admin = admin;
    }
    
    public int getAdmin() {
    	return admin;
    }
}
