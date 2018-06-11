/*
*
* @author Kaleb Martin
* @Date 6/11/2018
* @Assign JavascriptHomework2
*
*/
   

    /*1. USA
    Define function getUSA()

        Find the html element that contains "USA".

        Print that element's contents.
    */

    function getUSA(){
        var allElements = document.getElementsByTagName("*");
        for (var i = 0; i < allElements.length; i++){
            if (allElements[i].textContent == "USA"){
                console.log(allElements[i]);
                console.log(allElements[i].innerHTML);
            }
        }
    }

    /*
    2. Sales

    Define function getPeopleInSales()

        Print the names of all the people in the sales department.
    */

    function getPeopleInSales() {

        var parent;

        var employee = document.getElementsByClassName("empName");
        for (var i = 0; i < employee.length; i++) {
             parent = employee[i].parentNode;
             if (parent.lastElementChild.innerHTML == "Sales") {
                 console.log(parent.firstElementChild.innerHTML);
             }
        }

    }

    /*3. Click Here

    Define function getAnchorChildren()

    Find all anchor elements with a <span> child.

    Print the contents of <span>

    */

    function getAnchorChildren() {
        var anchors = document.getElementsByTagName("a");
        for (var i = 0; i < anchors.length; i++) {
            var anchorChildren = anchors[i].getElementsByTagName("span");
            for (var j = 0; j < anchorChildren.length; j++) {
                console.log(anchorChildren[j]);
            }
        }
    }


    /*
    4. Hobbies

    Define function getSkills()

    Find all checked options in the 'skills' select element.

    Print the value and the contents.

    */
    function getSkills() {
    
        var skills = document.getElementsByName("skills");
        for (var i = 0; i < skills.length; i++) {
       
          var children = skills[i].childNodes;
            for (var j = 0; j < children.length; j++) {
                if (children[j].selected == true) {
                    console.log(children[j].value);
                    console.log(children[j]);
                }
            }
        }
    }

    /*
    5. Custom Attribute

    Define function getCustomAttribute()

    Find all elements with "data-customAttr" attribute

    Print the value of the attribute.

    Print the element that has the attribute.


    */

    function getCustomAttribute() {
        var attributes = document.querySelectorAll("[data-customAttr]");
        for (var i = 0; i < attributes.length; i++) {
            console.log(attributes[i]);
            console.log(attributes[i].innerHTML);
        }
    }





        /*
        6. Sum Event

        NOTE: Write unobtrusive Javascript

        Regarding these elements:

        <input id="num1" class="nums" type="text"/>

        <input id="num2" class="nums" type="text"/>

        <h3>Sum: span id="sum"></span></h3>

         */
    
    function sumEven() {
        var numbers = document.getElementsByClassName("nums");
        var sum = 0;
        for (var i = 0; i < numbers.length; i++) {
            sum = sum + parseInt(numbers[i].value);
        }
        document.getElementById("sum").innerText = sum;
    }

        /*7 is below in the window.onload(function)
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

    function favoriteColors() {
     
        if(previousSelected == null){
        alert("Are you sure you want to change to " + this.value + "?");
        previousSelected = this.value;

        var colors = document.getElementsByName("favoriteColor");
        for (var i = 0; i < colors.length; i++) {
            console.log(colors[i].style.color = this.value);
        }

        }
        else {
            alert("Are you sure you want to change from " + previousSelected + " to " + this.value + "?");
            previousSelected = this.value;
   
            var colors = document.getElementsByName("favoriteColor");
            for (var i = 0; i < colors.length; i++) {
                console.log(colors[i].style.color = this.value);
            }
        }
    }

    
        /*
        9. Show/Hide Event

        NOTE: Write unobtrusive Javascript

        When user hovers over an employees name:
	
        Hide the name if shown.
	        Show the name if hidden.

        */

    function showHide() {
        if (this.style.visibility === 'hidden') {
            this.style.visibility = 'visible';
        }
        else  {
            this.style.visibility = 'hidden';
        }
    }


        /*
        10. Current Time

        Regarding this element:
	        <h5 id="currentTime"></h5>

        Show the current time in this element in this format: 9:05:23 AM

        The time should be accurate to the second without having to reload the page.


        */
    window.setTimeout(function setTime() {


        var time = document.getElementById("currentTime");
        var rightNow = new Date();
        var hours = rightNow.getHours();
        var minutes = rightNow.getMinutes();
        var seconds = rightNow.getSeconds();

        var aOrP = amOrPm(hours);
        hours = fromMilitaryTime(hours);
        hours = addZeros(hours);
        minutes = addZeros(minutes);
        seconds = addZeros(seconds);
        time.innerHTML = hours + ":" + minutes + ":" + seconds + aOrP;

    }, 1000);

    function fromMilitaryTime(hour) {
        if (hour > 12) {
            hour = hour - 12;
        }
        return hour;
    }
    
    function amOrPm(hours) {
        if (hours > 12) {
            return "pm";
        }
        else {
            return "am";
        }
    }

    function addZeros(num) {

        if (num < 10) {
            num = "0" + num;
        }
        return num;
    }



        /*
        11. Delay
        Regarding this element:
	
        <p id="helloWorld">Hello, World!</p>

        Three seconds after a user clicks on this element, change the text to a random color.

        */

    
        window.setTimeout(changeColor, 3000); 
    
       function changeColor(){
           var hello = document.getElementById("helloWorld");
           var colorOptions = ['a','b','c','d','e','f','0','1','2','3','4','5','6','7','8','9'];
           var newColor = "#";

           for(var i = 1;i<7;i++){
               newColor = newColor + colorOptions[Math.floor(Math.random() * 16)];
           }
           console.log(newColor);
           hello.style.color = newColor;

       }

        /*
        12. Walk the DOM

        Define function walkTheDOM(node, func)

        This function should traverse every node in the DOM. 
        Use recursion.

        On each node, call func(node).


        */
        
       function walkTheDom(node) {
           headNode = document.getElementsByTagName(node);
           console.log(headNode);
       }



       //Questions 6-9 use the window onload function
       //the functions used in the eventListener
       var previousSelected = null;
       window.onload = function () {




           document.getElementById("num1").addEventListener("change", sumEven);
           document.getElementById("num2").addEventListener("change", sumEven);

           //Question7
           var skills = document.getElementsByName("skills");
           for (var i = 0; i < skills.length; i++) {
               skills[i].addEventListener('change', function () {
                   alert('Are you sure ' + this.value + " is the skill you want to select?");
               })
           }


           //Question8
           var colors = document.getElementsByName("favoriteColor");
           for (var i = 0; i < colors.length; i++) {
               colors[i].addEventListener('click', favoriteColors);
               console.log(colors[i]);

           }

           //Question 9

           var employees = document.getElementsByClassName("empName");

           for (var i = 0; i < employees.length; i++) {
               employees[i].addEventListener('mouseover', showHide);
           }

       }