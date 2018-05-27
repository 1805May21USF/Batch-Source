package com.revature.same;
import java.util.ArrayList;

public class Prime {
	public static ArrayList<Integer> numbers;
	
	public Prime() {
		// TODO Auto-generated constructor stub
		this.numbers = new ArrayList<>();
		for(int i = 1; i <= 100; i++){
			numbers.add(i);
		}
	}
	
	public static ArrayList<Integer> prime(ArrayList<Integer> numbers){
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		primeNumbers.add(2);
		for(Integer number : numbers){
			Boolean isprime;
			if(number == 1 || number == 2 || number % 2 == 0){
				//System.out.println("");
			}else if(isPrime(number)) {
				primeNumbers.add(number);
			}
			else {
				continue;
			}
		}
		return primeNumbers;
	}
	
	public static Boolean isPrime(int num) {
		for(int i = 2; i < num; i++) {
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}

}
