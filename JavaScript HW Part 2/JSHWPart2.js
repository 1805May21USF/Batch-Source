// 1. USA
function getUSA() {
    var tags = document.body.getElementsByTagName("*");
    for (var i = 0; i < tags.length; i++) {
        if (tags[i].textContent === "USA") {
            console.log(tags[i].innerHTML);
        }
    }
}

// 2. Sales
function getPeopleInSales() {
    var table = document.body.getElementsByTagName("table")[0];
    for (var i = 0; i < table.rows.length; i++) {
        var cells = table.rows[i].cells;
        if (cells[1].textContent === "Sales") {
            console.log(cells[0].textContent);
        }
    }
}

// 3. Click Here
function getAnchorChildren() {
    var children = document.body.getElementsByTagName("span");
    for (var i = 0; i < children.length; i++) {
        if (children[i].parentNode.tagName == 'A') {
            console.log(children[i].textContent);
        }
    }
}

// 4. Hobbies
function getSkills() {
    var skills = document.getElementsByName("skills")[0];
    var values = skills.options[skills.selectedIndex].value;
    var contents = skills.options[skills.selectedIndex].textContent;
    console.log("value: " + values + ", contents: " + contents);
}

// 5. Custom Attribute
function getCustomAttribute() {
    var elements = document.body.querySelectorAll('[data-customAttr]');
    for (var i = 0; i < elements.length; i++) {
        console.log(elements[i].dataset.customattr);
    }
}

// 6. Sum Event
var a = document.getElementById("num1");
var b = document.getElementById("num2");

a.addEventListener("change", sumEvent);
b.addEventListener("change", sumEvent);

function sumEvent() {
    var sum = document.getElementById("sum");
    var firstNum = a.value;
    var secondNum = b.value;
    var temp = Number(firstNum) + Number(secondNum);

    if (isNaN(temp)) {
        sum.innerHTML = "Cannot add";
    } else {
        sum.innerHTML = temp;
    }
}

// 7. Skills Event
var skills = document.getElementsByName("skills")[0];
skills.addEventListener("change", skillsEvent);

function skillsEvent() {
    var selection = skills.options[skills.selectedIndex].textContent;
    alert("Are you sure " + selection + " is one of your skills?");
}

// 8. Favorite Color Event
var colors = document.getElementsByName("colors")[0];
colors.addEventListener("change", favColorEvent);
var previousColor = null;

function favColorEvent() {
    var selection = colors.options[colors.selectedIndex].textContent;
    if (previousColor == null) {
        previousColor = selection;
    } else {
        var currentColor = selection;
        alert("So you like " + currentColor + " more than " + previousColor + " now?");
        previousColor = currentColor;
    }
}

// 9. Show/Hide Event
var employeeNames = document.getElementsByClassName("empName");
for (var i = 0; i < employeeNames.length; i++) {
    employeeNames[i].onmouseover = function () {
        if (this.style.opacity == 1) {
            this.style.opacity = 0;
        } else {
            this.style.opacity = 1;
        }
    };
}

// 10. Current Time
setInterval(function () {
    var time = new Date();
    var h = time.getHours();
    var m = time.getMinutes();
    var s = time.getSeconds();
    m = formatTime(m);
    s = formatTime(s);
    var currentTime = document.getElementById("currentTime");
    currentTime.innerHTML = h + ":" + m + ":" + s;
}, 1000);

function formatTime(i) {
    if (i < 10) { i = "0" + i };
    return i;
}

// 11. Delay
var helloWorld = document.getElementById("helloWorld");
helloWorld.addEventListener("click", delayedChangeColor);
function delayedChangeColor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    setTimeout(function changeColor() {
        helloWorld.style.color = "rgb(" + r + "," + g + "," + b + ")";
    }, 3000);
}

// 12. Walk the DOM
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

walkTheDOM(document.body, function (node) {
    console.log(node);
});