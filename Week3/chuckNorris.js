function loadFact(chuck) {
    document.getElementById("fact").innerHTML=chuck.value;
}

function getFact() {
    console.log("in getFact");
    var xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function () {
        console.log("roll tide");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var fact = JSON.parse(xhr.responseText);
            loadFact(fact);
        }
    }

    xhr.open("GET", "https://api.chucknorris.io/jokes/random", true);
    xhr.send();
}

window.onload = function () {
    console.log("in onLoad");
    document.getElementById("chuckNorrisSubmit").addEventListener("click", getFact, false);

}

