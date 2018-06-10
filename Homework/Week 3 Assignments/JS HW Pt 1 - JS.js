// JavaScript source code
// JS Pt 1 HW - JS

console.log("JS Homework Part 1");

// 1.
console.log("1. Return the nth Fibonacci number.");
var homework = {};

// 0 1 1 2 3 5 8 13 21 34 55 89 
homework.fibonacci = function (n) {
    
    var x = [];
    x[0] = 0;
    x[1] = 1;

    var i;
    for (i = 2; i <= n; i++) {
        
        x[i] = x[i - 1] + x[i - 2];
        
    }
    return x[n];
};
console.log("homework.fibonacci(0) = " + homework.fibonacci(0));
console.log("homework.fibonacci(1) = " + homework.fibonacci(1));
console.log("homework.fibonacci(10) = " + homework.fibonacci(10));

/* ------------------------------------------------------------------------------- */
// 2. 
console.log("2. Sort array of integers");

homework.sort = function (array) {
    var temp1;
    var temp2;
    var i = 0;
    var j;
    var count = 0;
    var message = "";

    // count is total times elements have been compared and not switched.
    // if all compared and not switched, then all in order.
    var max = 0;
   
    do {
        if (i != (array.length - 1)) {
            //console.log("array[" + i + "] = " + (array[i]));
            //console.log("array[" + i + " + 1] = " + (array[i + 1]));
            // if current element is bigger than next element, switch places
            if (array[i] > array[i + 1]) {
                // first store both elements into temp variables
                temp1 = array[i];
                temp2 = array[i + 1];
                // then switch location
                array[i] = temp2;
                array[i + 1] = temp1;
                // reset count back to 0 since numbers were switched.
                count = 0;
            }
            else {
                // this counts how many times not switched
                // meaning if each element is <= than next,
                //it will not be switched.
                // If all are not switched, it means all in order.
                count++;
            }
            //console.log("count: " + count);
            i++;
        }
        else {
            i = 0;
        }
        max++;
    } while (count != (array.length-1)); // 

    var k;
    for (k = 0; k < array.length; k++) {
        message += array[k] + " ";
    }

    console.log(message);
};
// f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
console.log("homework.sort([2, 4, 5, 1, 3, 1]) = ");
homework.sort([2, 4, 5, 1, 3, 1]);
console.log("homework.sort([5, 7, 9, 3, 1]) = ");
homework.sort([5, 7, 9, 3, 1])

// Break-Down of f([2,4,5,1,3,1]):
// Compare current element with next element
// 2<=4, 245131
// 4<=5, 245131
// 5<=1, no then switch 241531
// 5<=3, no then switch 241351
// 5<=1, no then switch 241315

// 2<=4, 241315
// 4=<1, no then switch 214315
// 4<=3, no then switch 213415
// 4<=1, no then switch 213145
// 4<=5, 213145

// 2<=1, no then switch 123145
// 2<=3, 123145
// 3<=1, no then switch 121345
// 3<=4, 121345
// 4<=5, 121345

// 1<=2, 121345
// 2<=1, no then switch 112345
// 2<=3, 112345
// 3<=4, 112345
// 4<=5, 112345

// 1<=1, 112345 T
// 1<=1, 112345 T
// 2<=3, 112345 T
// 3<=4, 112345 T
// 4<=5, 112345 T




/* ------------------------------------------------------------------------------- */
// 3. Return the factorial of n

homework.factor = function (n) {
    var i;
    var total = 1;

    for (i = n; i > 0; i--) {
        // i = 3; i > 0; i--, total = 1*3 = 3
        // i = 2; i > 0; 
        //console.log("i: " + i);
       // console.log("n: " + n);
        total = total * i;
        //console.log("total: " + total);
    }
    console.log(total);
};

console.log("homework.factor(5): ");
homework.factor(5);
console.log("homework.factor(4): ");
homework.factor(4);
console.log("homework.factor(3): ");
homework.factor(3);
console.log("homework.factor(2): ");
homework.factor(2);
console.log("homework.factor(1): ");
homework.factor(1);

// factorial breakdown: 4! 3! 2! 1!
/*
    5! = 5 * 4 * 3 * 2 * 1 = 120
    4! = 4 * 3 * 2 * 1     = 24
    3! = 3 * 2 * 1         = 6
    2! = 2 * 1             = 2
    1!                     = 1   
*/




// 4. Rotate left
console.log("4. Rotate left");

// Given array, rotate left n times and return array

// f([1,2,3,4,5], 1) = [2,3,4,5,1] 
    //...moved firstNum from index 1 to last index
    //...moved each number to the left once.

// f([1,2,3,4,5], 6) = [2,3,4,5,1] 
    // ...moved firstNum to the end, then to left until front is reached.
    // then once more to the end to make a total 6 moves.

// f([1,2,3,4,5], 3) = [4,5,1,2,3]
    // ...moved firstNum to the end and then moved 2 more times to the left.
    // this makes the total moves of 3.

homework.rotateLeft = function (array, n) {
    // array = [1,2,3,4,5]
    // n = 2
    
    //index 1 goes backwards 2

};
console.log("homework.rotateLeft(array, n): ");
console.log(homework.rotateLeft([1,2,3,4,5], 1));


// 5. Balanced Brackets
console.log("5. Balanced Brackets");
// A bracket is any one of the following: (, ), {, }, [, or ]

// The following are balanced brackets:
//    ()
//    ()()
//    (())
//    ({[]})

// The following are NOT balanced brackets:
// (
// )
// (()
// ([)]

// Return true if balanced
// Return false if not balanced
//*/

homework.balancedBrackets = function (bracketString) {
    //console.log(bracketString);
    var arr = [];
    // convert string to an array using split() method.
    arr = bracketString.split("");
    //console.log(arr);

    var brackLength = bracketString.length;
    console.log("length: " + brackLength);
    //console.log("length % 2: " + (brackLength % 2));
    //console.log((brackLength % 2 === 0));
    if ((brackLength % 2) === 0) {
        //console.log("Inside if: ");
        // Divide length by 2
        // Ex: if length is 6. Half is 3. 3 iterations.
        // Compare 1st and 6th.
        // Compare 2nd and 5th.
        // Compare 3rd and 4th.
        var i;
        var j;
        var partner;
        for (i = 0, j = brackLength - 1; i < brackLength / 2; i++ , j--) {
            if (arr[i] === "[") {
                partner = "]";
            }
            else if (arr[i] === "{") {
                partner = "}";
            }
            else if (arr[i] === "(") {
                partner = ")";
            }
            else {
                console.log("You are not a bracket.");
            }
            console.log(arr[i]);
            console.log(arr[j]);
            //console.log(arr[j] == partner);
        }
        console.log("true");
    }
    else {
        console.log("false");
    }
};
console.log("homework.balancedBrackets('{}'): ");
homework.balancedBrackets("{}");
console.log("homework.balancedBrackets('{[]}'): ");
homework.balancedBrackets("{[]}");
console.log("homework.balancedBrackets('()'): ");
homework.balancedBrackets("()");
console.log("homework.balancedBrackets('{[}'): ");
homework.balancedBrackets("{[}");
console.log("homework.balancedBrackets('()()'):");
homework.balancedBrackets("()()");



