var homework = {}

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	var arr = [];
	arr[0] = 1;
	arr[1] = 1;
	var i;
	for(i = 2; i<n; i++) {
		arr[i] = arr[i-1]+arr[i-2];
	}
	return arr[i-1];
};	

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	var len = array.length;
	var notdone = true;
	var temp;
	
	while(notdone)
	{
		//if it doesn't swap at all, it's done
		notdone = false;
		for(var i = 0; i < len-1; i++) {
			if(array[i] > array[i+1]) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1]= temp;
				notdone = true;
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
	var fact = 1;
		
	for(var i = n; i >= 1; i--)
	{
		fact *= i;
	}
	
	return fact;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	//Simplifies the amount of rotations
	n=n%array.length;
	var arrFinal = array.slice(n, array.length).concat(array.slice(0,n));
	return arrFinal;
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
	var openBrackets = ["{", "[", "("];
	if(!bracketsString.length%2){
	 	return false;
	}else{
		var saveMe = [];
		for(var i = 0; i < bracketsString.length; i++){
			if(bracketsString[i] === openBrackets[0] ||
				bracketsString[i] === openBrackets[1] ||
				bracketsString[i] === openBrackets[2]){
				saveMe.push(bracketsString[i]);
			}else{
				if(bracketsString[i] === "}" && openBrackets[0]=== saveMe.pop()){}
				else if(bracketsString[i] === "]" && openBrackets[1]=== saveMe.pop()){}
				else if(bracketsString[i] === ")" && openBrackets[2] === saveMe.pop()){}
				else{
					return false;
				}
			}
		}
	}
	if(saveMe.length > 0){return false;}
	else{return true;}
};