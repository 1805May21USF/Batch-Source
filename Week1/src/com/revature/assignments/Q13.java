package com.revature.assignments;

public class Q13 {

	int lastPrinted = 1;
	
	
	public void printTriangle() {
		
		//if the lastPrinted number is 0 then print 1;
		//if the lastPrinted number is 1 then print 0;
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < i; j++ ) {
				if(lastPrinted == 0) {
					System.out.print(1);
					lastPrinted = 1;
				}
				else if(lastPrinted == 1) {
					System.out.print(0);
					lastPrinted = 0;
				}
			}
			System.out.println();
		}
		 
	}
	
}
