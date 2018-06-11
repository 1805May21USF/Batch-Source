//--------------- 1 -----------------

function fibonacci(num)
{
    var a =1;
    var b = 0;
    var temp; //for switching the values
    
    while(num >= 0)
    {
        temp = a;
        a = a +b;
        b = temp;
        num--;
    }
    
    return b;
    
}


//--------------- 2 -----------------

var arry = [2,4,5,1,3,1];

var size = arry.length();

function sort(arr, n)
{
    if(n==1)
    {
        return;
    }
    
    for(int i=0; i <n-1; i++)
    {
        switch(arr[i], arr[i+1]);
    }
            
    sort(arr, n);
}




//--------------- 3 -----------------
//recursive

function fac(x)
{
    var product=1;
    for(var j=1; j<=x; j++)
    {
        product *= j;
    }
    return product;
}




//--------------- 4 -----------------
function rotate(arr, n) 
{
    for (var i = 0; i < n; i++) 
    {
        for (var j = arr.length - 1; j > 0; j--) 
        {
            var temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
        }
    }
    return arr;
}



//--------------- 5 -----------------


