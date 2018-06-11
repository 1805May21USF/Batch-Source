
//Javascript Homework Part 1

var homework = {};

//Number 1
homework.fibonacci = function(n) {
    if(n <= 2) return 1;

    return this.fibonacci(n - 1) + this.fibonacci(n - 2);
};

//Number 2
var arr = [2, 4, 5, 1, 3, 1];
homework.sort = function(array) {
    var length = array.length - 1;
    var i, j, temp;

    for(i=0; i<length; i++) {
        for(j=0; j<length; j++) {
            if(array[j] > array[j+1]) {
                temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
};

//Number 3
homework.factorial = function(n) {
    if(n == 0) {
        return 1;
    } else {
        return (n * this.factorial(n - 1));
    }
};

//Number 4
var arr1 = [1, 2, 3, 4, 5];

homework.rotateLeft = function(array, n) {
    var front;
    for(var i=0; i<n; i++) {
        front = array.shift();
        array.push(front);
    }
    return array;
};

//Number 5
homework.balancedBrackets = function(bracketString) {
    var stack = [];
    var openBracket = {'(':')', '[':']', '{':'}'};
    var closedBracket = {')': true, ']': true, '}': true};

    for(var i=0; i<bracketString.length; i++) {
        var bracket = bracketString[i];
        if(openBracket[bracket]) {
            stack.push(bracket);
        } else if(closedBracket[bracket]) {
            if(openBracket[stack.pop()] !== bracket) return false;
        }
    }
    return stack.length === 0;
};