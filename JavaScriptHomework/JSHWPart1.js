/*
*
* @author Kaleb Martin
* @Date 6/11/2018
* @Assign JavascriptHomework2
*
*/

//return the fibonnaci number at the nth position
var homework = {}


 homework.fibbonaci = function(n) {
    var arr = [];
    arr[0] = 0;
    arr[1] = 1;
    for (var i = 2; i < n; i++) {
        arr[i] = arr[i-2] + arr[i-1];
        
    }
    return arr[n-1];
}


//question 2 sort the array ascending
var arr = [2, 4, 5, 1, 3, 1];
homework.sort = function(arr) {
    var temp;

    //ch
    for (var i = 0; i < arr.length; i++) {
        for (var j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j+1]) {
                temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    console.log(arr);
}

//question 3 return the factorial of n
homework.factorial = function(n) {

    var total = 1;

    for (var i = 1; i <= n; i++) {
        total *= i;
    }

    return total;
}

//question 4 array shift

homework.shiftArray = function(n) {

    var arr = [1, 2, 3, 4, 5];
    var temp = 0;
    //get the remainder of n/5 to cut down on the number of operations
    n = n % 5;

    if(n != 0){
    for (i = 1; i <= n; i++) {
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = arr[3];
        arr[3] = arr[4];
        arr[4] = temp;
        
         }
    }

    return arr;
}

//Question 5 balanced brackets
 homework.balancedBrackets = function(bracketString) {
    var leftSideTotal = 0;
    var RightSideTotal = 0;
    var length = bracketString.length / 2 - 1;

    console.log(length);
    if (bracketString.length % 2 == 1) {
        return false;
    }

    else {
        for (var i = 0; i <= length; i++) {
            if(bracketString.charAt(i) == '('){
                leftSideTotal += 1;
            }
            else if (bracketString.charAt(i) == '[') {
                leftSideTotal += 2;
            }
            else if (bracketString.charAt(i) == '{') {
                leftSideTotal += 3;
            }
            else {
                return false;
            }
           
                  for (var j = i; j <= i ;j++){
                      if (bracketString.charAt(bracketString.length - 1 - j) == ')') {
                          RightSideTotal += 1;
                      }
                      else if (bracketString.charAt(bracketString.length - 1 - j) == ']') {
                          RightSideTotal += 2;
                      }
                      else if (bracketString.charAt(bracketString.length -1 - j) == '}') {
                          RightSideTotal += 3;
                      }
                      else {
                          return false;
                      }
                      
                  }

                  if (leftSideTotal == RightSideTotal) {
                      continue;
                  }
                  else {
                      return false;
                  }

        }
        return true;
    }
    
}

