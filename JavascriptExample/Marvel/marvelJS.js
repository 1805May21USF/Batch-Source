function loadCharacter(response) {
    document.getElementById("name").innerHTML = "Here is " + response.data.results[0].name + "'s story...";
    document.getElementById("description").innerHTML = response.data.results[0].description;
    document.getElementById("comics").innerHTML = response.data.results[0].name + " has been in " 
    + response.data.results[0].comics.available + " comics!!";
    document.getElementById("picture").width = "200";
    document.getElementById("picture").height = "200";
    document.getElementById("picture").src = response.data.results[0].thumbnail.path + ".jpg";
    
}

function getCharacter() {
    console.log("in getCharacter");
    var characterName = document.getElementById("characterName").value;
    //Step 1 create XMLHttpRequest object
    var xhr = new XMLHttpRequest();
    //Step 2 function to handle onreadystatechange
    xhr.onreadystatechange = function () {
        console.log("Roll Tide!");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var character = JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET", "https://gateway.marvel.com/v1/public/characters?name=" + characterName + "&ts=1&apikey=566993eda76543d063ab2756019d03ec&hash=840406570c39381efd2fa307eff20792", true);
    //Step 4 send the request
    xhr.send();
}


window.onload = function () {
    console.log("in onLoad");
    document.getElementById("characterSubmit").addEventListener("click", getCharacter, false);
}