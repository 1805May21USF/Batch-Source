var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
console.log("here: ");
homework.fibonacci = function(n){
	if(n <= 2)
		return 1;
	return homework.fibonacci(n-1) + homework.fibonacci(n-2); 
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	var i; var j;
	for(i = 0; i < array.length; i++) {
			for(j = 0; j < array.length-i-1; j++) {
				var first = array[j]; var second = array[j+1];
				if(first > second) {
					var temp = first;
                    array[j] = second;
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
	if(n == 0){
			return 1;
		}
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
	if(n == 0){
		return array;
	}

	var temp = array[0];
	for(j = 0; j < array.length-1; j++){
		array[j] = array[j+1];
	}
	array[array.length-1] = temp
	return homework.rotateLeft(array, n-1);
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
	var left = "([{"; var right = ")]}"
	var array = [];

	for(index in bracketsString){
		 for(i = 0; i < left.length; i++){
		 	var bracket = bracketsString.charAt(index);
		 	var fromLeft = left.charAt(i);
		 	var fromRight = right.charAt(i);
			if(bracket == fromLeft){
				array.push(bracketsString.charAt(index));
			}else if(bracket == fromRight){
				var getPop = array.pop();
				console.log(bracket + getPop);
				if((bracket == "(" && getPop == ")" || bracket == "{" && getPop == "}" || bracket == "[" && getPop == "]")){
					return true;
				}
			}

		}
	}
	return false;
};

console.log(homework.balancedBrackets("({[]})"));