var homework = {};


// Part 1 Question 1
homework.fibonacci = function(n){
    if(n<=1){
        return n
    }
    return homework.fibonacci(n-1) + homework.fibonacci(n-2);
};


// Part 1 Question 2
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

// Part 1 Question 3
homework.factorial = function(n){
    var sum = 1;
    for(i = 1;i<=n;i++){
        sum = sum * i;
    }
    return sum;
};

// Part 1 Question 4
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

// Part 1 Question 5
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

// Part 2 Question 1
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
homework.getUSA = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('*');
    for(i = 0; i < allElements.length;i++){
        if(allElements[i].innerHTML==="USA"){
            console.log(allElements[i].innerHTML);
        }
    }
};

// Part 2 Question 2
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
homework.getPeopleInSales = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('td');
    for(i = 0; i < allElements.length;i++){
        if(allElements[i].innerHTML === "Sales"){
            console.log(allElements[i-1].innerHTML);
        }
    }
};

// Part 2 Question 3
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
homework.getAnchorChildren = function(){
    var elements = [];
    var allElements = document.getElementsByTagName("span");
    for(i = 0;i<allElements.length;i++){
        if(allElements[i].parentElement.tagName==="A"){
            console.log(allElements[i].innerHTML);
        }
    }
}

// Part 2 Question 4
// Define function getSkills()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
homework.getSkills = function(){
   var elements = [];
   var allElements = document.getElementsByName("skills")[0].children;
   for(i = 0;i<allElements.length;i++){
       if(allElements[i].getAttribute("selected")==="selected"){
            console.log(allElements[i].innerHTML);
        }
   }
};

// Part 2 Question 5
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute
// Print the element that has the attribute.
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

// Part 2 Question 6
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: span id="sum"></span></h3>
//
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
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

// Part 2 Question 7
//
// When user selects a skill, create an alert with a message similar to:
//
// "Are you sure CSS is one of your skills?"
//
//NOTE: no alert should appear when user deselects a skill.
var allElements = document.getElementsByName("skills");
allElements[0].setAttribute("onchange","homework.onSelectSkills(event)");
homework.onSelectSkills = function(event){
    alert("Are you sure "+event.target.value+" is one of your skills?");
};



// Part 2 Question 8
// When a user selects a color, create an alert with a message similar to:
//
//     "So you like green more than blue now?"
//
// In this example, green is the new value and blue is the old value.
//
// Make the background color (of all favoriteColor radio buttons)
// the newly selected favoriteColor
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


// Part 2 Question 9
// When user hovers over an employees name:
//
// Hide the name if shown.
// Show the name if hidden.
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

// Part 2 Question 10
// Regarding this element:
// <h5 id="currentTime"></h5>
//
// Show the current time in this element in this format: 9:05:23 AM
//
// The time should be accurate to the second without having to reload the page.
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


// Part 2 Question 11
// Regarding this element:
//
// <p id="helloWorld">Hello, World!</p>
//
// Three seconds after a user clicks on this element, change the text to a random color.
homework.waitDelay = function(){

   document.getElementById("helloWorld").style.color = "#"+((1<<24)*Math.random()|0).toString(16);
};
document.getElementById("helloWorld").setAttribute("onclick","setTimeout(function(){homework.waitDelay()},3000)");

// Part 2 Question 12
// Define function walkTheDOM(node, func)
//
// This function should traverse every node in the DOM.
// Use recursion.
//
// On each node, call func(node).
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

