package com.revature.hw1;

public class P13PyramidSchemeHaha {
	public static void pyramidify() {
		char wha = '0';
		int i = 0;
		int numitems = 0;
		//switches number w ternary every print
		while(i < 4) {
			for(int k = 0; k <= numitems; k++) {
				System.out.print(wha+" ");
				wha = (wha == '1') ? '0' : '1';
			}
			i++;
			numitems++;
			System.out.println("");
		}
	}
}
