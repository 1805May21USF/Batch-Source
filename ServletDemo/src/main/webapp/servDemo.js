function testStuff(){
	console.log("in testStuff");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.open("GET", "test", true);//asynchonous
	xhr.send();
}

function testStuff2(){
	console.log("in testStuff2");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.open("POST", "test", true);//asynchonous
	xhr.send();
}

window.onload = function(){
	console.log("in onload");
	document.getElementById("myBtn").addEventListener("click", testStuff, false);
	document.getElementById("myBtn2").addEventListener("click", testStuff2, false);
}