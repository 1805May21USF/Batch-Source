
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
if (n < 3){
    return 1;
}
return this.fibonacci(n-1)+this.fibonacci(n-2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
   
   //GEEZ. This took about 7x longer than it should have. Damn JS's lack of exceptions
    if (array.length <=1){
        return array;
    }
    var left = homework.sort(array.slice(0,(array.length-1)/2+1));
    var right = homework.sort(array.slice((array.length-1)/2+1),array.length)
   //alert(left + " Is left, "+ right);
    var leftIdx=0;
    var rightIdx = 0;
    for (var i = 0; i<array.length; i++){
        //alert("choseing");

        if ((left[leftIdx])<(right[rightIdx]) ||rightIdx >=right.length ){
            //alert("chose left");

            array[i]=left[leftIdx];
            leftIdx++;
        }
        else {
            //alert("chose right");

            array[i]=right[rightIdx];
            rightIdx++;
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
    if (n<2){
        return 1;
    }
return n*homework.factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
var array2 = array.slice(array);
for (var i = 0; i<array.length; i++){
    array2[((i-n) % array.length+array.length)%array.length] = array[i];
    }
    return array2;
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
var stack = [];
for(var i = 0; i< bracketsString.length; i++){
    if(bracketsString[i] == "("||bracketsString[i]=="[" || bracketsString[i] == "{"){
        stack.push(bracketsString[i]);
    }
    if(bracketsString[i]==')'){
        var r = stack.pop() ;
        //alert("got "+ bracketsString[i]  + "but expected oppisite of " + r);
        if(r!= '('){
            return false;
        }
    }
    if( bracketsString[i] == ']'){
        var r = stack.pop() ;
        //alert("got "+ bracketsString[i]  + "but expected oppisite of " + r);
        if(r!= '['){
            return false;
        }
    }
    if(bracketsString[i] == '}'){
        var r = stack.pop() ;
        //alert("got "+ bracketsString[i]  + "but expected oppisite of " + r);
        if(r != '{'){
            return false;
        }
    }
    
}
return(stack.length==0);

};


setupClickReports = function(node ,depth, useCapture){
    node.childNodes.forEach(element => {
        element.addEventListener("click",function(){
            toPrint="";
            for (var i = 0; i<depth; i++){
                toPrint += "    ";
            }
            toPrint+= element.nodeName ;
            toPrint+= " With useCapture= " + useCapture; 
            console.log(toPrint);
        }, useCapture);
        
        setupClickReports(element, depth+1, useCapture);

    });
}

//setupClickReports(document.body, 0, false);
//setupClickReports(document.body, 0, true);

/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
  
*/ 
USA =function(node){
    node.childNodes.forEach(element => {
        if(element.textContent != null&&(0<element.textContent.search("USA"))){
            console.log(element.textContent);
        }
        USA(element);
    });
}
/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
  
*/ 
getPeopleInSales = function(node){
    node.childNodes.forEach(element => {
        if(element.textContent == "Sales"&& element.parentNode.getElementsByClassName("empName")[0]!= null){
            console.log(element.parentNode.getElementsByClassName("empName")[0].textContent);
        }
        getPeopleInSales(element);
    });
}
/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
  
*/ 

getAnchorChildren = function(node){
    node.childNodes.forEach(element => {
        if(element.nodeName != null&&element.nodeName.toLowerCase() == "span"){
            console.log(element.textContent);
        }
        getAnchorChildren(element);
    });
}
/*
4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.
  
*/ 
getSkills = function(){
    var selectElement = document.getElementsByName("skills")[0];
    if (selectElement.options[selectElement.selectedIndex] == null){
        
        return;
    }
    console.log(selectElement.options[selectElement.selectedIndex].value)
    console.log(selectElement.options[selectElement.selectedIndex].textContent)

}
/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.

*/


 
getCustomAttribute=function(){

    walkTheDOM(document, function(node) {
       // console.log("running on" + node.nodeName);
        if (node.getAttribute!= null && node.getAttribute("data-customAttr")!= null ){
            console.log(node.getAttribute("data-customAttr"));
            console.log(node);
        }
    });
}
/*
6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>


Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element

*/ 
sumHandler = function(){
    console.log("Running!");
    document.getElementById("sum").textContent=(parseInt(document.getElementById("num1").value)+parseInt(document.getElementById("num2").value));
    if (  document.getElementById("sum").textContent == NaN){
        document.getElementById("sum").textContent= "Cannot Add";
    }
}
document.getElementById("num1").addEventListener("change",sumHandler, true  );
document.getElementById("num2").addEventListener("change",sumHandler, true  );

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.

*/ 
document.getElementsByName("skills")[0].addEventListener("change",function(){
    console.log("Are you sure "+document.getElementsByName("skills")[0].options[document.getElementsByName("skills")[0].selectedIndex].textContent+ " is one of your skills?");
    
}, true  );

/*
8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor

*/ 
globalColor = "white";
document.getElementsByName("favoriteColor").forEach(function(element) {
    element.addEventListener("change",function(){
        alert("So you like " + this.value + " more than "+ globalColor + " now?");
        globalColor= this.value;
        document.getElementsByName("favoriteColor").forEach(function(value){
            value.parentNode.setAttribute("style","background-color:"+globalColor );
        });
    })
} ,false);
/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.

    */ 
[].forEach.call(document.getElementsByClassName("empName"),function(nameTag){
    nameTag.addEventListener("mouseover", function(){
        if (nameTag.getAttribute("style") == "opacity:0"){
            nameTag.setAttribute("style", "opacity:1");
            return;
        }
        nameTag.setAttribute("style", "opacity:0");
        
        console.log("running!");
    }, false);

});
   /*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.

*/ 

window.setInterval(function() {
    var d=new Date();
    if (d.getHours >12){
    document.getElementById("currentTime").textContent=""+(d.getHours()+1)%13+":" +d.getMinutes()+":"+d.getSeconds()+" am";
    }else{
    document.getElementById("currentTime").textContent=""+(d.getHours()+1)%13+":" +d.getMinutes()+":"+d.getSeconds()+" pm";

    }

}, 1000);
/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/ 
document.getElementById("helloWorld").addEventListener("click", function(){
    var colorString = '#'+Math.floor(Math.random()*16777215).toString(16);
    setTimeout(()=>document.getElementById("helloWorld").setAttribute("style", "color:"+colorString,3000);


}, false);
/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).



*/ 
walkTheDOM = function(node, func){
    node.childNodes.forEach(element => {
        func(node);
        walkTheDOM(element, func);
    });
}