function loadPokemon(pokemon) {
    document.getElementById("name").innerHTML=pokemon.name;
}

function loadPokePic(pokePic) {
    document.getElementById("pic").innerHTML=pokePic.pic;
}

function getPokemon() {
    console.log("in getPokemon")
    var pokemonId = document.getElementById("pokeId").value;

    var xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function () {
        console.log("roll tide");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
        }
    }

    xhr.open("GET", "https://core.io/?https://pokeapi.co/api/v2/pokemon/" + pokemonId, true);
    xhr.send();
}

function getPokePic() {
    console.log("in getPokePic");
    var pokemonId = document.getElementById("pokeId").value;
}