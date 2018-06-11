//One
function getUSA(){
    var elems = document.body.getElementsByTagName("*");
    for (i = 0; i < elems.length; i++){
        if (elems[i].textContent == "USA"){
            console.log(elems[i].innerHTML);
        }
    }
}

//Two
function getPeopleInSales(){
    var main = document.getElementsByTagName("table")[0].rows;
    // var sec = main[main.length-1];   //.cells[0];
    // var value = sec.innerHTML;
    // console.log(cell);
    // console.log(value);
    var final = [];
    for (i = 0; i < main.length; i++){
        var sec = main[i];
        //console.log(sec.cells[1]);
        if (sec.cells[1].innerHTML == "Sales"){
            final.push(sec.cells[0].innerHTML);
        }
    }
    //console.log
    return final;

}

//Three
function getAnchorChildren(){
    var elems = document.body.getElementsByTagName("span");
    var endArray = [];
    var parentArray = [];
    for (i = 0; i < elems.length; i++){
        endArray.push(elems[i].innerHTML);
        parentArray.push(elems[i].parentElement);
    }
    return endArray;
}

//var e = document.getElementsByName("skills");
//Four
function getSkills(){
    var selected;
    var e = document.getElementsByName("skills")[0];
    for (i = 0; i < e.length; i++){
        if (e[i].selected == true){
            return e[i].innerHTML;
        }
        //if (e[i].selected == true){
           // selected = e[i].innerHTML;
        //}
    }
    
    //return selected;
}

//Five
function getCustomAttribute(){
    var custom = document.getElementsByTagName("*");
    for (i=0; i < custom.length; i++){
        if (custom[i].hasAttribute("data-customAttr")){
            console.log(custom[i]);
            console.log(custom[i].innerHTML);
        }
    }
}

//Six--may need the int check or something
function mySum(m, n){
    var elems = document.getElementsByClassName("nums");
    elems[0].setAttribute("value", m);
    elems[1].setAttribute("value", n);
    sum = m+n;
    var sumel = document.getElementById("sum");
    sumel.innerHTML = sum;
}

//Seven
var elems = document.getElementsByName("skills");
elems[0].setAttribute("onchange","onSelectSkills(event)");

onSelectSkills = function(event){ alert("Are you sure "+event.target.value+" is one of your skills?");}

//Eight
// var now;
// var prev;
// var getElements = document.getElementsByName("colors");
// prev = 
// getElements[0].setAttribute("onchange","onSelectColor(event)");

// onSelectColor = function(event){ alert("So you like " + now + " more than "+ prev + "now?" );}
var old = null;
var newv = "red";
onClickRadio = function(event){
    oldv = newvalue;
    newv = event.target.value;
    alert("so you like " +newv+" more than "+old+" now?");

};
var allElements = document.getElementsByName("favoriteColor");
for(var i = 0;i<elems.length;i++){

    elems[i].setAttribute("onclick","onClickRadio(event)");
}


//Nine
var elems = document.getElementsByClassName("empName");
for(i = 0;i<elems.length;i++){

    elems[i].setAttribute("onmouseover","homework.onHoverEmp(event)");
}
hoverfunc = function(event){
    if(event.target.style.visibility.toString == "hidden"){
        event.target.style.visibility = "visible";
    }
    else {
        event.target.style.visibility = "hidden";
    }
};

//Ten
function timing(){
    function checkTime(i) {
                return (i < 10) ? "0" + i : i;
    }
    var currtime= new Date();
    h = checkTime(currtime.getHours());
    m = checkTime(currtime.getMinutes());
    s = checkTime(currtime.getSeconds());
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout(function(){timing()},1000);
};



//Eleven
function wait(){

   document.getElementById("helloWorld").style.color = "#"+((1<<24)*Math.random()|0).toString(16);
};
document.getElementById("helloWorld").setAttribute("onclick","setTimeout(function(){wait()},3000)");

//Twelve
function walkingDOM(node, func){
    func(node);
    node = node.firstChild;
    while(node){
        homework.walkTheDOM(node,func);
        node = node.nextSibling;
    }
}
walkingDom(document.body,function(a){
   a.style.color = "#"+((1<<24)*Math.random()|0).toString(16);
});