
var homework ={};
homework.fibonacci = function(n){
	if(n ===0)
		return 0;
	if(n=== 1)
		return 1;
	var x = [0,1];
	for(var i = 2; i<=n; i++)
	{
		x[i] = x[i-2] + x[i-1];
	}
	return x[n];	
}
array = [2,4,5,1,3,1];
homework.sort = function(array)
{
	var swapped = false;
	do
	{
		swapped = false;
		for(var i = 0; i<array.length -1; i++)
		{
			if(array[i] > array[i+1])
			{
				swapped = true;
				var temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
	}while(swapped)
	return array;
}

homework.factorial =function(n)
{
	if(n===0)
		return 1;
	var total = n;
	n= n-1;
	for(n; n>0; n--)
	{
		total = total * n;
	}
	return total;
}

var array=[1,2,3,4,5];
homework.rotateLeft = function(array, n)
{
	for(n;n>0;n--)
	{
		var x =array.shift();
		array.push(x);
	}
	return array;
}

var bracketsString = "({[]})";
homework.balancedBrackets = function(bracketsString)
{
	var initial = bracketsString.split("");
	var reverse = bracketsString.split("");
	var reverse = reverse.reverse();
	
	for(var i = 0; i<reverse.length; i++)
	{
		if(reverse[i] === '(')
		{
			reverse[i] = ')';
			continue;
		}
		if(reverse[i] === ')')
		{
			reverse[i] = '(';
			continue;
		}
		if(reverse[i] === '[')
		{
			reverse[i] = ']';
			continue;
		}
		if(reverse[i] === ']')
		{
			reverse[i] = '[';
			continue;
		}
		if(reverse[i] === '{')
		{
		reverse[i] = '}';
			continue;
		}
		if(reverse[i] === '}')
		{
			reverse[i] = '{';
			continue;
		}
	}
	
	for(var i =0; i< reverse.length; i++)
	{
		if(initial[i] != reverse[i])
			return false;
	}
	
	return true;
}