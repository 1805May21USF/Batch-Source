//Nicholas Smith

//create an object called homework
var homework = {};
//1. Return the nth fibonacci number
//create a function called homework.fibonacci
homework.fibonacci = function(n)
{
    //a fibonacci number is the sum of the two 
    //previous fibonacci numbers
    //Ex: 0, 1, 1, 2, 3, 5, 8, 13, 21, 44, 55, 99, ...

    //the formula for finding the nth fibonacci number is:
    //f(n) = f(n-1) + f(n-2)

    //use recursion
    //base case
    //f(0) = 0
    //f(1) = 1
    if (n <= 1) 
	    {
	    	return n;
	    }
	    else
	    {
	    	return homework.fibonacci(n-1) + homework.fibonacci(n-2);
	    } 

};

//2. Sort array of integers
homework.sort = function(array)
{
    	//create a var called length to store the length of the array 
		var length = array.length;
		
		//outer loop
        for (var i = 0; i < length-1; i++)
        {
        	//inner loop
        	for (var j = 0; j < length-i-1; j++) 
            {
        		//if the preceding element in the array is less than the next element
            	if (array[j] > array[j+1])
                {
                    //create a temp variable to hold the value of the element
                    var temp = array[j];
                    //assign the element at the jth index to the next element 
                    array[j] = array[j+1];
                    //assign the next element to the previous element
                    array[j+1] = temp;
                    //the elements are now swapped
                }
            }
        }  

        return array;
};

//3. Return the factorial of n
homework.factorial = function(n)
{
    //assign fac to 1
	var fac = 1;
		
	//loop over n times
	for (var i = 1; i < n + 1; i++)
	{
	    //factorial is equal to (1 * 2 * 3 * 4 ....)
	    fac = fac * i;
    }

    //return the factorial of n
    return fac;
}

//4. Rotate left

/*
 Given array, rotate left n times and return array
 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]
  */
 
  /**
   * element at index i becomes element at index i-n
   * element at index 4 becomes element at index 4-n
   * element at index 0 becomes element at index 0-n
   * 
   * element at index 0 becomes element at index 2 (4-2)
   * element at index 1 becomes element at index 3 (4-1)
   * element at index 2 becomes element at index 4 (4-0)
   * 
   */

homework.rotateLeft = function(array, n)
{
    //move each element in the array n indexes left

    //store the length of the array
    var length = array.length;

    //store a temp array by creating a NEW array
    var sortedArray = new Array(length);

    //create a variable for the biggest index
    var bigI = length - 1;

    //use a for loop
    for(var i = 0; i < length; i++)
    {
        //create a variable to hold the new index
        var newI = i - n;

        //if newI is negative, assign it to newI + length
        if(newI < 0)
        {
            //loop until newI is no longer negative
            while(newI < 0)
            {
                newI = length + newI;
            }
            
           //assign the element at newI in sortedArray to the element at index i in array
           sortedArray[newI] = array[i];

           //console.log("index " + i + " element " + array[i]);
           //console.log("new index " + newI + " element " + sortedArray[newI]);

        }
        //if newI is 0, keep it at 0
        else if (newI === 0)
        {
            //assign the element at newI in sortedArray to the element at index i in array
            sortedArray[newI] = array[i];
        }
        else if(newI > 0)
        {
            //assign the element at newI in sortedArray to the element at index i in array
           sortedArray[newI] = array[i];
        }
    }
    //return the rotated array
    return sortedArray;
}

//5. Balanced Brackets

/**
 * Look at the first bracket.
 * If it is a closing bracket, return false.
 * If it is an opening bracket, look at the next bracket.
 * If it is a closing bracket that doesn't match, return false.
 * If it is closing bra
 * 
 * 
 * 
 * 
 */

homework.balancedBrackets = function(bracketsString)
{
    //console.log("I am in the balancedBrackets function");

    //create an array of open brackets
    var openBracketArray = ["(", "{", "["];

    var closedBracketArray = [")", "}", "]"];

    //console.log(openBracketArray);
    //console.log(closedBracketArray);

    var openBracket;
    var closedBracket;

    var bracket;
    var nextBracket;
    var open;
    var closed;

    var index;

    //assign the first bracket from bracketsString to bracket
    var bracket = bracketsString.charAt(0);
    console.log(bracket);

    //assign index to the index where bracket is found
    var index = openBracketArray.indexOf(bracket);

    //if bracket matches one of the brackets from openBracketArray
    if(index >= 0)
    {
        //print the index of the bracket
        console.log(index);

        //Assign nextBracket to the next bracket in bracketsString
        var nextBracket = bracketsString.charAt(1);

        //find out which array bracket belongs to
        //either openIndex or closedIndex will be negative
        var openIndex = openBracketArray.indexOf(bracket);
        var closedIndex = closedBracketArray.indexOf(bracket);

        //use the index that isn't negative

        //if nextBracket is closed and matches the opening bracket
        if(index === openIndex)
        {
            
        }
        //if nextBracket is open
        else if()
        {

        }
        else 
        {
            return false;
        }
    }
    else if(index < 0)
    {
        return false;
    }

    return true;
}
