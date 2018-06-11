/**
 * 
 */

function testStuff() {
	console.log("inside teststuff");
	var xhr = XMLHttpRequest();
	xhr.onreadystatechange = function () {}
	xhr.open("GET", "test", true);
	xhr.send();
}

function testStuff2() {
	console.log("inside teststuff");
	var xhr = XMLHttpRequest();
	xhr.onreadystatechange = function () {}
	xhr.open("POST", "test", true);
	xhr.send();
}


window.onload = function() {
	console.log("In onload");
	document.getElementById("myBtn").addEventListener("click", testStuff, false);
	document.getElementById("myBtn2").addEventListener("click", testStuff2, false);
}