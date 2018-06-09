function testStuff(){
    console.log("inside of testStuff");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){};
    xhr.open("Get","test",true);
    xhr.send();
}

function testStuff2(){
    console.log("inside of testStuff 2");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){};
    xhr.open("Post","test",true);
    xhr.send();
}

window.onload= function(){
    console.log("We are in the onload!");
    document.getElementById("myBtn").addEventListener("click", testStuff, false)
    document.getElementById("myBtn2").addEventListener("click", testStuff2, false)
}