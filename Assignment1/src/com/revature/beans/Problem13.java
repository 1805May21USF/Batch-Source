package com.revature.beans;

public class Problem13 {
	
	public static void printTriangle(int i){
		boolean b = false;
		
		for(int j = 1; j <= i ; j++){
			for(int k = 0; k < j; k++ ){
				if(b == false){
					System.out.print("0 ");
					b = true;
				}else{
					System.out.print("1 ");
					b = false;
				}
			}
			System.out.println();
		}		
	}

}
