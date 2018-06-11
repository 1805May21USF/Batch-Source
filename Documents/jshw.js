var myObject = {};

/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
  */

myObject.getUSA = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('*');
    for(j = 0; j < allElements.length;j++){
        if(allElements[j].innerHTML==="USA"){
            console.log(allElements[j].innerHTML);
        }
    }
};


/*


var array = [];

    var elements = document.body.getElementsByTagName("*");
for(var j = 0; j < elements.length; j++) {
       var current = elements[j];
       if( current.includes(USA)) {
       	console.log(current);
       }
   }

*/

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
   */

myObject.getPeopleInSales = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('td');
    for(j=0; j < allElements.length;j++){
    if(allElements[j].innerHTML === "Sales"){
    console.log(allElements[j-1].innerHTML);
        }
    }
};
/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
   */
myObject.getAnchorChildren = function(){
    var elements = [];
    var allElements = document.getElementsByTagName("span");
    for(j=0;j<allElements.length;j++){
    if(allElements[j].parentElement.tagName==="A"){
    console.log(allElements[j].innerHTML);
        }
    }
}

/*
4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.
   */

myObject.getSkills = function(){
   var elements = [];
   var allElements = document.getElementsByName("skills")[0].children;
   for(j=0;j<allElements.length;j++){
   if(allElements[j].getAttribute("selected")==="selected"){
   console.log(allElements[j].innerHTML);
        }
   }
};

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
 */
myObject.getCustomAttribute = function(){
    var elements = [];
    var allElements = document.getElementsByTagName('*');
    for(j=0;j<allElements.length;j++){
    if(allElements[j].getAttribute("data-customAttr")!=null){
    console.log(allElements[j].getAttribute("data-customAttr"));
    console.log(allElements[j]);
        }
    }
};

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
document.getElementById("num1").setAttribute("onchange","myObject.OnChangeSum()");
document.getElementById("num2").setAttribute("onchange","myObject.OnChangeSum()");
myObject.OnChangeSum = function(){
var num1 = document.getElementById("num1").value;
var num2 = document.getElementById("num2").value;
var result = document.getElementById("sum");
var sum = parseInt(num1)+parseInt(num2);
if(isNaN(sum)){
sum = "Result could not be added!";
}
result.innerHTML = sum;
};



/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.

*/

function partTwoQuestionSeven() {
    var x = 
alert("are you sure " + document.getElementById("skills").value + " is one of your skills");
}

document.getElementById("skills").onchange = partTwoQuestionSeven();



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



/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
var allElements = document.getElementsByClassName("empName");
for(var i = 0;i<allElements.length;i++){
    allElements[i].setAttribute("onmouseover","myObject.onHoverEmp(event)");
}
myObject.onHoverEmp = function(event){
    if(event.target.style.visibility.toString == "hidden"){
        event.target.style.visibility = "visible";
    }
    else {
        event.target.style.visibility = "hidden";
    }
};
/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
myObject.getTime = function(){
    function checkTime(i) {
                return (i < 10) ? "0" + i : i;
    }
    var now = new Date();
    h = checkTime(now.getHours());
    m = checkTime(now.getMinutes());
    s = checkTime(now.getSeconds());
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout(function(){myObject.getTime()},1000);
};
myObject.getTime();
/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/
myObject.waitDelay = function(){

   document.getElementById("helloWorld").style.color = "#"+((1<<24)*Math.random()|0).toString(16);
};
document.getElementById("helloWorld").setAttribute("onclick","setTimeout(function(){myObject.waitDelay()},3000)");


/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
