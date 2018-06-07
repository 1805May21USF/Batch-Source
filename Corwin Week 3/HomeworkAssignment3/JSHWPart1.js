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

var allElements = document.getElementsByName("skills");
allElements[0].setAttribute("onchange","homework.onSelectSkills(event)");
homework.onSelectSkills = function(event){
    alert("Are you sure "+event.target.value+" is one of your skills?");
};



var oldvalue = null;
var newvalue = "red";
homework.onClickRadio = function(event){
    oldvalue = newvalue;
    newvalue = event.target.value;
    alert("so you like " +newvalue+" more than "+oldvalue+" now?");
};
var allElements = document.getElementsByName("favoriteColor");
for(var i = 0;i<allElements.length;i++){
    allElements[i].setAttribute("onclick","homework.onClickRadio(event)");
}


var allElements = document.getElementsByClassName("empName");
for(var i = 0;i<allElements.length;i++){
    allElements[i].setAttribute("onmouseover","homework.onHoverEmp(event)");
}
homework.onHoverEmp = function(event){
    if(event.target.style.visibility.toString == "hidden"){
        event.target.style.visibility = "visible";
    }
    else {
        event.target.style.visibility = "hidden";
    }
};

homework.getTime = function(){
    function checkTime(i) {
                return (i < 10) ? "0" + i : i;
    }
    var now = new Date();
    h = checkTime(now.getHours());
    m = checkTime(now.getMinutes());
    s = checkTime(now.getSeconds());
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout(function(){homework.getTime()},1000);
};
homework.getTime();

homework.waitDelay = function(){

   document.getElementById("helloWorld").style.color = "#"+((1<<24)*Math.random()|0).toString(16);
};
document.getElementById("helloWorld").setAttribute("onclick","setTimeout(function(){homework.waitDelay()},3000)");

homework.walkTheDOM = function(node, func){
    func(node);
    node = node.firstChild;
    while(node){
        homework.walkTheDOM(node,func);
        node = node.nextSibling;
    }
}
homework.walkTheDOM(document.body,function(a){
   a.style.color = "#"+((1<<24)*Math.random()|0).toString(16);
});

