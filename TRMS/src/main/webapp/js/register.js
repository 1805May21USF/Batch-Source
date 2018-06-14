function getInfo() {
    var form = document.getElementById("registerdata");
    var pw = form.elements[4].value;
    var verify = form.elements[5].value;
    var pwcheck = document.getElementById('pwalert');
    pwcheck.style.display="none";
    if(pw != verify) {
        event.preventDefault();
        pwcheck.style.display="block";
        pwcheck.innerHTML="Password does not match<br />";
    } else {
        console.log("didn't work");
        var xhr = new XMLHttpRequest();
        var forminfo = new FormData(form);
        xhr.open("POST","register",true);
        xhr.send(forminfo);
    }
}



var f = document.getElementById('registerdata'); 
function handleForm(event) {
     event.preventDefault(); 
    
    } 
f.addEventListener('submit', getInfo);