/*Part 2 Question 1

Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.

*/
function getUSA(){
	var result = document.body.getElementsByTagName("*");
	var i;
    for (i = 0; i < result.length; i++) {
        if (result[i].textContent === "USA") {
            console.log(result[i].innerHTML);
        }
    }
    return "done";
}

/*Part 2 Question 2

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/
function getPeopleInSales(){
	var table = document.getElementsByTagName("table")[0];
	var i;
	for(i = 0; i < table.rows.length; i++){
		var result = table.rows[i].cells[1].innerHTML;
		if(result == "Sales")
			console.log(table.rows[i].cells[0].innerHTML);
	}
	return "done";
}

/*Part 2 Question 3

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/
function getAnchorChildren(){
	var results = document.getElementsByTagName("span");
	for(i = 0; i < results.length; i++)
		if(results[i].parentNode.tagName == 'A')
			console.log(results[i].innerHTML);
	return "done";
}

/*Part 2 Question 4

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.
*/
function getSkills(){
	var skills = document.getElementsByName("skills")[0]
	var i;
	for(i = 0; i < skills.length; i++){
		//console.log(skills.innerHTML);
		console.log(skills[i].innerHTML);
	}
	return "done";
}

/*Part 2 Question 5

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.

*/
function getCustomAttribute(){
	var result = document.body.querySelectorAll('[data-customAttr]');
	var i;
    for (i = 0; i < result.length; i++) {
        console.log(result[i].dataset.customattr);
    }
    return "done";
}

/*Part 2 Question 9

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
var employee = document.getElementsByClassName("empName");
var i;
for (i = 0; i < employee.length; i++) {
    employee[i].onmouseover = function () {
        if (this.style.opacity == 1) {
            this.style.opacity = 0;
        } else {
            this.style.opacity = 1;
        }
    };
}

/*Part 2 Question 10

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.

*/
setInterval(function () {
    var time = new Date();
    var hour = time.getHours();
    var meridian = hour >= 12 ? "PM" : "AM";
    document.getElementById("currentTime").innerHTML = hour + ":" + 
    	time.getMinutes() + ":" + time.getSeconds() + " " + meridian;
}, 500);

/*Part 2 Question 11

Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/
var helloWorld = document.getElementById("helloWorld");
helloWorld.addEventListener("click", delayedChangeColor);
function delayedChangeColor() {
    setTimeout(function changeColor() {
        helloWorld.style.color = getRandomColor();
    }, 3000);
}

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  var i;
  for (i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}


/*Part 2 Question 12

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
    	console.log(node);
        node = node.nextSibling;
    }
   	return "done";
}