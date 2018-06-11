var init = [0, 1];

function fibo(n){
    for(i = 2; i <= n; i++){
        init[i] = init[i-1] + init[i-2];
        var final = init[i];
    } 
    return final;
}

//var array = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];

// swap function helper
function swap(array, i, j) {
  var temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}

// be careful: this is a very basic implementation which is nice to understand the deep principle of bubble sort (going through all comparisons) but it can be greatly improved for performances
function bubbleSortBasic(array) {
  for(var i = 0; i < array.length; i++) {
    for(var j = 1; j < array.length; j++) {
      if(array[j - 1] > array[j]) {
        swap(array, j - 1, j);
      }
    }
  }
  return array;
}

//console.log(bubbleSortBasic(array.slice()));

function facto(n){
    var k =1;
    for (i=n; i>0; i--){
        k*=i
    }
    return k;
}

function rotate(n){
    var array = [1, 2, 3, 4, 5];
    for (i = 0; i < n; i++){
        array.push(array[0]);
        array.shift();
    }
    return array;
}


function balBrack(input){
    var temp = input.split("");

    if (temp.length % 2 == 0){
        
        for(i = 0; i < temp.length/2; i++){
            if (!check(temp[i], temp[temp.length-i-1])){
                //console.log(temp[i] + " " + temp[temp.size-i-1])
                //console.log("false compare")
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
function check(f, l){
    if ((f == "{" && l == "}") 
    ||(f == "}" && l == "{") || (f =="[" && l == "]") 
    || (f == "]" && l == "[") || (f == "(" && l == ")")){
        return true;
    }  
    else {
        return false;
    }
}