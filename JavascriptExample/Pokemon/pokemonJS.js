function loadPokemon(pokemon) {
    document.getElementById("name").innerHTML = pokemon.name;

}

function getPokemon() {
    console.log("Grabbing the pokemons");
    var pokemonID = document.getElementById("pokeID").value;
    //Step 1: Create the XMLHttpRequest (XHR) Object
    var xhr = new XMLHttpRequest();

    //Step 2: Define onreadytatechange Function
    xhr.onreadystatechange = function () {
        console.log("Readying!");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            // It is in JSON format, but we are putting it into JavaScript
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
        }
    }

    //Step 3: Open the request/connection
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pokemonID, true);

    //Step 4: Send the request
    xhr.send();

}

window.onload = function () {
    console.log("in onload");
    document.getElementById("pokemonSubmit").addEventListener("click", getPokemon, false);
}