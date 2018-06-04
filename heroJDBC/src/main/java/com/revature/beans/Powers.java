package com.revature.beans;

public class Powers {

		private int powersID;
		private String PowersName;
		
		
		
		public Powers(int powersID, String powersName) {
			super();
			this.powersID = powersID;
			PowersName = powersName;
		}


		public Powers() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getPowersID() {
			return powersID;
		}


		public void setPowersID(int powersID) {
			this.powersID = powersID;
		}


		public String getPowersName() {
			return PowersName;
		}


		public void setPowersName(String powersName) {
			PowersName = powersName;
		}
		
		
}
