var homework = {};

homework.fibonacci = function(n){
    if(n<=1){
        return n
    }
    return homework.fibonacci(n-1) + homework.fibonacci(n-2);
};

homework.sort = function(array){
    var isSorted = false;
    while(!isSorted){
        var didSwap = false;
        for(i = 0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                var a = array[i];
                array[i]=array[i+1];
                array[i+1] = array[i];
                didSwap = true;
            }
        }
        if(didSwap){
            isSorted = true;
        }
    }
    return array;
};

homework.factorial = function(n){
    var sum = 1;
    for(i = 1;i<=n;i++){
        sum = sum * i;
    }
    return sum;
};

homework.rotateLeft = function(array,n){
    for(i = 0;i<n;i++){
        var c = array[0];
        for(j = 0;j<array.length-1;j++){
            var c = array[j];
            array[j] = array[j+1];
            array[j+1] = c;
        }
    }
    return array;
};

homework.balancedBrackets = function(bracketsString){
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

homework.getUSA = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('*');
    for(i = 0; i < allElements.length;i++){
        if(allElements[i].getAttribute("data-customAttr")==="USA"){
            elements.push(allElements[i]);
        }
    }
    console.log(elements[0].innerHTML);
};

homework.getPeopleInSales = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('td');
    for(i = 0; i < allElements.length;i++){
        if(allElements[i].innerHTML === "Sales"){
            console.log(allElements[i-1].innerHTML);
        }
    }
};

homework.getAnchorChildren = function(){
    var elements = [];
    var allElements = document.getElementsByTagName("span");
    for(i = 0;i<allElements.length;i++){
        console.log(allElements[i].innerHTML);
    }
}

homework.getSkills = function(){
   var elements = [];
   var allElements = document.getElementsByName("skills")[0].children;
   for(i = 0;i<allElements.length;i++){
       if(allElements[i].getAttribute("selected")==="selected"){
            console.log(allElements[i].innerHTML);
        }
   }
};

homework.getCustomAttribute = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('*');
    for(i = 0; i < allElements.length;i++){
        if(allElements[i].getAttribute("data-customAttr")!=null){
            console.log(allElements[i].getAttribute("data-customAttr"));
            console.log(allElements[i]);
        }
    }
};

document.getElementById("num1").setAttribute("onchange","homework.OnChangeSum()");
document.getElementById("num2").setAttribute("onchange","homework.OnChangeSum()");
homework.OnChangeSum = function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("sum");
    var sum = parseInt(num1)+parseInt(num2);
    if(isNaN(sum)){
        sum = "Result could not be added!";
    }
    result.innerHTML = sum;
};

var allElements = document.getElementsByName("skills")[0].children;
for(i = 0;i<allElements.length;i++){
    allElements[i].setAttribute("onselected","homework.OnSelectSkills()");
}
homework.onSelectSkills = function(){

};



