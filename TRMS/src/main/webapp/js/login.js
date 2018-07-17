var loginform = document.getElementsByClassName("loginForm");
loginform = loginform[0];


loginform.addEventListener('submit',getLogin);

function getLogin() {
	e.preventDefault();
	var lf = document.getElementsByClassName("loginForm");
	e.preventDefault();
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(lf);
    xhr.open("POST","login",true);
    xhr.open(forminfo);
    

}

var b1 = document.getElementsByClassName("login");
b1[0].addEventListener('click', function() {
	e.preventDefault();
});
var b2 = document.getElementsByClassName("signup");
b2[0].addEventListener('click', function() {
	e.preventDefault();
});