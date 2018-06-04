package com.revature.utilities;

public class Question13 {
	public static void Q13() {
		int t = 1;
		for(int i = 0;i<=3;i++) //for 1-4 
			{ t = binary(t);
			//int lol=1;
			for(int j=0;j <=i;j++) //j=i -> 0
			{ System.out.print(t);
			t= binary(t);
			}
			t=binary(t);
			System.out.println();
				//function that prints a different 0 or 1 each time	
			}
		}
	
	public static int binary(int bin) {
		
		if(bin==0)
			return 1;
		else {
			
			return 0;
		}

	}}
	


	
	

