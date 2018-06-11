/*1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/

//finish later

var checkText = function (node, text) {
    if (node.innerText.includes(text)) {
        var result = node.innerText;
        for (var i = 0; i < node.children.length; i++) {
            var checked =  checkText(node.children[i], text);
            if (checked !== undefined) {
                result = checked;
            }
        }
        return result;
    }
}
var getUsa = function () {
    var text = "USA";
    //queryselectorall gets all the nodes, then foreach(node) executes for each
    document.querySelectorAll('*').forEach(function (node) {
        console.log(checkText(node, text));
    });
}
getUsa();

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/

var getPeopleInSales = function () {
    var arr = document.getElementsByClassName("empName");
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].nextElementSibling.innerHTML == "Sales") {
            console.log(arr[i].innerText);
        }
    }
}

//getPeopleInSales();

/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/

var getAnchorChildren = function () {
    //convert to array so foreach works
    Array.from(document.getElementsByTagName("a")).forEach(function (node) {
        //check that there are children and then each for whether it's a span
        if (node.children.length > 0) {
            for (var i = 0; i < node.children.length; i++) {
                if (node.children[i].nodeName == "SPAN") {
                    console.log(node.children[i].innerText);
                }
            }
        }
    });
}

//getAnchorChildren();

/*
4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.
*/

var getSkills = function () {
    var skills = document.getElementsByName("skills")[0];
    skills.onchange = console.log(skills.value);
    /*
    for (var i = 0; i < skills.options.length; i++) {
        skills[i].onchange = console.log(skills[i].value);
    }
    */
}

//getSkills();

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
*/

var getCustomAttribute = function () {
    Array.from(document.querySelectorAll('[data-customattr]')).forEach(function (node) {
        console.log(node.getAttribute('data-customattr'));
        console.log(node.tagName);
    });
}

//getCustomAttribute();

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

var sumAdder = function (e) {
    var num1 = 0;
    var num2 = 0;
    result = "";
    if (e.getAttribute("id") == "num1") {
        num1 = e.value;
    }
    if (e.getAttribute("id") == "num2") {
        num2 = e.value;
    }
    result = num1 + num2;
    if (result == NaN) { result = "Cannot add"; }
    document.getElementById("sum").innerText = result;
};

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
    
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/

document.getElementsByName("skills")[0].addEventListener("change", function () {
    alert("Are you sure CSS is one of your skills?");
});

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

var nodes = document.getElementsByName("favoriteColor");
nodes.forEach(function (e) {
    e.addEventListener("change", function () {
        if (e.parentNode.style.backgroundColor == "") { e.parentNode.style.backgroundColor = "white"; }
        alert('So you like ' + e.value + ' more than ' + e.parentNode.style.backgroundColor + '?');
        e.parentNode.style.backgroundColor = e.value;
    });
});

/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
    
Hide the name if shown.
    Show the name if hidden.
*/

var names = document.getElementsByClassName("empName");
Array.from(names).forEach(function (e) {
    e.onmouseover = function () {
        if (e.style.opacity == 0) { e.style.opacity = 1 }
        if (e.style.opacity == 1 || e.style.opacity == '') { e.style.opacity = 0 }
    }
});

/*
10. Current Time

Regarding this element:
    <h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/

function updateClock() {
    var now = new Date(),
        time = now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds();
    document.getElementById('currentTime').innerHTML = time;
}
setInterval(updateClock, 1000);

/*
11. Delay
Regarding this element:
    
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
var delayColor = function (e) {
    setTimeout(function (e) {
        e.style.color = getRandomColor();
    }, 3000);
}

var e = document.getElementById("helloWorld");
e.addEventListener("click", delayColor(e));

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
var walkTheDOM = function (node, func) {
    Array.from(node.children).forEach(function (e) {
        func(e);
        walkTheDOM(e, func);
    });
}