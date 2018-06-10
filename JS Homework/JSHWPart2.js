var homework ={};
//1 

homework.getUSA = function ()
{
	var tags = document.getElementsByTagName("span");
	var found;
	for(var i = 0; i<tags.length; i++)
	{
		if(tags[i].textContent == "USA")
		{
		found = tags[i];
		break;
		}
	}
	return found;
}

//2
homework.getPeopleInSales = function()
{
	var x = document.getElementsByClassName("empName");
	for(var i=0; i<x.length;i++)
		console.log(x[i].innerHTML);
}

//3
homework.getAnchorChildren = function()
{
	var x = document.getElementsByTagName('span');
	var y = document.getElementsByTagName('a');
	for(var i=0;i<x.length;i++)
	{
		for(var j=0; j<y.length;j++)
		{
			if(x[i].parentNode == y[j])
				console.log(x[i].innerHTML);
		}
	}
}

//4
homework.getSkills = function()
{
	var x = document.getElementsByName("skills")[0].children;
	for(var i = 0 ; i < x.length; i++)
	{
		if(x[i].getAttribute("selected")=="selected")
		{
			console.log(x[i].innerHTML);
		}
	}
 }

 //5
homework.getCustomAttribute = function()
{
    var elements = document.getElementsByTagName('*');
	for(var i = 0; i < elements.length;i++)
	{
		if(elements[i].getAttribute("data-customAttr")!=null)
		{
            console.log(elements[i].getAttribute("data-customAttr"));
            console.log(elements[i]);
        }
    }
}

//6
document.getElementById("num1").setAttribute("onchange","homework.OnChangeSum()");
document.getElementById("num2").setAttribute("onchange","homework.OnChangeSum()");
homework.OnChangeSum = function()
{
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("sum");
    var sum = parseInt(num1)+parseInt(num2);
	if(isNaN(sum))
	{
        sum = "Cannot add";
    }
    result.innerHTML = sum;
}

//7
var allElements = document.getElementsByName("skills");
allElements[0].setAttribute("onchange","onSelectSkills(event)");
onSelectSkills = function(event)
{
	alert("Are you sure "+event.target.value+" is one of your skills?");
}

//8
var newcolor = "red";
homework.onClickRadio = function(event)
{
    oldcolor = newcolor;
    newcolor = event.target.value;
    alert("so you like " +newcolor+" more than "+oldcolor+" now?");
}
var elements = document.getElementsByName("favoriteColor");
for(var i = 0;i<elements.length;i++)
{
    elements[i].setAttribute("onclick","homework.onClickRadio(event)");
}

//9
var elements = document.getElementsByClassName("empName");
for(var i = 0;i<elements.length;i++)
{
    elements[i].setAttribute("onmouseover","homework.onHoverEmp(event)");
}
homework.onHoverEmp = function(event)
{
	if(event.target.style.visibility.toString == "hidden")
	{
        event.target.style.visibility = "visible";
    }
	else 
	{
        event.target.style.visibility = "hidden";
    }
}

//10
homework.getTime = function()
{
	function checkTime(i) 
	{
        return (i < 10) ? "0" + i : i;
    }
    var now = new Date();
    h = checkTime(now.getHours());
    m = checkTime(now.getMinutes());
    s = checkTime(now.getSeconds());
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s;
	t = setTimeout(function(){homework.getTime()},1000);
}
homework.getTime();

//11
homework.waitDelay = function()
{
	document.getElementById("helloWorld").style.color = "#"+((1<<24)*Math.random()|0).toString(16);
}
document.getElementById("helloWorld").setAttribute("onclick","setTimeout(function(){homework.waitDelay()},3000)");

//12
