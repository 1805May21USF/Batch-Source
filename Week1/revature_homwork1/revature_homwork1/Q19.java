package revature_homwork1;

import java.util.ArrayList;

public class Q19 {
	public static ArrayList doit() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1;i<11;i++) {
			list.add(i);
		}
		System.out.println(list);
	
		int sum = 0;
		for (Integer i : list) {
			if (i%2==0) {
				sum += i;
			}
		}
		System.out.println("evens sum to: " + sum);
		sum = 0;
		for (Integer i : list) {
			if (i%2==1) {
				sum += i;
			}
		}
		System.out.println("odds sum to: " + sum);
		list.remove(9);//remove element 4, 6, 8, 10
		list.remove(7);
		list.remove(5);
		list.remove(3); 

		
	
		System.out.println(list);
		return list;
		
	}
	
}
