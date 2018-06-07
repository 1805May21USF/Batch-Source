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

homework.rotateLeft = function(array, n)
{
    //move each element in the array n indexes left
    //store a temp array
    sortedArray = array;

    //store the length of the array
    var length = tempArray.length;

    //use a for loop
    for(var i = 0; i < length; i++)
    {
        //print the index of the array 
        console.log(i + "is" + array[i]);

        sortedArray[i] = array[i+n];
    }

    //return the rotated array
    return tempArray;
}

//5. Balanced Brackets
