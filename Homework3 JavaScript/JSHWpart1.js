//JS HW, part 1: 

////Fill in the functions and submit them to your branch in a file called JSHWPart1.js
//gp
var homework = {};
/*

 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
if(n==0){return 0;}
if(n==1){return 1;}
if(n==2){return 1;}
var count = 2;
var x = 0;
var y = 1;
var z = 0;
while(count<=n){
    z = y + x;
    x=y;
    y=z;
    count++;
}
return z;
};
console.log(homework.fibonacci(3));
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
var array = [2,4,5,1,3,1];
homework.sort = function(array) {
var x = array.length;
var swapped = true;
while(swapped){
    swapped = false;
    for(var i = 1;i<x;i++){
        if(array[i-1]>array[i]){
            var temp = array[i];
            array[i]=array[i-1];
            array[i-1]=temp;
            swapped = true;
        }
    }
}
return array;
};
console.log(homework.sort(array));
/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
if(n-1==0){return 1;}
return n*homework.factorial(n-1);

};
console.log(homework.factorial(5));

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var count = 0;
    while(count<n){
        var temp = array[0];
        for(var i = 1;i<array.length;i++){
            array[i-1]=array[i];
        }
        array[array.length-1]=temp;
        count++;
    }
    
    return array;
};
console.log(homework.rotateLeft([1,2,3],2));

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
    var temp = bracketsString.length;
    var left = 0;
    var right = 0;
    for(var i = 0;i<temp;i++){
        var x = bracketsString.charAt(i);
        if(x=='('||x=='['||x=='{'){
            left++;
        }else if(x==')'||x==']'||x=='}'){right++;}
    }
    if(right==left){return true;}
    return false;
};
console.log(homework.balancedBrackets("([}}}}}}]))))(((()()()()"));


// YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
//(you dont understand matt. I am stackoverflow)
