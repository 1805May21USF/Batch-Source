/**
 * The login javascript reads from the login.html and sends the parameters email
 * and password to the loginservlet.
 * 
 * @author Tiffany Tran
 */



function login() {
	console.log("Attempting to login...");
	var loginUsername = document.getElementById("email").value;
	var loginUsername = document.getElementById("password").value;
	var xhr = new XMLHttpRequest();
	
	var forminfo = new FormData(form); 
	xhr.open("POST", "login", true);
	
	xhr.setRequestHeader(params);
	
	xhr.onreadystatechange = function() {
	}


	xhr.send();
}

window.onload = function() {
	console.log("In onload... login page!");
	document.getElementById("submit").addEventListener("click", login, false);
}