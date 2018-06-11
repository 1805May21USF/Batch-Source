/* Tiffany Tran
JSHW Part 2 - Due: 6/11/18

 */

/* 
1. Find the html element that contains "USA".
Print that element's contents.
 */
function getUSA() {
    var usa = document.querySelectorAll('[data-customAttr="USA"]');
    console.log(usa[0].textContent);
}

/*  
2. Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
    var sales = document.getElementsByClassName("empName");
    for (var i = 0; i < sales.length; i++) {
        if (sales[i].parentElement.getElementsByTagName("td")[1].textContent === "Sales") {
            console.log(sales[i].textContent);
        }
    }
}

/*
3. Find all anchor elements with a <span> child.
Print the contents of <span>
 */
function getAnchorChildren() {
    var anchor = document.getElementsByTagName("span");
    for (var i = 0; i < anchor.length; i++) {
        if (anchor[i].parentElement.tagName === "A") {
            console.log(anchor[i].textContent);
        }
    }
}

/**
 * 4.Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */

function getSkills() {
    var skills = document.getElementsByName("skills");
    console.log(skills[0].value);
}

/**
 * 5. Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute() {
    var usa = document.querySelectorAll('[data-customAttr]');
    for (var i = 0; i < usa.length; i++) {
        console.log("Value: " + usa[i].getAttribute('data-customAttr') + " Element: " + usa[i].tagName);
    }
}

/**
 * 6. NOTE: Write unobtrusive Javascript

Regarding these elements:
<input id="num1" class="nums" type="text"/>
<input id="num2" class="nums" type="text"/>
<h3>Sum: span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
 */

document.getElementById("num1").addEventListener("change", summer);
document.getElementById("num2").addEventListener("change", summer);

function summer() {
    var num1 = Number(document.getElementById("num1").value);
    var num2 = Number(document.getElementById("num2").value);
    var num3 = num1 + num2;
    if (typeof num3 === "number") {
        document.getElementById("sum").innerText = num3;
    } else {
        document.getElementById("sum").innerText = "Cannot add";
    }
}

/**
 * 7. NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
 */

document.getElementsByName("skills")[0].addEventListener("change", alerter);

function alerter() {
    window.alert("Are you sure " + document.getElementsByName("skills")[0].value
        + " is one of your skills?")
}

/**
 * 8. NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
 */

var favoriteColor = null;
//Sets the onchange event handler for input tags whose value equals favoriteColor
var input = document.getElementsByTagName('input');
for (var i = 0; i < input.length; i++) {
    if (input[i].attributes[0].value == 'favoriteColor') {
        input[i].onchange = changeBackground;
    }
}
function changeBackground() {
    for (var i = 0; i < input.length; i++) {
        if (input[i].attributes[0].value === 'favoriteColor') {
            //If the input is checked, the favorite color is changed and the background changes
            if (input[i].checked) {
                //Executes if the favorite color is undefined
                if (favoriteColor != null)
                    window.alert('So you like ' + input[i].attributes[1].value + ' more than ' + favoriteColor + ' now?');
                favoriteColor = input[i].attributes[1].value;
                input[i].parentNode.style.backgroundColor = favoriteColor;
            }
        }
    }
}


/**
 * 9. NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
    Hide the name if shown.
   Show the name if hidden.
 */

var employees = document.getElementsByClassName('empName');

for (var i = 0; i < employees.length; i++) {
    employees[i].onmouseover = function () {

        if (this.style.opacity == '0') {
            this.style.opacity = '1';
        }

        else {
            this.style.opacity = '0';
        }
    };
}

/**
 * 10. Regarding this element:
  <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
 */
function startTime() {
    document.getElementById('currentTime').innerHTML = new Date().toLocaleTimeString();
    t = setTimeout(function () {
        startTime()
    }, 500);
}
startTime();


/** 
 * 11. Regarding this element:
<p id="helloWorld">Hello, World!</p>
**** Three seconds after a user clicks on this element, change the text to a random color.
 */

document.getElementById("helloWorld").addEventListener("click", rainbow);

function rainbow() {
    var letters = '0123456789ABCDEF';
    var col = '#';
    for (var i = 0; i < 6; i++) {
        col += letters[Math.floor(Math.random() * 16)];
    }
   
    t = setTimeout(function () {
        document.getElementById('helloWorld').style.color = col;
    }, 3000);
}


/**
 * 12. Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).
 */

function walkTheDOM(node, func) {
    if (node == null) {
        return;
    }
    else {
        
        func(node);
        node = node.firstChild;

        while (node != null) {
            
            walkTheDOM(node, func);
            node = node.nextSibling;
        }
    }
}
