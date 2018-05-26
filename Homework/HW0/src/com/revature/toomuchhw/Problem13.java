package com.revature.toomuchhw;
//Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
/*0
1 0
1 0 1
0 1 0 1
*/
public class Problem13 {
	private int levels;
	
	
	public Problem13(int levels) {
		super();
		this.levels = levels;
	}


	public void printTriangle() {
		int count = -1;
		for(int i = 1; i <= levels; i++) {
			for(int j = 0; j < i; j++) {
				count+=1;
				System.out.print((count%2)+" ");
			}
			System.out.println();
		}
	}

}
