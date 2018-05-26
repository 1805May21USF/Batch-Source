package com.revature.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorFun {
	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		
		list.addAll(Arrays.asList(2.5, 3.2, 4.5));
		
		Iterator<Double> it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}
}
