/*JS HW, part 1: 

Fill in the functions and submit them to your branch in a file called JSHWPart1.js
*/

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    /*
var first = 0;
var second = 1;
var result;
for (var i = 1; i < n; i++) {
    result = first + second;
    first = second;
    second = result;
}
*/
if (n <= 1) {return n;}
return homework.fibonacci(n - 2) + homework.fibonacci(n - 1);
};
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    var highestPos;
    var temp;
    for (var i = 0; i < array.length; i++) {
        highestPos = i;
        for (var j = i + 1; j < array.length; j++) {
            if (array[highestPos] > array[j]) { highestPos = j; }
        }
        temp = array[i];
        array[i] = array[highestPos];
        array[highestPos] = temp; 
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
    if (n == 0) { return 1; }
    return n * homework.factorial(n - 1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var returnArray = [];
    while(n > array.length) {
        n-=array.length;
    }
    for (i = 0; i < array.length; i++) {
        if (i - n < 0) {
            returnArray[array.length + i - n] = array[i];
        }
        else { returnArray[i - n] = array[i]; }
    }
return returnArray;
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
    if (bracketsString.length % 2 === 1) {return false;}
    bracketsString;
    for (var left= 0; left < bracketsString.length; left++) {
        var right = bracketsString.length - 1 - left;
        if (right <= left) {return true;}
        var rightchar = bracketsString.charAt(right);
        var leftchar = bracketsString.charAt(left);
        if (
        (leftchar === '(' && rightchar !== ')') || 
        (leftchar === '[' && rightchar !== ']') || 
        (leftchar === '{' && rightchar !== '}'))
        { return false; }
    }

};