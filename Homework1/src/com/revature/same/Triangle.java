package com.revature.same;

public class Triangle {

	public Triangle() {
		// TODO Auto-generated constructor stub
		triangle();
	}
	
	public static void triangle() {
		//String binary = "0101010101";
		int x = 1;
		for(int i = 0; i <= 3; i++){
			x = binary(x);
			for(int j = 0; j <= i; j++){
				System.out.print(x);
				x = binary(x);
			}
			x = binary(x);
			System.out.println();
		}
	}
	
	public static int binary(int x) {
		if(x == 0)
			return 1;
		return 0;
	}

}
