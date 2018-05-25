package com.revature.test;
import java.util.*;
public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GenericsTest<String> obj = new GenericsTest<String>("Hey!", "Bye!");
//		GenericsTest<Integer> osj = new GenericsTest<Integer>(5,6);
//		obj.showType();
//		osj.showType();
		
		//Collections
		List<String> collection = new ArrayList<String>();
		collection.add("zero");
		collection.add("one");
		
		List<String> fruits = new ArrayList<String>();
		Collections.addAll(fruits, "Apples", "Oranges", "Banana");
		fruits.forEach(System.out::println);
		
		//Iterator<String> iterator = collection.iterator();
		
//		while(iterator.hasNext()) {
//			System.out.println("value= " + iterator.next());
//		}
	}

}
