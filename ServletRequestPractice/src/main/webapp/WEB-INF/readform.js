/**
 * @Author: Tiffany Tran
 */

function testStuff2() {
	console.log("inside teststuff");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
	}
	xhr.open("POST", "test", true);
	xhr.send();
}


window.onload = function() {
	console.log("In onload");
	document.getElementById("submit")
			.addEventListener("click", testStuff, false);
	document.getElementById("myBtn2").addEventListener("click", testStuff2,
			false);
}