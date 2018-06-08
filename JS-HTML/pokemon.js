function loadPokemon(pokemon) {
    document.getElementById("name").innerHTML = pokemon.name;
    document.getElementById("sprite").src = pokemon.sprites.front_default;
    document.getElementById("stats").innerHTML = "";
    pokemon.stats.forEach(function(e) {
        document.getElementById("stats").innerHTML += '<h4>' + e.stat.name + " : " + e.base_stat + '</h4>';
    });

} 
function getPokemon(){
    console.log("in getPokemon");
    var pokemonId = document.getElementById("pokeId").value;
    //step 1: create
    var xhr= new XMLHttpRequest();
    //Step 2: set up function handler
    xhr.onreadystatechange=function(){
        console.log("inside the handler method!");
        if (xhr.readyState == 4 && xhr.status == 200){
            var pokemon=JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
            console.log(pokemon);

        } 
    }
          //step3: open request
          xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+pokemonId,true );
          //step4
          xhr.send();
  
} 
window.onload = function(){
    this.console.log("in onload");
    document.getElementById("pokemonSubmit").addEventListener("click", getPokemon, false);
}


addNewField=function(statName, value){
    var node = document.createElement("LI");                 // Create a <li> node
   var newfield =document.createTextNode(statName + "=" +value);
    node.appendChild(newfield);
   document.getElementById("myList").appendChild(node);
   
}