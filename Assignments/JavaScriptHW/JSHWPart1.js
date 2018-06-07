
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n) {
	var num = 1;
	var prevnum = 1;
	var prevprevnum = 1;
	
	if (n === 0) {
		return 0;
	} 
	if (n <= 2) {
		return 1;
    }
	for (var i = 2; i < n; i++) {
		num = prevnum + prevprevnum;
		prevprevnum = prevnum;
		prevnum = num;
	}
	return num;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	//bubble sort 
	var temp;
	while (true) {
		var swapped = false;
		for (var i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				swapped = true;
			}
		}
		if (swapped == false) {
			return array;
		}
	}
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	var num = 1;
	for (var i = n; i > 0; i--) {
		num = num * i;
	}
	return num;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	for (var i = n; i > 0; i--) {
		array.push(array.shift());
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

	for (var i = 0; i < bracketsString.length; i++) {
		if (bracketsString[i] === "(" || bracketsString[i] === "{" || bracketsString[i] === "[")
			stack.push(bracketsString[i]);
		else {
			var pop = stack.pop();
			switch (pop) {
				case "(":
					if (bracketsString[i] != ")")
						return false;
					break;
				case "{":
					if (bracketsString[i] != "}")
						return false;
					break;
				case "[":
					if (bracketsString[i] != "]")
						return false;
					break;
				default:
					stack.push(pop);
			}
		}
	}
	if (stack.length === 0)
		return true;
	return false;
};



