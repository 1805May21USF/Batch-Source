var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

var result = 0;
if(n<=2){
    return n-1;
}

result = homework.fibonacci(n-1) + homework.fibonacci(n-2);
return result;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

    var length = array.length;

    //for loop to iterate through the array starting from the first number
		for (var i = 0; i < length - 1; i++)
		{	
			//for loop to iterate through the array starting from the second number
			for (var k = 0; k  < length -i-1; k++)
			{

				if (array[k] > array[k + 1])
				{
					//store the value of Array[k] in a temp
                    //swap the item in temp and the one in array[k] ()
					var temp = array[k];
					array[k] = array[k + 1];
					array[k+1] = temp;
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
homework.factorial = function(n){

    if(n == 0)
    {
        return 1;;
    }
    var answer;

    answer = homework.factorial(n - 1) * n;

    return answer;

};


/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {

    while( n --)
    {
        var temp = array.shift();
        array.push(temp)
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
homework.balancedBrackets = function(bracketsString){
 
    if(bracketsString.length <= 1)
    {
        return false;
    }

   var length = bracketsString.length;
   var lefts = ['(','[','{'];
   var rights = [')',']','}'];
   var stackarr = [];
   var same;
   var current;

   for (var i = 0; i < length; i++)
   {
       current = bracketsString[i];

       if(rights.indexOf(current) > -1)
       {
            same = lefts[rights.indexOf(current)];

            if(stackarr.length == 0 || (stackarr.pop() != same))
            {
                return false;
            }
        }
        else
        {
            stackarr.push(current);
        }
       
   }

   return (stackarr.length == 0);
};

