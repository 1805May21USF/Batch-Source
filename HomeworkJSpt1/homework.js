/**
 *  1. Return the nth fibonacci number
 */



function fibonacci(n) {
    var second_previous = 0;
    var frist_previous = 1;
    var total = 1;

    
    for (var i = 2; i <= n; i++) {
        total = frist_previous + second_previous;
        second_previous = frist_previous;
        frist_previous = total;
    }
    console.log(total);
};


/**
 *  2.  Sort array of integers
 */


function sort_the_array(new_array) {

    var temp = 0;
    for (var i = 0; i < new_array.length; i++) {
        for (var k = 1; k < new_array.length - i; k++) {
            if (new_array[k - 1] > new_array[k]) {
                temp = new_array[k - 1];
                new_array[k - 1] = new_array[k];
                new_array[k] = temp;
            }
        }
    }

    console.log(new_array)
}

/**
*  3. Return the factorial of n
*/

function factorial(n) {

    var factorial_total = 0;

    for (var i = factorial_number; i >= 1; i--) {
        factorial_total *= i;
    }

    console.log(factorial_total);
}

/**
*   4. Rotate left

 Given array, rotate left n times and return array

*/

function rotate_left(n) {

    var array = [4, 7, 8, 2, 9, 5, 3, 2, 4, 1];
    for (var i = n; i > 0; i--) {

        var shift = array.shift();
        array.push(shift);
    }
    console.log(array);
}


/**
*  5. Balanced Brackets
*/

function checking(i, j) {

    function balBrack(input) {
        var temp = input.split("");

        if (temp.length % 2 == 0) {

            for (i = 0; i < temp.length / 2; i++) {
                if (!check(temp[i], temp[temp.length - i - 1])) {
                    return false;
                }
            }
            return true;
        }
        else {
            //console.log("false size")
            return false;
        }

    }
    //result = fibo(4);
    function check(f, l) {
        if ((f == "{" && l == "}")
            || (f == "}" && l == "{") || (f == "[" && l == "]")
            || (f == "]" && l == "[") || (f == "(" && l == ")")) {
            return true;
        }
        else {
            return false;
        }
    }
}