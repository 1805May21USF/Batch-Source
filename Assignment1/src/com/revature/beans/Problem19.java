package com.revature.beans;

import java.util.ArrayList;

/*Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.*/
public class Problem19 {
	ArrayList<Integer> iArray = new ArrayList<>();
	
	public Problem19(){
		for(int i = 1; i <= 10; i++){
			iArray.add(i);
		}
	}
	
	public void printSumOfEvenNumbersInArray(){
		int sum = 0;
		for(Integer i: iArray){
			if(i % 2 == 0){
				sum += i;
			}
		}
		System.out.println("The sum of even numbers in the array is: " + sum);
	}
	
	public void printSumOfOddNumbersInArray(){
		int sum = 0;
		for(Integer i: iArray){
			if(!(i % 2 == 0)){
				sum += i;
			}
		}
		System.out.println("The sum of odd numbers in the array is: " + sum);
	}
	
	public void removePrimeNumberFromArrayAndPrint(){
		for(int i = 0; i < iArray.size(); i++){
			if(isPrime(iArray.get(i))){
				iArray.remove(iArray.get(i));
				i--;
			}
		}
		System.out.println("The rest of the array is: " + iArray);
	}
	
	private static boolean isPrime(int n){
		if( n < 2){
			return false;
		}
		for(int i = 2; i < n; i++){
			if(n % i == 0 ){
				return false;
			}
		}
		return true;
	}

}
