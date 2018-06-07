package com.revature.beans;

import java.io.Serializable;
import java.util.Random;

public abstract class User{

		protected int ID;
		protected String userName;
		protected String passWord;
		protected boolean isAdmin = false;
		protected boolean isEmployee = false;
		protected boolean isCustomer = true;
		
		public User(String username,String passWord) {
			this.setID(0);
			
			this.setUserName(username);
			this.setPassWord(passWord);
		}
		public User(int i, String username,String passWord) {
			this.setID(i);
			
			this.setUserName(username);
			this.setPassWord(passWord);
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public boolean isAdmin() {
			return isAdmin;
		}
		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
		public boolean isEmployee() {
			return isEmployee;
		}
		public void setEmployee(boolean isEmployee) {
			this.isEmployee = isEmployee;
		}
		public boolean isCustomer() {
			return isCustomer;
		}
		public void setCustomer(boolean isCustomer) {
			this.isCustomer = isCustomer;
		}
		
		
}
