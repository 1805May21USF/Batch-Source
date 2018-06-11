// JS HW, part 1: by Tiffany Tran
// June 5, 2018

// Fill in the functions and submit them to your branch in a file called JSHWPart1.js
// gp
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }
    return homework.fibonacci(n - 1) + homework.fibonacci(n - 2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    //Bubble sort! :)
    var flag = true;
    for (var i = 0; i < array.length && flag; i++) {
        var flag = false;
        for (var j = 0; j < array.length - i; j++) {
            if (array[j] > array[j + 1]) {
                var temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                flag = true;
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
homework.factorial = function (n) {
    if (n == 0) {
        return 1;
    }
    return n * homework.factorial(n - 1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    for (var i = 0; i < n; i++) {
        var tempValue = array[0];
        for (var j = 1; j < array.length; j++) {
            array[j - 1] = array[j];
        }
        array[array.length - 1] = tempValue;
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
homework.balancedBrackets = function (bracketsString) {

    var openb = ['[', '{', '('];
    var closingb = [']', '}', ')'];
    var stack = [];

    for (var i = 0; i < bracketsString.length; i++) {
        ch = bracketsString[i];
        // Store open brackets into the stack
        if (openb.indexOf(ch) > -1) {
            stack.push(ch);
        } else if (closingb.indexOf(ch) > -1) {
            //Check if there is an expected Bracket
            var expectedb = openb[closingb.indexOf(ch)];

            //If don't have, return false
            if (stack.length === 0 || (stack.pop() !== expectedb)) {
                return false;
            }

        } else {
            // Ignore the characters which do not match valid Brackets symbol
            continue;
        }
    }
    //If the stack is empty, return true

    return (stack.length === 0 ? true : false);

};


// YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)

