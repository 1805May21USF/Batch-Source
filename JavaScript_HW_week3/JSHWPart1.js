var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	if(n == 0)
		return 0;
	
	if(n == 1)
		return 1;
	
		return  homework.fibonacci(n - 1) + homework.fibonacci(n - 2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	var i, j;
	
	for(i = 0; i < array.length; i++){
		for(j = 0; j < array.length - (i+1); j++){
			if(array[j] > array[j+1]){
				var temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
		return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	if(n == 0 || n == 1)
		return 1;
	
	return (n * homework.factorial(n - 1));
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	var front;
	
	for(let i = 0; i < n; i++){
		for(let j = 0; j < array.length - 1; j++){
			front = array[j];
			array[j] = array[j + 1];
			array[j + 1] = front;
		}
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
	var stack = [];
	var isBalanced = false;
	var openBrackets = { '(': ')', '{': '}', '[': ']'};
	var closedBrackets = { ')': true, '}': true, ']': true};
	
		for(let i = 0; i < bracketsString.length; i++){	
			var chr = bracketsString[i];
			if(openBrackets[chr]){
				stack.push(chr);
			}else if(closedBrackets[chr]){
				if(openBracket[stack.pop()] !== chr)
					return isBalanced;
			}
		}
		
		return stack.length === 0;
};
