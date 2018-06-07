function loadCat(cat){
	document.getElementById("name").innerHTML = cat.fact;
}

function getCat(){
    console.log("in getCat");
    //Step 1
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log("roll tide");
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            var cat = JSON.parse(xhr.responseText);
            loadCat(cat);
        }
    }

    xhr.open("GET","https://cors.io/?http://catfact.ninja/fact",true);
    xhr.send();
}

window.onload = function(){
    console.log("in onLoad");
    document.getElementById("catSubmit").addEventListener("click",getCat,false);
}

