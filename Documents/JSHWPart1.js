
var myObject = {};

// Q1

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
myObject.fibonacci = function(f){
    if(f<=1){
        return f
    }
    return myObject.fibonacci(f-1) + myObject.fibonacci(f-2);
};


/*

//Q2
f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/

var f = ([2,4,5,1,3,1]);
myObject.sort = function(array){
    var sorted = false;
    
    for(j = 0;j<array.length-1;j++){
        for(i = 0;i<array.length-i-1;i++){
            if(array[i]>array[i+1]){
                var a = array[i];
                array[i]=array[i+1];
                array[i+1] = a;
                swap = true;
            }
        }
    }
    
    return array;
};

/*
//Q3

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
myObject.factorial = function(f){
    var sum = 1;
    for(i = 1;i<=f;i++){
        sum = sum * i;
    }
    return sum;
};

/*
//Q4
 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
myObject.rotateLeft = function(array,n){
    for(i = 0;i<n;i++){
        for(j = 0;j<array.length-1;j++){
            var c = array[j];
            array[j] = array[j+1];
            array[j+1] = c;
        }
    }
    return array;
};

//Q5
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
myObject.balanceBrackets = function(bracketsString){
    if(bracketsString.length % 2 != 0){
        return false;
    } else{
            var rev = bracketsString.split("");
            rev = rev.reverse();
            for(i = 0;i<rev.length;i++){
                var turned = false;
                if(rev[i] === "(" && !turned){
                    rev[i] = ")";
                    turned = true;
                }
                if(rev[i] === ")"  && !turned){
                    rev[i] = "(";
                    turned = true;
                }
                if(rev[i] === "{" && !turned){
                    rev[i] = "}";
                    turned = true;
                }
                if(rev[i] === "}" && !turned){
                    rev[i] = "{";
                    turned = true;
                }
                if(rev[i] === "[" && !turned){
                    rev[i] = "]";
                    turned = true;
                }
                if(rev[i] === "]" && !turned){
                    rev[i] = "[";
                    turned = true;
                }
            }
            rev = rev.join("");
            if(bracketsString === rev){
                return true;
            }
            return false;
        }
};