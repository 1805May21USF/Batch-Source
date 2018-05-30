package com.revature.bank;

public class account implements java.io.Serializable {
		private String name;
		private int num;
		private double balance;
		public account(String name,int num, double balance) {
			super();
			this.num = num;
			this.balance = balance;
			this.name = name;
		}
		public boolean withdraw(double cash) {
			if(cash>this.balance) {
				return false;
			}else {
				balance = balance - cash;
				return true;
			}
		}
		public boolean deposit(double cash) {
			if(cash<=0) {
				return false;
			}else {
				balance = balance + cash;
				return true;
			}
		}
		public int getNum() {
			return num;
		}
		public String getName() {
			return name;
		}
}
