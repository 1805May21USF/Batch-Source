package com.revature.corejava;

public class Q13 
{
	private String mainString;
	
	public Q13()
	{
		this.mainString = "0 1 0 1";
	}
	//Creates the triangle output by using the mainstring and using substrings of it. Going through a loop and outputing a different substring for each iteration through the loop
	public void displayTheTriangle()
	{
		String tempString = "";
		for(int i = 0; i < 4; i++)
		{
			if(i == 0) {
				tempString = this.mainString.substring(0, 1);
			}
			if(i == 1) {
				tempString = this.mainString.substring(2, 5);
			}
			if(i == 2) {
				tempString = this.mainString.substring(2, 7);
			}
			
			if(i == 3) {
				tempString = this.mainString;
			}
			System.out.println(tempString);
		}
	}
}
