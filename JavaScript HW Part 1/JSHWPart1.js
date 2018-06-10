var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    if (n <= 2) return 1;
    return this.fibonacci(n - 1) + this.fibonacci(n - 2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    var temp;
    var swapped;

    do {
        swapped = false;
        for (var i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = true;
            }
        }
    } while (swapped == true);

    return array;
};

console.log(homework.sort([2, 4, 5, 1, 3, 1]));

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function (n) {
    for (var i = n - 1; i > 0; i--) {
        n *= i;
    }
    return n;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    var temp;
    if (array.length == 1 || n < 1) return array;
    else {
        for (var i = n; i > 0; i--) {
            temp = array[0];
            for (var j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }
    }
    return array;
};

console.log(homework.rotateLeft([1, 2, 3, 4, 5], 1));
console.log(homework.rotateLeft([1, 2, 3, 4, 5], 3));
console.log(homework.rotateLeft([1, 2, 3, 4, 5], 6));

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
    if (bracketsString.length % 2 != 0) return false;
    for (var i = 0; i < bracketsString.length / 2; i++) {
        switch (bracketsString.charAt(i)) {
            case "(":
                if (bracketsString.charAt(bracketsString.length - i - 1) != ")") return false;
                break;
            case ")":
                if (bracketsString.charAt(bracketsString.length - i - 1) != "(") return false;
                break;
            case "{":
                if (bracketsString.charAt(bracketsString.length - i - 1) != "}") return false;
                break;
            case "}":
                if (bracketsString.charAt(bracketsString.length - i - 1) != "{") return false;
                break;
            case "[":
                if (bracketsString.charAt(bracketsString.length - i - 1) != "]") return false;
                break;
            case "]":
                if (bracketsString.charAt(bracketsString.length - i - 1) != "[") return false;
                break;
            default:
                console.log("Not a bracket. Your input is not roll tide.");
        }
    }
    return true;
};
//True
console.log(homework.balancedBrackets("()"));
console.log(homework.balancedBrackets("()()"));
console.log(homework.balancedBrackets("(())"));
console.log(homework.balancedBrackets("({[]})"));

//False
console.log(homework.balancedBrackets("("));
console.log(homework.balancedBrackets(")"));
console.log(homework.balancedBrackets("(()"));
console.log(homework.balancedBrackets("([)]"));
console.log(homework.balancedBrackets("([]{})"));
