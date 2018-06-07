var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	//Returns 0 if n is 0
	if(n==0)
		return 0;
	//Returns 1 if n is 1
	if(n==1)
		return 1;
	
	//Returns the result of recursively adding the values of n-1 and n-2
	return homework.fibonacci(n-1)+homework.fibonacci(n-2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	//Temporary values to store the index of the smallest value of an array and the current array value
	var min;
	var temp;
  
	//Loops through the array in order to sort it
	for(var i=0; i<array.length; i++){
		//Assigns the current value of i to the min variable
		min=i;
		//Loops through the elements of array after i
		for(var j=i+1; j<array.length; j++){
			//If the element at index j is smaller than the element at index min, min becomes equal to j
			if(array[j]<array[min]){
				min = j;
			}
		}
		//Swaps the elements at index i with the element at index min
		temp=array[i];
		array[i]=array[min];
		array[min]=temp;
	}
	// Returns the array
	return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	//Returns 1 if n equals 0
	if(n==0)
		return 1;
	//Returns the result of multiplying n with the returned value of a recursive call of n-1
	return n * homework.factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	// Creates a temporary variable to store the array element
	var temp;
	
	//Executes n amount of times
	for(var i=0; i<n; i++){
		//Retrieves the first element of array
		tempOne=array[0];
		
		//Moves each element of the array left by one
		for(var j=0; j<array.length-1; j++){
			array[j]=array[j+1];
		}
		
		//Assigns the element in temp to the last index of array
		array[array.length-1]=tempOne;
	}
	
	return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	//Creates an array to store open brackets
	var openBrackets = [];
	
	/*Return false if the String is empty, if the String's length is an odd number, 
	  or the first character is a closed bracket*/
	if(bracketsString.length==0)
		return false;
	if(bracketsString.length%2==1)
		return false;
	if(bracketsString.charAt(0)==']' || bracketsString.charAt(0)=='}' || bracketsString.charAt(0)==')')
		return false;
	
	//Goes through the String one character at a time
	for(var i=0; i<bracketsString.length; i++){
		//If the character is an open bracket, the bracket is added to the end openBrackets
		if(bracketsString.charAt(i)=='[' || bracketsString.charAt(i)=='{' || bracketsString.charAt(i)=='('){
			openBrackets.push(bracketsString.charAt(i));
		}
		else{
		//Returns false if the closed bracket doesn't match with the latest open bracket(ie. [})
			if(bracketsString.charAt(i)==']'){
				//Retrieves the last element of the openBrackets array and deletes it
				if(openBrackets.pop()!='[')
					return false;
			}
			if(bracketsString.charAt(i)=='}'){
				if(openBrackets.pop()!='{')
					return false;
			}
			if(bracketsString.charAt(i)==')'){
				if(openBrackets.pop()!='(')
					return false;
			}
		}
	}
	
	// Returns true if no errors were encountered
	return true;
};
